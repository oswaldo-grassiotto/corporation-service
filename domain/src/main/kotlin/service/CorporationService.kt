package service

import entity.Corporation
import repository.CorporationRepository

class CorporationService(val repository: CorporationRepository) {
    fun createCorporation(value: Corporation){}
    fun searchCorporationById(value: String){}
    fun searchCorporationByDocument(value: String){}
    fun updateCorporation(value: Corporation){}
    fun removeCorporation(corporationId: String){}
}