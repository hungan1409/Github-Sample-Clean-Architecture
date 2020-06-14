package com.example.github.domain.usecase.user

import com.example.github.domain.model.User
import com.example.github.domain.repository.UserRepository
import com.example.github.domain.usecase.UseCase
import io.reactivex.Single
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) : UseCase<GetUserUseCase.Params, Single<User>>() {

    override fun createObservable(params: Params?): Single<User> {
        return when (params) {
            null -> throw Throwable("Params must be not null")
            else -> userRepository.getUser(params.id)
        }
    }

    class Params(val id: String)
}
