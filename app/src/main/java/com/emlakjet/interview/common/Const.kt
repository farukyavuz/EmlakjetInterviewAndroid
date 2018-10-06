package com.emlakjet.interview.common

import com.emlakjet.interview.R
import com.emlakjet.interview.model.NearbyItemModel


/**
 * Created by farukyavuz on 5.10.2018.
 * Copyright (c) 2018 Hürriyet to present
 * All rights reserved.
 */

const val TEST_URL = "https://gist.githubusercontent.com/umutSeferEmlakjet/fb12107ee5c451b57b508778e7217ba9/raw/2e562b481b822ef2e65b807c67b65a09c7e816ab/listing-mock-data.json"


val NEARBY_LIST: MutableList<NearbyItemModel> = mutableListOf(
        NearbyItemModel("all", R.drawable.icon_nearby_all, "Tüm Kategoriler", "#51C945", 67),
        NearbyItemModel("transport", R.drawable.icon_nearby_transport, "Ulaşım", "#ff616161", 12),
        NearbyItemModel("education", R.drawable.icon_nearby_education, "Eğitim Kurumları", "#ff2196f3", 23),
        NearbyItemModel("market", R.drawable.icon_nearby_market, "Marketler", "#ffff9800", 3),
        NearbyItemModel("health", R.drawable.icon_nearby_health, "Sağlık Kurumları", "#fff44336", 3),
        NearbyItemModel("mall", R.drawable.icon_nearby_mall, "Alışveriş Merkezleri", "#ffe91e63", 7),
        NearbyItemModel("fun", R.drawable.icon_nearby_fun, "Eğlence Yerleri", "#ffffc107", 12),
        NearbyItemModel("sport", R.drawable.icon_nearby_sport, "Spor Tesisleri", "#ff4caf50", 20),
        NearbyItemModel("cultural", R.drawable.icon_nearby_cultural, "Kültürel Aktiviteler", "#ff673ab7", 11),
        NearbyItemModel("religious", R.drawable.icon_nearby_cultural, "Dini Yerler", "#ff009688", 19),
        NearbyItemModel("touristic", R.drawable.icon_nearby_touristic, "Tarihi/Turistik Yer", "#ff795548", 19)
)