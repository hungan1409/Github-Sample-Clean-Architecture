package com.example.github.domain

import com.example.github.domain.model.Item
import com.example.github.domain.model.Owner

fun createItem() = Item(
    id = 2,
    name = "Hoan",
    fullName = "Bach Hoan",
    description = "ha nam",
    url = "",
    stars = 1,
    owner = Owner(id = 1, login = null, avatar = null)
)