package model

import java.util.*

data class CorporationResponseModel(val id: String) {
    lateinit var name: String
    lateinit var document: String
    lateinit var contact: String
    lateinit var email: String
    lateinit var phone: String
    var active: Boolean = false
    lateinit var createdAt: Date
    lateinit var updatedAt: Date
}