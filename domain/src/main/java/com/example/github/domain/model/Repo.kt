package com.example.github.domain.model

data class Repo(
    val description: String? = null,
    val forksCount: Int? = null,
    val id: Int,
    val language: Any? = null,
    val fullName: String? = null,
    val stargazersCount: Int? = null,
    val updatedAt: String? = null,
    val watchersCount: Int? = null
) : Model()
