package org.ilri.adggcatalogue;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BullSemenDao {
    @Query("SELECT * from bullsemen")
    List<BullSemen> getAll();

    @Insert
    Void Insert(BullSemen bullSemen);

    @Delete
    void delete(BullSemen bullSemen);

    @Query("DELETE FROM bullsemen")
    void deleteAll();

    @Update
    void update(BullSemen bullSemen);
}
