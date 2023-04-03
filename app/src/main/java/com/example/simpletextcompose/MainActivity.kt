package com.example.simpletextcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.simpletextcompose.ui.theme.SimpleTextComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SimpleTextComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colors.background
                ) {
                    GreetingButton()
                }
            }
        }
    }
}

@Composable
fun GreetingText(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun GreetingButton() {

    Button(onClick = {}) {
        GreetingText(name = "beautiful button")
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SimpleTextComposeTheme {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colors.background
        ) {
            GreetingButton()
        }
    }
}