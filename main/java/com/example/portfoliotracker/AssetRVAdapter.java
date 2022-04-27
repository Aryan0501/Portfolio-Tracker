package com.example.portfoliotracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AssetRVAdapter extends RecyclerView.Adapter<AssetRVAdapter.ViewHolder>{

    // variable for our array list and context
    private ArrayList<AssetModel> assetModelArrayList;
    private Context context;

    // constructor
    public AssetRVAdapter(ArrayList<AssetModel> assetModelArrayList, Context context) {
        this.assetModelArrayList = assetModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.asset_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        AssetModel model = assetModelArrayList.get(position);
        holder.cryptoNameTV.setText(model.getCryptoName());
        holder.cryptoPriceTV.setText(String.valueOf(model.getCryptoPrice()));
        holder.cryptoQuantityTV.setText(String.valueOf(model.getQuantity()));
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return assetModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView cryptoNameTV, cryptoPriceTV, cryptoQuantityTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            cryptoNameTV = itemView.findViewById(R.id.cryptoName);
            cryptoPriceTV = itemView.findViewById(R.id.cryptoPrice);
            cryptoQuantityTV = itemView.findViewById(R.id.cryptoQuantity);
        }
    }

}
