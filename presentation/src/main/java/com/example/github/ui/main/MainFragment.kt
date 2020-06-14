package com.example.github.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.github.R
import com.example.github.base.BaseFragment
import com.example.github.databinding.FragmentMainBinding
import com.example.github.util.autoCleared

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_main

    override val viewModel: MainViewModel by viewModels { viewModelFactory }

    private var mainAdapter by autoCleared<MainAdapter>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        subscribeUI()
        viewModel.init()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainAdapter = MainAdapter()
        with(viewDataBinding) {
            recycler.adapter = mainAdapter
            recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                    val lastPosition = layoutManager.findLastVisibleItemPosition()
                    if (lastPosition == mainAdapter.itemCount - REMAINING_ITEM_REFRESH) {
                        viewModel?.loadMore()
                    }
                }
            })

            swipeRefresh.setOnRefreshListener {
                viewModel?.refresh()
            }
        }
    }

    private fun subscribeUI() = with(viewModel) {
        items.observe(viewLifecycleOwner) {
            mainAdapter.submitList(it)
        }
    }

    companion object {
        private const val REMAINING_ITEM_REFRESH = 5
    }
}
