package dev.yhonncq.todo.data.repository

import dev.yhonncq.todo.data.model.Task
import dev.yhonncq.todo.data.source.local.TaskDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.util.UUID

class DefaultTaskRepository(
    private val localDataSource: TaskDao
) : TaskRepository {

    override fun getTasks(): Flow<List<Task>> {
        return localDataSource.getTasks().map { task ->
            withContext(Dispatchers.IO) {
                task.toExternal()
            }
        }
    }

    override suspend fun getTask(taskId: String): Task? = localDataSource.getById(taskId)?.toExternal()

    override suspend fun addTask(title: String, description: String) {
        val taskId = withContext(Dispatchers.IO) {
            UUID.randomUUID().toString()
        }
        val task = Task(
            id = taskId,
            title = title,
            description = description
        )
        localDataSource.addTask(task.toEntity())
    }

    override suspend fun updateTask(taskId: String, title: String, description: String) {
        val task = getTask(taskId)?.copy(
            title = title,
            description = description
        ) ?: throw Exception("Task (id $taskId) not found")
        localDataSource.updateTask(task.toEntity())
    }

    override suspend fun completedTask(taskId: String) = localDataSource.updateCompleted(taskId, completed = true)

    override suspend fun deleteTask(taskId: String) = localDataSource.deleteById(taskId)
}