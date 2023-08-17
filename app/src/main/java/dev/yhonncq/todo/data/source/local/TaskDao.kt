package dev.yhonncq.todo.data.source.local

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

interface TaskDao {

    @Query("SELECT * FROM task")
    fun getTasks(): Flow<List<TaskEntity>>

    @Query("SELECT * FROM task WHERE id = :taskId")
    suspend fun getById(taskId: String): TaskEntity?

    @Insert
    suspend fun addTask(task: TaskEntity)

    @Upsert
    suspend fun updateTask(task: TaskEntity)

    @Query("UPDATE task SET is_completed = :completed WHERE id = :taskId")
    suspend fun updateCompleted(taskId: String, completed: Boolean)

    @Query("DELETE FROM task WHERE id = :taskId")
    suspend fun deleteById(taskId: String)
}