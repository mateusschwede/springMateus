package com.whateverer.exception

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.AccessDeniedException
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundException(
        exception: ResourceNotFoundException,
        request: HttpServletRequest
    ): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(
                ErrorResponse(
                    status = HttpStatus.NOT_FOUND.value(),
                    error = HttpStatus.NOT_FOUND.reasonPhrase,
                    message = exception.message ?: "Resource not found.",
                    path = request.requestURI
                )
            )

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(
        exception: BusinessException,
        request: HttpServletRequest
    ): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(
                ErrorResponse(
                    status = HttpStatus.BAD_REQUEST.value(),
                    error = HttpStatus.BAD_REQUEST.reasonPhrase,
                    message = exception.message ?: "Business rule violation.",
                    path = request.requestURI
                )
            )

    @ExceptionHandler(UnauthorizedException::class)
    fun handleUnauthorizedException(
        exception: UnauthorizedException,
        request: HttpServletRequest
    ): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body(
                ErrorResponse(
                    status = HttpStatus.UNAUTHORIZED.value(),
                    error = HttpStatus.UNAUTHORIZED.reasonPhrase,
                    message = exception.message ?: "Unauthorized.",
                    path = request.requestURI
                )
            )

    @ExceptionHandler(AccessDeniedException::class)
    fun handleAccessDeniedException(
        exception: AccessDeniedException,
        request: HttpServletRequest
    ): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(HttpStatus.FORBIDDEN)
            .body(
                ErrorResponse(
                    status = HttpStatus.FORBIDDEN.value(),
                    error = HttpStatus.FORBIDDEN.reasonPhrase,
                    message = exception.message ?: "Access denied.",
                    path = request.requestURI
                )
            )

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationException(
        exception: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): ResponseEntity<ErrorResponse> {
        val message = exception.bindingResult
            .allErrors
            .joinToString("; ") { error ->
                val field = (error as? FieldError)?.field ?: error.objectName
                "$field: ${error.defaultMessage}"
            }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(
                ErrorResponse(
                    status = HttpStatus.BAD_REQUEST.value(),
                    error = HttpStatus.BAD_REQUEST.reasonPhrase,
                    message = message,
                    path = request.requestURI
                )
            )
    }

    @ExceptionHandler(Exception::class)
    fun handleGenericException(
        exception: Exception,
        request: HttpServletRequest
    ): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(
                ErrorResponse(
                    status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    error = HttpStatus.INTERNAL_SERVER_ERROR.reasonPhrase,
                    message = exception.message ?: "Unexpected internal error.",
                    path = request.requestURI
                )
            )
}