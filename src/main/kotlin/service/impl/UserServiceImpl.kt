package com.dam.api.service.impl

import com.dam.api.commons.impl.GenericServiceImpl
import com.dam.api.model.User
import com.dam.api.repository.UserRepository
import com.dam.api.service.api.UserServiceAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserServiceAPI, GenericServiceImpl<User, Long>() {

    @Autowired
    lateinit var userRepository: UserRepository;

    override val dao: CrudRepository<User, Long>
        get() = userRepository

    override fun insertUser(user: User){
        insertOne(User(user.nick,user.email,user.profilePicture,null))
    }

    override fun getUserByNick(nick: String): List<User>? {
        return userRepository.findByNick(nick)
    }

    override fun deleteUserByNick(nick: String) {
        deleteOne(getUserByNick(nick)?.takeIf { it.isNotEmpty() }?.first {it.nick == nick}?.id!!)
    }


    override fun updateUser(nick: String, user: User):Boolean {

        if (!getUserByNick(nick).isNullOrEmpty()) {
            val updatedUser = getUserByNick(nick)?.first()
            if (updatedUser != null) {
                updatedUser.nick = user.nick
                updatedUser.email = user.email
                updatedUser.profilePicture = user.profilePicture
                insertOne(updatedUser)
                return true
            } else return false
        } else return false
    }
}
