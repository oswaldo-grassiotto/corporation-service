package model

data class UpdateCorporationRequestModel(val id: String) {
    lateinit var name: String
    lateinit var document: String
    lateinit var contact: String
    lateinit var email: String
    lateinit var phone: String
    var active: Boolean = false
}