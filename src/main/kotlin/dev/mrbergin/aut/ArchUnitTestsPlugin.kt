package dev.mrbergin.aut

import includeTestsFrom
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.ListProperty
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.create

interface ArchitectureTestExtension {
    val tests: ListProperty<String>
}

/**
 * Suppressing unused as this is the main class and not intended to be instantiated directly.
 */
@Suppress("unused")
class ArchUnitTestsPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        val architectureTestTask = target.tasks.create("architectureTest", Test::class.java).apply {
            group = "verification"
        }
        val architectureTestExtension = target.extensions.create<ArchitectureTestExtension>("architectureTest")
        target.afterEvaluate {
            architectureTestTask.classpath = project.objects.fileCollection()
            architectureTestTask.testClassesDirs = project.objects.fileCollection()
            architectureTestTask.includeTestsFrom(*architectureTestExtension.tests.get().toTypedArray())
        }
    }
}


