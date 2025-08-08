package com.lazarodiaz.lab4

import androidx.annotation.DrawableRes

data class Mascota(
    val id: Int,
    val nombre: String,
    val raza: String,
    @DrawableRes val imagenResId: Int
)
