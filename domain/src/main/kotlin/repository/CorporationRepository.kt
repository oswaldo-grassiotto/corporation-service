package repository

import entity.CorporationEntity

interface CorporationRepository {

    fun save(bean: CorporationEntity): String

    fun update(value: CorporationEntity) : Boolean

    fun remove(corporationId: String) : Boolean

    fun fetchById(corporationId: String) : CorporationEntity?

    fun fetchByDocument(document: String) : CorporationEntity?

}
