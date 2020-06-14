package com.example.github.data.remote.interceptor

import android.content.Context
import com.example.github.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor(
    private val context: Context
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request?.newBuilder()
            ?.addHeader("Content-Type", "application/json")
            ?.addHeader("Accept", "application/json")
            ?.apply { addHeader("Authorization", "token ${BuildConfig.BASIC_AUTH_TOKEN}") }
            ?.build()
        return chain.proceed(request)
    }
}
