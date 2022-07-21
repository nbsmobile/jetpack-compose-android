// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        classpath("com.android.tools.build:gradle:7.1.3")
        classpath("io.insert-koin:koin-gradle-plugin:3.1.4")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}