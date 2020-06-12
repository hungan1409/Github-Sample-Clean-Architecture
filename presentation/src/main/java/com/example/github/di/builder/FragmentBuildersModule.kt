package com.example.github.di.builder

import com.example.github.MainActivity
import com.example.github.ui.contributor.ContributorFragment
import com.example.github.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment

    @ContributesAndroidInjector
    abstract fun contributeRepoDetailFragment(): ContributorFragment
}
