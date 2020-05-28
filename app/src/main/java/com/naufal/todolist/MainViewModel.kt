package com.naufal.todolist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.naufal.todolist.database.TodoRepository
import com.naufal.todolist.model.TodoModel

class MainViewModel(application: Application): AndroidViewModel(application) {
    private var todoRepository = TodoRepository(application)
    private var todos: LiveData<List<TodoModel>>? = todoRepository.getTodos()


    fun getTodos(): LiveData<List<TodoModel>>? {
        return todos
    }

    fun insertTodo(todo: TodoModel) {
        todoRepository.insert(todo)
    }

    fun deleteTodo(todo: TodoModel) {
        todoRepository.delete(todo)
    }

    fun updateTodo(todo: TodoModel) {
        todoRepository.update(todo)
    }
}