package com.example.themovieapp.model

data class Movie(
    val name: String,
    val rating: Double,
    val imageUrl: Int // Assuming image resources are being used. If URLs, use String.
)
