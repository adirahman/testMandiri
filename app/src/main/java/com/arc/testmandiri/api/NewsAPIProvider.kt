package com.arc.testmandiri.api

import com.arc.testmandiri.di.component.DaggerNetworkComponent
import javax.inject.Inject

class NewsAPIProvider {

    @Inject
    lateinit var newsClient: BaseRetrofitClient

    fun newsService(): NewsService {
        DaggerNetworkComponent.create().injectNews(this)
        return newsClient.let {
            it.retrofitClient.create(NewsService::class.java)
        }
    }
}