@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("tictactoe.android.library")
    id("tictactoe.android.koin")
}
android {
    namespace = "com.sergeyzorych.tictactoe.domain"
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.androidx.appcomapt)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}