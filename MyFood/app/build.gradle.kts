plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  id("com.google.devtools.ksp")
  id("androidx.navigation.safeargs.kotlin")
}

android {
  namespace = "com.sinan.myfood"
  compileSdk = 34

  defaultConfig {
    applicationId = "com.sinan.myfood"
    minSdk = 24
    targetSdk = 34
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    jvmTarget = "17"
  }

  /*kotlin {
    jvmToolchain(17)
  }*/

  buildFeatures {
    viewBinding = true
  }
}

dependencies {
  implementation(project(mapOf("path" to ":core")))
  implementation("androidx.constraintlayout:constraintlayout:2.1.4")
  implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
  implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
  val room_version = "2.6.0"
  val coroutines_version = "1.7.3"
  val glide_version = "4.16.0"
  val daggerVersion = "2.48.1"
  val nav_version = "2.7.5"

  implementation("androidx.core:core-ktx:1.12.0")
  implementation("androidx.appcompat:appcompat:1.6.1")
  implementation("com.google.android.material:material:1.10.0")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.5")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

  //Retrofit
  //implementation("com.squareup.retrofit2:retrofit:2.9.0")
  //implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

  //room
  implementation("androidx.room:room-runtime:$room_version")
  annotationProcessor("androidx.room:room-compiler:$room_version")
  ksp("androidx.room:room-compiler:$room_version")
  implementation("androidx.room:room-ktx:$room_version")

  implementation("androidx.recyclerview:recyclerview:1.3.2")

  implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
  implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

  implementation("android.arch.lifecycle:extensions:1.1.1")

  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version")

  //gif
  implementation("pl.droidsonroids.gif:android-gif-drawable:1.2.17")

  //Glide
  implementation("com.github.bumptech.glide:glide:$glide_version")
}