package cz.petrbalat.statemachine.repository

import cz.petrbalat.statemachine.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

/**
 * @author petrbalat
 */
@Repository
@Transactional
interface UserRepository : JpaRepository<User, Int> {
}
