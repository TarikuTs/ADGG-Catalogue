package org.ilri.adggcatalogue;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {TopAnimals.class,BullSemen.class},version = 18,exportSchema = false)

public abstract class AdggDatabase extends RoomDatabase {

    public abstract TopAnimalsDao topAnimalsDao();
    public abstract BullSemenDao bullSemenDao();





}
