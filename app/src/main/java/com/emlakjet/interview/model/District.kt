package com.emlakjet.interview.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


/**
 * Created by farukyavuz on 6.10.2018.
 * Copyright (c) 2018 Hürriyet to present
 * All rights reserved.
 */

@Parcelize
data class District(var id: Int,
                    var name: String,
                    var slug: String) : BaseModel(), Parcelable
