package com.example.bdtroops

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.bdtroops.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var btnUrl = "https://bd-troops.herokuapp.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
        webViewSetup()
        initClickListener()
    }

    private fun initClickListener() {
        binding?.google?.setOnClickListener {
            btnUrl = "https://www.google.com/"
            webViewSetup()
        }

        binding?.bdTroops?.setOnClickListener {
            btnUrl = "https://bd-troops.herokuapp.com/"
            webViewSetup()
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun webViewSetup() {
        binding?.webView?.webViewClient = WebViewClient()

        binding?.webView?.apply {
            loadUrl(btnUrl)
            //loadUrl("https://www.google.com/")
            settings.javaScriptEnabled = true
        }
    }

    override fun onBackPressed() {
        if (binding?.webView?.canGoBack() == true) {
            binding?.webView?.goBack()
        } else {
            super.onBackPressed()
        }
    }
}