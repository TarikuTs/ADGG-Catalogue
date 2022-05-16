package org.ilri.adggcatalogue;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

class TopAnimalsAdapter extends RecyclerView.Adapter<TopAnimalsAdapter.ViewHolder>{
    private List<TopAnimals> topAnimals;
    public TopAnimalsAdapter(List<TopAnimals> topAnimals){
        this.topAnimals =topAnimals;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView exoticName;
        public TextView milk;
        public TextView location;
        public TextView gender;
        public ConstraintLayout layout;
        public ImageView Image;

        public ViewHolder (@NonNull View itemView) {
            super(itemView);
            this.exoticName= itemView.findViewById(R.id.ExoticNameTv);
            this.location=itemView.findViewById(R.id.locationTv);
            this.milk=itemView.findViewById(R.id.MilkTv);
            this.gender= itemView.findViewById(R.id.GenderTv);
            this.layout=itemView.findViewById(R.id.recyclerItemsLayout);
            this.Image=itemView.findViewById(R.id.TopAnimalImage);
        }
    }

    @NonNull
    @Override
    public TopAnimalsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.top_animal_items, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TopAnimalsAdapter.ViewHolder holder, int position) {
        String BaseUri="http://45.79.249.127/";
        TopAnimals tpAnimals=topAnimals.get(position);
        holder.exoticName.setText(topAnimals.get(position).getField_exotic_name());
        String locations=topAnimals.get(position).getField_region()+", "+topAnimals.get(position).getField_district();
        holder.location.setText(locations);
        holder.milk.setText(topAnimals.get(position).getField_average_milk());
        holder.gender.setText(topAnimals.get(position).getField_sex());

        Picasso.with(holder.Image.getContext()).load(BaseUri+topAnimals.get(position).getField_picture()).placeholder(R.drawable.topanimalsdefault2);
        Picasso.with(holder.Image.getContext()).load(BaseUri+topAnimals.get(position).getField_picture()).into(holder.Image);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(view.getContext(),TopAnimalsDetailActivity.class);
                intent.putExtra("topanimalsdetailobj",tpAnimals);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return topAnimals.size();
    }
}
