package com.arc.testmandiri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_category.*

class CategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        onClick()
    }

    fun onClick(){
        tv_business.setOnClickListener { NewsListActivity.startThisActivity(this,"business") }
        tv_entertainment.setOnClickListener { NewsListActivity.startThisActivity(this,"entertainment") }
        tv_health.setOnClickListener { NewsListActivity.startThisActivity(this,"health") }
        tv_science.setOnClickListener { NewsListActivity.startThisActivity(this,"science") }
        tv_sports.setOnClickListener { NewsListActivity.startThisActivity(this,"sports") }
        tv_technology.setOnClickListener { NewsListActivity.startThisActivity(this,"technology") }
    }
}
