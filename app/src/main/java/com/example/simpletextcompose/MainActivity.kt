package com.example.simpletextcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simpletextcompose.ui.theme.SimpleTextComposeTheme

val names: ArrayList<String> = arrayListOf("Jeff", "Rol", "Mel", "Xof")

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
                    MainScreen(Color.Blue) {
                        names.add("new user!")
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(color: Color, onColoredButtonClick: () -> Unit) {

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {


            GreetingList(color)
        }

    }

}

@SuppressLint("UnrememberedMutableState")
@Composable
fun GreetingList(color: Color) {

    val greetingListState: SnapshotStateList<String> = remember { mutableStateListOf("Jeff") }


    greetingListState.forEach {
        GreetingText(msg = it, color = color)
    }
    ColoredButton {
        greetingListState.add("new user")
    }
}

@Composable
fun GreetingText(msg: String, color: Color) {
    Text(
        text = "Hello $msg!",
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
fun ColoredButton(onColoredButtonClick: () -> Unit) {

    Button(
        onClick = { onColoredButtonClick() },
        modifier = Modifier
            .width(150.dp)
            .height(60.dp)
    ) {
        Text(text = "add a new user", color = Color.Magenta)
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
            MainScreen(color = Color.Green) {

                names.add("new user!")
            }
        }
    }
}