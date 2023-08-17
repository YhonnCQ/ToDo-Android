package dev.yhonncq.todo.data.repository

import dev.yhonncq.todo.data.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    fun getTasks(): Flow<List<Task>>

    suspend fun getTask(taskId: String): Task?

    suspend fun addTask(title: String, description: String)

    suspend fun updateTask(taskId: String, title: String, description: String)

    suspend fun completedTask(taskId: String)

    suspend fun deleteTask(taskId: String)
}