package com.example.github.data.local.pref

import com.example.github.data.model.Token

interface PrefHelper {
    fun isFirstRun(): Boolean

    fun setFirstRun(boolean: Boolean)

    fun getToken(): Token?

    fun setToken(token: Token)
}