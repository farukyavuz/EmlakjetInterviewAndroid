package com.emlakjet.interview.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/**
 * Created by farukyavuz on 6.10.2018.
 * Copyright (c) 2018 Hürriyet to present
 * All rights reserved.
 */
@Parcelize
data class Town(var name: String) : BaseModel(), Parcelable