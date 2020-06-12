package com.example.github.data.di

import android.content.Context
import androidx.room.Room
import com.example.github.data.Constants
import com.example.github.data.ContributorRepositoryImpl
import com.example.github.data.ItemRepositoryImpl
import com.example.github.data.UserRepositoryImpl
import com.example.github.data.local.db.AppDatabase
import com.example.github.data.local.pref.AppPrefs
import com.example.github.data.local.pref.PrefHelper
import com.example.github.domain.repository.ContributorRepository
import com.example.github.domain.repository.ItemRepository
import com.example.github.domain.repository.UserRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @DatabaseInfo
    fun providerDatabaseName(): String {
        return Constants.DATABASE_NAME
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@DatabaseInfo dbName: String, context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, dbName)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providePrefHelper(appPrefs: AppPrefs): PrefHelper {
        return appPrefs
    }

    @Provides
    @Singleton
    fun providerAppPrefs(context: Context): AppPrefs {
        return AppPrefs(context, Gson())
    }

    @Provides
    @Singleton
    fun providerUserRepository(repository: UserRepositoryImpl): UserRepository {
        return repository
    }

    @Provides
    @Singleton
    fun providerItemRepository(repository: ItemRepositoryImpl): ItemRepository {
        return repository
    }

    @Provides
    @Singleton
    fun providerContributorRepository(repository: ContributorRepositoryImpl): ContributorRepository {
        return repository
    }
}
