package com.example.kotlinapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        recyclerView_main.setBackgroundColor(Color.BLUE)

        fetchJson()
    }

    fun fetchJson(){
        println("attempting to fetch JSON")

        val url = "https://api.letsbuildthatapp.com/youtube/home_feed"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response.body()?.string()
                val resp = Gson().fromJson(body, CallResponse::class.java)
                runOnUiThread {
                    setRecycler(resp)
                    progressBar.isVisible = false
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }
        })
    }

    fun setRecycler(response: CallResponse) {
        recyclerView_main.layoutManager = LinearLayoutManager(this)
        recyclerView_main.adapter = MainAdapter(response)
    }
}








