package service

import entity.Classes
import repository.ClassesRepository

class ClassesService(val repository: ClassesRepository) {
    fun createClasses(value: Classes){}
    fun searchAllClasses(){}
    fun updateClasses(value: Classes){}
    fun removeClasses(classesId: String){}
}