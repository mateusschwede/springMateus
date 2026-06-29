package com.whateverer.feature.auth.service

import com.whateverer.config.JwtConfig
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service
import java.nio.charset.StandardCharsets
import java.util.Date
import javax.crypto.SecretKey

@Service
class TokenService(
    private val jwtConfig: JwtConfig
) {

    private fun getSigningKey(): SecretKey =
        Keys.hmacShaKeyFor(jwtConfig.secret.toByteArray(StandardCharsets.UTF_8))

    fun generateToken(authentication: Authentication): String {
        val now = Date()
        val expirationDate = Date(now.time + jwtConfig.expiration)

        return Jwts.builder()
            .subject(authentication.name)
            .issuer(jwtConfig.issuer)
            .issuedAt(now)
            .expiration(expirationDate)
            .signWith(getSigningKey(), SignatureAlgorithm.HS256)
            .compact()
    }

    fun extractUsername(token: String): String =
        extractAllClaims(token).subject

    fun validateToken(token: String): Boolean =
        try {
            extractAllClaims(token)
            true
        } catch (_: Exception) {
            false
        }

    fun getExpirationTime(): Long =
        jwtConfig.expiration

    private fun extractAllClaims(token: String): Claims =
        Jwts.parser()
            .verifyWith(getSigningKey())
            .build()
            .parseSignedClaims(token)
            .payload
}