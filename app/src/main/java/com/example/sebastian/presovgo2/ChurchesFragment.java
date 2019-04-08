package com.example.sebastian.presovgo2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChurchesFragment extends Fragment {


    private View view;
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList <String> mImageUrls = new ArrayList<>();
    private ArrayList<Double>mLatitude=new ArrayList<>();
    private ArrayList<Double>mLongtitude=new ArrayList<>();

    public ChurchesFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_churches, container, false);
        initImageBitmaps();
        return view;




    }

    private void initImageBitmaps(){

        mImageUrls.add("http://www.svestav.sk/wp-content/uploads/2016/01/pre%C5%A1ov-kostol.jpg");
        mNames.add("Konkatedrála sv. Mikuláša");


        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d2/Town_Presov_Slovakia_0862.jpg/270px-Town_Presov_Slovakia_0862.jpg");
        mNames.add("Evanjelický a.v. chrám Svätej Trojice");

        mImageUrls.add("https://www.abu.sk/gallery/katedrala/priecelie-katedraly_n.jpg");
        mNames.add("Katedrála sv. Jána Krstiteľa");

        mImageUrls.add("http://www.vypadni.sk/App_Blobs/Images/Upload/00000885.jpg");
        mNames.add("Katedrálny chrám sv. Alexandra Nevského");

        mImageUrls.add("https://c1.staticflickr.com/5/4011/4519650902_15442d9dae_z.jpg");
        mNames.add("Ortodoxná synagóga");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/Presov12Slovakia145.JPG/270px-Presov12Slovakia145.JPG");
        mNames.add("Zbor Cirkvi bratskej v Prešove");


        mImageUrls.add("http://duchovne-cvicenia.jezuiti.sk/images/presov.jpg");
        mNames.add("Kaplnka sv. Ignáca (Jezuiti)");



        mImageUrls.add("https://i.pinimg.com/originals/74/ff/49/74ff49a33c48a94f633679c4de0da231.jpg");
        mNames.add("Kostol Svätého Kríža (Kalvária)");




        mImageUrls.add("http://solivar.fara.sk/useruploads/images/farnost/hradok.jpg");
        mNames.add("Farský kostol Najsvätejšej Trojice (Solivar)");

        mImageUrls.add("http://solivar.fara.sk/useruploads/images/farnost/bana.jpg");
        mNames.add("Kostol narodenia sv. Jána Krstiteľa (Soľná Baňa)");

        mImageUrls.add("http://omestach.sk/po/foto/hpim0364maxi.jpg");
        mNames.add("Kostol sv. Jozefa (Františkáni)");

        

        mImageUrls.add("http://farskyurad.sk/uploads/thumb_45-afbadf2157.jpg");
        mNames.add("Farský kostol Kráľovnej pokoja (Sídlisko III)");

        mImageUrls.add("http://farskyurad.sk/uploads/thumb_52-743993f436.jpg");
        mNames.add("Farský kostol Krista Kráľa (Sekčov)");

        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = view.findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(view.getContext(),mNames,mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

}