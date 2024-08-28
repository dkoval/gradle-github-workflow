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
    register("currentVersion") {
        group = "Custom"
        description = "Prints the current project version"

        doLast {
            println(project.version)
        }
    }

    test {
        useJUnitPlatform()
    }

    wrapper {
        gradleVersion = "8.8"
    }
}
