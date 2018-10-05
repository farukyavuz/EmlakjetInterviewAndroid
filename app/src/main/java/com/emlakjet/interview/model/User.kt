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
data class User(var id: Int,
                @SerializedName("account_id") var accountID: Int,
                @SerializedName("office_id") var officeID: Int,
                var type: String,
                var category: Int,
                var phone: MutableList<MainPhone>,
                @SerializedName("full_name") var fullName: String,
                @SerializedName("account_name") var accountName: String,
                var logo: String) : BaseModel(), Parcelable