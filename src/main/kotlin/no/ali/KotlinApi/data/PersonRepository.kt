package no.ali.KotlinApi.data

import no.ali.KotlinApi.Person
import no.ali.KotlinApi.dto.PersonDto
import no.ali.KotlinApi.dto.Response
import no.ali.KotlinApi.`interface`.IPersonRepository
import no.ali.KotlinApi.utils.PersonUtility
import org.springframework.stereotype.Repository

@Repository
class PersonRepository : IPersonRepository{
    val personList = mutableListOf<Person>();

    override fun addPerson(person: PersonDto) : Response {
        if(exists(person.firstName, person.lastName)){
            return Response(
                false,
                null,
                "Person ${person.fullname} already exists"
            )
        }
        personList.add(PersonUtility.convertToPerson(person, personList));
        return Response(
          true,
           "${person.fullname} has been added to the list",
            ""
        );
    }

    override fun getPeople(): Response {
        return Response(
            true,
            personList,
            ""
        )
    }

    override fun getPersonById(id: Int): Response{
        val person : Person? = personList.find { it.id == id }
        return if(person == null) Response(
            false,
            null,
            "No person with id ${id} in the list."
        )
        else Response(
            true,
            PersonUtility.convertToDto(person),
            ""
        );
    }

    override fun getPersonByName(firstName: String, lastName: String): Response {
        val person : Person? = personList.find { it.firstName.equals(firstName, ignoreCase = true) && it.lastName.equals(lastName, ignoreCase = true)  };
        return if(person == null) Response(
            false,
            null,
            "No person named ${"$firstName $lastName"} in the list."
        )
        else Response(
            true,
            PersonUtility.convertToDto(person),
            ""
        );
    }

    override fun deletePersonById(id: Int): Response {
        val person : Person? = personList.find { it.id == id }
        if(person != null){
            personList.remove(person);
            return Response(
                true,
                "Person ${person.fullname} has been deleted",
                ""
            )
        }
        return Response(
            false,
            null,
            "No person with id ${id} in the list."
        )
    }

    override fun deletePersonByName(firstName: String, lastName: String): Response {
        val person : Person? = personList.find { it.firstName.equals(firstName, ignoreCase = true) && it.lastName.equals(lastName, ignoreCase = true)  };
        if(person != null){
            personList.remove(person);
            return Response(
                true,
                "Person ${person.fullname} has been deleted",
                ""
            )
        }
        return Response(
            false,
            null,
            "No person named ${"$firstName $lastName"} in the list."
        )
    }

    override fun exists(firstName: String, lastName: String): Boolean {
        return personList.filter { it.firstName.equals(firstName, ignoreCase = true) && it.lastName.equals(lastName) }
            .isNotEmpty()
    }
}