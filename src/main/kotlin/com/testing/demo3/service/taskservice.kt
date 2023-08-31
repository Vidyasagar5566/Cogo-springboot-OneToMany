package com.testing.demo3.service
import com.testing.demo3.dto.TaskDto

interface TaskService {
    fun createTask(Task: TaskDto): TaskDto
    fun getTask(): List<TaskDto>
    fun getTask(id: Int): TaskDto
    fun updateTask(Task: TaskDto): TaskDto
    fun deleteTask(id: Int)
}