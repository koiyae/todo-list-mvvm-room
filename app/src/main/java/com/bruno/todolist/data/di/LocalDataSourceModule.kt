package com.bruno.todolist.data.di

import com.bruno.todolist.data.LocalDataSource
import com.bruno.todolist.data.LocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface LocalDataSourceModule {

    @Binds
    fun bindLocalDataSource(dataSource: LocalDataSourceImpl): LocalDataSource
}