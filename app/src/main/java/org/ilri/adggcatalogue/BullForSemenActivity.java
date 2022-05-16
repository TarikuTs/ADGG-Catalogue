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

public class BullForSemenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bull_for_semen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        GetBullSemenFromDb getBullSemenFromDb=new GetBullSemenFromDb(this);
        getBullSemenFromDb.execute();
    }

    static class GetBullSemenFromDb extends AsyncTask<Void,Void,Void> {
        List<BullSemen> bullSemenFromDb;

        Context ctx;
        public GetBullSemenFromDb(Context context){
            this.ctx=context;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            bullSemenFromDb=DBClient.getInstance(ctx).getAdggDatabase().bullSemenDao().getAll();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            RecyclerView recyclerView =  ((Activity)ctx).findViewById(R.id.BullRecycler);
            BullSemenAdapter adapter = new BullSemenAdapter(bullSemenFromDb);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(ctx));
            recyclerView.setAdapter(adapter);
        }
    }
}