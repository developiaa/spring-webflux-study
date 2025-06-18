pluginManagement {
    repositories {
        gradlePluginPortal()

        maven { setUrl("https://repo.spring.io/milestone") } // Spring milestones
        maven { setUrl("https://repo.spring.io/snapshot") } // Spring snapshots
    }

    plugins {
        id("de.fayard.refreshVersions") version "0.60.5"
    }
}

plugins {
    id("de.fayard.refreshVersions")
}


rootProject.name = "spring-webflux-study"

include("examples:async-programming")
include("examples:spring-webflux")

include("practices:completable-future")
include("practices:reactive-streams")

include("practices:nio-server")
include("practices:selector")
include("practices:reactor-pattern")
include("practices:netty")
