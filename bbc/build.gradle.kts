plugins {
    id("com.android.library")
    id("com.vanniktech.maven.publish") version "0.28.0"
}

android {
    namespace = "com.bigoat.bbc"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
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

    buildFeatures {
        dataBinding=true
    }
}

dependencies {
    // 原生依赖
    api("androidx.appcompat:appcompat:1.6.1")
    api("androidx.lifecycle:lifecycle-extensions:2.2.0")
    api("androidx.recyclerview:recyclerview:1.3.2")

    // Retrofit: https://square.github.io/retrofit/
    api("com.squareup.retrofit2:retrofit:2.9.0")
    api("com.squareup.retrofit2:converter-gson:2.9.0")

    // OkHttp: https://square.github.io/okhttp
    api("com.squareup.okhttp3:okhttp:4.12.0")

    // Gson: https://github.com/google/gson
    api("com.google.code.gson:gson:2.10.1")

    // AndroidUtil: https://github.com/Blankj/AndroidUtilCode
    api("com.blankj:utilcodex:1.31.1")

    // BaseRecycler: http://www.recyclerview.org/
    api("io.github.cymchad:BaseRecyclerViewAdapterHelper:3.0.14")

    // Glide: https://muyangmin.github.io/glide-docs-cn/
    api("com.github.bumptech.glide:glide:4.12.0")

    // https://github.com/wasabeef/glide-transformations
    api("jp.wasabeef:glide-transformations:4.3.0")
}


mavenPublishing {
    signAllPublications()
}
