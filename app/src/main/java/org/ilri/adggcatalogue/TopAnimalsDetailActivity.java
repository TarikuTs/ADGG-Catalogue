package org.ilri.adggcatalogue;

import android.os.Bundle;

import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.ImageView;
import android.widget.TextView;

public class TopAnimalsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_animals_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String BaseUri="http://45.79.249.127/";

        TextView Title=findViewById(R.id.TopAnimalID);
        TextView BirthDate=findViewById(R.id.TopBirthDateTv);
        TextView Sex=findViewById(R.id.TopSexTv);
        TextView Sire=findViewById(R.id.TopSireTv);
        TextView Dam=findViewById(R.id.TopDamTv);
        TextView Ebv=findViewById(R.id.TopEBVTv);
        TextView Daughters=findViewById(R.id.TopDaughtersTv);
        TextView Milk=findViewById(R.id.TopMilkTv);
        TextView Exotic=findViewById(R.id.TopExoticNameTv);
        TextView Local=findViewById(R.id.TopLocalTv);
        TextView ExoticPc=findViewById(R.id.TopExoticPcTv);
        TextView LocalPc=findViewById(R.id.TopLocalPcTv);
        TextView Region=findViewById(R.id.TopRegionTv);
        TextView Zone=findViewById(R.id.TopZoneTv);
        TextView District=findViewById(R.id.TopDistrictTv);
        TextView Farmer=findViewById(R.id.TopFarmerTv);
        TextView Mobile=findViewById(R.id.TopMobileTv);
        ImageView picture=findViewById(R.id.topAnimalDetailImg);

        TopAnimals topAnimals=(TopAnimals)getIntent().getSerializableExtra("topanimalsdetailobj");
         Title.setText(topAnimals.getTitle());
         BirthDate.setText(topAnimals.getField_birth_date());
         Sex.setText(topAnimals.getField_sex());
         Sire.setText(topAnimals.getField_sire());
         Dam.setText(topAnimals.getField_dam());
         Ebv.setText(topAnimals.getField_ebv());
         Daughters.setText(topAnimals.getField_daughters());
         Milk.setText(topAnimals.getField_average_milk());
         Exotic.setText(topAnimals.getField_exotic_name());
         Local.setText(topAnimals.getField_local_name());
         ExoticPc.setText(topAnimals.getField_exotic_pc());
         LocalPc.setText(topAnimals.getField_local_pc());
         Region.setText(topAnimals.getField_region());
         Zone.setText(topAnimals.getField_zone());
         District.setText(topAnimals.getField_district());
         Farmer.setText(topAnimals.getField_farmer_name());
         Mobile.setText(topAnimals.getField_farmer_mobile());

        Picasso.with(getApplicationContext()).load(BaseUri+topAnimals.getField_picture()).placeholder(R.drawable.topanimalsdefault2).into(picture);

    }
}