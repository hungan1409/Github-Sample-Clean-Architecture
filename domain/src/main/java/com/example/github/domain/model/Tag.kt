package com.example.github.domain.model

import com.example.github.domain.annotation.TagName

data class Tag(@TagName val name: String, val message: String?)