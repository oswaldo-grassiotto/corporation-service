package model

import entity.CorporationEntity
import service.CorporationService

class CorporationViewModel(val service: CorporationService) {

    fun createCorporation(corporationModel: CreateCorporationRequestModel): CreateCorporationResponseModel {
        val responseMessage = service.createCorporation(createCorporationEntity(corporationModel))

        return CreateCorporationResponseModel(responseMessage)
    }

    fun fetchCorporationById(request: FindCorporationByIdRequestModel): FindSingleCorporationResponseModel {
        val corporationId = request.id
        val corporation = service.findCorporationById(corporationId)

        return FindSingleCorporationResponseModel(corporation)
    }

    fun fetchCorporationByDocument(request: FindCorporationByDocumentRequestModel): FindSingleCorporationResponseModel {
        val document = request.document
        val corporation = service.findCorporationByDocument(document)

        return FindSingleCorporationResponseModel(corporation)
    }

    fun updateCorporation(request: UpdateCorporationRequestModel): UpdateCorporationResponseModel {
        val corporationEntity = createCorporationEntity(request)
        val updated = service.updateCorporation(corporationEntity)

        return UpdateCorporationResponseModel(updated)
    }

    fun removeCorporation(request: RemoveCorporationRequestModel): RemoveCorporationResponseModel {
        val corporationId = request.id
        val removed = service.removeCorporation(corporationId)

        return RemoveCorporationResponseModel(removed)
    }


    private fun createCorporationEntity(corporationModel: CreateCorporationRequestModel) : CorporationEntity {
        val corporationEntity = CorporationEntity(corporationModel.id,
                corporationModel.name,
                corporationModel.document,
                corporationModel.contact)

        corporationEntity.email = corporationModel.email
        corporationEntity.phone = corporationModel.phone
        corporationEntity.active = corporationModel.active

        return corporationEntity
    }

    private fun createCorporationEntity(corporationModel: UpdateCorporationRequestModel) : CorporationEntity {
        val corporationEntity = CorporationEntity(corporationModel.id,
                corporationModel.name,
                corporationModel.document,
                corporationModel.contact)

        corporationEntity.email = corporationModel.email
        corporationEntity.phone = corporationModel.phone
        corporationEntity.active = corporationModel.active

        return corporationEntity
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