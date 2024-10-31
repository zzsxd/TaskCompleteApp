package com.example.taskcompleteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskcompleteapp.ui.theme.TaskCompleteAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskCompleteAppTheme {

            }
        }
    }
}


@Composable
fun TaskCompleteText(status: String, congratulation: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        content =
        {
            Text(
                text = status,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 24.dp, bottom = 8.dp)
            )
            Text(
                text = congratulation,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                )
        }
    )
}

@Composable
fun TaskCompleteImage(status: String, congratulation: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.task_completed)
    Box(modifier) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            content = {
            Image(
                painter = image,
                contentDescription = null, // для слепых говорим чтобы они не видели изображение
                alpha = 1.0F
            )
            TaskCompleteText(
                status = stringResource(R.string.task_done),
                congratulation = stringResource(R.string.nice_work)
            )
        }
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TaskPreview() {
    TaskCompleteAppTheme {
        TaskCompleteImage(
            status = "",
            congratulation = ""
        )
    }
}