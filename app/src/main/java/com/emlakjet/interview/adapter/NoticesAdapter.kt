package com.emlakjet.interview.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.emlakjet.interview.R
import com.emlakjet.interview.model.Hit
import com.emlakjet.interview.model.Notice
import kotlinx.android.synthetic.main.list_item_notice.view.*


/**
 * Created by farukyavuz on 5.10.2018.
 * Copyright (c) 2018 Hürriyet to present
 * All rights reserved.
 */


class NoticesAdapter(private val hits: List<Hit>?, private val context: Context?)
    : RecyclerView.Adapter<NoticeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            NoticeViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item_notice, parent, false))

    override fun getItemCount() = hits?.count() ?: 0

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) =
            holder.bind(hits?.get(position))

}

class NoticeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val rootView = view.itemNoticeRootView
    private val title = view.itemNoticeTitle

    fun bind(hit: Hit?) {

        rootView.setOnClickListener {

            //            val intent = Intent(selfContext, WebViewActivity::class.java)
//            intent.putExtra(WebViewActivity.EXTRA_URL, news?.url)
//            selfContext.startActivity(intent)
//        }
//

        title.text = hit?.source?.currency


        }
    }
}