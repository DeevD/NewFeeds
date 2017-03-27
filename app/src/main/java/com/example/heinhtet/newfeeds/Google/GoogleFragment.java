package com.example.heinhtet.newfeeds.Google;

import android.app.SearchManager;
import android.content.Context;
import android.content.Loader;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.heinhtet.newfeeds.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heinhtet on 2/18/17.
 */

public class GoogleFragment extends android.app.Fragment implements android.app.LoaderManager.LoaderCallbacks<List<Google>> {
    GridLayoutManager gridLayoutManager;
    RecyclerView googleRecylcer;
    public GoogleRecyclerAdapter googleRecyclerAdapter;
    List<Google> data = new ArrayList<>();

    public static final int GOOGLER_LOADER = 1;
    public static final String GOOLGE_LINK =
            "https://newsapi.org/v1/articles?source=google-news&sortBy=top&apiKey=d6a6da0807b542ffbb7357837dee84f1";

    SwipeRefreshLayout swipeRefreshLayout;

    android.app.LoaderManager loaderManager;
    View googleView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        googleView = inflater.inflate(R.layout.google_fragment, container, false);
        setHasOptionsMenu(true);


        ConnectivityManager manager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null && info.isConnected()) {

            loaderManager = getLoaderManager();
            loaderManager.initLoader(GOOGLER_LOADER, null, this);
        } else {
            emptyViewCalling();
        }

        swipeRefreshLayoutCalling();


        gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        googleRecylcer = (RecyclerView) googleView.findViewById(R.id.google_recycler_list);
        googleRecyclerAdapter = new GoogleRecyclerAdapter(getActivity(), new ArrayList<Google>());
        googleRecylcer.setAdapter(googleRecyclerAdapter);
        googleRecylcer.setLayoutManager(gridLayoutManager);
        googleRecylcer.setHasFixedSize(true);
        return googleView;
    }

    private void emptyViewCalling() {
        TextView empty = (TextView) googleView.findViewById(R.id.empty_text);
        empty.setText("No Internet Connection" + "\nSorry Try Again ");
        ImageView emptyImage = (ImageView) googleView.findViewById(R.id.empty_image);
        emptyImage.setImageResource(R.drawable.back_icon);
    }

    private void swipeRefreshLayoutCalling() {

          /*
        For Running time for swipeRefreshLayout that is now 3 seconds
         */
        swipeRefreshLayout = (SwipeRefreshLayout) googleView.findViewById(R.id.swipeLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                (new Handler()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);

                        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
                        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                        if (networkInfo != null && networkInfo.isConnected()) {

                            loaderManager.initLoader(GOOGLER_LOADER, null, GoogleFragment.this);
                        }

                    }
                }, 3000);
            }
        });
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, R.color.dot_dark_screen4, R.color.magnitude4);

    }


    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        getActivity().getMenuInflater().inflate(R.menu.search, menu);

        searchViewCallingForSearchFilterItem(menu);

    }

    private void searchViewCallingForSearchFilterItem(Menu menu) {
        SearchManager searchManager =
                (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        //final MenuItem searchItem = menu.findItem(R.id.action_search);
        // final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setQueryHint(Html.fromHtml("<font color = #ffffff>" + getResources().getString(R.string.hintSearchMess) + "</font>"));


        /*
        When use of custom searchView Icon
         */
//        int searchImgId = android.support.v7.appcompat.R.id.search_button; // I used the explicit layout ID of searchview's ImageView
//        ImageView v = (ImageView) searchView.findViewById(searchImgId);
//        v.setImageResource(R.drawable.simple);
        // super.onPrepareOptionsMenu(menu);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
//                if(fragment instanceof GoogleFragment)
//                    ((GoogleFragment)fragment).googleRecyclerAdapter.getFilter().filter(newText);
                googleRecyclerAdapter.getFilter().filter(newText);

                return true;
            }
        });

    }


    @Override
    public Loader<List<Google>> onCreateLoader(int i, Bundle bundle) {
        return new GoolgeLoader(getActivity(), GOOLGE_LINK);
    }

    @Override
    public void onLoadFinished(Loader<List<Google>> loader, List<Google> googles) {
        data = googles;

        ProgressBar progressBar = (ProgressBar) getActivity().findViewById(R.id.prograssbar);
        progressBar.getIndeterminateDrawable().setColorFilter(Color.BLUE, PorterDuff.Mode.MULTIPLY);


        progressBar.setVisibility(View.GONE);

        googleRecylcerAdding(data);


    }

    private void googleRecylcerAdding(List<Google> data) {
        googleRecyclerAdapter = new GoogleRecyclerAdapter(getActivity(), data);
        googleRecylcer.setAdapter(googleRecyclerAdapter);
        googleRecylcer.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onLoaderReset(Loader<List<Google>> loader) {
        googleRecylcerAdding(data);

    }
}
