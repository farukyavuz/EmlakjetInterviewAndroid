package com.emlakjet.interview.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


/**
 * Created by farukyavuz on 5.10.2018.
 * Copyright (c) 2018 Hürriyet to present
 * All rights reserved.
 */
@Parcelize
data class Notice(var id: Int,
                  var user: User,
                  var properties: Properties,
                  var currency: String,
                  @SerializedName("price_order") var priceOrder: String,
                  @SerializedName("cover_photo") var coverPhoto: String,
                  @SerializedName("has_photo") var hasPhoto: Boolean,
                  var images: MutableList<String>?,
                  var map: Map,
                  var title: Title,
                  var description: Description,
                  @SerializedName("created_at") var createdAt: String
) : BaseModel(), Parcelable