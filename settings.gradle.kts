pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "OnboardingCompose"
include(":app")
include(":compulynx-prints-bio-capture")
include(":compulynx-prints-bio-capture:fingerPrintSdk")
