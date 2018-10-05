package com.emlakjet.interview.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/**
 * Created by farukyavuz on 5.10.2018.
 * Copyright (c) 2018 Hürriyet to present
 * All rights reserved.
 */
@Parcelize
data class MainPhone(var source: String,
                     var phones: MutableList<Phone>) : BaseModel(), Parcelable
