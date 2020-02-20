package com.elviraminnullina.nike_test_app.data.model

data class DefinitionModel(
    val definition: String,
    val permalink: String,
    val thumbs_up: Int,
    val sound_urls: ArrayList<String>?,
    val author: String,
    val word: String,
    val defid: Int,
    val current_vote: String,
    val written_on: String,
    val example: String,
    val thumbs_down: Int
)