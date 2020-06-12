package com.example.github.base

import androidx.lifecycle.ViewModel
import com.example.github.domain.exception.*
import com.example.github.domain.model.Dialog
import com.example.github.domain.model.Redirect
import com.example.github.domain.model.Tag
import com.example.github.domain.usecase.UseCase
import com.example.github.util.SingleLiveData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel constructor(
    private vararg val useCases: UseCase<*, *>?
) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    val snackBarMessage = SingleLiveData<String>()
    val toastMessage = SingleLiveData<String>()
    val inlineException = SingleLiveData<List<Tag>>()
    val alertException = SingleLiveData<Pair<String?, String>>()
    val dialogException = SingleLiveData<Dialog>()
    val redirectException = SingleLiveData<Redirect>()

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun setThrowable(throwable: Throwable) {
        when (throwable) {
            is SnackBarException -> snackBarMessage.value = throwable.message
            is ToastException -> toastMessage.value = throwable.message
            is InlineException -> inlineException.value = throwable.tags.toList()
            is AlertException -> alertException.value = Pair(throwable.title, throwable.message)
            is DialogException -> dialogException.value = throwable.dialog
            is RedirectException -> redirectException.value = throwable.redirect
        }
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        useCases.let { userCases ->
            if (userCases.isNotEmpty()) userCases.forEach { it?.onCleared() }
        }
        super.onCleared()
    }
}
