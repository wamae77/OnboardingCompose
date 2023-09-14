package com.example.onboardingcompose.ui.components

import android.widget.TextView
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview


@Preview
@Composable
fun PreviewOnboardingTextView(){
    OnboardingTextView()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingTextView(modifier: Modifier =Modifier){
    OutlinedTextField(
        modifier = modifier,
        value = "",
        onValueChange = { },
        label = { Text("Label") },
    )
}
