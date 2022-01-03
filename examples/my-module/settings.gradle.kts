@file:Suppress("UnstableApiUsage")

rootProject.name = "my-module"

includeBuild("../arch-tests")

pluginManagement {
    includeBuild("../../")
}
