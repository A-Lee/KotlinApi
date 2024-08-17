package no.ali.KotlinApi.service

import no.ali.KotlinApi.dto.PersonDto
import no.ali.KotlinApi.dto.Response
import no.ali.KotlinApi.`interface`.IPersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonService @Autowired constructor(private val repository: IPersonRepository) {

    fun getPeople(): Response{
        return repository.getPeople();
    }

    fun getPersonByName(firstName: String, lastName: String): Response{
        return repository.getPersonByName(firstName, lastName);
    }

    fun getPersonById(id: Int): Response{
        return repository.getPersonById(id);
    }

    fun addPerson(person: PersonDto): Response{
        return repository.addPerson(person);
    }

    fun deletePersonById(id: Int): Response{
        return repository.deletePersonById(id);
    }

    fun deletePersonByName(firstName: String, lastName: String): Response{
        return repository.deletePersonByName(firstName, lastName);
    }

}