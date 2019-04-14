package com.example.sebastian.presovgo2;

import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.google.android.gms.maps.model.LatLng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class SakralneObjekty  {

    private ArrayList<Pamiatka> pamiatky =new ArrayList<>();



    public SakralneObjekty() {
        this.pamiatky = setData();
    }


    private ArrayList<Pamiatka> setData(){
        pamiatky.add(new Pamiatka(
                "Konkatedrála sv. Mikuláša",
                "http://www.svestav.sk/wp-content/uploads/2016/01/pre%C5%A1ov-kostol.jpg",
                "48.998058, 21.239890"));
        pamiatky.add(new Pamiatka(
                "Evanjelický a.v. chrám Svätej Trojice",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d2/Town_Presov_Slovakia_0862.jpg/270px-Town_Presov_Slovakia_0862.jpg",
                "48.998492, 21.239862"));

        pamiatky.add(new Pamiatka(
                "Katedrála sv. Jána Krstiteľa",
                "https://www.abu.sk/gallery/katedrala/priecelie-katedraly_n.jpg",
                "48.994157, 21.242976"));

        pamiatky.add(new Pamiatka(
                "Katedrálny chrám sv. Alexandra Nevského",
                "http://www.vypadni.sk/App_Blobs/Images/Upload/00000885.jpg",
                "48.989799, 21.244289"));

        pamiatky.add(new Pamiatka(
                "Ortodoxná synagóga",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/Presov12Slovakia145.JPG/270px-Presov12Slovakia145.JPG",
                "49.000021, 21.237849"));

        pamiatky.add(new Pamiatka(
                "Kaplnka sv. Ignáca (Jezuiti)",
                "http://duchovne-cvicenia.jezuiti.sk/images/presov.jpg",
                "48.989448, 21.227343"));

        pamiatky.add(new Pamiatka(
                "Kostol Svätého Kríža (Kalvária)",
                "https://i.pinimg.com/originals/74/ff/49/74ff49a33c48a94f633679c4de0da231.jpg",
                "48.988057, 21.225881"));

        pamiatky.add(new Pamiatka(
                "Kostol narodenia sv. Jána Krstiteľa (Soľná Baňa)",
                "http://solivar.fara.sk/useruploads/images/farnost/bana.jpg",
                "48.979994, 21.276552"));

        pamiatky.add(new Pamiatka(
                "Kostol sv. Jozefa (Františkáni)",
                "http://omestach.sk/po/foto/hpim0364maxi.jpg",
                "48.996245, 21.243839"));

        pamiatky.add(new Pamiatka(
                "Farský kostol Kráľovnej pokoja (Sídlisko III)",
                "http://farskyurad.sk/uploads/thumb_45-afbadf2157.jpg",
                "8.998492, 21.239862"));

        pamiatky.add(new Pamiatka(
                "Farský kostol Krista Kráľa (Sekčov)",
                "http://farskyurad.sk/uploads/thumb_52-743993f436.jpg",
                "49.006799, 21.225588"));

        pamiatky.add(new Pamiatka(
                "Kaplnka sv. Makríny (Baziliánky)",
                "http://www.dokostola.sk/content/images/p/presov-bazilianky_thumb.jpg?1463230619",
                "48.994075, 21.272423"));

        pamiatky.add(new Pamiatka(
                "Farský kostol Najsvätejšej Trojice (Solivar)",
                "http://www.dokostola.sk/content/images/p/po-solivar_thumb.jpg?1455042372",
                "49.002234, 21.232797"));

        pamiatky.add(new Pamiatka(
                "Kostol sv. Donáta (Cemjata)",
                "http://www.svatomarianska-put.sk/photos/import/po1/2378_cemjata_full.jpg",
                "48.978732, 21.269154"));

        pamiatky.add(new Pamiatka(
                "Kostol sv. Františka Xaverského (Šalgovík)",
                "http://www.svatomarianska-put.sk/photos/import/po1/2379_presov-salgovik_full.jpg",
                "48.983558, 21.175571"));

        pamiatky.add(new Pamiatka(
                "Farský kostol Najsvätejšieho Mena Ježiša a Márie (Nižná Šebastová)",
                "http://www.svatomarianska-put.sk/photos/import/po1/2367_menajezisa_sebastova.jpg",
                "48.996943, 21.286334"));

        pamiatky.add(new Pamiatka(
                "Kaplnka sv. Ondreja na Vydumanci",
                "https://slovensko84.webnode.sk/_files/200000227-e96feea694/1024px-Presov12Slovakia40.JPG",
                "49.020747, 21.281516"));
        return pamiatky;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)

    public ArrayList<String> getNames() {
        ArrayList<String> names = new ArrayList<>();
        pamiatky.forEach((n) -> names.add(n.getName()));


        return names;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)

    public ArrayList<String> getImgUrl() {
        ArrayList<String> urls = new ArrayList<>();
        pamiatky.forEach((n) -> urls.add(n.getImageUrl()));


        return urls;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)

    public ArrayList<String> getCoordinates() {
        ArrayList<String> coor = new ArrayList<>();
        pamiatky.forEach((n) -> coor.add(n.getCoordinates()));


        return coor;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)

    public ArrayList<LatLng> getLatLng(){
        ArrayList<LatLng> latLngs=new ArrayList<>();
        String [] pomoc;

        for (int i = 0; i < getCoordinates().size(); i++) {
            pomoc=getCoordinates().get(i).split(",");
            latLngs.add(new LatLng(Double.parseDouble(pomoc[0]), Double.parseDouble(pomoc[1])));
        }


        return latLngs;
    }
    public double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1))
                * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1))
                * Math.cos(deg2rad(lat2))
                * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515/ 0.62137;
        return (Math.round(dist*100.0)/100.0);
    }
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
//    @Override
//    protected Void doInBackground(Void... voids) {
//        try {
//            URL url = new URL("https://egov.presov.sk/GeoDataKatalog/sakralne_objekty.json");
//            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//            InputStream inputStream = httpURLConnection.getInputStream();
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//            String line = "";
//
//            while(line != null) {
//                line = bufferedReader.readLine();
//                data = data + line;
//            }
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    @Override
//    protected void onPostExecute(Void aVoid){
//        super.onPostExecute(aVoid);
//    }


}
