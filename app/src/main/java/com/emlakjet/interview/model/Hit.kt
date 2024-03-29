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
data class Hit(@SerializedName("_id") var id: String,
               @SerializedName("_source") var source: Notice) : BaseModel(), Parcelable
