package ru.yandex.architectureproject.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.yandex.architectureproject.R
import ru.yandex.architectureproject.data.model.Task
import ru.yandex.architectureproject.presentation.state.TaskAction
import ru.yandex.architectureproject.presentation.ui.theme.ArchitectureProjectTheme

@Composable
fun TaskItem(
    onAction: (TaskAction) -> Unit,
    task: Task
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            task.text,
            style = if (task.isDone) TextStyle(textDecoration = TextDecoration.LineThrough) else TextStyle()
        )
        Row {
            Checkbox(
                checked = task.isDone,
                onCheckedChange = { onAction(TaskAction.UpdateTaskStatus(task.id, it)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { onAction(TaskAction.DeleteTask(task.id)) }) {
                Text(stringResource(R.string.delete_task))
            }
        }
    }
}

@Preview
@Composable
private fun ShowTaskItemPreview() {
    ArchitectureProjectTheme {
        TaskItem(
            onAction = { },
            task =
            Task(
                id = 10050,
                text = "Test task",
                isDone = false
            )
        )
    }
}
