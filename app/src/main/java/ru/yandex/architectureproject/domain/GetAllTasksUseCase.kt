package ru.yandex.architectureproject.domain

import kotlinx.coroutines.flow.Flow
import ru.yandex.architectureproject.data.model.Task
import ru.yandex.architectureproject.domain.repository.TaskRepository

class GetAllTasksUseCase(
    private val repository: TaskRepository,
) {
    operator fun invoke(): Flow<List<Task>> {
        return repository.getAllTasks()
    }
}
