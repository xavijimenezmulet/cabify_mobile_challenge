plugins {
    id(Depends.library)
    id(Depends.kotlinAndroid)
}

configureAndroidLibrary(Namings.constantsModule)

dependencies {
    addCommonDependencies()
}