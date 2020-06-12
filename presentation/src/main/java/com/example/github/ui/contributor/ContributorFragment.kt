package com.example.github.ui.contributor

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import com.example.github.BR
import com.example.github.R
import com.example.github.base.BaseFragment
import com.example.github.binding.FragmentDataBindingComponent
import com.example.github.databinding.FragmentContributorBinding
import com.example.github.util.autoCleared

class ContributorFragment : BaseFragment<FragmentContributorBinding, ContributorViewModel>() {

    override val bindingVariable: Int
        get() = BR.viewModel

    override val viewModel: ContributorViewModel by viewModels { viewModelFactory }

    override val layoutId: Int = R.layout.fragment_contributor

    private val args by navArgs<ContributorFragmentArgs>()

    private var contributorAdapter by autoCleared<ContributorAdapter>()
    private var bindingComponent = FragmentDataBindingComponent(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.repoItem.value = args.repo
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ContributorAdapter(bindingComponent) { contribute ->
        }
        this.contributorAdapter = adapter

        with(viewDataBinding) {
            listContributor.adapter = contributorAdapter
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        subscribeUI()
    }

    private fun subscribeUI() = with(viewModel) {
        getContributions().observe(viewLifecycleOwner) { contributions ->
            contributorAdapter.submitList(contributions)
        }
    }
}