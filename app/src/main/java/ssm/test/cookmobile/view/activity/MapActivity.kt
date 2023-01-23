package ssm.test.cookmobile.view.activity

import android.os.Bundle
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import ssm.test.cookmobile.R
import ssm.test.cookmobile.R.layout.activity_map
import ssm.test.cookmobile.presenter.MapPresenter
import ssm.test.cookmobile.presenter.MapUI


class MapActivity: BaseActivity(), OnMapReadyCallback, MapUI {

    private lateinit var mMap: GoogleMap
    private var markerRecipe: Marker? = null
    private var presenter: MapPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_map)

        presenter = MapPresenter(this,this)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        getRecipeLocation()
    }

    private fun getRecipeLocation(){
        if(intent.hasExtra("latitude")){
            val latitude = intent.getDoubleExtra("latitude", 0.0)
            val longitude = intent.getDoubleExtra("longitude", 0.0)

            presenter?.setLocation(latitude, longitude)
        }
    }

    override fun addMarker(latLng: LatLng) {
        val location = CameraUpdateFactory.newLatLngZoom(latLng, 8f)
        markerRecipe = mMap.addMarker(
            MarkerOptions()
                .position(latLng)
                .title("Marker")
        )
        mMap.animateCamera(location)
    }
}