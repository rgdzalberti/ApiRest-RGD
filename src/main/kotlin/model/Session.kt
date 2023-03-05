package com.dam.api.model

import jakarta.persistence.*
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDate

@Entity
@Table(name="session")
@EntityListeners(AuditingEntityListener::class)
class Session(
    @Column(name="room_id")
    var room_id: Long,
    @Column(name="date")
    var date: LocalDate,
    @ManyToOne()
    @JoinColumn(name = "movie_id")
    var pelicula_id: Movie,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long
) {
}