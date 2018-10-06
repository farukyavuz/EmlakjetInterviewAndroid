package com.emlakjet.interview.util

import android.annotation.TargetApi
import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.drawable.DrawableCompat
import android.util.AttributeSet
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout


/**
 * Created by farukyavuz on 7.10.2018.
 * Copyright (c) 2018 Hürriyet to present
 * All rights reserved.
 */
class OverlayProgressBar : RelativeLayout {

    @JvmOverloads
    constructor(
            context: Context,
            attrs: AttributeSet? = null,
            defStyleAttr: Int = 0)
            : super(context, attrs, defStyleAttr)

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
            context: Context,
            attrs: AttributeSet?,
            defStyleAttr: Int,
            defStyleRes: Int)
            : super(context, attrs, defStyleAttr, defStyleRes)


    private var progressBar: ProgressBar? = null

    init {
        if (progressBar == null) {
            progressBar = ProgressBar(context)

            progressBar!!.progressDrawable?.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN)


            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                val wrapDrawable = DrawableCompat.wrap(progressBar?.indeterminateDrawable!!)
                DrawableCompat.setTint(wrapDrawable, ContextCompat.getColor(context
                        , android.R.color.holo_red_dark))
                progressBar?.indeterminateDrawable = DrawableCompat.unwrap(wrapDrawable)
            } else {
                progressBar?.indeterminateDrawable!!.setColorFilter(ContextCompat
                        .getColor(context, android.R.color.holo_green_dark), PorterDuff.Mode.SRC_IN)
            }

            val params = RelativeLayout
                    .LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT
                            , RelativeLayout.LayoutParams.WRAP_CONTENT)
            params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE)
            params.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE)
            super.addView(progressBar, params)
            this.setOnClickListener {}
        }

    }

    fun show() {
        this.visibility = VISIBLE
        progressBar?.visibility = View.VISIBLE
    }

    fun stop() {
        this.visibility = GONE
        progressBar?.visibility = View.GONE
    }

}