package com.example.github.ui.main

import androidx.lifecycle.MutableLiveData
import com.example.github.base.BaseViewModel
import com.example.github.base.ModelItem
import com.example.github.model.PageHeaderItem
import com.example.github.model.RepoItem
import com.example.github.model.UserItem
import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseViewModel() {

    val fakeData = MutableLiveData<List<ModelItem>>()
    val loading = MutableLiveData<Boolean>().apply { postValue(false) }

    fun getFakeData() {
        Thread {
            Thread.sleep(2000)
            fakeData.postValue(
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
}