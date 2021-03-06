package com.naufal.todolist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.naufal.todolist.model.TodoModel

@Database(entities = [TodoModel::class], exportSchema = false, version = 1)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao

    companion object{
        private const val DB_NAME = "TODO_DATABASE"
        private var instance: TodoDatabase? = null

        fun getInstance(context: Context): TodoDatabase? {
            if (instance == null) {
                synchronized(TodoDatabase::class) {
                    instance = Room.databaseBuilder(context, TodoDatabase::class.java, DB_NAME).build()
                }
            }

            return instance
        }
    }

}