package com.dam.api.commons.api

import java.io.Serializable

interface GenericServiceAPI<T, ID: Serializable> {
    fun insertOne(entity:T): T
    fun deleteOne(id: ID)
    operator fun get(id: ID): T?
    val all: MutableList<T>?
}