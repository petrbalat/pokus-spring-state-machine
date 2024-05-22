package cz.petrbalat.statemachine.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.statemachine.config.EnableStateMachineFactory
import org.springframework.statemachine.config.StateMachineConfigurerAdapter
import org.springframework.statemachine.data.jpa.JpaPersistingStateMachineInterceptor
import org.springframework.statemachine.data.jpa.JpaStateMachineRepository
import org.springframework.statemachine.persist.StateMachineRuntimePersister

@Configuration
@EnableStateMachineFactory
class StateConfig : StateMachineConfigurerAdapter<String, String>() {

    @Bean
    fun stateMachineRuntimePersister(jpaStateMachineRepository: JpaStateMachineRepository): StateMachineRuntimePersister<String, String, String> {
        return JpaPersistingStateMachineInterceptor(jpaStateMachineRepository)
    }
}
