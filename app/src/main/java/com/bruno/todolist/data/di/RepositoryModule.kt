package com.bruno.todolist.data.di

import com.bruno.todolist.data.TodoRepository
import com.bruno.todolist.data.TodoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    fun bindTodoRepository(repository: TodoRepositoryImpl): TodoRepository
}