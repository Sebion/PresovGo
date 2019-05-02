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
public class ChurchesFragment extends Fragment {
    SakralneObjekty sakralneObjekty =new SakralneObjekty();
    private String myCoordinates;
    private View view;
    private IMainActivity iMainActivity;
    private ImageView imageView;
    private SeekBar seekBar;
    private TextView textView1;
    private ArrayList<String> pamiatkyNames =new ArrayList<>();
    private ArrayList<String> pamiatkyImgUrls =new ArrayList<>();
    private ArrayList<Double> pamiatkyDistances = new ArrayList<>();
    private ArrayList<String> pamiatkyCoordinates=new ArrayList<>();

    public ChurchesFragment() {
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
        view = inflater.inflate(R.layout.fragment_churches, container, false);
        textView1 = (TextView) view.findViewById(R.id.textViewProgres);
        seekBar = (SeekBar) view.findViewById(R.id.seekBar);
        imageView = (ImageView)view.findViewById(R.id.errorImage);
        seekBar.setMin(1);
        seekBar.setMax(getDistanceToPresov()+10);
        seekBar.setProgress(getDistanceToPresov()+10);
        pamiatkyNames = sakralneObjekty.getNames();
        pamiatkyImgUrls = sakralneObjekty.getImgUrl();
        pamiatkyDistances = getDistancesToChurches();
        pamiatkyCoordinates = sakralneObjekty.getCoordinates();
        initRecyclerView();
        ArrayList<Double> pamiatkyDistances2 = new ArrayList<>();
        pamiatkyDistances2 = getDistancesToChurches();
        ArrayList<Double> finalPamiatkyDistances2 = pamiatkyDistances2;
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pamiatkyNames.clear();pamiatkyDistances.clear();pamiatkyImgUrls.clear();pamiatkyCoordinates.clear();
                textView1.setText(""+progress+"km");
                for (int i = 0; i< finalPamiatkyDistances2.size(); i++){
                    if(finalPamiatkyDistances2.get(i)<=progress){
                        pamiatkyNames.add(sakralneObjekty.getNames().get(i));
                        pamiatkyImgUrls.add(sakralneObjekty.getImgUrl().get(i));
                        pamiatkyDistances.add(finalPamiatkyDistances2.get(i));
                        pamiatkyCoordinates.add(sakralneObjekty.getCoordinates().get(i));
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
    public int getDistanceToPresov(){

        int distance;
        if(!myCoordinates.equals("null")){
            double[]pomocMyCoor=getMyCoordinatesDouble();

            distance=(int)sakralneObjekty.distance(pomocMyCoor[0],pomocMyCoor[1],48.997631,21.2401873);
            return distance;
        }
        else return 0;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public ArrayList<Double> getDistancesToChurches() {
        ArrayList<Double> distances =new ArrayList<>();
        ArrayList<Double> loading=new ArrayList<>();
        if(!myCoordinates.equals("null")){
        double[]pomocMyCoor=getMyCoordinatesDouble();
        String [] pomocChurchesCoor;
        for (int i = 0; i < sakralneObjekty.getLatLng().size(); i++) {
            pomocChurchesCoor=sakralneObjekty.getCoordinates().get(i).split(",");
            distances.add(sakralneObjekty.distance(pomocMyCoor[0],pomocMyCoor[1],Double.parseDouble(pomocChurchesCoor[0]),Double.parseDouble(pomocChurchesCoor[1])));
        }
            return distances;
        }
        else {
            for (int i = 0; i < sakralneObjekty.getCoordinates().size(); i++) {
                loading.add(0.0);
            }
            return loading;



        }





    }




    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initRecyclerView() {

        RecyclerView recyclerView = view.findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(view.getContext(), pamiatkyNames, pamiatkyImgUrls, pamiatkyDistances,pamiatkyCoordinates);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }




}