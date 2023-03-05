package com.dam.api.service.impl

import com.dam.api.commons.impl.GenericServiceImpl
import com.dam.api.model.Movie
import com.dam.api.repository.MovieRepository
import com.dam.api.service.api.MovieServiceAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class MovieServiceImpl : MovieServiceAPI, GenericServiceImpl<Movie, Long>() {

    @Autowired
    lateinit var repository: MovieRepository;

    override val dao: CrudRepository<Movie, Long>
    get() = repository;

}