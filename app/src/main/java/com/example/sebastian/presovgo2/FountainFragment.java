package com.example.sebastian.presovgo2;


import android.os.Bundle;
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
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList <String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mCoordinates =new ArrayList<>();




    public FountainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fountain, container, false);
        initImageBitmaps();
        return view;
    }

    private void initImageBitmaps(){

        mImageUrls.add("https://m.smedata.sk/api-media/media/image/sme/4/32/3229924/3229924_1200x.jpeg?rev=3");
        mNames.add("Fontána Neptún");
        mCoordinates.add("48.9972801,21.2406273");

        mImageUrls.add("http://www.obecbardonovo.sk/portals_pictures/i_005149/i_5149417.jpg");
        mNames.add("Fontána Centrál Sídl. II.");
        mCoordinates.add("48.998796,21.2244021");

        mImageUrls.add("https://www.odkazprestarostu.sk/image/w1280/public/alerts/55350/images/5b6227eb00fab.jpg");
        mNames.add("Fontána Divízia, Nám. legionárov");
        mCoordinates.add("48.992649,21.245111");

        mImageUrls.add("https://mapio.net/images-p/107427244.jpg");
        mNames.add("Fontána Nám. mieru");
        mCoordinates.add("49.0016961,21.2396836");
       
        mImageUrls.add("https://mapio.net/images-p/51421431.jpg");
        mNames.add("Fontána Nám. mládeže");
        mCoordinates.add("48.994849,21.230344");

        mImageUrls.add("https://s3.amazonaws.com/gs-geo-images/50f2f050-b291-45e8-986e-58d6e2fe9f87.jpg");
        mNames.add("Fontána Družba");
        mCoordinates.add("49.006467, 21.223953");

        mImageUrls.add("https://m.smedata.sk/api-media/media/image/sme/7/15/1588737/1588737_1200x.jpg?rev=1");
        mNames.add("Fontána Park Angelinum");
        mCoordinates.add("48.993027,21.272304");

        mImageUrls.add("https://www.odkazprestarostu.sk/image/w1280/public/alerts/31583/images/579b90c0280f1.jpg");
        mNames.add("Fontána NS OPÁL");
        mCoordinates.add("48.9867838,21.2656024");

        mImageUrls.add("https://mapio.net/images-p/105665770.jpg");
        mNames.add("Fontána Šváby");
        mCoordinates.add("48.9740729,21.2624717");


        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = view.findViewById(R.id.recyclerv_view_fountain);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(view.getContext(),mNames,mImageUrls,mCoordinates);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

}
