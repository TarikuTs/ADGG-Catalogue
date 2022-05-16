package org.ilri.adggcatalogue;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "bullsemen")
public class BullSemen implements Serializable {
    @PrimaryKey @NonNull
    private String title;
    private String field_avg_milk;
    private String field_bull_birth_dat;
    private String field_bull_ai_center;
    private String field_bull_dam;
    private String field_bull_daughters;
    private String field_bull_district;
    private String field_bull_ebv;
    private String field_bull_exotic_name;
    private String field_bull_exotic_pc;
    private String field_bull_local_name;
    private String field_bull_local_pc;
    private String field_bull_region;
    private String field_bull_sire;
    private String field_bull_zone;
    private String field_bull_picture;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getField_avg_milk() {
        return field_avg_milk;
    }

    public void setField_avg_milk(String field_avg_milk) {
        this.field_avg_milk = field_avg_milk;
    }

    public String getField_bull_birth_dat() {
        return field_bull_birth_dat;
    }

    public void setField_bull_birth_dat(String field_bull_birth_dat) {
        this.field_bull_birth_dat = field_bull_birth_dat;
    }

    public String getField_bull_ai_center() {
        return field_bull_ai_center;
    }

    public void setField_bull_ai_center(String field_bull_ai_center) {
        this.field_bull_ai_center = field_bull_ai_center;
    }

    public String getField_bull_dam() {
        return field_bull_dam;
    }

    public void setField_bull_dam(String field_bull_dam) {
        this.field_bull_dam = field_bull_dam;
    }

    public String getField_bull_daughters() {
        return field_bull_daughters;
    }

    public void setField_bull_daughters(String field_bull_daughters) {
        this.field_bull_daughters = field_bull_daughters;
    }

    public String getField_bull_district() {
        return field_bull_district;
    }

    public void setField_bull_district(String field_bull_district) {
        this.field_bull_district = field_bull_district;
    }

    public String getField_bull_ebv() {
        return field_bull_ebv;
    }

    public void setField_bull_ebv(String field_bull_ebv) {
        this.field_bull_ebv = field_bull_ebv;
    }

    public String getField_bull_exotic_name() {
        return field_bull_exotic_name;
    }

    public void setField_bull_exotic_name(String field_bull_exotic_name) {
        this.field_bull_exotic_name = field_bull_exotic_name;
    }

    public String getField_bull_exotic_pc() {
        return field_bull_exotic_pc;
    }

    public void setField_bull_exotic_pc(String field_bull_exotic_pc) {
        this.field_bull_exotic_pc = field_bull_exotic_pc;
    }

    public String getField_bull_local_name() {
        return field_bull_local_name;
    }

    public void setField_bull_local_name(String field_bull_local_name) {
        this.field_bull_local_name = field_bull_local_name;
    }

    public String getField_bull_local_pc() {
        return field_bull_local_pc;
    }

    public void setField_bull_local_pc(String field_bull_local_pc) {
        this.field_bull_local_pc = field_bull_local_pc;
    }

    public String getField_bull_region() {
        return field_bull_region;
    }

    public void setField_bull_region(String field_bull_region) {
        this.field_bull_region = field_bull_region;
    }

    public String getField_bull_sire() {
        return field_bull_sire;
    }

    public void setField_bull_sire(String field_bull_sire) {
        this.field_bull_sire = field_bull_sire;
    }

    public String getField_bull_zone() {
        return field_bull_zone;
    }

    public void setField_bull_zone(String field_bull_zone) {
        this.field_bull_zone = field_bull_zone;
    }

    public String getField_bull_picture() {
        return field_bull_picture;
    }

    public void setField_bull_picture(String field_bull_picture) {
        this.field_bull_picture = field_bull_picture;
    }
}
