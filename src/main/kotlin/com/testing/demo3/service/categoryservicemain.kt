package com.testing.demo3.service


import org.springframework.stereotype.Service
import com.testing.demo3.dto.CategoryDto
import com.testing.demo3.repository.CategoryRepository
import com.testing.demo3.mapper.CategoryMapper
import com.testing.demo3.exceptions.TaskException
import com.testing.demo3.mapper.TaskMapper
import com.testing.demo3.repository.TaskRepository

@Service
class CategoryServiceimain(
    private val CategoryRepository: CategoryRepository,
    private val CategoryMapper: CategoryMapper,
    private val TaskRepository: TaskRepository,
    private val TaskMapper: TaskMapper,
) : CategoryService {

    override fun createCategory(categoryDto: CategoryDto): CategoryDto {
        if (categoryDto.id != null) {
            throw TaskException("Id should be null")
        }

        var task = TaskRepository.findById(categoryDto.task_id!!).orElseThrow {
            TaskException("Movie with ${categoryDto.task_id!!} doesn't exist")
        }

        val category = CategoryMapper.toEntity(categoryDto)
        val taskDto = TaskMapper.toDto(task)
        taskDto.category += listOf(categoryDto)

        val taskEntity = TaskMapper.toEntity(taskDto)
        TaskRepository.save(taskEntity)
        CategoryRepository.save(category)
        return CategoryMapper.toDto(category);
    }

    override fun getCategory(id: Int): CategoryDto {
        var category = CategoryRepository.findById(id).orElseThrow {
            TaskException("Movie with $id doesn't exist")
        }
        return CategoryMapper.toDto(category)
    }

    override fun getCategory(): List<CategoryDto> {
        var categories = CategoryRepository.getAllCategory()
        if (categories.isEmpty()) {
            throw TaskException("Movie list is empty")
        }
        return categories.map {
            CategoryMapper.toDto(it)
        }
    }

    override fun updateCategory(TaskDto: CategoryDto): CategoryDto {
        getCategory(TaskDto.id!!)
        CategoryRepository.save(CategoryMapper.toEntity(TaskDto))
        return TaskDto
    }

    override fun deleteCategory(id: Int) {
        val exists = CategoryRepository.existsById(id);
        if (!exists)
            throw TaskException("Movie with $id doesn't exist")
        CategoryRepository.deleteById(id)
    }
}


