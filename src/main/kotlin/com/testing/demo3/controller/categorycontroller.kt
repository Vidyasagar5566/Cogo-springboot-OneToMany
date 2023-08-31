package com.testing.demo3.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.boot.autoconfigure.SpringBootApplication

import com.testing.demo3.dto.CategoryDto
import com.testing.demo3.service.CategoryService



@RestController
@SpringBootApplication
class categorycontroller(
    private val CategoryService: CategoryService
) {

    @GetMapping("/category")
    fun getCategory(): ResponseEntity<List<CategoryDto>> {
        return ResponseEntity(CategoryService.getCategory(), HttpStatus.OK) //200.
    }

    @GetMapping("/category/{id}")
    fun getCategory(@PathVariable id: Int): ResponseEntity<CategoryDto> {
        return ResponseEntity.ok(CategoryService.getCategory(id))
    }

    @PostMapping("/category")
    fun createCategory(@RequestBody categoryDto: CategoryDto): ResponseEntity<CategoryDto>? {
        return ResponseEntity(CategoryService.createCategory(categoryDto), HttpStatus.CREATED); //201
    }

    @PutMapping("/category")
    fun updateCategory(@RequestBody categoryDto: CategoryDto): ResponseEntity<CategoryDto> {
        return ResponseEntity(CategoryService.updateCategory(categoryDto), HttpStatus.OK); //200
    }

    @DeleteMapping("/category/{id}")
    fun deleteCategory(@PathVariable id: Int): ResponseEntity<Unit> =
        ResponseEntity(CategoryService.deleteCategory(id), HttpStatus.NO_CONTENT)

}