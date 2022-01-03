plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    id("maven-publish")
    id("com.gradle.plugin-publish") version "0.16.0"
}

group = "dev.mrbergin"
val releaseVersion: String? by project
version = releaseVersion ?: "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("dev.mrbergin:run-dependency-tests:0.0.1")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(8))
    }
}

pluginBundle {
    website = "https://github.com/MrBergin/arch-unit-tests"
    vcsUrl = "https://github.com/MrBergin/arch-unit-tests.git"
    tags = listOf("testing", "archunit")
}

gradlePlugin {
    plugins {
        create("ArchUnitTests") {
            id = "dev.mrbergin.arch-unit-tests"
            displayName = "Run Architecture Tests"
            description =
                "Provides a new ArchitectureTest task running ArchUnit tests, including those in dependencies"
            implementationClass = "dev.mrbergin.aut.ArchUnitTestsPlugin"
        }
    }
}
