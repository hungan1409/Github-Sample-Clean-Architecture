package com.example.github.data

import com.example.github.data.model.ItemEntity
import com.example.github.data.model.OwnerEntity
import com.example.github.domain.model.Item
import com.example.github.domain.model.Owner

fun createItemEntity() = ItemEntity(
    id = 1,
    name = "Bach",
    fullName = "Bach Hoan",
    description = "framgia",
    url = "",
    stars = 1,
    ownerEntity = OwnerEntity(id = 1, login = null, avatar = null)
)

fun createItem() = Item(
    id = 2,
    name = "Hoan",
    fullName = "Bach Hoan",
    description = "ha nam",
    url = "",
    stars = 1,
    owner = Owner(id = 1, login = null, avatar = null)
)