@file:OptIn(ExperimentalComposeUiApi::class)

package com.nbs.moviecompose.presentation.main

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import com.nbs.moviecompose.composable.component.MovieComposeButton
import com.nbs.moviecompose.composable.component.ValidationForm
import com.nbs.moviecompose.composable.model.FormValidationData
import com.nbs.moviecompose.composable.style.Dimensions
import com.nbs.moviecompose.composable.style.MovieComposeTheme
import com.nbs.moviecompose.composable.style.TextSizes
import com.nbs.moviecompose.composable.utils.withSize
import com.nbs.moviecompose.utils.emailRegex
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun ProfileScreen(navigator: DestinationsNavigator) {
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MovieComposeTheme.colors.colorPrimary)
            .padding(Dimensions.SIZE_16),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val context = LocalContext.current

        val emailValidation =
            remember {
                mutableStateOf(
                    FormValidationData(
                        hint = "Masukkan Email",
                        errorMessage = "Format Email Salah"
                    )
                )
            }

        val passwordValidation =
            remember {
                mutableStateOf(
                    FormValidationData(
                        hint = "Masukkan Password",
                        errorMessage = "Password Tidak Boleh Kosong"
                    )
                )
            }

        val buttonValidation =
            !emailValidation.value.isError &&
                    !passwordValidation.value.isError &&
                    emailValidation.value.text.isNotEmpty() &&
                    passwordValidation.value.text.isNotEmpty()


        Text(
            "Login",
            style = MovieComposeTheme.typography.bold.withSize(TextSizes.SIZE_16),
            modifier = Modifier
        )

        Spacer(modifier = Modifier.height(Dimensions.SIZE_24))

        ValidationForm(
            modifier = Modifier.fillMaxWidth(),
            state = emailValidation,
            onFormValueChange = {
                emailValidation.value = emailValidation.value.copy(
                    text = it,
                    isError = !it.matches(Regex(emailRegex))
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            onImeKeyAction = {
                keyboardController?.hide()
            }
        )

        Spacer(modifier = Modifier.height(Dimensions.SIZE_16))

        ValidationForm(
            modifier = Modifier.fillMaxWidth(),
            state = passwordValidation,
            isPasswordForm = true,
            onFormValueChange = {
                passwordValidation.value = passwordValidation.value.copy(
                    text = it,
                    isError = it.isEmpty()
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            onImeKeyAction = {
                keyboardController?.hide()
            }
        )

        Spacer(modifier = Modifier.height(Dimensions.SIZE_32))

        MovieComposeButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Login",
            enabled = buttonValidation,
            onClick = {
                Toast.makeText(context, "Login Clicked", Toast.LENGTH_SHORT).show()
            }
        )
    }
}