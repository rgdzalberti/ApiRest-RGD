package com.dam.api.commons.impl

import com.dam.api.commons.api.GenericServiceAPI
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.io.Serializable

@Service
abstract class GenericServiceImpl<T: Any, ID: Serializable> : GenericServiceAPI<T, ID> {

    override fun insertOne(entity: T): T {
        return dao.save(entity)
    }

    override fun deleteOne(id: ID) {
        dao.deleteById(id)
    }

    override fun get(id: ID): T? {
        return dao.findByIdOrNull(id)
    }

    override val all: MutableList<T>?
        get() {
            val returnList: MutableList<T> = mutableListOf()
            dao.findAll().forEach{ obj: T -> returnList.add(obj) }
            return returnList;
        }

    abstract val dao: CrudRepository<T, ID>
}