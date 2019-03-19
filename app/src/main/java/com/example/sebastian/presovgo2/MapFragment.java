package com.example.sebastian.presovgo2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback{
    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_map, container, false);
        mapFragment=(SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if(mapFragment==null){
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft= fm.beginTransaction();
            mapFragment=SupportMapFragment.newInstance();
            ft.replace(R.id.map,mapFragment).commit();

        }
        mapFragment.getMapAsync(this);
        return v;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng presov= new LatLng(48.997631, 21.2401873);
        mMap.addMarker(new MarkerOptions().position(presov).title("Marker in Presov"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(presov));
        mMap.setMinZoomPreference(15);

    }
}
