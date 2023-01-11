package com.rifara.storyappdicoding.core.data.remote.request

data class RegisterRequest(
    val email: String? = "",
    val password: String? = "",
    val fullname: String? = "",
    val phone: String? = "",
    val universitas: String? = ""
)
