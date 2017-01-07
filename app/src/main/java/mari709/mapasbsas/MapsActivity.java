package mari709.mapasbsas;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private double latitud;
    private double longitud;
    private String nombre;
    private float color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Bundle bundle = getIntent().getExtras();
        latitud = bundle.getDouble(getResources().getString(R.string.pLatitud));
        longitud = bundle.getDouble(getResources().getString(R.string.pLongitud));
        nombre = bundle.getString(getResources().getString(R.string.pNombre));
        color = bundle.getFloat(getResources().getString(R.string.pColor));
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng coordenada = new LatLng(latitud, longitud);
        googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

        googleMap.addMarker(new MarkerOptions()
                .anchor(0.0f, -0.0f)
                .position(coordenada)
                .title(nombre)
                .icon(BitmapDescriptorFactory.defaultMarker(color)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(latitud, longitud), 15));
    }
}