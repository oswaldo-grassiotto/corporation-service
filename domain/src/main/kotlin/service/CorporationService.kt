package service

import entity.CorporationEntity
import repository.CorporationRepository

class CorporationService(val repository: CorporationRepository) {

    fun createCorporation(corporationEntity: CorporationEntity): String {
        return repository.save(corporationEntity)
    }

    fun findCorporationById(id: String): CorporationEntity? {
        return repository.fetchById(id)
    }

    fun findCorporationByDocument(document: String): CorporationEntity? {
        return repository.fetchByDocument(document)
    }

    fun updateCorporation(corporation: CorporationEntity): Boolean{
        val corporation = repository.fetchById(corporation.id)
        if(corporation === null){
            return false
        }

        return repository.update(corporation)
    }

    fun removeCorporation(id: String): Boolean{
        return repository.remove(id);
    }
}