package model

data class CreateCorporationRequestModel(val id: String, val name: String, val document: String, val contact: String) {
    lateinit var email: String
    lateinit var phone: String
    var active: Boolean = false
}