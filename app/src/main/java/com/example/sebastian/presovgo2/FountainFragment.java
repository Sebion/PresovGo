package com.example.sebastian.presovgo2;


import android.annotation.TargetApi;
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
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FountainFragment extends Fragment {

    private View view;
    FontanyPramene fontanyPramene = new FontanyPramene();
    private IMainActivity iMainActivity;
    private String myCoordinates;
    private SeekBar seekBar;
    private TextView textView1;
    private ImageView imageView;
    private ArrayList<String> pamiatkyNames =new ArrayList<>();
    private ArrayList<String> pamiatkyImgUrls =new ArrayList<>();
    private ArrayList<Double> pamiatkyDistances = new ArrayList<>();
    private ArrayList<String> pamiatkyCoordinates=new ArrayList<>();

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





    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fountain, container, false);
        textView1 = (TextView) view.findViewById(R.id.textViewProgres);
        seekBar = (SeekBar) view.findViewById(R.id.seekBar);
        imageView = (ImageView)view.findViewById(R.id.errorImage);
        seekBar.setMin(1);
        seekBar.setMax(getDistanceToPresov()+10);
        seekBar.setProgress(getDistanceToPresov()+10);
        pamiatkyNames = fontanyPramene.getNames();
        pamiatkyImgUrls = fontanyPramene.getImgUrl();
        pamiatkyDistances = getDistancesToFountains();
        pamiatkyCoordinates = fontanyPramene.getCoordinates();
        initRecyclerView();
        ArrayList<Double> pamiatkyDistances2 = new ArrayList<>();
        pamiatkyDistances2 = getDistancesToFountains();
        ArrayList<Double> finalPamiatkyDistances2 = pamiatkyDistances2;
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pamiatkyNames.clear();pamiatkyDistances.clear();pamiatkyImgUrls.clear();pamiatkyCoordinates.clear();
                textView1.setText(""+progress+"km");
                for (int i = 0; i< finalPamiatkyDistances2.size(); i++){
                    if(finalPamiatkyDistances2.get(i)<=progress){

                        pamiatkyNames.add(fontanyPramene.getNames().get(i));
                        pamiatkyImgUrls.add(fontanyPramene.getImgUrl().get(i));
                        pamiatkyDistances.add(finalPamiatkyDistances2.get(i));
                        pamiatkyCoordinates.add(fontanyPramene.getCoordinates().get(i));
                    }
                    if(pamiatkyNames.size()==0){
                        imageView.setVisibility(View.VISIBLE);
                    }else{imageView.setVisibility(View.INVISIBLE);}
                }initRecyclerView();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

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
    public ArrayList<Double> getDistancesToFountains() {
        ArrayList<Double> distances =new ArrayList<>();
        ArrayList<Double> loading=new ArrayList<>();
        if(!myCoordinates.equals("null")){
            double[]pomocMyCoor=getMyCoordinatesDouble();
            String [] pomocFountainsCoor;
            for (int i = 0; i < fontanyPramene.getLatLng().size(); i++) {
                pomocFountainsCoor=fontanyPramene.getCoordinates().get(i).split(",");
                distances.add(fontanyPramene.distance(pomocMyCoor[0],pomocMyCoor[1],Double.parseDouble(pomocFountainsCoor[0]),Double.parseDouble(pomocFountainsCoor[1])));
            }
            return distances;
        }
        else {
            for (int i = 0; i < fontanyPramene.getCoordinates().size(); i++) {
                loading.add(0.0);
            }
            return loading;



        }
    }

    public int getDistanceToPresov(){

        int distance;
        if(!myCoordinates.equals("null")){
            double[]pomocMyCoor=getMyCoordinatesDouble();

            distance=(int)fontanyPramene.distance(pomocMyCoor[0],pomocMyCoor[1],48.997631,21.2401873);
            return distance;
        }
        else return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initRecyclerView() {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerv_view_fountain);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(view.getContext(), pamiatkyNames, pamiatkyImgUrls, pamiatkyDistances,pamiatkyCoordinates);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));


    }

}
