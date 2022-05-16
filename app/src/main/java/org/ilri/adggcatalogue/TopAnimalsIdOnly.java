package org.ilri.adggcatalogue;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "topanimals")
public class TopAnimalsIdOnly {
    @PrimaryKey
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
