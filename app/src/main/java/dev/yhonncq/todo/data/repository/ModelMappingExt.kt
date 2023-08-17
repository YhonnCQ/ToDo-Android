package dev.yhonncq.todo.data.repository

import dev.yhonncq.todo.data.model.Task
import dev.yhonncq.todo.data.source.local.TaskEntity

fun Task.toEntity() = TaskEntity(
    id = id,
    title = title,
    description = description,
    isCompleted = isCompleted
)

fun List<Task>.toEntity() = map(Task::toEntity)

fun TaskEntity.toExternal() = Task(
    id = id,
    title = title,
    description = description,
    isCompleted = isCompleted
)

fun List<TaskEntity>.toExternal() = map(TaskEntity::toExternal)