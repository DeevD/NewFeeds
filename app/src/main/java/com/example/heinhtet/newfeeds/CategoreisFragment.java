package com.example.heinhtet.newfeeds;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by heinhtet on 2/19/17.
 */
public class CategoreisFragment extends Fragment {

    ArrayList<Categories> categoriesList ;

    RecyclerView categoreisRecycler;
    CategoriesAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View categories = inflater.inflate(R.layout.categories_layout,container,false);
        categoriesList = new ArrayList<>();
        categoriesList.add(new Categories("G","Google အတြက္သတင္းစာမ်က္ႏွာ") );
        categoriesList.add(new Categories("M","MTV အတြက္သတင္းစာမ်က္ႏွာ") );
        categoriesList.add(new Categories("D","Daily Mail အတြက္သတင္းစာမ်က္ႏွာ") );
        categoriesList.add(new Categories("C","CCN အတြက္သတင္းစာမ်က္ႏွာ") );


        categoreisRecycler = (RecyclerView)categories.findViewById(R.id.categories_recycler);
        adapter = new CategoriesAdapter(getActivity(),categoriesList);
        categoreisRecycler.setHasFixedSize(true);
        categoreisRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        categoreisRecycler.setAdapter(adapter);









        return categories;
    }
}
