plugins {
  id("java")
  id("org.springframework.boot") version "3.3.2"
  id("io.spring.dependency-management") version "1.1.6"
}

group = "org.home.lissoviy"
version = "0.0.1-SNAPSHOT"

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(22)
  }
}

configurations {
  compileOnly {
    extendsFrom(configurations.annotationProcessor.get())
  }
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
  implementation("org.springframework.boot:spring-boot-starter-web")
  compileOnly("org.projectlombok:lombok")
  runtimeOnly("org.postgresql:postgresql")
  annotationProcessor("org.projectlombok:lombok")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
  useJUnitPlatform()
}

tasks.wrapper {
  version = "latest"
  distributionType = Wrapper.DistributionType.ALL
}