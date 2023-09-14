package com.example.onboardingcompose

interface OnboardingDestinations{
    val route:String
}
object CountrySelection:OnboardingDestinations{
    override val route: String
        get() = "country-selection"
}
object EmploymentDetails:OnboardingDestinations{
    override val route: String
        get() = "employment"

}
object PersonalInfo:OnboardingDestinations{
    override val route: String
        get() = "personal-info"

}