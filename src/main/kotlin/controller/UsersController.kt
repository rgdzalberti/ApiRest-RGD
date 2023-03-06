package com.dam.api.controller

import com.dam.api.dto.UserDTO
import com.dam.api.model.User
import com.dam.api.service.api.UserServiceAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin("*")
class UsersController {

    @Autowired
    lateinit var userService: UserServiceAPI;

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<User>> {
        val users = userService.all
        return ResponseEntity.ok(users)
    }
    @GetMapping("/{nick}")
    fun getUserByNick(@PathVariable nick: String): ResponseEntity<List<User>?> {
        val users = userService.getUserByNick(nick)
            return ResponseEntity.ok(users)
        }

    @PostMapping
    fun createUser(@RequestBody request: UserDTO): ResponseEntity<Void?>? {
        val user = User(
            id = null,
            nick = request.nick,
            email = request.email,
            profilePicture = request.profilePicture
        )
        userService.insertUser(user)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @PutMapping("/{nick}")
    fun updateUser(@PathVariable("nick") nick: String, @RequestBody request: UserDTO): ResponseEntity<Void?>? {
        if (userService.updateUser(nick,User(request.nick,request.email,request.profilePicture,null))) {
            return ResponseEntity(HttpStatus.OK)
        } else {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/{nick}")
    fun deleteUser(@PathVariable nick: String): ResponseEntity<Void> {

        if (userService.deleteUserByNick(nick)){
            return ResponseEntity.ok().build()
        } else return ResponseEntity.notFound().build()

    }


}
