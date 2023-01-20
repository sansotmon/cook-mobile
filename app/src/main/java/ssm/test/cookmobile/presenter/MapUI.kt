package ssm.test.cookmobile.presenter

import com.google.android.gms.maps.model.LatLng

interface MapUI {
    fun addMarker(latLng: LatLng)
}