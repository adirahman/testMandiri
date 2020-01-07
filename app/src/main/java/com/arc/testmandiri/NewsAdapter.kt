package com.arc.testmandiri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.arc.testmandiri.api.Articles
import com.arc.testmandiri.api.NewsModel

class NewsAdapter(private val listNews: List<Articles>, val listener:NewsListener): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return listNews.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = listNews[position]
        holder.title.text = news.title

        holder.cl.setOnClickListener {
            listener.onClick(news.url)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title : TextView = itemView.findViewById(R.id.tv_title)
        val cl: ConstraintLayout = itemView.findViewById(R.id.cl)
    }

    interface NewsListener{
        fun onClick(url:String?)
    }
}