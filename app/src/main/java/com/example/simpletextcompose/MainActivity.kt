package com.example.simpletextcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simpletextcompose.ui.theme.SimpleTextComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SimpleTextComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GreetingButton(msg = "first button", Color.Blue)
                }
            }
        }
    }
}

@Composable
fun GreetingText(name: String, color: Color) {
    Text(
        text = "Hello $name!",
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        textAlign = TextAlign.Center,
        style = TextStyle(
            color = Color.Black, fontSize = 28.sp, background = color
        )
    )
}

@Composable
fun GreetingButton(msg: String, color: Color) {

    Surface(color = color) {
        Button(
            onClick = {},
            modifier = Modifier
                .padding(top = 20.dp)
                .width(200.dp)
                .height(200.dp)
        ) {
            GreetingText(name = msg, color)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SimpleTextComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                GreetingButton(msg = "first button", Color.Blue)
                GreetingButton(msg = "second button", Color.Red)
            }
        }
    }
}