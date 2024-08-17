package no.ali.KotlinApi.controller

import no.ali.KotlinApi.dto.PersonDto
import no.ali.KotlinApi.dto.Response
import no.ali.KotlinApi.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/person")
class PersonController @Autowired constructor(val personService: PersonService) {

    @GetMapping
    fun getPeople(): Response{
        return personService.getPeople();
    }

    @PostMapping
    fun addPerson(@RequestBody person: PersonDto): Response{
        return personService.addPerson(person);
    }

    @GetMapping("/{id}")
    fun getPersonById(@PathVariable("id") id: Int): Response{
        return personService.getPersonById(id);
    }

    @GetMapping("/{firstName}/{lastName}")
    fun getPersonByName(@PathVariable("firstName") firstName: String, @PathVariable lastName: String): Response{
        return personService.getPersonByName(firstName, lastName);
    }

    @DeleteMapping("/{id}")
    fun deletePersonById(@PathVariable id: Int) : Response {
        return personService.deletePersonById(id);
    }

    @DeleteMapping("/{firstName}/{lastName}")
    fun deletePersonByName(@PathVariable("firstName") firstName: String, @PathVariable("lastName") lastName: String): Response{
        return personService.deletePersonByName(firstName,lastName);
    }
}