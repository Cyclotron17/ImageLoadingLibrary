package com.example.nexusreality.models

data class Thumbnail(
    val id: String,
    val version: Int,
    val domain: String,
    val basePath: String,
    val key: String,
    val qualities: List<Int>,
    val aspectRatio: Double
)