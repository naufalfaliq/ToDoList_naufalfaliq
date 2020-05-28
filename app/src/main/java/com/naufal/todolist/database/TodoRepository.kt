package com.naufal.todolist.database

import android.app.Application
import androidx.lifecycle.LiveData
import com.naufal.todolist.model.TodoModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TodoRepository(application: Application){
    private val todoDao: TodoDao?
    private var todos: LiveData<List<TodoModel>>? = null

    init{
        val db = TodoDatabase.getInstance(application.applicationContext)
        todoDao = db?.todoDao()
        todos = todoDao?.getTodos()
    }

    fun getTodos(): LiveData<List<TodoModel>>?{
        return todos
    }

    fun insert(todo: TodoModel) = runBlocking {
        this.launch(Dispatchers.IO){
            todoDao?.insertTodo(todo)
        }
    }

    fun update(todo: TodoModel) = runBlocking {
        this.launch(Dispatchers.IO){
            todoDao?.updateTodo(todo)
        }
    }

    fun delete(todo: TodoModel) = runBlocking {
        this.launch(Dispatchers.IO){
            todoDao?.deleteTodo(todo)
        }
    }

}