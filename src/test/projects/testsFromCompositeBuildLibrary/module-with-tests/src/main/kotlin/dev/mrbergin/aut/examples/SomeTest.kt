package dev.mrbergin.aut.examples

import com.tngtech.archunit.core.domain.JavaClasses
import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition

@Suppress("FunctionName")
@AnalyzeClasses(
    importOptions = [ImportOption.DoNotIncludeArchives::class]
)
internal class SomeTest {

    @ArchTest
    fun all_classes_are_belong_to_mrbergin(importedClasses: JavaClasses) {
        ArchRuleDefinition.classes()
            .should()
            .resideInAPackage("dev.mrbergin..")
            .because("mrbergin projects should always be in dev.mrbergin!!")
            .check(importedClasses)
    }
}