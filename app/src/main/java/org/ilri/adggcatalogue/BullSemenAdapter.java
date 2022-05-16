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

class BullSemenAdapter extends RecyclerView.Adapter<BullSemenAdapter.ViewHolder> {
    private List<BullSemen> bullSemenList;
    public BullSemenAdapter(List<BullSemen> bullSemenList)
    {
        this.bullSemenList =bullSemenList;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView BullItemTitleTv;
        public TextView BullLocationTv;
        public TextView BullAiTv;
        public ImageView BullImage;
        public ConstraintLayout Bulllayout;

        public ViewHolder (@NonNull View itemView) {
            super(itemView);
            this.BullItemTitleTv= itemView.findViewById(R.id.BullItemTitleTv);
            this.BullLocationTv=itemView.findViewById(R.id.BullLocationTv);
            this.BullAiTv=itemView.findViewById(R.id.BullAiTv);
            this.Bulllayout=itemView.findViewById(R.id.BullItemLayout);
            this.BullImage=itemView.findViewById(R.id.BullImage);
        }
    }
    @NonNull
    @Override
    public BullSemenAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.bull_items, parent, false);
        BullSemenAdapter.ViewHolder viewHolder = new BullSemenAdapter.ViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BullSemenAdapter.ViewHolder holder, int position) {
        String BaseUri="http://45.79.249.127/";
        BullSemen blsemen=bullSemenList.get(position);
        holder.BullItemTitleTv.setText(bullSemenList.get(position).getField_bull_exotic_name());
        String locations=bullSemenList.get(position).getField_bull_region()+", "+bullSemenList.get(position).getField_bull_district();
        holder.BullLocationTv.setText(locations);
        holder.BullAiTv.setText(bullSemenList.get(position).getField_bull_ai_center());

        Picasso.with(holder.BullImage.getContext()).load(BaseUri+bullSemenList.get(position).getField_bull_picture()).into(holder.BullImage);
        Picasso.with(holder.BullImage.getContext()).load(BaseUri+bullSemenList.get(position).getField_bull_picture()).placeholder(R.drawable.bulldefault);
        holder.Bulllayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(view.getContext(),BullDetailActivity.class);
                intent.putExtra("bulldetailobj",blsemen);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bullSemenList.size();
    }
}
