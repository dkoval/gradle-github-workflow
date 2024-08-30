plugins {
    kotlin("jvm") version "2.0.20"
    distribution
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    testImplementation(kotlin("test"))
}

distributions {
    main {
        contents {
            from(tasks.jar)
            from(configurations.runtimeClasspath)
        }
    }
}

tasks {
    test {
        useJUnitPlatform()
    }

    distTar {
        compression = Compression.GZIP
        archiveExtension = "tar.gz"
    }

    wrapper {
        gradleVersion = "8.8"
    }
}
