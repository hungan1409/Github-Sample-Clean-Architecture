package com.example.github.data.di

import com.example.github.data.UserRepositoryImpl
import com.example.github.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun providerUserRepository(repository: UserRepositoryImpl): UserRepository {
        return repository
    }
}
