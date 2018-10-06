package com.emlakjet.interview.activity

import android.os.Bundle
import com.emlakjet.interview.R
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment
import com.google.android.gms.maps.model.LatLng

class StreetViewActivity : BaseActivity() {

    private lateinit var noticeLocation: LatLng

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_street_view)

        noticeLocation = intent.getParcelableExtra("noticeLocation")

        val streetViewPanoramaFragment = supportFragmentManager.findFragmentById(R.id.streetviewpanorama)
                as SupportStreetViewPanoramaFragment?
        streetViewPanoramaFragment!!.getStreetViewPanoramaAsync { panorama ->
            if (savedInstanceState == null) {
                panorama.setPosition(noticeLocation)
            }
        }
    }
}
