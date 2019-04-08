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


       
        mImageUrls.add("https://mapio.net/images-p/51421431.jpg");
        mNames.add("Fontána Nám. mládeže");

        mImageUrls.add("https://s3.amazonaws.com/gs-geo-images/50f2f050-b291-45e8-986e-58d6e2fe9f87.jpg");
        mNames.add("Fontána Družba");

        mImageUrls.add("https://m.smedata.sk/api-media/media/image/sme/7/15/1588737/1588737_1200x.jpg?rev=1");
        mNames.add("Fontána Park Angelinum");

        mImageUrls.add("https://www.odkazprestarostu.sk/image/w1280/public/alerts/31583/images/579b90c0280f1.jpg");
        mNames.add("Fontána NS OPÁL");

        mImageUrls.add("https://mapio.net/images-p/105665770.jpg");
        mNames.add("Fontána Šváby");




        /*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*/
        /*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*/
        /*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*/
        /*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*/
        /*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*/
        /*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*/
        /*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*/
        /*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*/
        /*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*/
        /*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*/
        /*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*/
        /*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*/
        /*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*/
        /*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*/
        /*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*/
        /*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*/
        /*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*/
        /*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*/
        /*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*/
        /*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*/
        /*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*//*KOMAR JE DEBIL*/
        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = view.findViewById(R.id.recyclerv_view_fountain);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(view.getContext(),mNames,mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

}
