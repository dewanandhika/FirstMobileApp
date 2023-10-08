package com.example.firstmobileapp

import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firstmobileapp.ui.theme.FirstMobileAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstMobileAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
//                    Welcome()
//                    TryRow()
//                    TryColumn()
//                    TryColumnModifier()
//                    TryAnotherColumnModifier()
//                    TryMakeLogin()
//                    WelcomeScreen()
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "homepage") {
                        composable("homepage") {
                            WelcomeScreen(navController)
                        }
                        composable("pagetwo") {
                            PageTwo(navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstMobileAppTheme {
        Greeting("Android")
    }
}

@Composable
fun Welcome() {
    Text(text = "Dewa")
}

@Composable
fun TryRow() {
    Row {
        Text(text = "Nama")
        Text(text = "NIM")
    }
}

@Composable
fun TryColumn() {
    Column {
        Text(text = "Program Studi")
        Text(text = "Kelas")
    }
}

@Composable
fun TryColumnModifier() {
    Column {
        Text(text = "Nomor Telepon", modifier = Modifier.padding(24.dp))
        Text(text = "Email")
    }
}

@Composable
fun TryAnotherColumnModifier() {
    val expanded = remember { mutableStateOf(false) }
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
            Row {
                Text(text = if (expanded.value) "Expanded" else "Not Expanded")
                Text(text = "Row 2")
            }

            ElevatedButton(onClick = { expanded.value = !expanded.value }) {
                Text(text = "Submit")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(navController: NavController) {
//    val imageView = ImageView(this) // "this" mengacu pada konteks aktivitas
//    imageView.setImageResource(R.drawable.dew)
//    imageView.layoutParams = ViewGroup.LayoutParams(
//        ViewGroup.LayoutParams.WRAP_CONTENT,
//        ViewGroup.LayoutParams.WRAP_CONTENT
//    )
    val usernameField = remember { mutableStateOf(TextFieldValue("")) }
    val passwordField = remember { mutableStateOf(TextFieldValue("")) }
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.dew), // Specify the image resource
                contentDescription = null, // Provide a content description if needed
                modifier = Modifier.size(200.dp) // Set the size of the image
            )
            OutlinedTextField(value = usernameField.value,
                onValueChange = {
                    usernameField.value = it
                },
                label = { Text(text = "Username") },
                placeholder = { Text(text = "") })
            OutlinedTextField(value = passwordField.value,
                onValueChange = {
                    passwordField.value = it
                },
                label = { Text(text = "Password") },
                placeholder = { Text(text = "") })
            Spacer(modifier = Modifier.padding(5.dp))
            ElevatedButton(onClick = { navController.navigate("pagetwo") }) {
                Text(text = "Login")
            }
        }
    }
}

@Composable
fun PageTwo(navController: NavController) {
    Column (modifier = Modifier.fillMaxWidth()) {
        (Text(text = "Dewa UI", textAlign = TextAlign.Center,modifier = Modifier.fillMaxWidth()))
        //    Text("DEWA UI")
        ElevatedButton(onClick = { navController.navigate("homepage") }) {
            Text(text = "Kembali")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TryMakeLogin() {
    val expanded = remember { mutableStateOf(false) }
    val usernameState = remember { mutableStateOf(TextFieldValue("")) }
    val passwordState = remember { mutableStateOf(TextFieldValue("")) }

    Row(
        horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(value = usernameState.value,
                onValueChange = {
                    usernameState.value = it
                },
                label = { Text(text = "Username") },
                placeholder = { Text(text = "Your Username") })
            OutlinedTextField(value = passwordState.value,
                onValueChange = {
                    passwordState.value = it
                },
                label = { Text(text = "Password") },
                placeholder = { Text(text = "Your Password") })
            Spacer(modifier = Modifier.padding(10.dp))
            ElevatedButton(onClick = { expanded.value = !expanded.value }) {
                Text(text = "Submit")
            }
        }
    }
}




