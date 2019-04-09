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
    private ArrayList<String> mCoordinates = new ArrayList<>();

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
        mCoordinates.add("48.998058, 21.239890");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d2/Town_Presov_Slovakia_0862.jpg/270px-Town_Presov_Slovakia_0862.jpg");
        mNames.add("Evanjelický a.v. chrám Svätej Trojice");
        mCoordinates.add("48.998492, 21.239862");

        mImageUrls.add("https://www.abu.sk/gallery/katedrala/priecelie-katedraly_n.jpg");
        mNames.add("Katedrála sv. Jána Krstiteľa");
        mCoordinates.add("48.994157, 21.242976");

        mImageUrls.add("http://www.vypadni.sk/App_Blobs/Images/Upload/00000885.jpg");
        mNames.add("Katedrálny chrám sv. Alexandra Nevského");
        mCoordinates.add("48.989799, 21.244289");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/Presov12Slovakia145.JPG/270px-Presov12Slovakia145.JPG");
        mNames.add("Ortodoxná synagóga");
        mCoordinates.add("49.000021, 21.237849");

        mImageUrls.add("http://duchovne-cvicenia.jezuiti.sk/images/presov.jpg");
        mNames.add("Kaplnka sv. Ignáca (Jezuiti)");
        mCoordinates.add("48.989448, 21.227343");

        mImageUrls.add("https://i.pinimg.com/originals/74/ff/49/74ff49a33c48a94f633679c4de0da231.jpg");
        mNames.add("Kostol Svätého Kríža (Kalvária)");
        mCoordinates.add("48.988057, 21.225881");


        mImageUrls.add("http://solivar.fara.sk/useruploads/images/farnost/bana.jpg");
        mNames.add("Kostol narodenia sv. Jána Krstiteľa (Soľná Baňa)");
        mCoordinates.add("48.979994, 21.276552");

        mImageUrls.add("http://omestach.sk/po/foto/hpim0364maxi.jpg");
        mNames.add("Kostol sv. Jozefa (Františkáni)");
        mCoordinates.add("48.996245, 21.243839");

        mImageUrls.add("http://farskyurad.sk/uploads/thumb_45-afbadf2157.jpg");
        mNames.add("Farský kostol Kráľovnej pokoja (Sídlisko III)");
        mCoordinates.add("8.998492, 21.239862");

        mImageUrls.add("http://farskyurad.sk/uploads/thumb_52-743993f436.jpg");
        mNames.add("Farský kostol Krista Kráľa (Sekčov)");
        mCoordinates.add("49.006799, 21.225588");


        mImageUrls.add("http://www.dokostola.sk/content/images/p/presov-bazilianky_thumb.jpg?1463230619");
        mNames.add("Kaplnka sv. Makríny (Baziliánky)");
        mCoordinates.add("48.994075, 21.272423");

        mImageUrls.add("http://www.dokostola.sk/content/images/p/po-solivar_thumb.jpg?1455042372");
        mNames.add("Farský kostol Najsvätejšej Trojice (Solivar)");
        mCoordinates.add("49.002234, 21.232797");

        mImageUrls.add("http://www.svatomarianska-put.sk/photos/import/po1/2378_cemjata_full.jpg");
        mNames.add("Kostol sv. Donáta (Cemjata)");
        mCoordinates.add("48.978732, 21.269154");

        mImageUrls.add("http://www.svatomarianska-put.sk/photos/import/po1/2379_presov-salgovik_full.jpg");
        mNames.add("Kostol sv. Františka Xaverského (Šalgovík)");
        mCoordinates.add("48.983558, 21.175571");

        mImageUrls.add("http://www.svatomarianska-put.sk/photos/import/po1/2367_menajezisa_sebastova.jpg");
        mNames.add("Farský kostol Najsvätejšieho Mena Ježiša a Márie (Nižná Šebastová)");
        mCoordinates.add("48.996943, 21.286334");

        mImageUrls.add("https://slovensko84.webnode.sk/_files/200000227-e96feea694/1024px-Presov12Slovakia40.JPG");
        mNames.add("Kaplnka sv. Ondreja na Vydumanci");
        mCoordinates.add("49.020747, 21.281516");






        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = view.findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(view.getContext(),mNames,mImageUrls,mCoordinates);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

}