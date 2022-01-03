plugins {
    kotlin("jvm") version "1.6.10"
    `maven-publish`
}

group = "dev.mrbergin.aut"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.tngtech.archunit:archunit-junit5:0.22.0")
}
