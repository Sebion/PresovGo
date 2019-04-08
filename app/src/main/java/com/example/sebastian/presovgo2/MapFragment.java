package com.example.sebastian.presovgo2;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
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

import java.util.ArrayList;


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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng presov= new LatLng(48.997631, 21.2401873);
        ArrayList <LatLng> markers=new ArrayList<>();
        // Add a marker in Sydney and move the camera

        markers.add(new LatLng(48.998058, 21.239890));
        markers.add(new LatLng(48.998492, 21.239862));
        markers.add(new LatLng(48.994157, 21.242976));
        markers.add(new LatLng(48.989799, 21.244289));
        markers.add(new LatLng(49.000021, 21.237849));
        markers.add(new LatLng(48.989448, 21.227343));
        markers.add(new LatLng(48.988057, 21.225881));
        markers.add(new LatLng(48.979994, 21.276552));
        markers.add(new LatLng(48.996245, 21.243839));
        markers.add(new LatLng(48.998492, 21.239862));
        markers.add(new LatLng(49.006799, 21.225588));
        markers.add(new LatLng(48.994075, 21.272423));

        markers.add(new LatLng(49.002234, 21.232797));
        markers.add(new LatLng(48.978732, 21.269154));
        markers.add(new LatLng(48.983558, 21.175571));
        markers.add(new LatLng(48.996943, 21.286334));
        markers.add(new LatLng(49.020747, 21.281516));

        markers.forEach((n) ->  mMap.addMarker(new MarkerOptions().position(n)));


        mMap.moveCamera(CameraUpdateFactory.newLatLng(presov));
        mMap.setMinZoomPreference(11);

    }
}
