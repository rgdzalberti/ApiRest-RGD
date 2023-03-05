package com.dam.api.model

import jakarta.persistence.*

@Entity
@Table(name="user")
class User(

    @Column(name="nick")
    var nick: String,
    @Column(name="email")
    var email: String,
    @Column(name="profilePicture")
    var profilePicture: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?
) {
}