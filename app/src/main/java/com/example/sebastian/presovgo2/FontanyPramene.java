package com.example.sebastian.presovgo2;

import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class FontanyPramene  {
    ArrayList<Pamiatka> fontany=new ArrayList<>();



    public FontanyPramene() {
        this.fontany = setData();
    }





    private ArrayList<Pamiatka> setData(){
        fontany.add(new Pamiatka(
                "Fontána Neptún",
                "https://m.smedata.sk/api-media/media/image/sme/4/32/3229924/3229924_1200x.jpeg?rev=3",
                "48.9972801,21.2406273"));
        fontany.add(new Pamiatka(
                "Fontána Centrál Sídl. II.",
                "http://www.obecbardonovo.sk/portals_pictures/i_005149/i_5149417.jpg",
                "48.998796,21.2244021"));
        fontany.add(new Pamiatka(
                "Fontána Divízia, Nám. legionárov",
                "https://www.odkazprestarostu.sk/image/w1280/public/alerts/55350/images/5b6227eb00fab.jpg",
                "48.992649,21.245111"));
        fontany.add(new Pamiatka(
                "Fontána Nám. mieru",
                "https://mapio.net/images-p/107427244.jpg",
                "49.0016961,21.2396836"));
        fontany.add(new Pamiatka(
                "Fontána Nám. mládeže",
                "https://mapio.net/images-p/51421431.jpg",
                "48.994849,21.230344"));
        fontany.add(new Pamiatka(
                "Fontána Družba",
                "https://s3.amazonaws.com/gs-geo-images/50f2f050-b291-45e8-986e-58d6e2fe9f87.jpg",
                "49.006467, 21.223953"));
        fontany.add(new Pamiatka(
                "Fontána Park Angelinum",
                "https://m.smedata.sk/api-media/media/image/sme/7/15/1588737/1588737_1200x.jpg?rev=1",
                "48.993027,21.272304"));
        fontany.add(new Pamiatka(
                "Fontána NS OPÁL",
                "https://www.odkazprestarostu.sk/image/w1280/public/alerts/31583/images/579b90c0280f1.jpg",
                "48.9867838,21.2656024"));
        fontany.add(new Pamiatka(
                "Fontána Šváby",
                "https://mapio.net/images-p/105665770.jpg",
                "48.9740729,21.2624717"));


        return fontany;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public ArrayList<String> getNames() {
        ArrayList<String> names = new ArrayList<>();
        fontany.forEach((n) -> names.add(n.getName()));


        return names;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)

    public ArrayList<String> getImgUrl() {
        ArrayList<String> urls = new ArrayList<>();
        fontany.forEach((n) -> urls.add(n.getImageUrl()));


        return urls;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)

    public ArrayList<String> getCoordinates() {
        ArrayList<String> coor = new ArrayList<>();
        fontany.forEach((n) -> coor.add(n.getCoordinates()));


        return coor;
    }



//    @Override
//    protected Void doInBackground(Void... voids) {
//        try {
//            URL url = new URL("https://egov.presov.sk/GeoDataKatalog/fontany_pramene.json");
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
//
//
//    }
//
//    @Override
//    protected void onPostExecute(Void aVoid){
//        super.onPostExecute(aVoid);
//    }

}

