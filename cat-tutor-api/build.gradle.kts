plugins {
 kotlin("jvm") version "2.2.0"
 kotlin("plugin.spring") version "2.2.0"
 id("org.springframework.boot") version "3.5.0"
 id("io.spring.dependency-management") version "1.1.7"
 kotlin("plugin.jpa") version "2.2.0"
}
dependencies {
 implementation("org.springframework.boot:spring-boot-starter-web")
 implementation("org.springframework.boot:spring-boot-starter-data-jpa")
 implementation("org.springframework.boot:spring-boot-starter-security")
 implementation("org.springframework.boot:spring-boot-starter-validation")
 implementation("io.jsonwebtoken:jjwt-api:0.12.7")
 runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.7")
 runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.7")
 runtimeOnly("com.oracle.database.jdbc:ojdbc11")
 implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
 implementation("org.jetbrains.kotlin:kotlin-reflect")
}
