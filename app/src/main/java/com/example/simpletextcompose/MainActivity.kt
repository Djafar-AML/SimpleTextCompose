package com.example.simpletextcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
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
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {

    val greetingListState: SnapshotStateList<String> = remember { mutableStateListOf() }

    val userInput: MutableState<String> = remember {
        mutableStateOf("")
    }

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


            GreetingList(greetingListState)

            UserNameInput(userInput.value) { newUserInput ->
                userInput.value = newUserInput
            }

            ColoredButton {
                if (userInput.value.isBlank().not()) {
                    greetingListState.add(userInput.value)
                }
            }

        }

    }

}

@SuppressLint("UnrememberedMutableState")
@Composable
fun GreetingList(greetingList: List<String>) {

    greetingList.forEach {
        GreetingText(msg = it, color = Color.LightGray)
    }

}

@Composable
fun UserNameInput(userInput: String, userNewInput: (String) -> Unit) {

    TextField(value = userInput, onValueChange = { userNewInput(it) })

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
            MainScreen()
        }
    }

}