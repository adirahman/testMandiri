package com.arc.testmandiri

import com.arc.testmandiri.api.NewsAPIProvider
import com.arc.testmandiri.api.NewsModel
import javax.inject.Inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsListPresenter @Inject constructor():NewsListContract.Presenter {

    lateinit var view: NewsListContract.View


    override fun setTargetView(view: NewsListContract.View) {
        this.view = view
    }

    override fun callNewsAPI() {
        val newsApi = NewsAPIProvider().newsService()
            newsApi.getHeadLines().enqueue(object : Callback<NewsModel>{
                override fun onFailure(call: Call<NewsModel>?, t: Throwable?) {
                    view.failedGetData(t?.message)
                }

                override fun onResponse(call: Call<NewsModel>?, response: Response<NewsModel>?) {
                    view.updateListNews(response?.body()?.articles)
                }
            })
    }

    override fun callNewsAPIByCat(cat: String) {
        val newsAPI = NewsAPIProvider().newsService()
            newsAPI.getHeadLinesByCategory(cat).enqueue( object : Callback<NewsModel> {
                override fun onFailure(call: Call<NewsModel>?, t: Throwable?) {
                    view.failedGetData(t?.message)
                }

                override fun onResponse(call: Call<NewsModel>?, response: Response<NewsModel>?) {
                    view.updateListNews(response?.body()?.articles)
                }
            })
    }


}