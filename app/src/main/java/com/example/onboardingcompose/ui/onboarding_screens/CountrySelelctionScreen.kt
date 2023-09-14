package com.example.onboardingcompose.ui.onboarding_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconToggleButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.onboardingcompose.ui.theme.OnboardingComposeTheme

@Preview
@Composable
fun PreviewCountrySelectionScreen() {
    OnboardingComposeTheme {
        CountrySelectionScreen {

        }
    }
}

@Composable
fun CountrySelectionScreen(
    onboardingViewModel: OnboardingViewModel = viewModel(), onClick: () -> Unit
) {

    val listOfCountry = onboardingViewModel.countryList.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 24.dp, end = 24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            modifier = Modifier.weight(1f) // Takes up available space between top and bottom elements
        ) {
            Spacer(modifier = Modifier.height(7.dp))
            Text(
                text = "First, can you tell us where you live?",
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "Location", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(10.dp))

            //val listState = rememberSaveable(mutableListOf(listOfCountries))

            listOfCountry.value.forEachIndexed { index, country ->
                CountryItem(country = country) {
                    onboardingViewModel.updateSelectedItem(index)
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
        Button(modifier = Modifier.fillMaxWidth(), onClick = { onClick() }) {
            Text(text = "Next")
        }
        Spacer(modifier = Modifier.height(5.dp))
    }

}

@Composable
fun CountryItem(country: Country, onSelect: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 9.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                country.flag?.let { id ->
                    Image(
                        painter = painterResource(id = id),
                        contentDescription = country.flagDescription,
                        modifier = Modifier.size(35.dp)
                    )
                    Spacer(modifier = Modifier.width(7.dp))
                }
                Text(text = country.name, style = MaterialTheme.typography.bodyMedium)
            }
            Checkbox(checked = country.selected, onCheckedChange = { onSelect() })
        }
    }
}

data class Country(
    val flag: Int? = null,
    val flagDescription: String,
    val name: String,
    val selected: Boolean = false
)

