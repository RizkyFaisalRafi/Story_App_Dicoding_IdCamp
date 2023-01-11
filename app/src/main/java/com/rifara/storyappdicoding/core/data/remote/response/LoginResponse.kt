package com.rifara.storyappdicoding.core.data.remote.response

data class LoginResponse(
    val id: String? = "",
    val email: String? = "",
    val fullname: String? = "",
    val phone: String? = "",
    val universitas: String? = "",
    val expired: Long? = 0,
    val token: String? = ""
)