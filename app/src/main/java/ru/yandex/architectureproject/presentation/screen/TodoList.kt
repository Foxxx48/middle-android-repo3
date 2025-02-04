package ru.yandex.architectureproject.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.yandex.architectureproject.R
import ru.yandex.architectureproject.data.model.Task
import ru.yandex.architectureproject.presentation.state.TaskAction

@Composable
fun TodoList(
    onAction: (TaskAction) -> Unit,
    tasks: List<Task>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val taskText = remember { mutableStateOf("") }

        Row {
            TextField(
                value = taskText.value,
                onValueChange = { taskText.value = it },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                if (taskText.value.isNotBlank()) {
                    onAction(TaskAction.AddTask(taskText.value))
                    taskText.value = ""
                }
            }) {
                Text(stringResource(R.string.add_task))
            }
        }

        LazyColumn {
            items(tasks) { task ->
                TaskItem(onAction = onAction, task = task)
            }
        }
    }
}