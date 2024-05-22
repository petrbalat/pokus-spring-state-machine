package cz.petrbalat.statemachine.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.ColumnDefault
import java.time.LocalDateTime

@Entity
@Table(name = "USERS")
open class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Int = 0

    open lateinit var username: String

    open lateinit var password: String

    open var name: String? = null

    open var surname: String? = null

    @ColumnDefault("LOCALTIMESTAMP")
    @Column(name = "CREATED", nullable = false)
    open var created: LocalDateTime = LocalDateTime.now()
}
