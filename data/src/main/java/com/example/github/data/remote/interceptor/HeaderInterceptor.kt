package com.example.github.data.remote.interceptor

import android.content.Context
import com.example.github.data.local.pref.AppPrefs
import com.example.github.data.model.Token
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor(
    private val context: Context
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val token: Token? = AppPrefs(context, Gson()).getToken()

        var request = chain.request()
        request = request?.newBuilder()
            ?.addHeader("Content-Type", "application/json")
            ?.addHeader("Accept", "application/json")
            ?.apply { token?.token?.let { addHeader("Authorization", "Bearer $it") } }
            ?.build()
        return chain.proceed(request)
    }
}