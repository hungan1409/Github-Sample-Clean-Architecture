package com.example.github.data.remote.api

import com.example.github.data.model.Token
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface OAuthApi {

    @POST("/oauth/token")
    @FormUrlEncoded
    fun refreshToken(
        @Field("refresh_token") grantType: String
    ): Call<Token>
}