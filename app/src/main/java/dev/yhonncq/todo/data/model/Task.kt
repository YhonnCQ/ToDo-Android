package dev.yhonncq.todo.data.model

data class Task(
    val id: String,
    val title: String = "",
    val description: String = "",
    val isCompleted: Boolean = false
)
