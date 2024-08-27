import groovy.lang.Closure

plugins {
    kotlin("jvm") version "2.0.20"
    id("com.palantir.git-version") version "3.1.0"
    distribution
}

// https://github.com/palantir/gradle-git-version?tab=readme-ov-file#usage
val gitVersion: Closure<String> by extra

group = "com.github.dkoval"
version = gitVersion()

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

    wrapper {
        gradleVersion = "8.8"
    }
}
