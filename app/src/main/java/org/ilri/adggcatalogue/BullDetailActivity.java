package org.ilri.adggcatalogue;

import android.os.Bundle;

import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.ImageView;
import android.widget.TextView;

public class BullDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bull_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String BaseUri="http://45.79.249.127/";

        TextView Title=findViewById(R.id.BullID);
        TextView BirthDate=findViewById(R.id.BullBirthDayTv);
        TextView Sire=findViewById(R.id.BullSireTv);
        TextView Dam=findViewById(R.id.BullDamTv);
        TextView Ebv=findViewById(R.id.BullEBVTv);
        TextView Daughters=findViewById(R.id.BullDaughtersTv);
        TextView Milk=findViewById(R.id.BullMilkTv);
        TextView Exotic=findViewById(R.id.BullExoticNameTv);
        TextView Local=findViewById(R.id.BullLocalTv);
        TextView ExoticPc=findViewById(R.id.BullExoticPcTv);
        TextView LocalPc=findViewById(R.id.BullLocalPcTv);
        TextView Region=findViewById(R.id.BullRegionTv);
        TextView Zone=findViewById(R.id.BullZoneTv);
        TextView District=findViewById(R.id.BullDistrictTv);
        TextView AiCenter=findViewById(R.id.BullDetailAiTv);
        ImageView BullImage = findViewById(R.id.bullDetailImg);


        BullSemen bullSemenDetails=(BullSemen)getIntent().getSerializableExtra("bulldetailobj");

        Title.setText(bullSemenDetails.getTitle());
        BirthDate.setText(bullSemenDetails.getField_bull_birth_dat());
        Sire.setText(bullSemenDetails.getField_bull_sire());
        Dam.setText(bullSemenDetails.getField_bull_dam());
        Ebv.setText(bullSemenDetails.getField_bull_ebv());
        Daughters.setText(bullSemenDetails.getField_bull_daughters());
        Milk.setText(bullSemenDetails.getField_avg_milk());
        Exotic.setText(bullSemenDetails.getField_bull_exotic_name());
        Local.setText(bullSemenDetails.getField_bull_local_name());
        ExoticPc.setText(bullSemenDetails.getField_bull_exotic_pc());
        LocalPc.setText(bullSemenDetails.getField_bull_local_pc());
        Region.setText(bullSemenDetails.getField_bull_region());
        Zone.setText(bullSemenDetails.getField_bull_zone());
        District.setText(bullSemenDetails.getField_bull_district());
        AiCenter.setText(bullSemenDetails.getField_bull_ai_center());
        Picasso.with(getApplicationContext()).load(BaseUri+bullSemenDetails.getField_bull_picture()).into(BullImage);
        Picasso.with(getApplicationContext()).load(BaseUri+bullSemenDetails.getField_bull_picture()).placeholder(R.drawable.bulldefault);
    }
}