package com.dam.api.service.api

import com.dam.api.commons.api.GenericServiceAPI
import com.dam.api.model.Session

interface SesionServiceAPI : GenericServiceAPI<Session, Long> {
     fun getFutureSessions(sessions: MutableList<Session>?): MutableList<Session>
     fun getTodaySessions(sessions: MutableList<Session>?): MutableList<Session>
     fun getAllSessions(sessions: MutableList<Session>?): MutableList<Session>
}