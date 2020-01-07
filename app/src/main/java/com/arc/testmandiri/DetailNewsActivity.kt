package com.arc.testmandiri

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_news.*

class DetailNewsActivity : AppCompatActivity() {

    companion object{
        const val URL = "url"

        fun startThisActivity(ctx: Context,url:String ){
            val intent = Intent(ctx,DetailNewsActivity::class.java)
            intent.putExtra(URL,url)
            ctx.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)

        val url = intent.getStringExtra(URL)
        webview.settings.javaScriptEnabled = true
        webview.loadUrl(url)
    }
}
