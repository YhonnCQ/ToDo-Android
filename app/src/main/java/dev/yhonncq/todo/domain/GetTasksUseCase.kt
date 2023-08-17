package dev.yhonncq.todo.domain

import dev.yhonncq.todo.data.model.Task
import dev.yhonncq.todo.data.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class GetTasksUseCase(
    private val taskRepository: TaskRepository
) {
    operator fun invoke(): Flow<List<Task>> = taskRepository.getTasks()
}