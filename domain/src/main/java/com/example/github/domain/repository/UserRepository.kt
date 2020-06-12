package com.example.github.domain.repository

import com.example.github.domain.model.User
import io.reactivex.Single

interface UserRepository : Repository {
    fun getUser(): Single<User>
}
