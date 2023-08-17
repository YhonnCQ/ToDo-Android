package dev.yhonncq.todo.domain

import dev.yhonncq.todo.data.model.Task
import dev.yhonncq.todo.data.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class GetTaskUseCase(
    private val taskRepository: TaskRepository
) {
    suspend operator fun invoke(taskId: String): Task? = taskRepository.getTask(taskId)
}