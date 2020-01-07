package com.arc.testmandiri.di.module

import com.arc.testmandiri.NewsListContract
import com.arc.testmandiri.NewsListPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {

    @Provides
    open fun provideMainPresenter(mainPresenter: NewsListPresenter): NewsListContract.Presenter = mainPresenter
}