plugins {
    kotlin("jvm") version "1.6.10"
}

group = "dev.mrbergin.aut.examples"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.tngtech.archunit:archunit-junit5:0.22.0")
}
