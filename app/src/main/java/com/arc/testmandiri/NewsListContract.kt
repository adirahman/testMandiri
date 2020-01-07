package com.arc.testmandiri

import com.arc.testmandiri.api.Articles

class NewsListContract {

    interface View{
        fun updateListNews(listNews:List<Articles>?)
        fun failedGetData(message:String?)
    }

    interface Presenter{
        fun setTargetView(view:View)
        fun callNewsAPI()
        fun callNewsAPIByCat(cat:String)
    }
}