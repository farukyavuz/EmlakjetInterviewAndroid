package com.emlakjet.interview.activity

import android.os.Bundle
import android.view.MenuItem
import com.emlakjet.interview.R
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.activity_street_view.*

class StreetViewActivity : BaseActivity() {

    private lateinit var noticeLocation: LatLng

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_street_view)

        setSupportActionBar(streetToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = ""

        noticeLocation = intent.getParcelableExtra("noticeLocation")

        val streetViewPanoramaFragment = supportFragmentManager.findFragmentById(R.id.streetviewpanorama)
                as SupportStreetViewPanoramaFragment?
        streetViewPanoramaFragment!!.getStreetViewPanoramaAsync { panorama ->
            if (savedInstanceState == null) {
                panorama.setPosition(noticeLocation)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
