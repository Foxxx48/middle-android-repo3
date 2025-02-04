package ru.yandex.architectureproject.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import ru.yandex.architectureproject.presentation.screen.TodoScreen
import ru.yandex.architectureproject.presentation.ui.theme.ArchitectureProjectTheme
import ru.yandex.architectureproject.presentation.viewmodel.TaskViewModel
import ru.yandex.architectureproject.presentation.viewmodel.TaskViewModelFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel by viewModels<TaskViewModel> {
                TaskViewModelFactory()
            }
            ArchitectureProjectTheme {
                TodoScreen(viewModel)
            }
        }
    }
}
