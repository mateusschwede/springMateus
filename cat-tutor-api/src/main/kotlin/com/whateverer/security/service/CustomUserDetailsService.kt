package com.whateverer.security.service

import com.whateverer.feature.auth.repository.UserRepository
import com.whateverer.security.model.UserPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CustomUserDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {

    @Transactional(readOnly = true)
    override fun loadUserByUsername(username: String): UserDetails {

        val user = userRepository.findByUsername(username)
            .orElseThrow {
                UsernameNotFoundException("User '$username' not found.")
            }

        return UserPrincipal(user)
    }
}