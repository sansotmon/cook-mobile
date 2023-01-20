package ssm.test.cookmobile.presenter

import android.content.Context
import com.google.android.gms.maps.model.LatLng

class MapPresenter(val context: Context, val ui: MapUI) {

    fun setLocation(latitude: Double, longitude: Double) {
        ui.addMarker(LatLng(latitude, longitude))
    }
}