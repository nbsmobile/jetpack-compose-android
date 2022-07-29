package com.nbs.moviecompose.composable.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.nbs.moviecompose.R
import com.nbs.moviecompose.composable.model.FormValidationData
import com.nbs.moviecompose.composable.style.Colors
import com.nbs.moviecompose.composable.style.Dimensions
import com.nbs.moviecompose.composable.style.MovieComposeTheme
import com.nbs.moviecompose.composable.utils.asDisabledColor
import com.nbs.moviecompose.composable.utils.withColor
import com.nbs.moviecompose.utils.emptyString

typealias OnFormValueChange = (String) -> Unit
typealias OnImeKeyAction = (KeyboardOptions) -> Unit

@Composable
fun ValidationForm(
    modifier: Modifier = Modifier,
    isPasswordForm: Boolean = false,
    onFormValueChange: OnFormValueChange? = null,
    onImeKeyAction: OnImeKeyAction? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    singleLine: Boolean = false,
    readOnly: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    state: MutableState<FormValidationData>,
    errorTag: String = emptyString()
) {
    val data by state
    val showPassword = remember { mutableStateOf(false) }

    MovieComposeTextField(
        value = data.text,
        onFormValueChange = onFormValueChange,
        isError = data.isError,
        errorMsg = data.errorMessage,
        hint = data.hint,
        modifier = modifier,
        trailingIcon = if (isPasswordForm) passwordToggleView(showPassword.value) {
            showPassword.value = !showPassword.value
        } else trailingIcon,
        visualTransformation = if (!showPassword.value && isPasswordForm) PasswordVisualTransformation() else VisualTransformation.None,
        onImeKeyAction = onImeKeyAction,
        leadingIcon = leadingIcon,
        readOnly = readOnly,
        keyboardOptions = keyboardOptions,
        singleLine = singleLine,
        maxLines = maxLines,
        errorTag = errorTag
    )
}

@Composable
fun MovieComposeTextField(
    modifier: Modifier = Modifier,
    value: String,
    onFormValueChange: OnFormValueChange?,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onImeKeyAction: OnImeKeyAction?,
    readOnly: Boolean = false,
    hint: String = emptyString(),
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    errorMsg: String = emptyString(),
    errorTag: String = emptyString()
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(Dimensions.SIZE_0)
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = {
                onFormValueChange?.invoke(it)
            },
            modifier = modifier
                .fillMaxWidth()
                .height(Dimensions.SIZE_50)
                .padding(Dimensions.SIZE_0),
            enabled = !readOnly,
            singleLine = singleLine,
            readOnly = readOnly,
            visualTransformation = visualTransformation,
            textStyle = MovieComposeTheme.typography.normal.withColor(MovieComposeTheme.colors.colorTextPrimary),
            placeholder = {
                Text(
                    modifier = Modifier
                        .wrapContentHeight(align = Alignment.CenterVertically)
                        .padding(Dimensions.SIZE_0),
                    text = hint,
                    style = MovieComposeTheme.typography.normal.withColor(MovieComposeTheme.colors.colorTextPrimary.asDisabledColor()),
                )
            },
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            isError = isError,
            keyboardOptions = keyboardOptions,
            keyboardActions = KeyboardActions(onAny = {
                onImeKeyAction?.invoke(keyboardOptions)
            }),
            maxLines = maxLines,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = MovieComposeTheme.colors.colorTextPrimary,
                backgroundColor = Color.Transparent,
                focusedBorderColor = MovieComposeTheme.colors.colorTextSecondary,
                unfocusedBorderColor = MovieComposeTheme.colors.colorTextSecondary,
                disabledBorderColor = MovieComposeTheme.colors.colorTextSecondary
            )
        )

        if (isError) {
            Text(
                modifier = Modifier
                    .padding(start = Dimensions.SIZE_8, top = Dimensions.SIZE_8)
                    .semantics { testTag = errorTag },
                text = errorMsg,
                style = MovieComposeTheme.typography.normal.withColor(Colors.red),
            )
        }
    }
}

@Composable
fun passwordToggleView(showPassword: Boolean, onClick: () -> Unit): @Composable () -> Unit {
    val icon =
        if (showPassword) painterResource(id = R.drawable.ic_password_show) else painterResource(
            id = R.drawable.ic_password_hide
        )

    return {
        IconButton(onClick = onClick) {
            Image(
                icon,
                contentDescription = "Password Toggle"
            )
        }
    }
}