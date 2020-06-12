package com.example.github.data.model

import com.example.github.data.base.EntityMapper
import com.example.github.data.base.ModelEntity
import com.example.github.domain.model.Owner
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class OwnerEntity(
    @SerializedName("id") val id: Int,
    @SerializedName("login") val login: String?,
    @SerializedName("avatar_url") val avatar: String?
) : ModelEntity()

class OwnerEntityMapper @Inject constructor() : EntityMapper<Owner, OwnerEntity> {
    override fun mapToDomain(entity: OwnerEntity) = Owner(
        entity.id, entity.login, entity.avatar
    )

    override fun mapToEntity(model: Owner) = OwnerEntity(
        model.id, model.login, model.avatar
    )
}