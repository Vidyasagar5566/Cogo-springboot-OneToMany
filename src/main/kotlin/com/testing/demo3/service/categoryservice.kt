package com.testing.demo3.service

import com.testing.demo3.dto.CategoryDto

interface CategoryService {
    fun createCategory(Task: CategoryDto): CategoryDto
    fun getCategory(): List<CategoryDto>
    fun getCategory(id: Int): CategoryDto
    fun updateCategory(Task: CategoryDto): CategoryDto
    fun deleteCategory(id: Int)
}

