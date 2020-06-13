package com.example.github.ui.main

import com.example.github.base.BaseViewModel
import com.example.github.base.ModelItem
import com.example.github.domain.usecase.GetReposUseCase
import com.example.github.domain.usecase.GetUserUseCase
import com.example.github.extension.add
import com.example.github.model.*
import com.example.github.util.RxUtils
import com.example.github.util.SingleLiveData
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val getReposUseCase: GetReposUseCase,
    private val userItemMapper: UserItemMapper,
    private val repoItemMapper: RepoItemMapper
) : BaseViewModel() {

    val user = SingleLiveData<UserItem>()
    val repos = SingleLiveData<List<RepoItem>>()

    val items = SingleLiveData<List<ModelItem>>()

    fun getFakeData() {
        Thread {
            Thread.sleep(2000)
            items.postValue(
                listOf(
                    UserItem("", "", "", 1, "", 1),
                    PageHeaderItem(1),
                    RepoItem("", 1, 1, "", "", 1, null),
                    RepoItem("", 1, 2, "", "", 1, null),
                    RepoItem("", 1, 3, "", "", 1, null),
                    PageHeaderItem(2),
                    RepoItem("", 1, 4, "", "", 1, null),
                    RepoItem("", 1, 5, "", "", 1, null),
                    RepoItem("", 1, 6, "", "", 1, null)
                )
            )
        }.start()
    }

    private fun getPage(page: Int): PageHeaderItem {
        return PageHeaderItem(page)
    }

    fun getUser(id: String = USER_ID_DEFAULT) {
        getUserUseCase.createObservable(GetUserUseCase.Params(id))
            .compose(RxUtils.applySingleScheduler(isLoading))
            .subscribe({
                user.value = userItemMapper.mapToPresentation(it)
            }, {
                setThrowable(it)
            })
            .add(this)
    }

    fun getRepos(id: String = USER_ID_DEFAULT, page: Int) {
        getReposUseCase.createObservable(GetReposUseCase.Params(id, page))
            .compose(RxUtils.applySingleScheduler(isLoading)).map {
                it.map { repo -> repoItemMapper.mapToPresentation(repo) }
            }
            .subscribe({
                ArrayList<ModelItem>().apply {
                    if (!items.value.isNullOrEmpty()) {
                        add(getPage(page))
                        addAll(it)
                    } else {
                        add(user.value!!)
                        addAll(it)
                    }
                    items.value = this
                }

            }, {
                setThrowable(it)
            })
            .add(this)
    }

    companion object {
        private const val USER_ID_DEFAULT = "google"
    }
}