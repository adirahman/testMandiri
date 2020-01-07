package com.arc.testmandiri

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arc.testmandiri.api.Articles
import com.arc.testmandiri.di.component.DaggerActivityComponent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class NewsListActivity : AppCompatActivity(), NewsListContract.View, NewsAdapter.NewsListener {

    var listArticles = ArrayList<Articles>()
    val newsAdapter = NewsAdapter(listArticles,this)

    @Inject lateinit var presenter: NewsListPresenter

    companion object{
        const val CAT_PARAM = "category"
        fun startThisActivity(ctx: Context, cat:String){
            val intent = Intent(ctx,NewsListActivity::class.java)
            intent.putExtra(CAT_PARAM,cat)
            ctx.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerActivityComponent.create().inject(this)

        presenter.setTargetView(this)
        val cat = intent.getStringExtra(CAT_PARAM)
        presenter.callNewsAPIByCat(cat)
        text_view.text = "Fetching data ...."

        rv_news?.apply {
            layoutManager = LinearLayoutManager(this@NewsListActivity,RecyclerView.VERTICAL,false)
            adapter = newsAdapter
        }
    }

    override fun updateListNews(listNews: List<Articles>?) {
        /*for( i in 0..listNews!!.size-1 ){
            text_view.append(listNews[i].title+"\n\n")
        }*/
        if(listNews?.size == 0){
            failedGetData("data tidak ditemukan")
        }else{
            listArticles.clear()
            listArticles.addAll(listNews!!)
            newsAdapter.notifyDataSetChanged()
            rv_news.visibility = View.VISIBLE
            text_view.visibility = View.GONE
        }
    }

    override fun failedGetData(message: String?) {
        rv_news.visibility = View.GONE
        text_view.text = message
    }

    override fun onClick(url: String?) {
        DetailNewsActivity.startThisActivity(this,url!!)
    }
}
