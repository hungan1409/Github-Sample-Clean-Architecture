package com.example.github.data

import com.example.github.data.model.ContributorEntityMapper
import com.example.github.data.remote.api.ContributorApi
import com.example.github.domain.model.Contributor
import com.example.github.domain.repository.ContributorRepository
import io.reactivex.Observable
import javax.inject.Inject

class ContributorRepositoryImpl @Inject constructor(
    private val contributorApi: ContributorApi,
    private val contributorEntityMapper: ContributorEntityMapper
) : ContributorRepository {

    override fun getContribution(name: String, owner: String): Observable<List<Contributor>> {
        return contributorApi.getContributors(owner, name)
            .map { it.map { contributorEntityMapper.mapToDomain(it) } }
    }
}