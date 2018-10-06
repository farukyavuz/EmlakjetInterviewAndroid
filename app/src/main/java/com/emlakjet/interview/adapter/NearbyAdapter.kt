package com.emlakjet.interview.adapter

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.emlakjet.interview.R
import com.emlakjet.interview.model.NearbyItemModel
import kotlinx.android.synthetic.main.list_item_nearby.view.*

/**
 * Created by farukyavuz on 6.10.2018.
 * Copyright (c) 2018 Hürriyet to present
 * All rights reserved.
 */

class NearbyAdapter(private val nearbyList: List<NearbyItemModel>?, private val context: Context?, private val nearbyItemClicked: (nearbyItemModel: NearbyItemModel) -> Unit)
    : RecyclerView.Adapter<NearbyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            NearbyViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item_nearby, parent, false))

    override fun getItemCount() = nearbyList?.count() ?: 0

    override fun onBindViewHolder(holder: NearbyViewHolder, position: Int) =
            holder.bind(nearbyList?.get(position), nearbyItemClicked)

}

class NearbyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val rootView = view.itemNearbyRootView
    private val image = view.itemImage
    private val title = view.itemNearbyTitle

    fun bind(nearbyItemModel: NearbyItemModel?, nearbyItemClicked: (nearbyItemModel: NearbyItemModel) -> Unit) {

        rootView.setOnClickListener {
            nearbyItemClicked(nearbyItemModel!!)
        }

        title.text = nearbyItemModel?.title + " (" + (nearbyItemModel?.count ?: 0) + ")"
        title.setTextColor(Color.parseColor(nearbyItemModel?.textColor))
        nearbyItemModel?.icon?.let { image.setImageResource(it) }

    }

}