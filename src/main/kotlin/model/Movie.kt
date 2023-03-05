package com.dam.api.model

import jakarta.persistence.*
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@Entity
@Table(name="movies")
@EntityListeners(AuditingEntityListener::class)
class Movie(
    @Column(name="title")
    var title: String,
    @Column(name="director")
    var director: String,
    @Column(name="time")
    var time: String,
    @Column(name="trailer")
    var trailer: String,
    @Column(name="poster_image")
    var poster_image: String,
    @Column(name="screenshot")
    var screenshot: String,
    @Column(name="synopsis")
    var synopsis: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0



) {
}
