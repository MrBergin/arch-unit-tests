import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class ExtensionsTest {

    @Test
    fun `given a module without tests depends on a module with tests, when the test task is run, then that task runs successfully`() {
        val projectDir = File("${System.getProperty("user.dir")}/build/tests/testsFromCompositeBuildLibrary")
        if (!projectDir.deleteRecursively()) {
            throw AssertionError("Failed to clear test project directory before running")
        }
        projectDir.mkdir()

        val sourceDir = File("${System.getProperty("user.dir")}/src/test/projects/testsFromCompositeBuildLibrary")

        sourceDir.copyRecursively(projectDir)

        val result = GradleRunner.create()
            .withProjectDir(projectDir.resolve("module-without-tests"))
            .withPluginClasspath()
            .withArguments("architectureTest")
            .build()

        assertEquals(TaskOutcome.SUCCESS, result.task(":architectureTest")?.outcome)

        val testResult = projectDir.resolve("module-without-tests/build/test-results/architectureTest")
            .listFiles()
            ?.filter { it.name == "TEST-dev.mrbergin.aut.examples.SomeTest.xml" }

        assertEquals(1, testResult?.size)
    }
}
