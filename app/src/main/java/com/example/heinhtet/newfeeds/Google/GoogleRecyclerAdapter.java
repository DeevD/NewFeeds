package com.example.heinhtet.newfeeds.Google;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.heinhtet.newfeeds.R;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by heinhtet on 2/18/17.
 */

public class GoogleRecyclerAdapter extends RecyclerView.Adapter<GoogleRecyclerAdapter.MyViewHolder> implements Filterable {
    List<Google> googleList = new ArrayList<>();
    Context mContext;
    List<Google> filterList ;


    public GoogleRecyclerAdapter(Context context, List<Google> googles) {
        this.mContext =context;
        this.googleList = googles;
        filterList = googles;

    }
    @Override
    public Filter getFilter() {
        return new FilterClass(this,filterList);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View googleView = LayoutInflater.from(mContext).inflate(R.layout.list_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(googleView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Google google = googleList.get(position);
        holder.title.setText(google.getmTitle());
        Picasso.with(mContext).load(google.getmImageUrl()).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return googleList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title , des;
        ImageView iv;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.load_title);
            iv = (ImageView)itemView.findViewById(R.id.image_load_IV);

            onClickItemView();


        }

        private void onClickItemView() {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent detail = new Intent(mContext,DetailTap.class);
                    detail.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    Bundle bundle = new Bundle();
                    detail.putExtra("item", (Serializable) googleList.get(getAdapterPosition()));
                    mContext.getApplicationContext().startActivity(detail);
                }
            });
        }
    }
}
