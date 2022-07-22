plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("com.google.devtools.ksp") version "1.6.10-1.0.4"
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.nbs.moviecompose"
        minSdk = 24
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
        buildConfigField("String", "API_KEY", "\"270363a57bb9637a16bdd04f9979e433\"")
        buildConfigField("String", "API_LANGUAGE", "\"en-US\"")
        buildConfigField("String", "IMAGE_BASE_URL", "\"https://image.tmdb.org/t/p/original/\"")
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false
        }

        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
        viewBinding = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }

    applicationVariants.all {
        kotlin.sourceSets {
            getByName(name) {
                kotlin.srcDir("build/generated/ksp/$name/kotlin")
            }
        }
    }
}

dependencies {

    // Default Dependencies
    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.multidex:multidex:2.0.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    //glide
    implementation("com.github.bumptech.glide:glide:4.13.2")

    // Compose Dependencies
    implementation("androidx.activity:activity-compose:1.5.0")
    implementation("androidx.compose.ui:ui:1.1.1")
    implementation("androidx.compose.material:material:1.1.1")
    implementation("androidx.compose.ui:ui-tooling:1.1.1")
    implementation("androidx.compose.runtime:runtime-livedata:1.1.1")

    // Compose Navigation
    implementation("androidx.navigation:navigation-compose:2.5.0")

    // Koin
    implementation("io.insert-koin:koin-android:3.1.4")
    implementation("io.insert-koin:koin-androidx-compose:3.1.4")
    implementation("io.insert-koin:koin-android-ext:3.0.1")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1")

    // Chucker
    debugImplementation("com.github.chuckerteam.chucker:library:3.5.2")
    releaseImplementation("com.github.chuckerteam.chucker:library-no-op:3.5.2")

    // Compose Destinations
    implementation("io.github.raamcosta.compose-destinations:animations-core:1.5.13-beta")
    ksp("io.github.raamcosta.compose-destinations:ksp:1.5.13-beta")

    // Compose Pager
    implementation("com.google.accompanist:accompanist-pager:0.24.13-rc")

    // Compose Constraint Layout
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")

    // Compose Coil
    implementation("io.coil-kt:coil-compose:2.0.0-rc01")

    // Compose Page Indicators
    implementation("com.google.accompanist:accompanist-pager-indicators:0.24.13-rc")

    // Compose Place Holder
    implementation("com.google.accompanist:accompanist-placeholder-material:0.24.7-alpha")
}