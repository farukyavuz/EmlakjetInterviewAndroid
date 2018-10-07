package com.emlakjet.interview.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.widget.LinearLayout
import android.widget.Toast
import com.emlakjet.interview.R
import com.emlakjet.interview.adapter.NearbyAdapter
import com.emlakjet.interview.common.NEARBY_LIST
import com.emlakjet.interview.model.Hit
import com.emlakjet.interview.model.NearbyItemModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_map.*

class MapActivity : BaseActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var hit: Hit
    private val nearbyItemClicked: (nearbyItemModel: NearbyItemModel) -> Unit = {
        Toast.makeText(this, "TODO Nearby Type : " + it.type, Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        hit = intent.getParcelableExtra("hit")

        nearbyRecyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.HORIZONTAL))
        nearbyRecyclerView.adapter = NearbyAdapter(NEARBY_LIST, this, nearbyItemClicked)


        mapStreetViewContainer.setOnClickListener {
            val intent = Intent(this, StreetViewActivity::class.java)
            val lat = hit.source.map.coordinate.lat
            val long = hit.source.map.coordinate.lon
            val noticeLocation = LatLng(lat, long)
            intent.putExtra("noticeLocation", noticeLocation)
            startActivity(intent)
        }

        mapDirectionsViewContainer.setOnClickListener {

            val lat = hit.source.map.coordinate.lat
            val long = hit.source.map.coordinate.lon
            //val noticeLocation = LatLng(lat, long)
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:"+lat+","+long +"?z=17"))
            startActivity(intent)

        }

        nearbyCall.setOnClickListener {
            val phoneNumber = hit.source.user.phone?.get(0)?.phones?.get(0)?.did
            val intent = Intent(Intent.ACTION_DIAL);
            intent.data = Uri.parse("tel:$phoneNumber")
            startActivity(intent)
        }

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val customMarker = BitmapDescriptorFactory.fromResource(R.drawable.icon_marker_announcement)

        val lat = hit.source.map.coordinate.lat
        val long = hit.source.map.coordinate.lon
        val noticeLocation = LatLng(lat, long)

        val markerOptions = MarkerOptions()
                .position(noticeLocation)
                //.title(hit.source.title.tr)
                .icon(customMarker)
        mMap.addMarker(markerOptions)
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(noticeLocation, 11.0f))
    }
}
