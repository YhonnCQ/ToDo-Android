package dev.yhonncq.todo.domain

import dev.yhonncq.todo.data.repository.TaskRepository

class DeleteTaskUseCase(
    private val taskRepository: TaskRepository
) {
    suspend operator fun invoke(taskId: String) = taskRepository.deleteTask(taskId)
}