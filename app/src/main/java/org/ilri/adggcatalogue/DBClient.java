package org.ilri.adggcatalogue;

import android.content.Context;

import androidx.room.Room;

public class DBClient {
    private Context context;
    private static DBClient adggDatabaseInstance;
    private AdggDatabase adggDatabase;

    public DBClient(Context context) {
        this.context = context;
        adggDatabase=buildDb(context);
    }

    public static synchronized DBClient getInstance(Context ctx){

        if (adggDatabaseInstance==null){
            adggDatabaseInstance=new DBClient(ctx);
        }
        return adggDatabaseInstance;
    }

    private static AdggDatabase buildDb(final Context ctx){
        return  Room.databaseBuilder(ctx,AdggDatabase.class,"adgg_app_db").fallbackToDestructiveMigration().build();
    }

    public AdggDatabase getAdggDatabase(){
        return adggDatabase;
    }
}
