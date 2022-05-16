package org.ilri.adggcatalogue;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity (tableName = "topanimals")
public class TopAnimals implements Serializable {
    @PrimaryKey @NonNull
    private String title;
    private String field_average_milk;
    private String field_birth_date;
    private String field_dam;
    private String field_daughters;
    private String field_district;
    private String field_ebv;
    private String field_exotic_name;
    private String field_exotic_pc;
    private String field_farmer_mobile;
    private String field_farmer_name;
    private String field_local_name;
    private String field_local_pc;
    private String field_picture;
    private String field_region;
    private String field_sex;
    private String field_sire;
    private String field_zone;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getField_average_milk() {
        return field_average_milk;
    }

    public void setField_average_milk(String field_average_milk) {
        this.field_average_milk = field_average_milk;
    }

    public String getField_birth_date() {
        return field_birth_date;
    }

    public void setField_birth_date(String field_birth_date) {
        this.field_birth_date = field_birth_date;
    }

    public String getField_dam() {
        return field_dam;
    }

    public void setField_dam(String field_dam) {
        this.field_dam = field_dam;
    }

    public String getField_daughters() {
        return field_daughters;
    }

    public void setField_daughters(String field_daughters) {
        this.field_daughters = field_daughters;
    }

    public String getField_district() {
        return field_district;
    }

    public void setField_district(String field_district) {
        this.field_district = field_district;
    }

    public String getField_ebv() {
        return field_ebv;
    }

    public void setField_ebv(String field_ebv) {
        this.field_ebv = field_ebv;
    }

    public String getField_exotic_name() {
        return field_exotic_name;
    }

    public void setField_exotic_name(String field_exotic_name) {
        this.field_exotic_name = field_exotic_name;
    }

    public String getField_exotic_pc() {
        return field_exotic_pc;
    }

    public void setField_exotic_pc(String field_exotic_pc) {
        this.field_exotic_pc = field_exotic_pc;
    }

    public String getField_farmer_mobile() {
        return field_farmer_mobile;
    }

    public void setField_farmer_mobile(String field_farmer_mobile) {
        this.field_farmer_mobile = field_farmer_mobile;
    }

    public String getField_farmer_name() {
        return field_farmer_name;
    }

    public void setField_farmer_name(String field_farmer_name) {
        this.field_farmer_name = field_farmer_name;
    }

    public String getField_local_name() {
        return field_local_name;
    }

    public void setField_local_name(String field_local_name) {
        this.field_local_name = field_local_name;
    }

    public String getField_local_pc() {
        return field_local_pc;
    }

    public void setField_local_pc(String field_local_pc) {
        this.field_local_pc = field_local_pc;
    }

    public String getField_picture() {
        return field_picture;
    }

    public void setField_picture(String field_picture) {
        this.field_picture = field_picture;
    }

    public String getField_region() {
        return field_region;
    }

    public void setField_region(String field_region) {
        this.field_region = field_region;
    }

    public String getField_sex() {
        return field_sex;
    }

    public void setField_sex(String field_sex) {
        this.field_sex = field_sex;
    }

    public String getField_sire() {
        return field_sire;
    }

    public void setField_sire(String field_sire) {
        this.field_sire = field_sire;
    }

    public String getField_zone() {
        return field_zone;
    }

    public void setField_zone(String field_zone) {
        this.field_zone = field_zone;
    }
}
