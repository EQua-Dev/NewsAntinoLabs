package com.androidstrike.antinolabsnews.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.androidstrike.antinolabsnews.R
import kotlinx.android.synthetic.main.activity_news_detail.*

class NewsDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        val newsUrl = intent.getStringExtra("newsUrl")

        webViewSetup(newsUrl)
    }

    private fun webViewSetup(newsUrl: String) {
        web_view.webViewClient = WebViewClient()
        web_view.apply {
            loadUrl("$newsUrl")
            settings.javaScriptEnabled = true
        }
    }

    override fun onBackPressed() {
        if (web_view.canGoBack())
            web_view.goBack()
        else
        super.onBackPressed()
    }
}