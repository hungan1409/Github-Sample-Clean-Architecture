package com.example.github.ui.main

import androidx.lifecycle.MutableLiveData
import com.example.github.base.BaseViewModel
import com.example.github.domain.usecase.item.SearchItemUseCase
import com.example.github.extension.add
import com.example.github.model.RepoItem
import com.example.github.model.RepoItemMapper
import com.example.github.util.RxUtils
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val searchItemUseCase: SearchItemUseCase,
    private val repoItemMapper: RepoItemMapper
) : BaseViewModel() {

    val data = MutableLiveData<List<RepoItem>>()
    val query = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>().apply { postValue(false) }

    fun searchRepo() = when (query.value.isNullOrEmpty()) {
        true -> Unit
        false -> query.value?.let {
            searchItemUseCase.createObservable(SearchItemUseCase.Params(query = it, pageNumber = 1))
                .compose(RxUtils.applySingleScheduler(loading))
                .doFinally { loading.value = false }
                .map { it.map { repoItemMapper.mapToPresentation(it) } }
                .subscribe({ data.value = it }, {
                    Timber.e("Get repo error: $it")
                    setThrowable(it)
                })
                .add(this)
        }
    }
}