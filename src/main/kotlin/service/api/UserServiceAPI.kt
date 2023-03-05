package com.dam.api.service.api

import com.dam.api.commons.api.GenericServiceAPI
import com.dam.api.model.User

interface UserServiceAPI : GenericServiceAPI<User, Long> {

   fun insertUser(user: User)
   fun getUserByNick(nick: String): List<User>?
   fun deleteUserByNick(nick: String)
   fun updateUser(nick: String,user: User):Boolean

}