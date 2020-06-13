package com.example.github.data.repository

import com.example.github.data.UserRepositoryImpl
import com.example.github.data.model.RepoEntityMapper
import com.example.github.data.model.UserEntityMapper
import com.example.github.data.remote.api.GithubApi
import org.junit.Before
import org.mockito.Mockito.mock

class UserRepositoryImplTest {
    private lateinit var userRepositoryImpl: UserRepositoryImpl

    private val githubApiMock = mock(GithubApi::class.java)
    private val userEntityMapper = UserEntityMapper()
    private val repoEntityMapper = RepoEntityMapper()

    @Before
    fun setup() {
        userRepositoryImpl = UserRepositoryImpl(githubApiMock, userEntityMapper, repoEntityMapper)
    }
}
