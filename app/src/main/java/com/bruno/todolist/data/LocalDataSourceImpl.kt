package com.bruno.todolist.data

import com.bruno.todolist.data.database.TodoDao
import com.bruno.todolist.data.database.TodoEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val dao: TodoDao
) : LocalDataSource {
    override suspend fun insertOrUpdate(entity: TodoEntity) {
        dao.insert(entity)
    }

    override suspend fun delete(entity: TodoEntity) {
        dao.delete(entity)
    }

    override fun getAll(): Flow<List<TodoEntity>> {
        return dao.getAll()
    }

    override suspend fun getBy(id: Long): TodoEntity? {
        return dao.getBy(id)
    }

}