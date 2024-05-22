package cz.petrbalat.statemachine.api

import cz.petrbalat.statemachine.entity.User
import cz.petrbalat.statemachine.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.messaging.MessageHeaders
import org.springframework.messaging.support.GenericMessage
import org.springframework.statemachine.StateMachine
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import kotlin.jvm.optionals.getOrNull

@RestController
@RequestMapping("/api/users")
class UserApiController(
    private val repository: UserRepository,
    private val stateMachine: StateMachine<String, String>,
    ) {

    @GetMapping
    fun all(): List<User> = repository.findAll()

    @PostMapping("/state-transition")
    fun state(@RequestParam transition: String, @RequestParam id: Int): Unit {
        val user: User = repository.findById(id).getOrNull() ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

        // FIXME s kontextem userId
        stateMachine.start()
        stateMachine.sendEvent(GenericMessage("E1", MessageHeaders(mapOf("id" to id))))


    }
}
