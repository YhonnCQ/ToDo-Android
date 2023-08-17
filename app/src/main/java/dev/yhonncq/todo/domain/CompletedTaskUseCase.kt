package dev.yhonncq.todo.domain

import dev.yhonncq.todo.data.model.Task
import dev.yhonncq.todo.data.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class CompletedTaskUseCase(
    private val taskRepository: TaskRepository
) {
    suspend operator fun invoke(taskId: String) = taskRepository.completedTask(taskId)
}