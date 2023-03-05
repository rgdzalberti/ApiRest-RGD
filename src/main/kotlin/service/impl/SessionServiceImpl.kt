package com.dam.api.service.impl

import com.dam.api.commons.impl.GenericServiceImpl
import com.dam.api.model.Session
import com.dam.api.repository.SessionRepository
import com.dam.api.service.api.SesionServiceAPI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class SessionServiceImpl : SesionServiceAPI, GenericServiceImpl<Session, Long>() {

    @Autowired
    lateinit var sessionRepository: SessionRepository;

    override val dao: CrudRepository<Session, Long>
        get() = sessionRepository

    override fun getFutureSessions(sessions: MutableList<Session>?): MutableList<Session> {
        val today = LocalDate.now()
        return sessions?.filter { it.date.isAfterOrEqual(today) }?.toMutableList() ?: mutableListOf()
    }

    override fun getTodaySessions(sessions: MutableList<Session>?): MutableList<Session> {
        val today = LocalDate.now()
        return sessions?.filter { it.date.isEqual(today) }?.toMutableList() ?: mutableListOf()
    }

    override fun getAllSessions(sessions: MutableList<Session>?): MutableList<Session> {
        if (sessions != null) return sessions else return emptyList<Session>().toMutableList()
    }

    fun LocalDate.isAfterOrEqual(other: LocalDate): Boolean {
        return this.isEqual(other) || this.isAfter(other)
    }

}