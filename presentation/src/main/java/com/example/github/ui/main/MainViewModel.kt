package com.example.github.ui.main

import androidx.lifecycle.MutableLiveData
import com.example.github.base.BaseViewModel
import com.example.github.model.RepoItem
import com.example.github.model.RepoItemMapper
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repoItemMapper: RepoItemMapper
) : BaseViewModel() {

    val data = MutableLiveData<List<RepoItem>>()
    val query = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>().apply { postValue(false) }

}
