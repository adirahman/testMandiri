package com.arc.testmandiri.di.module

import com.arc.testmandiri.api.BaseRetrofitClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton @Provides
    open fun newsClient(): BaseRetrofitClient {
        return BaseRetrofitClient("https://newsapi.org/v2/")
    }
}