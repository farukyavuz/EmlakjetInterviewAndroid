package com.emlakjet.interview.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.emlakjet.interview.R
import com.emlakjet.interview.adapter.NoticesAdapter
import com.emlakjet.interview.model.response.NoticesResponse
import com.emlakjet.interview.network.ApiService
import kotlinx.android.synthetic.main.activity_notices.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NoticesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notices)

        val call = ApiService.factory().getNotices()
        call.enqueue(object : Callback<NoticesResponse> {
            override fun onFailure(call: Call<NoticesResponse>, t: Throwable) {
                Log.e("MainActivity : ", "onFailure")
            }
            override fun onResponse(call: Call<NoticesResponse>, response: Response<NoticesResponse>) {
                Log.e("MainActivity : ", response.body().toString())
                var res =
                noticesRecyclerView.setHasFixedSize(true)
                noticesRecyclerView.layoutManager = LinearLayoutManager(this@NoticesActivity)
                noticesRecyclerView.adapter = NoticesAdapter(response.body()?.data?.notices, this@NoticesActivity)
            }
        })
    }
}
