package com.example.github.data

import com.example.github.data.model.RepoEntity
import com.example.github.domain.model.Repo


fun createRepoEntity() = RepoEntity(
    description = "A sample of unit test description",
    forksCount = 20,
    id = 123,
    language = "Kotlin",
    fullName = "google/abc",
    stargazersCount = 40,
    updatedAt = "2020-05-19T16:47:50Z",
    watchersCount = 20,
    htmlUrl = "https://github.com/google/.github"
)

fun createRepo() = Repo(
    description = "A sample of unit test description",
    forksCount = 30,
    id = 1323,
    language = "Java",
    fullName = "google/sample",
    stargazersCount = 20,
    updatedAt = "2020-08-19T16:47:50Z",
    watchersCount = 40,
    htmlUrl = "https://github.com/google/0x0g-2018-badge"
)