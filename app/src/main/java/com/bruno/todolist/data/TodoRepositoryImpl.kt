package com.bruno.todolist.data

import com.bruno.todolist.data.database.TodoDao
import com.bruno.todolist.data.database.TodoEntity
import com.bruno.todolist.domain.Todo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : TodoRepository {
    override suspend fun insert(title: String, description: String?, id: Long?) {
        val entity = id?.let {
            localDataSource.getBy(id)?.copy(
                title = title,
                description = description
            )
        } ?: TodoEntity(
            title = title,
            description = description,
            isCompleted = false,
        )
        localDataSource.insertOrUpdate(entity)
    }

    override suspend fun updateCompleted(id: Long, isCompleted: Boolean) {
        val existingEntity = localDataSource.getBy(id) ?: return
        val updatedEntity = existingEntity.copy(isCompleted = isCompleted)
        localDataSource.insertOrUpdate(updatedEntity)
    }

    override suspend fun delete(id: Long) {
        val existingEntity = localDataSource.getBy(id) ?: return
        localDataSource.delete(existingEntity)
    }

    override fun getAll(): Flow<List<Todo>> {
        return localDataSource.getAll().map { entities ->
            entities.map { entity ->
                Todo(
                    id = entity.id,
                    title = entity.title,
                    description = entity.description,
                    isCompleted = entity.isCompleted
                )
            }
        }
    }

    override suspend fun getBy(id: Long): Todo? {
        return localDataSource.getBy(id)?.let { entity ->
            Todo(
                id = entity.id,
                title = entity.title,
                description = entity.description,
                isCompleted = entity.isCompleted
            )
        }
    }
}