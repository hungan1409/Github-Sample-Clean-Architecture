package com.example.github.domain.exception

import com.example.github.domain.annotation.ExceptionType
import com.example.github.domain.model.Dialog

class DialogException(
    override val code: Int,
    val dialog: Dialog
) : CleanException(code, ExceptionType.DIALOG, null)