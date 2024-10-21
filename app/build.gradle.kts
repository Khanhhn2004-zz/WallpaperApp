plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.devtools.ksp")
    id("dagger.hilt.android.plugin")

}

android {
    namespace = "com.hnk.wallpaper"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.hnk.wallpaper"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    ksp {
        arg("room.schemaLocation", "$projectDir/schemas")
    }
    dataBinding{
        enable = true
    }
    buildFeatures{
        buildConfig = true
    }
}


dependencies {
    implementation (libs.androidx.paging.common.ktx)

    implementation(libs.okhttp)

    implementation (libs.androidx.room.runtime)
    implementation(libs.firebase.crashlytics.buildtools)
    implementation(libs.androidx.media3.exoplayer)
    implementation(libs.androidx.paging.runtime.ktx)
    ksp (libs.androidx.room.compiler)
    implementation (libs.androidx.room.ktx)

    implementation(libs.volley)
    implementation (libs.shimmer)

    implementation(libs.duo.navigation.drawer)

    implementation(libs.timber)

    implementation(libs.glide)
    implementation (libs.palette)

    implementation(libs.gson)
    implementation (libs.retrofit)
    implementation (libs.converter.gson)

    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    //Ui
    implementation(libs.circleimageview)
    implementation(libs.dotsindicator)
    implementation(libs.lottie)
    implementation(libs.sdp.android)
    implementation(libs.photoview)
    implementation (libs.androidx.core.splashscreen)
    implementation (libs.shimmer)
    implementation (libs.yalantis.ucrop)

    //Hill
    implementation (libs.eventbus)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}