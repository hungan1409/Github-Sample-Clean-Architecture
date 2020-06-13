package com.example.github.domain.usecase

import com.example.github.domain.model.Repo
import com.example.github.domain.repository.UserRepository
import io.reactivex.Single
import javax.inject.Inject

class GetReposUseCase @Inject constructor(
    private val userRepository: UserRepository
) : UseCase<GetReposUseCase.Params, Single<List<Repo>>>() {

    override fun createObservable(params: Params?): Single<List<Repo>> {
        return when (params) {
            null -> throw Throwable("Params must be not null")
            else -> userRepository.getRepos(params.id, params.page)
        }
    }

    class Params(val id: String, val page: Int)
}