package cz.petrbalat.statemachine

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PokusSpringStateMachineApplication

fun main(args: Array<String>) {
	runApplication<PokusSpringStateMachineApplication>(*args)
}
