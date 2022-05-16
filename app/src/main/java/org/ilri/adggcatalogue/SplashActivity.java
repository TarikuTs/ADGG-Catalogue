package org.ilri.adggcatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_DURATION=2000;
    static Boolean isConnected=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ProgressBar progressBar= findViewById(R.id.splashprogress);
        Button retryButton= findViewById(R.id.retryBtn);
        TextView checkConnection= findViewById(R.id.checkconnectionTv);

        prepareDownload();
        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prepareDownload();
            }
        });
    }


     public void prepareDownload() {
         ProgressBar pgBar= findViewById(R.id.splashprogress);
         Button retryButton= findViewById(R.id.retryBtn);
         TextView checkConnection= findViewById(R.id.checkconnectionTv);

         pgBar.setVisibility(View.VISIBLE);
         retryButton.setVisibility(View.INVISIBLE);
         checkConnection.setVisibility(View.INVISIBLE);


        checkForInternet checkforInternet =new checkForInternet(this);
        checkforInternet.execute();
    }

    static class checkForInternet extends AsyncTask<Void,Void,Void> {
        WeakReference<Context> contextWeakReference;
        Context ctx;
        List<TopAnimals> tpAnimalsFromDb;
        List<BullSemen> bullSemenFromDb;
        int totalTopAnimalsFromAPI;


        public checkForInternet(Context context){
            contextWeakReference= new WeakReference<Context>(context);
            ctx=context;
        }
        @Override
        protected Void doInBackground(Void... voids) {

            tpAnimalsFromDb=DBClient.getInstance(ctx).getAdggDatabase().topAnimalsDao().getAll();
            bullSemenFromDb=DBClient.getInstance(ctx).getAdggDatabase().bullSemenDao().getAll();


            try {
                try (Socket soc = new Socket()) {
                    soc.connect(new InetSocketAddress("45.79.249.127", 80), 10000);
                }
                isConnected= true;
            } catch (IOException ex) {
                isConnected =false;
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


            SplashActivity activity=new SplashActivity();
            ProgressBar pgBar= ((Activity)ctx).findViewById(R.id.splashprogress);
            Button retryButton= ((Activity)ctx).findViewById(R.id.retryBtn);
            TextView checkConnection= ((Activity)ctx).findViewById(R.id.checkconnectionTv);



            if (activity == null || activity.isFinishing()) return;

            if (isConnected){
                pgBar.setVisibility(View.INVISIBLE);
                retryButton.setVisibility(View.INVISIBLE);
                checkConnection.setVisibility(View.INVISIBLE);
                Log.d("TAG", "connected");
                downloadContent(ctx,tpAnimalsFromDb,bullSemenFromDb);

            }
            else{
                if(tpAnimalsFromDb.size()>0){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(ctx,MainActivity.class);
                            ctx.startActivity(intent);
                            ;
                        }
                    },SPLASH_DURATION);
                    return;
                }
                pgBar.setVisibility(View.INVISIBLE);
                retryButton.setVisibility(View.VISIBLE);
                checkConnection.setVisibility(View.VISIBLE);


            }
        }
    }
     public static void downloadContent(final Context ctx, List<TopAnimals> tpAnimalsFromDb,List<BullSemen> bullsemenfromdb){
        SplashActivity activity=new SplashActivity();
         List<TopAnimals> topAnimalsList= new ArrayList<>();
         List<BullSemen> bullSemenList=new ArrayList<>();

         ProgressBar pgBar= ((Activity)ctx).findViewById(R.id.splashprogress);
         Button retryButton= ((Activity)ctx).findViewById(R.id.retryBtn);
         TextView checkConnection= ((Activity)ctx).findViewById(R.id.checkconnectionTv);
            if (isConnected){
                RetroInterface service = RetroClientInstance.getRetrofitInstance().create(RetroInterface.class);
                final Call<List<TopAnimals>> topAnimalsCall = service.getTopAnimals();
                final Call<List<BullSemen>> bullSemenCall = service.getBullSemen();


                topAnimalsCall.enqueue(new Callback<List<TopAnimals>>() {
                    @Override
                    public void onResponse(Call<List<TopAnimals>> call, Response<List<TopAnimals>> response) {
                            if(response.body()==null){
                                pgBar.setVisibility(View.INVISIBLE);
                                retryButton.setVisibility(View.VISIBLE);
                                checkConnection.setVisibility(View.VISIBLE);
                                return;
                            }
                            for (int i=0;i<response.body().size();i++){
                                TopAnimals topanim= new TopAnimals();
                                topanim.setField_average_milk(response.body().get(i).getField_average_milk());
                                topanim.setField_birth_date(response.body().get(i).getField_birth_date());
                                topanim.setField_dam(response.body().get(i).getField_dam());
                                topanim.setField_daughters(response.body().get(i).getField_daughters());
                                topanim.setField_district(response.body().get(i).getField_district());
                                topanim.setField_ebv(response.body().get(i).getField_ebv());
                                topanim.setField_exotic_name(response.body().get(i).getField_exotic_name());
                                topanim.setField_exotic_pc(response.body().get(i).getField_exotic_pc());
                                topanim.setField_farmer_mobile(response.body().get(i).getField_farmer_mobile());
                                topanim.setField_farmer_name(response.body().get(i).getField_farmer_name());
                                topanim.setField_local_name(response.body().get(i).getField_local_name());
                                topanim.setField_picture(response.body().get(i).getField_picture());
                                topanim.setTitle(response.body().get(i).getTitle());
                                topanim.setField_sire(response.body().get(i).getField_sire());
                                topanim.setField_local_pc(response.body().get(i).getField_local_pc());
                                topanim.setField_sex(response.body().get(i).getField_sex());
                                topanim.setField_zone(response.body().get(i).getField_zone());
                                topanim.setField_region(response.body().get(i).getField_region());
                                topAnimalsList.add(topanim);
                            }
                        bullSemenCall.enqueue(new Callback<List<BullSemen>>() {
                            @Override
                            public void onResponse(Call<List<BullSemen>> call, Response<List<BullSemen>> response) {
                                for (int i=0;i<response.body().size();i++){
                                    BullSemen bullsmn= new BullSemen();
                                    bullsmn.setField_avg_milk(response.body().get(i).getField_avg_milk());
                                    bullsmn.setField_bull_birth_dat(response.body().get(i).getField_bull_birth_dat());
                                    bullsmn.setField_bull_dam(response.body().get(i).getField_bull_dam());
                                    bullsmn.setField_bull_daughters(response.body().get(i).getField_bull_daughters());
                                    bullsmn.setField_bull_district(response.body().get(i).getField_bull_district());
                                    bullsmn.setField_bull_ebv(response.body().get(i).getField_bull_ebv());
                                    bullsmn.setField_bull_exotic_name(response.body().get(i).getField_bull_exotic_name());
                                    bullsmn.setField_bull_exotic_pc(response.body().get(i).getField_bull_exotic_pc());
                                    bullsmn.setField_bull_local_name(response.body().get(i).getField_bull_local_name());
                                    bullsmn.setField_bull_picture(response.body().get(i).getField_bull_picture());
                                    bullsmn.setTitle(response.body().get(i).getTitle());
                                    bullsmn.setField_bull_sire(response.body().get(i).getField_bull_sire());
                                    bullsmn.setField_bull_local_pc(response.body().get(i).getField_bull_local_pc());
                                    bullsmn.setField_bull_zone(response.body().get(i).getField_bull_zone());
                                    bullsmn.setField_bull_region(response.body().get(i).getField_bull_region());
                                    bullsmn.setField_bull_ai_center(response.body().get(i).getField_bull_ai_center());

                                    bullSemenList.add(bullsmn);

                                }
                                saveResources(ctx,topAnimalsList,tpAnimalsFromDb,bullSemenList,bullsemenfromdb);
                            }

                            @Override
                            public void onFailure(Call<List<BullSemen>> call, Throwable t) {

                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<List<TopAnimals>> call, Throwable t) {

                    }
                });


            }
            else{
                pgBar.setVisibility(View.INVISIBLE);
                retryButton.setVisibility(View.VISIBLE);
                checkConnection.setVisibility(View.VISIBLE);
            }
    }
    private static  void saveResources(final Context ctx, final List<TopAnimals> topAnimalsList, List<TopAnimals> tpAnimalsFromDb,List<BullSemen> bullSemenList,List<BullSemen> bullsemenfromdb){



        class saveResources extends AsyncTask<Void,Void,Void>{

            boolean noUpdate=false;
            @Override
            protected Void doInBackground(Void... voids) {
//                List<TopAnimals> TopAnimlasAdditionals=new ArrayList<>();
//                List<BullSemen> BullSemenAdditionals=new ArrayList<>();
//                int startingPoint=0;
                DBClient.getInstance(ctx).getAdggDatabase().topAnimalsDao().deleteAll();
                for(int i=0;i<topAnimalsList.size();i++){
                  DBClient.getInstance(ctx).getAdggDatabase().topAnimalsDao().Insert(topAnimalsList.get(i));
              }

                DBClient.getInstance(ctx).getAdggDatabase().bullSemenDao().deleteAll();
                for(int j=0;j<bullSemenList.size();j++){
                        DBClient.getInstance(ctx).getAdggDatabase().bullSemenDao().Insert(bullSemenList.get(j));
              }

//                if((tpAnimalsFromDb!=null && tpAnimalsFromDb.size()!=0) && (bullsemenfromdb!=null && bullsemenfromdb.size()!=0)){
//
//                    //checking if there is new data from api, topAnimals
//                    if(tpAnimalsFromDb.size() < topAnimalsList.size()){
//                        startingPoint=(topAnimalsList.size()-tpAnimalsFromDb.size());
//                        for(int i=startingPoint;i<topAnimalsList.size();i++){
//                            TopAnimals temp= new TopAnimals();
//                            temp.setField_average_milk(topAnimalsList.get(i).getField_average_milk());
//                            temp.setField_birth_date(topAnimalsList.get(i).getField_birth_date());
//                            temp.setField_dam(topAnimalsList.get(i).getField_dam());
//                            temp.setField_daughters(topAnimalsList.get(i).getField_daughters());
//                            temp.setField_district(topAnimalsList.get(i).getField_district());
//                            temp.setField_ebv(topAnimalsList.get(i).getField_ebv());
//                            temp.setField_exotic_name(topAnimalsList.get(i).getField_exotic_name());
//                            temp.setField_exotic_pc(topAnimalsList.get(i).getField_exotic_pc());
//                            temp.setField_farmer_mobile(topAnimalsList.get(i).getField_farmer_mobile());
//                            temp.setField_farmer_name(topAnimalsList.get(i).getField_farmer_name());
//                            temp.setField_local_name(topAnimalsList.get(i).getField_local_name());
//                            temp.setField_picture(topAnimalsList.get(i).getField_picture());
//                            temp.setTitle(topAnimalsList.get(i).getTitle());
//                            temp.setField_sire(topAnimalsList.get(i).getField_sire());
//                            temp.setField_local_pc(topAnimalsList.get(i).getField_local_pc());
//                            temp.setField_sex(topAnimalsList.get(i).getField_sex());
//                            temp.setField_zone(topAnimalsList.get(i).getField_zone());
//                            temp.setField_region(topAnimalsList.get(i).getField_region());
//                            TopAnimlasAdditionals.add(temp);
//                        }
//                        for(int i=0;i<TopAnimlasAdditionals.size();i++){
//                            DBClient.getInstance(ctx).getAdggDatabase().topAnimalsDao().Insert(TopAnimlasAdditionals.get(i));
//                        }
//                    }
//
//                    //checking if there is new data from api, bullsemen
//                    if(bullsemenfromdb.size() < bullSemenList.size()){
//                        startingPoint=(bullSemenList.size()-bullsemenfromdb.size());
//                        for(int i=startingPoint;i<bullSemenList.size();i++){
//                            BullSemen bullsmn= new BullSemen();
//                            bullsmn.setField_avg_milk(bullSemenList.get(i).getField_avg_milk());
//                            bullsmn.setField_bull_birth_dat(bullSemenList.get(i).getField_bull_birth_dat());
//                            bullsmn.setField_bull_dam(bullSemenList.get(i).getField_bull_dam());
//                            bullsmn.setField_bull_daughters(bullSemenList.get(i).getField_bull_daughters());
//                            bullsmn.setField_bull_district(bullSemenList.get(i).getField_bull_district());
//                            bullsmn.setField_bull_ebv(bullSemenList.get(i).getField_bull_ebv());
//                            bullsmn.setField_bull_exotic_name(bullSemenList.get(i).getField_bull_exotic_name());
//                            bullsmn.setField_bull_exotic_pc(bullSemenList.get(i).getField_bull_exotic_pc());
//                            bullsmn.setField_bull_local_name(bullSemenList.get(i).getField_bull_local_name());
//                            bullsmn.setField_bull_picture(bullSemenList.get(i).getField_bull_picture());
//                            bullsmn.setTitle(bullSemenList.get(i).getTitle());
//                            bullsmn.setField_bull_sire(bullSemenList.get(i).getField_bull_sire());
//                            bullsmn.setField_bull_local_pc(bullSemenList.get(i).getField_bull_local_pc());
//                            bullsmn.setField_bull_zone(bullSemenList.get(i).getField_bull_zone());
//                            bullsmn.setField_bull_region(bullSemenList.get(i).getField_bull_region());
//                            bullsmn.setField_bull_ai_center(bullSemenList.get(i).getField_bull_ai_center());
//                            BullSemenAdditionals.add(bullsmn);
//                        }
//                        for(int i=0;i<BullSemenAdditionals.size();i++){
//                            DBClient.getInstance(ctx).getAdggDatabase().bullSemenDao().Insert(BullSemenAdditionals.get(i));
//                        }
//                    }
//
//                }
//                else{
//                    if(topAnimalsList!=null & topAnimalsList.size()!=0){
//                        for(int i=0;i<topAnimalsList.size();i++){
//                            DBClient.getInstance(ctx).getAdggDatabase().topAnimalsDao().Insert(topAnimalsList.get(i));
//                        }
//                    }
//
//                    if(bullSemenList!=null && bullSemenList.size()!=0){
//                        for(int i=0;i<bullSemenList.size();i++){
//                            DBClient.getInstance(ctx).getAdggDatabase().bullSemenDao().Insert(bullSemenList.get(i));
//                        }
//                    }
//
//                }
                return null;
            }
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(ctx,MainActivity.class);
                        ctx.startActivity(intent);
                    }
                },SPLASH_DURATION);



            }
        }

        saveResources svResources=new saveResources();
        svResources.execute();

    }
}