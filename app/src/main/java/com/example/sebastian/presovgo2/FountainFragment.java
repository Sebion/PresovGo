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

        mImageUrls.add("https://c1.staticflickr.com/1/64/225912483_a9aec208a2_o.jpg");
        mNames.add("A");

        mImageUrls.add("https://c1.staticflickr.com/1/64/225912483_a9aec208a2_o.jpg");
        mNames.add("B");

        mImageUrls.add("https://c1.staticflickr.com/5/4857/45837642755_02afc2893c_o.jpg");
        mNames.add("C");

        mImageUrls.add("https://c1.staticflickr.com/5/4011/4519650902_15442d9dae_z.jpg");
        mNames.add("D");

        mImageUrls.add("https://c1.staticflickr.com/5/4011/4519650902_15442d9dae_z.jpg");
        mNames.add("E");

        mImageUrls.add("https://c1.staticflickr.com/6/5705/30259890684_53652482e3.jpg");
        mNames.add("F");

        mImageUrls.add("https://c1.staticflickr.com/7829/46513501805_28bd57556e_k.jpg");
        mNames.add("G");

        mImageUrls.add("https://c1.staticflickr.com/7866/47413255301_4cebf0c942_k.jpg");
        mNames.add("H");

        mImageUrls.add("https://c1.staticflickr.com/3/2545/3907058181_ef370524cb_b.jpg");
        mNames.add("I");

        mImageUrls.add("https://c1.staticflickr.com/1/661/21255980099_215fe587e9_k.jpg");
        mNames.add("J");

        mImageUrls.add("https://c1.staticflickr.com/1/186/436759602_df41e06a92_z.jpg?zz=1");
        mNames.add("K");

        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = view.findViewById(R.id.recyclerv_view_fountain);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(view.getContext(),mNames,mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

}
