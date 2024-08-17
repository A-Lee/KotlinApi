package no.ali.KotlinApi.`interface`

import no.ali.KotlinApi.dto.PersonDto
import no.ali.KotlinApi.dto.Response

interface IPersonRepository {
    fun addPerson(person: PersonDto) : Response;

    fun getPeople(): Response;

    fun getPersonById(id: Int): Response;
    fun getPersonByName(firstName: String, lastName: String): Response;
    fun deletePersonById(id: Int): Response;
    fun deletePersonByName(firstName: String, lastName: String): Response;
    //fun UpdatePerson(person: Person): Response;

    fun exists(firstName: String, lastName: String): Boolean;
}