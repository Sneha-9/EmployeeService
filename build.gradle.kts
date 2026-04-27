plugins {
        id("org.springframework.boot") version "4.0.3"
        id("io.spring.dependency-management") version "1.1.7"
    id("com.google.protobuf") version "0.9.6"
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:4.33.5"
    }
}

sourceSets {
    main {
        proto {
            srcDir("src/main/proto")
        }
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("com.google.protobuf:protobuf-java:4.33.5")
    implementation("com.hubspot.jackson:jackson-datatype-protobuf:0.9.18")
    implementation("com.google.protobuf:protobuf-java-util:4.33.5")

}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<ProcessResources> {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}