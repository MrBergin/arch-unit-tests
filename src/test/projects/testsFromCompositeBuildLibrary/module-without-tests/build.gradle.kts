plugins {
    kotlin("jvm") version "1.6.10"
    id("dev.mrbergin.arch-unit-tests")
}

repositories {
    mavenCentral()
}

architectureTest {
    tests.set(listOf("dev.mrbergin.aut:module-with-tests"))
}

tasks.withType<Test> {
    useJUnitPlatform()
}