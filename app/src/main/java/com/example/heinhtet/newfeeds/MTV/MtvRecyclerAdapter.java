package com.example.heinhtet.newfeeds.MTV;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.heinhtet.newfeeds.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heinhtet on 2/21/17.
 */
public class MtvRecyclerAdapter extends RecyclerView.Adapter<MtvRecyclerAdapter.ViewHolder> {
    Context con;
    List<MTV> mtvList = new ArrayList<>();

    public MtvRecyclerAdapter(Context context, List<MTV> mtvs) {
        this.con = context;
        this.mtvList = mtvs;

    }

    @Override
    public MtvRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mtvView = LayoutInflater.from(con).inflate(R.layout.list_layout,parent,false);
        ViewHolder view = new ViewHolder(mtvView);
        return view;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MTV mtv = mtvList.get(position);
        holder.title.setText(mtv.getmTitle());
        Picasso.with(con).load(mtv.getmImageUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mtvList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.load_title);
            image = (ImageView)itemView.findViewById(R.id.image_load_IV);
        }
    }
}
