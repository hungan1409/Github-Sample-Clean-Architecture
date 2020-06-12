package com.example.github.di.builder

import android.content.Context
import com.example.github.MainApplication
import com.example.github.data.di.NetworkModule
import com.example.github.data.di.RepositoryModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, FragmentBuildersModule::class, NetworkModule::class, RepositoryModule::class])
class AppModule {

    @Singleton
    @Provides
    fun providerContext(application: MainApplication): Context {
        return application.applicationContext
    }
}