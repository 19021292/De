package com.example.football;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Context;

import java.util.List;

public class AdapterRecycleview extends RecyclerView.Adapter<AdapterRecycleview.ViewHoder> implements View.OnClickListener, View.OnLongClickListener{

    List<KitInfo> kitInfoList;
    Context context;
    private ItemClickListener mItemListener;

    public AdapterRecycleview(List<KitInfo> kitInfoList,ItemClickListener itemClickListener) {
        this.kitInfoList = kitInfoList;
        this.mItemListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_recycleview, parent, false);
        ViewHoder viewHoder = new ViewHoder(view);
        return viewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        KitInfo kitInfo = kitInfoList.get(position);

        holder.tvPrice.setText(kitInfo.getPrice());
        holder.tvName.setText(kitInfo.getName());
        holder.tvSize.setText(kitInfo.getSize());
        holder.img.setImageResource(kitInfo.getBrand());

        holder.itemView.setOnClickListener(v -> {
            mItemListener.onItemClick(kitInfoList.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return kitInfoList.size();
    }

    public interface ItemClickListener {
        void onItemClick(KitInfo details);
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }


    public class ViewHoder extends RecyclerView.ViewHolder{
        TextView tvName, tvSize, tvPrice;
        ImageView img;
        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            tvPrice = itemView.findViewById(R.id.tvPriceRec);
            tvName = itemView.findViewById(R.id.tvNameRec);
            tvSize = itemView.findViewById(R.id.tvSizeRec);
            img = itemView.findViewById(R.id.img);

        }

    }

}
