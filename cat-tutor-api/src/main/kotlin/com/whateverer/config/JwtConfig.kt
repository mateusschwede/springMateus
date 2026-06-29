package com.whateverer.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "jwt")
class JwtConfig {

    lateinit var secret: String
    var expiration: Long = 0
    var issuer: String = "whateverer-api"
}