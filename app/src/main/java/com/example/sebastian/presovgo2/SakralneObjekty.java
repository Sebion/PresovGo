package com.example.sebastian.presovgo2;

import android.os.AsyncTask;


public class FetchData extends AsyncTask<Void,Void,Void> {
    String data;

    @Override
    protected void doInBakcground(Void... voids) {
       try {
           URL url = new URL("https://egov.presov.sk/GeoDataKatalog/sakralne_objekty.json");
           HttpURLConnection httpURLConnection = url.openConnection();
           InputStream inputStream = httpURLConnection.getInputStream();
           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
           String line = "";

           while(line != null) {
               line = bufferedReader.readLine();
               data = data + line;
           }

       } catch (MalFormedURLException e) {
           e.printStackTrace();
       } catch (IOException e){
           e.printStackTrace();
       }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid){
        super.onPostExecute(aVoid);
    }

}

