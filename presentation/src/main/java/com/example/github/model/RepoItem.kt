package com.example.github.model

import com.example.github.base.ItemMapper
import com.example.github.base.ModelItem
import com.example.github.domain.model.Repo
import javax.inject.Inject

data class RepoItem(
    val description: String? = null,
    val forksCount: Int? = null,
    val id: Int,
    val language: Any? = null,
    val fullName: String? = null,
    val stargazersCount: Int? = null,
    val updatedAt: String? = null,
    val watchersCount: Int? = null
) : ModelItem()

class RepoItemMapper @Inject constructor() : ItemMapper<Repo, RepoItem> {
    override fun mapToPresentation(model: Repo) = RepoItem(
        description = model.description,
        forksCount = model.forksCount,
        fullName = model.fullName,
        id = model.id,
        language = model.language,
        stargazersCount = model.stargazersCount,
        updatedAt = model.updatedAt,
        watchersCount = model.watchersCount
    )

    override fun mapToDomain(modelItem: RepoItem) = Repo(
        description = modelItem.description,
        forksCount = modelItem.forksCount,
        fullName = modelItem.fullName,
        id = modelItem.id,
        language = modelItem.language,
        stargazersCount = modelItem.stargazersCount,
        updatedAt = modelItem.updatedAt,
        watchersCount = modelItem.watchersCount
    )
}
