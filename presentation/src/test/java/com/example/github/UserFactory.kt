package com.example.github

import com.example.github.data.model.ItemEntity
import com.example.github.data.model.OwnerEntity
import com.example.github.domain.model.Item
import com.example.github.domain.model.Owner
import com.example.github.domain.model.User
import com.example.github.model.UserItem

fun createUserItem(): UserItem = UserItem(
    "1",
    "Bach",
    "bachhoan88",
    "hoanbn88@gmail.com",
    "0904576359  ",
    "Tu Liem - Ha Noi"
)

fun createUser(): User = User(
    "2",
    "Hoan",
    "hoanbn88",
    "bach.ngoc.hoai@framgia.com",
    "0123456789",
    "Thanh Liem - Ha Nam"
)

fun createRepoItem() = ItemEntity(
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