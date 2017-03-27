package com.example.heinhtet.newfeeds.MTV;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.heinhtet.newfeeds.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heinhtet on 2/19/17.
 */
public class MtvFragment extends android.app.Fragment implements android.app.LoaderManager.LoaderCallbacks<List<MTV>> {

    RecyclerView mtvRecyclerView;
    MtvRecyclerAdapter mtvRecyclerAdapter;

    LoaderManager load;
    List<MTV> getData = new ArrayList<>();
    public static final int LOADER_ID_MTV = 1;
    public static final String MTV_LINK= "https://newsapi.org/v1/articles?source=mtv-news&sortBy=top&apiKey=d6a6da0807b542ffbb7357837dee84f1";

    View mtvView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mtvView = inflater.inflate(R.layout.mtv_fragment_view,container,false);
        setHasOptionsMenu(true);

        CheckConnection();


        mtvRecyclerView = (RecyclerView)mtvView.findViewById(R.id.mtv_recycler_list);
        mtvRecyclerAdapter = new MtvRecyclerAdapter(getActivity(),new ArrayList<MTV>());


        mtvRecyclerView.setAdapter(mtvRecyclerAdapter);
        mtvRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        return mtvView;
    }

    private void CheckConnection() {
        ConnectivityManager manager = (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo!=null&&networkInfo.isConnected()){
            load = getLoaderManager();
            load.initLoader(LOADER_ID_MTV, null, this);
        }
        else {
            TextView empty = (TextView)mtvView.findViewById(R.id.empty_mtv_view);
            empty.setText("No Internet Connection");
        }

    }


    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        getActivity().getMenuInflater().inflate(R.menu.search_mtv,menu);




    }

    @Override
    public Loader<List<MTV>> onCreateLoader(int id, Bundle args) {
        return new MTVLoader(getActivity(),MTV_LINK);
    }

    @Override
    public void onLoadFinished(Loader<List<MTV>> loader, List<MTV> data) {
        getData = data;

        ProgressBar progressBar = (ProgressBar)getActivity().findViewById(R.id.prograssbar_mtv);
        progressBar.setVisibility(View.GONE);
//
//       mtvRecyclerView = (RecyclerView)mtvView.findViewById(R.id.mtv_recycler_list);
//        mtvRecyclerAdapter = new MtvRecyclerAdapter(getActivity(),data);
//        mtvRecyclerView.setAdapter(mtvRecyclerAdapter);
//        mtvRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        /*
        calling
         */
        addingRecyclerView(getData);

    }

    private void addingRecyclerView(List<MTV> getData) {

        mtvRecyclerAdapter = new MtvRecyclerAdapter(getActivity(),getData);
        mtvRecyclerView.setAdapter(mtvRecyclerAdapter);
        mtvRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //mtvRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoaderReset(Loader<List<MTV>> loader) {
        addingRecyclerView(getData);
    }
}
