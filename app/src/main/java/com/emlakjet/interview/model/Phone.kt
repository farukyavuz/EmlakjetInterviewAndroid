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
data class Phone(var did: String,
                 @SerializedName("phone_type") var phoneType: String) : BaseModel(), Parcelable