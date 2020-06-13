package com.example.github.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
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
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainAdapter = MainAdapter()
        viewDataBinding.listRepo.adapter = mainAdapter
        viewModel.getFakeData()
    }

    private fun subscribeUI() = with(viewModel) {
        fakeData.observe(viewLifecycleOwner) {
            mainAdapter.submitList(it)
        }
        loading.observe(viewLifecycleOwner) { loading ->
            viewDataBinding.loading.visibility = if (loading) View.VISIBLE else View.GONE
        }
    }
}
