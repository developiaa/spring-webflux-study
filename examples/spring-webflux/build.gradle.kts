plugins {
    java
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-mustache")

    // reactor tool
    implementation("io.projectreactor:reactor-tools")
}


tasks.register("prepareKotlinBuildScriptModel") {}
