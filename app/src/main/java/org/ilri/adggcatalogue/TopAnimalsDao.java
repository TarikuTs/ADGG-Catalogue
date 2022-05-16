package org.ilri.adggcatalogue;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TopAnimalsDao {

    @Query("SELECT * from TopAnimals")
    List<TopAnimals> getAll();

    @Insert
    Void Insert(TopAnimals topAnimals);

    @Delete
    void delete(TopAnimals topAnimals);

    @Query("DELETE FROM TopAnimals")
    void deleteAll();

    @Update
    void update(TopAnimals topAnimals);

}
