package com.testing.demo3.mapper

import com.testing.demo3.dto.CategoryDto
import org.springframework.stereotype.Service
import com.testing.demo3.dto.TaskDto
import com.testing.demo3.entity.Category
import com.testing.demo3.entity.Task


@Service
class TaskMapper (
    private val CategoryMapper : CategoryMapper
): Mapper<TaskDto, Task> {


    override fun toDto(entity: Task): TaskDto {
        return TaskDto(
            entity.id,
            entity.title,
            entity.description,
            entity.duedate,
            entity.completed,
            entity.category.map(fun(category:Category) : CategoryDto{
                return CategoryMapper.toDto(category)
            })

        )
    }

    override fun toEntity(dto: TaskDto): Task {
        return Task(
            dto.id,
            dto.title,
            dto.description,
            dto.duedate,
            dto.completed,
            dto.category.map(fun(categorydto:CategoryDto) : Category{
                return CategoryMapper.toEntity(categorydto)
            })
        )
    }
}
