package com.naufal.todolist.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.naufal.todolist.model.TodoModel

@Dao
interface TodoDao {
    @Query("SELECT * FROM todotable")
    fun getTodos(): LiveData<List<TodoModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTodo(todo: TodoModel)

    @Update
    suspend fun updateTodo(todo: TodoModel)

    @Delete
    suspend fun deleteTodo(todo: TodoModel)
}