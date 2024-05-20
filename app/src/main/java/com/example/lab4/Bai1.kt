package com.example.lab4

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Bai1 : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			LoginScreen()
		}
	}
}

@Preview(showBackground = true)
@Composable
fun LoginScreen() {
	val context = LocalContext.current
	var userName by remember { mutableStateOf("") }
	var passWord by remember { mutableStateOf("") }
	Column(
		modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {
		Image(
			painter = painterResource(id = R.drawable.ic_launcher_foreground),
			contentDescription = "logo"
		)
		Spacer(modifier = Modifier.size(120.dp))
		OutlinedTextField(
			value = userName, onValueChange = { userName = it },
			label = { Text("Username") },
		)
		Spacer(modifier = Modifier.height(8.dp))
		OutlinedTextField(
			value = passWord, onValueChange = { passWord = it },
			label = { Text("Password") },
			visualTransformation = PasswordVisualTransformation()
		)
		Spacer(modifier = Modifier.height(16.dp))
		
		Button(
			onClick = {
				if (userName.isNotBlank() && passWord.isNotBlank()) {
					Toast.makeText(
						context, "Login successful",
						Toast.LENGTH_LONG
					).show()
				} else {
					Toast.makeText(
						context, "Please enter username and password",
						Toast.LENGTH_LONG
					).show()
				}
			},
			colors = ButtonDefaults.buttonColors(
				containerColor = Color.DarkGray,
				contentColor = Color.White
			)
		)
		{
			Text("Login")
		}
	}
}
