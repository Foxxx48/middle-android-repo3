package ru.yandex.architectureproject.domain

import ru.yandex.architectureproject.domain.repository.TaskRepository

class IncompleteTaskUseCase(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(taskId: Int) {
        repository.incompleteTask(taskId)
    }
}