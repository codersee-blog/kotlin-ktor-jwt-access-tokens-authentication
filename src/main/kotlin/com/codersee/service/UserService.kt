package com.codersee.service

import com.codersee.model.User
import com.codersee.repository.UserRepository
import java.util.*

class UserService(
  private val userRepository: UserRepository
) {

  fun findAll(): List<User> =
    userRepository.findAll()

  fun findById(id: String): User? =
    userRepository.findById(
      id = UUID.fromString(id)
    )

  fun findByUsername(username: String): User? =
    userRepository.findByUsername(username)

  fun save(user: User): User? {
    val foundUser = userRepository.findByUsername(user.username)

    return if (foundUser == null) {
      userRepository.save(user)
      user
    } else null
  }
}