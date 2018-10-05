package com.emlakjet.interview.model.response

import android.os.Parcelable
import com.emlakjet.interview.model.MainHit
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


/**
 * Created by farukyavuz on 5.10.2018.
 * Copyright (c) 2018 Hürriyet to present
 * All rights reserved.
 */

@Parcelize
data class NoticesResponse(@SerializedName("hits") var data: MainHit) : BaseResponse(), Parcelable
