package com.example.onboardingcompose.ui.onboarding_screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compulynx_prints_bio_capture.TestLibrary
import com.example.onboardingcompose.R
import com.example.onboardingcompose.ui.components.OnboardingDropDownMenu
import com.example.onboardingcompose.ui.onboarding_screens.models.EmploymentDetails
import com.example.onboardingcompose.ui.theme.OnboardingComposeTheme

@Preview
@Composable
fun PreviewPreviewEmploymentDetailsScreen() {
    OnboardingComposeTheme {
        PreviewEmploymentDetailsScreen(navigate = { /*TODO*/ })
    }
}

@Composable
fun PreviewEmploymentDetailsScreen(
    modifier: Modifier = Modifier,
    navigate: () -> Unit,
    onboardingViewModel: OnboardingViewModel = viewModel()
) {
    val employmentDetails = onboardingViewModel.employmentDetails.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 24.dp, end = 24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.weight(1f)
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
                text = stringResource(id = R.string.employment_status),
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(5.dp))

            val listOfEmploymentStatus = stringArrayResource(id = R.array.employmentStatus).toList()
            OnboardingDropDownMenu(
                options = listOfEmploymentStatus,
                selectedOption = employmentDetails.value.employmentStatus

            )

            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = stringResource(id = R.string.Disability),
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(5.dp))

            val disabledChoice =
                LocalContext.current.resources.getStringArray(R.array.choices).toList()
            OnboardingDropDownMenu(
                options = disabledChoice, selectedOption = employmentDetails.value.disability

            )

            Spacer(modifier = Modifier.height(5.dp))
        }
        Button(modifier = Modifier.fillMaxWidth(), onClick = { navigate() }) {
            Text(text = stringResource(id = R.string.next))
        }
        Spacer(modifier = Modifier.height(5.dp))
    }
}
