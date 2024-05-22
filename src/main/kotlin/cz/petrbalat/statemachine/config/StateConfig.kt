package cz.petrbalat.statemachine.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.statemachine.config.EnableStateMachineFactory
import org.springframework.statemachine.config.StateMachineConfigurerAdapter
import org.springframework.statemachine.config.builders.StateMachineModelConfigurer
import org.springframework.statemachine.config.model.StateMachineModelFactory
import org.springframework.statemachine.data.jpa.JpaPersistingStateMachineInterceptor
import org.springframework.statemachine.data.jpa.JpaStateMachineRepository
import org.springframework.statemachine.persist.StateMachineRuntimePersister
import org.springframework.statemachine.uml.UmlStateMachineModelFactory

@Configuration
@EnableStateMachineFactory
class StateConfig : StateMachineConfigurerAdapter<String, String>() {

    @Bean
    fun stateMachineRuntimePersister(jpaStateMachineRepository: JpaStateMachineRepository): StateMachineRuntimePersister<String, String, String> =
        JpaPersistingStateMachineInterceptor(jpaStateMachineRepository)

    override fun configure(model: StateMachineModelConfigurer<String, String>) {
        model.withModel().factory(modelFactory()) // TODO multiple xml
    }

    @Bean
    fun modelFactory(): StateMachineModelFactory<String, String> {
        val modelFactory = UmlStateMachineModelFactory("classpath:/states/example-s1-s2.xml")
        return modelFactory
    };
}
