package cz.petrbalat.statemachine

import cz.petrbalat.statemachine.entity.User
import cz.petrbalat.statemachine.repository.UserRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.statemachine.data.jpa.JpaRepositoryStateMachine
import org.springframework.statemachine.data.jpa.JpaStateMachineRepository

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = [UserRepository::class])
@EntityScan(basePackageClasses = [User::class])
class PokusSpringStateMachineApplication

fun main(args: Array<String>) {
	runApplication<PokusSpringStateMachineApplication>(*args)
}
