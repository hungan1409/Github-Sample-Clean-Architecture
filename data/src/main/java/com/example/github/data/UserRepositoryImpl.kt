package com.example.github.data

import com.example.github.data.model.UserEntityMapper
import com.example.github.data.remote.api.UserApi
import com.example.github.domain.model.User
import com.example.github.domain.repository.UserRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val userApi: UserApi,
    private val mapper: UserEntityMapper
) : UserRepository {
    override fun getUser(): Single<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
