package com.emlakjet.interview.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v4.view.ViewPager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.emlakjet.interview.R
import com.emlakjet.interview.activity.MapActivity
import com.emlakjet.interview.model.Hit
import kotlinx.android.synthetic.main.list_item_notice.view.*


/**
 * Created by farukyavuz on 5.10.2018.
 * Copyright (c) 2018 Hürriyet to present
 * All rights reserved.
 */


class NoticesAdapter(private val hits: List<Hit>?, private val context: Context?)
    : RecyclerView.Adapter<NoticeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            NoticeViewHolder(LayoutInflater.from(context)
                    .inflate(R.layout.list_item_notice, parent, false))

    override fun getItemCount() = hits?.count() ?: 0

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        holder.bind(hits?.get(position), context)
    }


}

class NoticeViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
    private val rootView = view.itemNoticeRootView
    private val viewPager = view.itemNoticeViewPager
    private val favorite = view.itemNoticeFavorite
    private val backArrow = view.itemNoticeBackArrow
    private val nextArrow = view.itemNoticeNextArrow
    private val callView = view.itemNoticeCall
    private val title = view.itemNoticeTitle
    private val price = view.itemNoticePrice
    private val address = view.itemNoticeShortAddress
    private val floor = view.itemNoticeFloor
    private val date = view.itemNoticeDate


    @SuppressLint("SetTextI18n")
    fun bind(hit: Hit?, context: Context?) {

        viewPager.adapter = ImagesViewPagerAdapter(hit?.source?.images, context)
        title.text = hit?.source?.title?.tr ?: ""
        price.text = (hit?.source?.priceOrder ?: "") + " " + hit?.source?.currency
        address.text = (hit?.source?.properties?.town?.name
                ?: "") + " / " + (hit?.source?.properties?.district?.name ?: "")
        //floor.text = ""
        //date.text = "5 Ekim"

        if (viewPager.currentItem == 0) {
            backArrow.visibility = View.GONE
        }

        favorite.setOnClickListener {
            Toast.makeText(context, "TODO Favorite Button", Toast.LENGTH_LONG).show()
        }

        backArrow.setOnClickListener {
            viewPager.currentItem = viewPager.currentItem - 1
        }

        nextArrow.setOnClickListener {
            viewPager.currentItem = viewPager.currentItem + 1
        }

        viewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

                if (viewPager.currentItem == 0) {
                    backArrow.visibility = View.GONE
                } else {
                    backArrow.visibility = View.VISIBLE
                }

                if (viewPager.currentItem + 1 == viewPager.adapter!!.count) {
                    nextArrow.visibility = View.GONE
                } else {
                    nextArrow.visibility = View.VISIBLE
                }

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {}

        })

        callView.setOnClickListener {
            val phoneNumber = hit?.source?.user?.phone?.get(0)?.phones?.get(0)?.did
            val intent = Intent(Intent.ACTION_DIAL);
            intent.data = Uri.parse("tel:$phoneNumber")
            context?.startActivity(intent)
        }

        itemView.setOnClickListener {
            val intent = Intent(rootView.context, MapActivity::class.java)
            intent.putExtra("hit", hit)
            rootView.context.startActivity(intent)
        }

        viewPager.setOnItemClickListener {
            itemView.performClick()
        }

    }

}