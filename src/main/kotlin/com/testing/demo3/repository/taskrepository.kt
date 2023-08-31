package com.testing.demo3.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import com.testing.demo3.entity.Task

@Repository
interface TaskRepository : CrudRepository<Task, Int> {

    @Query("SELECT a from Task as a")
    fun getAllTasks(): List<Task>
}