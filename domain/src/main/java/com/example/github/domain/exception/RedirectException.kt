package com.example.github.domain.exception

import com.example.github.domain.annotation.ExceptionType
import com.example.github.domain.model.Redirect

class RedirectException(
    override val code: Int,
    val redirect: Redirect
) : CleanException(code, ExceptionType.REDIRECT, null)