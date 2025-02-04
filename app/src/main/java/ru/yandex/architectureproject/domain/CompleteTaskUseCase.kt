package ru.yandex.architectureproject.domain

import kotlinx.coroutines.delay
import ru.yandex.architectureproject.domain.repository.TaskRepository

class CompleteTaskUseCase(
    private val repository: TaskRepository,
) {
    suspend operator fun invoke(taskId: Int) {
        repository.completeTask(taskId)
        delay(DELAY_TIME)
        repository.deleteTask(taskId)
    }

    private companion object {
        const val DELAY_TIME = 10_000L
    }
}
