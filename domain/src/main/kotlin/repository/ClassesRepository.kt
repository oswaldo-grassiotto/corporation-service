package repository

import entity.Classes

interface ClassesRepository {

    fun save(bean: Classes): String

    fun update(value: Classes) : Boolean

    fun fetchAll() : Array<Classes>

    fun remove(classesId: String) : Boolean

}