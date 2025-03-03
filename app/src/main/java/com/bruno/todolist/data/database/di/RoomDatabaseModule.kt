package com.bruno.todolist.data.database.di

import android.content.Context
import androidx.room.Room
import com.bruno.todolist.data.database.TodoDao
import com.bruno.todolist.data.database.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomDatabaseModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(
        @ApplicationContext context: Context
    ): TodoDatabase {
        return Room.databaseBuilder(
            context,
            TodoDatabase::class.java,
            "todo-app"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTodoDao(
        database: TodoDatabase
    ): TodoDao {
        return database.todoDao
    }
}