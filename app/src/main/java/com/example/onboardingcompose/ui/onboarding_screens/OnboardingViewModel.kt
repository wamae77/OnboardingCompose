package com.example.onboardingcompose.ui.onboarding_screens

import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import com.example.onboardingcompose.R
import com.example.onboardingcompose.ui.onboarding_screens.models.EmploymentDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update


class OnboardingViewModel : ViewModel() {

    private val _employmentDetails = MutableStateFlow(EmploymentDetails())
    val employmentDetails: StateFlow<EmploymentDetails> = _employmentDetails
    val countryCode = listOf("+254", "+255", "+256")


    private val _countryList = MutableStateFlow(
        listOf(
            Country(
                flag = R.drawable.ke,
                name = "Kenya",
                flagDescription = "Kenya",
                selected = true
            ), Country(
                flag = R.drawable.tanzania_flag_icon,
                name = "Tanzania",
                flagDescription = "Tanzania"
            ), Country(flag = R.drawable.uganda, name = "Uganda", flagDescription = "Uganda")
        )
    )

    val countryList: StateFlow<List<Country>> = _countryList

    fun updateSelectedItem(index: Int) {
        _countryList.value = _countryList.value.mapIndexed { i, country ->
            if (i == index) {
                country.copy(selected = true)
            } else {
                country.copy(selected = false)
            }
        }
    }

    fun updateEmploymentDetails(mEmploymentDetails: EmploymentDetails) {
        _employmentDetails.update {
            it.copy(
                companyName = mEmploymentDetails.companyName,
                department = mEmploymentDetails.department,
                employeeNumber = mEmploymentDetails.employeeNumber,
                disability = mEmploymentDetails.disability,
                employmentStatus = mEmploymentDetails.employmentStatus,
                designation = mEmploymentDetails.designation,
                companyContact = mEmploymentDetails.companyContact,
                companyEmail = mEmploymentDetails.companyEmail,
                address = mEmploymentDetails.address,
                country = mEmploymentDetails.country,
                town = mEmploymentDetails.town,
            )
        }
    }


}