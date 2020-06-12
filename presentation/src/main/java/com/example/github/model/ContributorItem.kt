package com.example.github.model

import com.example.github.base.ItemMapper
import com.example.github.base.ModelItem
import com.example.github.domain.model.Contributor
import javax.inject.Inject

data class ContributorItem(
    val login: String,
    val contributions: Int,
    val avatarUrl: String?
) : ModelItem()

class ContributorItemMapper @Inject constructor() : ItemMapper<Contributor, ContributorItem> {

    override fun mapToDomain(modelItem: ContributorItem) = Contributor(
        modelItem.login, modelItem.contributions, modelItem.avatarUrl
    )

    override fun mapToPresentation(model: Contributor) = ContributorItem(
        model.login, model.contributions, model.avatarUrl
    )
}
