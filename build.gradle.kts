plugins {
    kotlin("jvm") version "1.6.21"
    id("fabric-loom") version "0.11-SNAPSHOT"
    `maven-publish`
}

base.archivesName.set(findProperty("archives_base_name").toString())
version = findProperty("mod_version").toString()
group = findProperty("maven_group").toString()

repositories {
    // Add repositories to retrieve artifacts from in here.
    // You should only use this when depending on other mods because
    // Loom adds the essential maven repositories to download Minecraft and libraries from automatically.
    // See https://docs.gradle.org/current/userguide/declaring_repositories.html
    // for more information about repositories.
}

dependencies {
    // To change the versions see the gradle.properties file
    minecraft("com.mojang:minecraft:${findProperty("minecraft_version").toString()}")
    mappings("net.fabricmc:yarn:${findProperty("yarn_mappings").toString()}:v2")
    modImplementation("net.fabricmc:fabric-loader:${findProperty("loader_version").toString()}")

    // Kotlin support
    modImplementation("net.fabricmc:fabric-language-kotlin:${findProperty("fabric_kotlin_version").toString()}")

    // Fabric API. This is technically optional, but you probably want it anyway.
    modImplementation("net.fabricmc.fabric-api:fabric-api:${findProperty("fabric_version").toString()}")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    // Loom will automatically attach sourcesJar to a RemapSourcesJar task and to the "build" task
    // if it is present.
    // If you remove this line, sources will not be generated.
    withSourcesJar()
}

tasks {
    processResources {
        inputs.property("version", project.version)

        filesMatching("fabric.mod.json") {
            expand(mutableMapOf("version" to project.version))
        }
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }

    withType<JavaCompile> {
        // Minecraft 1.18 (1.18-pre2) upwards uses Java 17.
        options.release.set(17)
    }

    jar {
        from("LICENSE") {
            rename { "${it}_${base.archivesName}" }
        }
    }
}

// configure the maven publication
publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }

    // See https://docs.gradle.org/current/userguide/publishing_maven.html for information on how to set up publishing.
    repositories {
        // Add repositories to publish to here.
        // Notice: This block does NOT have the same function as the block in the top level.
        // The repositories here will be used for publishing your artifact, not for
        // retrieving dependencies.
    }
}
