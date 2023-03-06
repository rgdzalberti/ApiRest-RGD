package com.dam.api.controller

import com.dam.api.model.Movie
import com.dam.api.service.impl.MovieServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/movies")
class MoviesController {

    @Autowired
    lateinit var moviesService: MovieServiceImpl;

    @GetMapping
    fun getAllMovies(): ResponseEntity<List<Movie>?> {
        var movies = moviesService.all
        return ResponseEntity.ok(movies)
    }

    @GetMapping("/{id}")
    fun getMovieById(@PathVariable id: Long): ResponseEntity<Movie> {
        val movie = moviesService.dao.findById(id)
        return if (movie.isPresent) {
            ResponseEntity.ok(movie.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }
}