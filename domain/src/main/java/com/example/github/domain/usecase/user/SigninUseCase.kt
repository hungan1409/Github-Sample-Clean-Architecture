package com.example.github.domain.usecase.user

import com.example.github.domain.repository.UserRepository
import com.example.github.domain.usecase.UseCase
import io.reactivex.Completable
import javax.inject.Inject

open class SigninUseCase @Inject constructor(
    private val userRepository: UserRepository
) : UseCase<SigninUseCase.Params, Completable>() {

    override fun createObservable(params: Params?): Completable {
        return userRepository.signin(userName = params!!.userName, password = params.password)
    }

    data class Params(val userName: String, val password: String)
}