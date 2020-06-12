package com.example.github.domain.exception

import com.example.github.domain.annotation.ExceptionType

class AlertException(
    override val code: Int,
    override val message: String,
    val title: String? = null
) : CleanException(code, ExceptionType.ALERT, message)