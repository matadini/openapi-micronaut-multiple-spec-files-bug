plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.micronaut.application") version "4.4.5"
    id("io.micronaut.aot") version "4.4.5"
    id("io.micronaut.openapi") version "4.4.5"
}

version = "0.1"
group = "com.example"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("io.micronaut:micronaut-http-validation")
    annotationProcessor("io.micronaut.serde:micronaut-serde-processor")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    implementation("jakarta.validation:jakarta.validation-api")
    compileOnly("io.micronaut:micronaut-http-client")
    runtimeOnly("ch.qos.logback:logback-classic")
    testImplementation("io.micronaut:micronaut-http-client")
    annotationProcessor("io.micronaut.openapi:micronaut-openapi")
    compileOnly("io.micronaut.openapi:micronaut-openapi-annotations")
}


application {
    mainClass = "com.example.Application"
}
java {
    sourceCompatibility = JavaVersion.toVersion("23")
    targetCompatibility = JavaVersion.toVersion("23")
}


graalvmNative.toolchainDetection = false

micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.example.*")
    }
    aot {
        // Please review carefully the optimizations enabled below
        // Check https://micronaut-projects.github.io/micronaut-aot/latest/guide/ for more details
        optimizeServiceLoading = false
        convertYamlToJava = false
        precomputeOperations = true
        cacheEnvironment = true
        optimizeClassLoading = true
        deduceEnvironment = true
        optimizeNetty = true
        replaceLogbackXml = true
    }
    openapi {
        server("serverOne", file("src/main/resources/openapi/my-api-first.yml")) {
            apiPackageName = "com.example.first.api"
            modelPackageName = "com.example.first.model"
            controllerPackage = "com.example.first.controller"
            useReactive = false
            useOptional = true
            generateHttpResponseWhereRequired = true
        }
        server("serverTwo", file("src/main/resources/openapi/my-api-second.yml")) {
            apiPackageName = "com.example.second.api"
            modelPackageName = "com.example.second.model"
            controllerPackage = "com.example.second.controller"
            useReactive = false
            useOptional = true
            generateHttpResponseWhereRequired = true
        }
        server("serverThree", file("src/main/resources/openapi/my-api-third.yml")) {
            apiPackageName = "com.example.third.api"
            modelPackageName = "com.example.third.model"
            controllerPackage = "com.example.third.controller"
            useReactive = false
            useOptional = true
            generateHttpResponseWhereRequired = true
        }
    }
}


tasks.named<io.micronaut.gradle.docker.NativeImageDockerfile>("dockerfileNative") {
    jdkVersion = "23"
}


