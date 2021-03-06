import dependencies.Dependencies
import dependencies.TestDependencies
import dependencies.AnnotationProcessorsDependencies
import extensions.implementation

plugins {
    id("commons.kotlin-library")
}

dependencies {

    implementation(Dependencies.COROUTINES)
    implementation(Dependencies.JODA_TIME)
    implementation(Dependencies.JAVAX_INJECT)
    implementation(Dependencies.JAVAX_ANNOTATION)

    testImplementation (TestDependencies.KONVEYOR)
    testImplementation (TestDependencies.JUNIT)
    testImplementation (TestDependencies.MOCKK)
    implementation(TestDependencies.COROUTINES_TEST)

}
