package com.example.heinhtet.newfeeds;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.heinhtet.newfeeds.Google.GoogleFragment;
import com.example.heinhtet.newfeeds.MTV.MtvFragment;

import java.util.ArrayList;

/**
 * Created by heinhtet on 2/19/17.
 */

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.MyViewHoler> {
    ArrayList<Categories> data = new ArrayList<>();
    Context mContext ;

    public CategoriesAdapter(Context context, ArrayList<Categories> categoriesList) {
        mContext = context;
        data = categoriesList;


    }

    @Override
    public CategoriesAdapter.MyViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.categoreis_item_list,parent,false);
        MyViewHoler myViewHoler = new MyViewHoler(view);
        return myViewHoler;
    }

    @Override
    public void onBindViewHolder(CategoriesAdapter.MyViewHoler holder, int position) {
        Categories categories = data.get(position);
        holder.keyWord.setText(categories.getMkeyWord());
        holder.des.setText(categories.getDes());
        GradientDrawable magnitudeCircle = (GradientDrawable) holder.keyWord.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getKeyWordColor(categories.getMkeyWord());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


    }

    private int getKeyWordColor(String mkeyWord) {
        int backGroundColor ;
        if (mkeyWord.contains("G")){
            backGroundColor = R.color.magnitude1;
        }
        else if (mkeyWord.contains("M")){
            backGroundColor = R.color.magnitude2;
        }
        else if (mkeyWord.contains("D")){
            backGroundColor = R.color.magnitude3;
        }
        else if (mkeyWord.contains("C")){
            backGroundColor = R.color.magnitude4;
        }
        else {
            backGroundColor = R.color.magnitude5;
        }

        return ContextCompat.getColor(mContext.getApplicationContext(),backGroundColor);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }




    public class MyViewHoler extends RecyclerView.ViewHolder {
        TextView keyWord;
        TextView des;
        public MyViewHoler(View itemView) {
            super(itemView);
            keyWord = (TextView)itemView.findViewById(R.id.key_word);
            des = (TextView)itemView.findViewById(R.id.des_cate);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch ((getAdapterPosition())){
                        case 0:{
                            GoogleFragment goolge= new GoogleFragment();
                            FragmentTransaction manager = ((Activity)mContext).getFragmentManager().beginTransaction().remove(new CategoreisFragment()).replace(R.id.blank_space,goolge);
                            manager.commit();
                            break;
                        }
                        case 1:{
                            MtvFragment mtvFragment = new MtvFragment();
                            FragmentTransaction ft = ((Activity)mContext).getFragmentManager().beginTransaction().remove(new CategoreisFragment()).replace(R.id.blank_space,mtvFragment);
                            ft.commit();
                            break;
                        }
                        case 2:{
                            GoogleFragment goolge= new GoogleFragment();
                            FragmentTransaction manager = ((Activity)mContext).getFragmentManager().beginTransaction().remove(new CategoreisFragment()).replace(R.id.blank_space,goolge);
                            manager.commit();
                            break;
                        }
                        default:{
                            Toast.makeText((Activity)mContext,"Hello",Toast.LENGTH_LONG).show();break;
                        }
                    }

                    //FragmentTransaction f = Adapter.this.getItemId().get
                }
            });


        }
    }
}
