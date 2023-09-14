package com.example.onboardingcompose.ui.onboarding_screens

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconToggleButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compulynx_prints_bio_capture.TestLibrary
import com.example.onboardingcompose.EmploymentDetails
import com.example.onboardingcompose.R
import com.example.onboardingcompose.ui.components.OnboardingDropDownMenu

@Preview
@Composable
fun PreviewEmploymentDetailsScreen() {
    EmploymentDetailsScreen {

    }
}

@Composable
fun EmploymentDetailsScreen(
    modifier: Modifier = Modifier,
    onboardingViewModel: OnboardingViewModel = viewModel(),
    navigate: () -> Unit
) {
    val employmentDetails = onboardingViewModel.employmentDetails.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 24.dp, end = 24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = stringResource(id = R.string.just_few_more_questions),
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = stringResource(id = R.string.regulation_requirement_description),
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = stringResource(id = R.string.company_name),
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = stringResource(id = R.string.company_placeholder)) },
                value = employmentDetails.value.companyName,
                onValueChange = {
                    onboardingViewModel.updateEmploymentDetails(
                        employmentDetails.value.copy(
                            companyName = it
                        )
                    )
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
            )
            Spacer(modifier = Modifier.height(7.dp))
            Text(
                text = stringResource(id = R.string.department),
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = stringResource(id = R.string.department_placeholder)) },
                value = employmentDetails.value.department,
                onValueChange = {
                    onboardingViewModel.updateEmploymentDetails(
                        employmentDetails.value.copy(
                            department = it
                        )
                    )
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            )
            Spacer(modifier = Modifier.height(7.dp))
            Text(
                text = stringResource(id = R.string.employee_no),
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = stringResource(id = R.string.employee_no)) },
                value = employmentDetails.value.employeeNumber,
                onValueChange = {
                    onboardingViewModel.updateEmploymentDetails(
                        employmentDetails.value.copy(
                            employeeNumber = it
                        )
                    )
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            )

            Spacer(modifier = Modifier.height(7.dp))
            Text(
                text = stringResource(id = R.string.designation),
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = stringResource(id = R.string.designation)) },
                value = employmentDetails.value.designation,
                onValueChange = {
                    onboardingViewModel.updateEmploymentDetails(
                        employmentDetails.value.copy(
                            designation = it
                        )
                    )
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            )

            Spacer(modifier = Modifier.height(7.dp))
            Text(
                text = stringResource(id = R.string.company_contact),
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(5.dp))

            Row(
                verticalAlignment = Alignment.Bottom
            ) {

                val countryCodes = stringArrayResource(id = R.array.country_code).toList()
                OnboardingDropDownMenu(
                    modifier = Modifier.weight(0.9f),
                    countryCodes,
                    employmentDetails.value.countryCode
                )
                Spacer(modifier = Modifier.width(5.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(2f),
                    placeholder = { Text(text = stringResource(id = R.string.company_contact)) },
                    value = employmentDetails.value.companyContact,
                    onValueChange = {
                        onboardingViewModel.updateEmploymentDetails(
                            employmentDetails.value.copy(
                                companyContact = it
                            )
                        )
                    },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                )
            }
            Spacer(modifier = Modifier.height(7.dp))
            Text(
                text = stringResource(id = R.string.company_email),
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = stringResource(id = R.string.company_email_placeholder)) },
                value = employmentDetails.value.companyEmail,
                onValueChange = {
                    onboardingViewModel.updateEmploymentDetails(
                        employmentDetails.value.copy(
                            companyEmail = it
                        )
                    )
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    navigate()
                })
            )
        }
        Button(modifier = Modifier.fillMaxWidth(), onClick = { navigate() }) {
            Text(text = stringResource(id = R.string.next))
        }
        Spacer(modifier = Modifier.height(5.dp))
    }

}