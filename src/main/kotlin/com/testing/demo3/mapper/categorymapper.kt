package com.testing.demo3.mapper

import com.testing.demo3.dto.CategoryDto
import com.testing.demo3.entity.Category
import org.springframework.stereotype.Service

@Service
class CategoryMapper : Mapper<CategoryDto, Category> {
    override fun toDto(entity: Category): CategoryDto {
        return CategoryDto(
            entity.id,
            entity.name,
            entity.task_id
        )
    }

    override fun toEntity(dto: CategoryDto): Category {
        return Category(
            dto.id,
            dto.name,
            dto.task_id
        )
    }
}