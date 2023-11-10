// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
  val nav_version = "2.7.5"

  repositories {
    google()
  }
  dependencies {
    classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
  }
}

plugins {
  id("com.android.application") version "8.1.0" apply false
  id("org.jetbrains.kotlin.android") version "1.8.0" apply false
  id("com.google.devtools.ksp") version "1.9.10-1.0.13" apply false
  id("org.jetbrains.kotlin.jvm") version "1.9.10" apply false
}