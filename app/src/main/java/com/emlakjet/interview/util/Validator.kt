package com.emlakjet.interview.util

import java.net.URL


/**
 * Created by farukyavuz on 7.10.2018.
 * Copyright (c) 2018 Hürriyet to present
 * All rights reserved.
 */
class Validator {

    companion object {
        fun isURL(url: String): Boolean {
            return try {
                URL(url)
                true
            } catch (e: Exception) {
                false
            }
        }
    }

}