plugins {
    kotlin("jvm") version "1.6.10"
    id("dev.mrbergin.arch-unit-tests")
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testImplementation(kotlin("test"))
}

architectureTest {
    tests.set(listOf("dev.mrbergin.aut.examples:arch-tests"))
}

tasks.withType<Test> {
    useJUnitPlatform()
}