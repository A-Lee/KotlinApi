package no.ali.KotlinApi

data class Person(var id: Int, val firstName: String, val lastName: String, val age: Int) {
    val fullname: String
        get() = "$firstName $lastName";

    fun getFullInfo() : String {
        return "First name: $firstName\nLast name: $lastName\nAge: $age\n";
    }
}