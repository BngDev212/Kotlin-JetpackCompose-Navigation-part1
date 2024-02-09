package com.tmdsimple.myloginapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navigationToMainScreen:()->Unit) {
    val userName = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val keyboardController = LocalSoftwareKeyboardController.current

        var isPasswordVisible by remember {
            mutableStateOf(false)
        }

        TextField(value=userName.value,
            onValueChange = {userName.value =it},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            singleLine = true,

            modifier = Modifier.fillMaxWidth()
                .padding(10.dp),
            label = { Text("User Name") } )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(value=password.value,
            onValueChange = {password.value =it},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null
                )
            },
            trailingIcon = {
                IconButton(onClick = {
                    isPasswordVisible = !isPasswordVisible
                }) {

                    val visibleIconAndText = Pair(
                        first = Icons.Outlined.Visibility,
                        second = stringResource(id = R.string.icon_password_visible)
                    )

                    val hiddenIconAndText = Pair(
                        first = Icons.Outlined.VisibilityOff,
                        second = stringResource(id = R.string.icon_password_hidden)
                    )

                    val passwordVisibilityIconAndText =
                        if (isPasswordVisible) visibleIconAndText else hiddenIconAndText

                    // Render Icon
                    Icon(
                        imageVector = passwordVisibilityIconAndText.first,
                        contentDescription = passwordVisibilityIconAndText.second
                    )
                }
            },
            label = { Text("Password") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
                .padding(10.dp),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navigationToMainScreen()
        } ){
            Text("Login")
        }


    }
}


