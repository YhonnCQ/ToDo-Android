package dev.yhonncq.todo.domain

import dev.yhonncq.todo.data.model.Task
import dev.yhonncq.todo.data.repository.TaskRepository

class AddTaskUseCase(
    private val taskRepository: TaskRepository
) {
    suspend operator fun invoke(title: String, description: String) = taskRepository.addTask(title, description)
}