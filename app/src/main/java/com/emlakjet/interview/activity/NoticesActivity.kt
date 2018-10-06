package com.emlakjet.interview.activity

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.view.View
import android.widget.LinearLayout.VERTICAL
import android.widget.Toast
import com.emlakjet.interview.EJApp
import com.emlakjet.interview.R
import com.emlakjet.interview.adapter.NoticesAdapter
import com.emlakjet.interview.model.response.NoticesResponse
import com.emlakjet.interview.network.ApiService
import kotlinx.android.synthetic.main.activity_notices.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NoticesActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notices)
        getData()

        noticesTryAgainButton.setOnClickListener {
            getData()
        }

    }

    fun getData() {

        if (EJApp.isNetworkAvailable()) {
            noticesTryAgainButton.visibility = View.GONE
        } else {
            noticesTryAgainButton.visibility = View.VISIBLE
            Toast.makeText(this, "İnternet Bağlantınız Yok", Toast.LENGTH_LONG).show()
            return
        }

        noticesOverlayProgressBar.show()
        val call = ApiService.factory().getNotices()
        call.enqueue(object : Callback<NoticesResponse> {
            override fun onFailure(call: Call<NoticesResponse>, t: Throwable) {
                Toast.makeText(this@NoticesActivity, "Sunucuyla Bağlantı Sağlanamadı.", Toast.LENGTH_LONG).show()
                noticesTryAgainButton.visibility = View.VISIBLE
                noticesOverlayProgressBar.stop()
            }

            override fun onResponse(call: Call<NoticesResponse>, response: Response<NoticesResponse>) {
                //noticesRecyclerView.setHasFixedSize(true)
                //noticesRecyclerView.layoutManager = LinearLayoutManager(this@NoticesActivity)
                noticesRecyclerView.addItemDecoration(DividerItemDecoration(this@NoticesActivity, VERTICAL))
                noticesRecyclerView.adapter = NoticesAdapter(response.body()?.data?.notices, this@NoticesActivity)
                noticesOverlayProgressBar.stop()
            }
        })

    }


}
