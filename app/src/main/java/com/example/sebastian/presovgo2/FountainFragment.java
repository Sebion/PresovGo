package com.example.sebastian.presovgo2;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FountainFragment extends Fragment {

    private View view;
    FontanyPramene fontanyPramene = new FontanyPramene();
    private IMainActivity iMainActivity;
    private String myCoordinates;


    public FountainFragment() {
        // Required empty public constructor
    }


        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            Bundle bundle=this.getArguments();
            if(bundle!=null){
                myCoordinates=bundle.getString("coor");

            }

        }

        @Override
        public void onAttach(Context context) {
            super.onAttach(context);
            iMainActivity = (IMainActivity) getActivity();

        }





    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fountain, container, false);
        initRecyclerView();
        return view;
    }
    private double[] getMyCoordinatesDouble(){

        String[] myCoordinatesString = myCoordinates.split(",");
        double [] myCoordinatesDouble=new double[2];
        myCoordinatesDouble[0]=Double.parseDouble(myCoordinatesString[0]);
        myCoordinatesDouble[1]=Double.parseDouble(myCoordinatesString[1]);
        return myCoordinatesDouble;


    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public ArrayList<String> getDistancesToFountains() {
        ArrayList<String> distances =new ArrayList<>();
        double[]pomocMyCoor=getMyCoordinatesDouble();
        String [] pomocFountainsCoor;
        for (int i = 0; i < fontanyPramene.getLatLng().size(); i++) {
            pomocFountainsCoor=fontanyPramene.getCoordinates().get(i).split(",");
            distances.add("Distance to this fountain: "+fontanyPramene.distance(pomocMyCoor[0],pomocMyCoor[1],Double.parseDouble(pomocFountainsCoor[0]),Double.parseDouble(pomocFountainsCoor[1])));
        }


        return distances;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initRecyclerView() {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerv_view_fountain);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(view.getContext(), fontanyPramene.getNames(), fontanyPramene.getImgUrl(), getDistancesToFountains());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));


    }

}
