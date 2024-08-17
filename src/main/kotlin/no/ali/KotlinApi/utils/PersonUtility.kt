package no.ali.KotlinApi.utils

import no.ali.KotlinApi.Person
import no.ali.KotlinApi.dto.PersonDto

object PersonUtility {
    fun convertToDto(person: Person): PersonDto {
        return PersonDto(
            firstName = person.firstName,
            lastName = person.lastName,
            age = person.age,
        );
    }

    fun convertToPerson(personDto: PersonDto, list: MutableList<Person>): Person {
        return Person(
            if(list.size > 0) list.maxOfOrNull { it.id }!! + 1 else 1,
            personDto.firstName,
            personDto.lastName,
            personDto.age,
        );
    }
}