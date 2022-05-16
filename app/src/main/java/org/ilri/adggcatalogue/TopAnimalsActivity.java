package org.ilri.adggcatalogue;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TopAnimalsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_animals);
        Toolbar toolbar = findViewById(R.id.topanimaltoolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        GetTopAnimalsFromDb getTopAnimalsFromDb = new GetTopAnimalsFromDb(this);
        getTopAnimalsFromDb.execute();


    }

    static class GetTopAnimalsFromDb extends AsyncTask<Void,Void,Void> {
        List<TopAnimals> topAnimalsFromDb;

        Context ctx;
        public GetTopAnimalsFromDb(Context context){
            this.ctx=context;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            topAnimalsFromDb=DBClient.getInstance(ctx).getAdggDatabase().topAnimalsDao().getAll();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            TopAnimalsActivity activity=new TopAnimalsActivity();
            RecyclerView recyclerView =  ((Activity)ctx).findViewById(R.id.topAnimalsRecycler);
            TopAnimalsAdapter adapter = new TopAnimalsAdapter(topAnimalsFromDb);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(ctx));
            recyclerView.setAdapter(adapter);
        }
    }
}