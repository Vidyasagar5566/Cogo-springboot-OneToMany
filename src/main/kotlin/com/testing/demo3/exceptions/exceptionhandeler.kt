package com.testing.demo3.exceptions

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.Exception

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun handleException(exception: Exception): ResponseEntity<ApiError> {
        var error = ApiError(exception.message ?: "Something went wrong -> Exception")
        return ResponseEntity(error, error.status)
    }

    @ExceptionHandler(TaskException::class)
    fun taskHandleException(exception: Exception): ResponseEntity<ApiError> {
        var error = ApiError(exception.message ?: "Something went wrong")
        return ResponseEntity(error, error.status)
    }

    @ExceptionHandler(CategoryException::class)
    fun categoryHandleException(exception: Exception): ResponseEntity<ApiError> {
        var error = ApiError(exception.message ?: "Something went wrong")
        return ResponseEntity(error, error.status)
    }

}