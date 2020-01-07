package com.arc.testmandiri.di.component

import com.arc.testmandiri.api.NewsAPIProvider
import com.arc.testmandiri.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent {
    fun injectNews(provider: NewsAPIProvider)
}