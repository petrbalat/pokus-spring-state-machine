package cz.petrbalat.statemachine.api

import cz.petrbalat.statemachine.entity.User
import cz.petrbalat.statemachine.repository.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserApiController(private val repository: UserRepository) {

    @GetMapping
    fun all(): List<User> = repository.findAll()
}
