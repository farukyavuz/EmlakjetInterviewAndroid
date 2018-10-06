package com.emlakjet.interview.adapter

import android.content.Context
import android.graphics.Color
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.emlakjet.interview.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pager_item_images.view.*

/**
 * Created by farukyavuz on 6.10.2018.
 * Copyright (c) 2018 Hürriyet to present
 * All rights reserved.
 */
class ImagesViewPagerAdapter(private val images: List<String>?, private val context: Context?) : PagerAdapter() {

    override fun instantiateItem(parent: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.pager_item_images, parent, false)
        Picasso.get()
                .load(images?.get(position))
                .placeholder(R.drawable.icon_image_place_holder)
                .error(R.drawable.icon_image_place_holder)
                .into(view.pagerItemImageView)
        parent.addView(view)

        view.pagerItemImageView.setColorFilter(Color.rgb(205, 205, 205), android.graphics.PorterDuff.Mode.MULTIPLY);

        return view
    }

    override fun getCount(): Int {
        return images?.count() ?: 0
    }

    override fun isViewFromObject(v: View, any: Any): Boolean {
        return v === any as View
    }

    override fun destroyItem(parent: ViewGroup, position: Int, any: Any) {
        parent.removeView(any as View)
    }

}