package com.example.github.domain.exception

import com.example.github.domain.annotation.ExceptionType
import com.example.github.domain.model.Tag

class InlineException(
    override val code: Int,
    vararg val tags: Tag
) : CleanException(code, ExceptionType.INLINE, null)