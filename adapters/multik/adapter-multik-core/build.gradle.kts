import io.kinference.gradle.configureTests

group = rootProject.group
version = rootProject.version

kotlin {
    jvm {
        configureTests()
    }

    js(IR) {
        browser()
        configureTests()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":ndarray:ndarray-api"))
                api(project(":ndarray:ndarray-core"))

                api(project(":inference:inference-api"))
                api(project(":inference:inference-core"))

                api(libs.multik.core)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(project(":utils:utils-testing"))
            }
        }
    }
}
