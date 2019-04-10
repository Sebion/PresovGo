package com.example.sebastian.presovgo2;


import android.os.Build;
import android.os.Bundle;
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
public class ChurchesFragment extends Fragment {
    SakralneObjekty sakralneObjekty =new SakralneObjekty();

    private View view;
    private ArrayList<Pamiatka> pamiatky = new ArrayList<>();

    public ChurchesFragment() {
        // Required empty public constructor

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_churches, container, false);
        initRecyclerView();
        return view;


    }




    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initRecyclerView() {

        RecyclerView recyclerView = view.findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(view.getContext(), sakralneObjekty.getNames(), sakralneObjekty.getImgUrl(), sakralneObjekty.getCoordinates());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }




}