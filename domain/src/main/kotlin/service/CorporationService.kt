package service

import entity.CorporationEntity
import model.UpdateCorporationRequestModel
import model.CorporationResponseModel
import model.CreateCorporationRequestModel
import repository.CorporationRepository

class CorporationService(val repository: CorporationRepository) {

    fun createCorporation(corporationModel: CreateCorporationRequestModel): String{
        return repository.save(createCorporationEntity(corporationModel))
    }

    fun findCorporationById(id: String): CorporationResponseModel? {
        return createCorporationResponseModel(repository.fetchById(id))
    }

    fun findCorporationByDocument(document: String): CorporationResponseModel? {
        return createCorporationResponseModel(repository.fetchByDocument(document))
    }

    fun updateCorporation(corporationModel: UpdateCorporationRequestModel): Boolean{
        return repository.update(createCorporationEntity(corporationModel))
    }

    fun removeCorporation(id: String): Boolean{
        return repository.remove(id);
    }

    private fun createCorporationEntity(corporationModel: CreateCorporationRequestModel){
        val corporationEntity = CorporationEntity(corporationModel.id,
            corporationModel.name,
            corporationModel.document,
            corporationModel.contact)

        corporationEntity.email = corporationModel.email
        corporationEntity.phone = corporationModel.phone
        corporationEntity.active = corporationModel.active
    }

    private fun createCorporationEntity(corporationModel: UpdateCorporationRequestModel){
        val corporationEntity = CorporationEntity(corporationModel.id,
            corporationModel.name,
            corporationModel.document,
            corporationModel.contact)

        corporationEntity.email = corporationModel.email
        corporationEntity.phone = corporationModel.phone
        corporationEntity.active = corporationModel.active
    }

    private fun createCorporationResponseModel(corporationEntity: CorporationEntity?): CorporationResponseModel?{

        if(corporationEntity == null)
            return null;

        val corporationResponseModel = CorporationResponseModel(corporationEntity.id)

        corporationResponseModel.name = corporationEntity.name;
        corporationResponseModel.document = corporationEntity.document
        corporationResponseModel.contact = corporationEntity.contact
        corporationResponseModel.email = corporationEntity.email
        corporationResponseModel.phone = corporationEntity.phone
        corporationResponseModel.active = corporationEntity.active

        return corporationResponseModel
    }
}