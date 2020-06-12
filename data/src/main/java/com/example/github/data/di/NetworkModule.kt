package com.example.github.data.di

import com.example.github.data.remote.api.UserApi
import com.example.github.data.remote.builder.RetrofitBuilder
import com.example.github.data.remote.interceptor.HeaderInterceptor
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        retrofitBuilder: RetrofitBuilder,
        headerInterceptor: HeaderInterceptor
    ): Retrofit = retrofitBuilder
        .addInterceptors(headerInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideUsersApi(retrofit: Retrofit): UserApi = retrofit.create(UserApi::class.java)
}
