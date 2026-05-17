include(":core")
include(":bootstrap-standalone")
include(":bootstrap-geyser")
project(":bootstrap-standalone").projectDir = file("bootstrap/standalone")
project(":bootstrap-geyser").projectDir = file("bootstrap/geyser")

pluginManagement {
    repositories {
        gradlePluginPortal()
    }
    includeBuild("build-logic")
}

val geyserForkDir = file("../GeyserFork")
if (geyserForkDir.isDirectory) {
    includeBuild(geyserForkDir) {
        dependencySubstitution {
            substitute(module("com.github.SendableMetatype.EduGeyser:api")).using(project(":api"))
            substitute(module("com.github.SendableMetatype.EduGeyser:core")).using(project(":core"))
        }
    }
}
