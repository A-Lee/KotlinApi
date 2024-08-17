package no.ali.KotlinApi.dto

data class PersonDto(val firstName: String, val lastName: String, val age: Int) {
    val fullname: String
    get() = "$firstName $lastName";

    private fun getFullInfo() : String {
        return "First name: $firstName\nLast name: $lastName\nAge: $age\n";
    }
}