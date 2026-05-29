pluginManagement {
    repositories {
        gradlePluginPortal()
        //maven("https://maven.aliyun.com/repository/public")
        //maven("https://maven.aliyun.com/repository/google")
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        //maven("https://maven.aliyun.com/repository/public")
        //maven("https://maven.aliyun.com/repository/google")
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

rootProject.name = "ImageViewer"
include(":app")
include(":imageviewer")
