package com.arc.testmandiri.di.component

import com.arc.testmandiri.NewsListActivity
import com.arc.testmandiri.di.module.ActivityModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(newsListActivity: NewsListActivity)
}