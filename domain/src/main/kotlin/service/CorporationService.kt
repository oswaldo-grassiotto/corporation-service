package service

import entity.Corporation
import repository.CorporationRepository

class CorporationService(private val repository: CorporationRepository) {

    fun createCorporation(value: Corporation) : String {
        return repository.save(value)
    }

    fun searchCorporationById(value: String) : Corporation? {
        return repository.fetchById(value)
    }

    fun searchCorporationByDocument(value: String) : Corporation? {
        return repository.fetchByDocument(value)
    }

    fun updateCorporation(value: Corporation) : Boolean {
        val corporation = repository.fetchById(value.id)
        if(corporation === null){
            return false
        }

        return repository.update(value)
    }

    fun removeCorporation(corporationId: String) : Boolean {
        return repository.remove(corporationId)
    }

}