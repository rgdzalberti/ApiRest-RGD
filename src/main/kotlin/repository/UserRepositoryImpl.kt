package com.dam.api.repository

import com.dam.api.model.User

abstract class UserRepositoryImpl : UserRepository {

    override fun findByNick(nick: String): List<User>? {
        val listaUsuarios: MutableIterable<User> = findAll()
        return listaUsuarios.filter { it.nick == nick }.toMutableList()
    }

}
