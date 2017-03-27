package com.example.heinhtet.newfeeds.Google;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heinhtet on 2/18/17.
 */
public class GoolgeLoader extends AsyncTaskLoader<List<Google>> {
    public static  String link = null;

    public GoolgeLoader(Context context, String goolgeLink) {
        super(context);
        link = goolgeLink;


    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Google> loadInBackground() {
        List<Google> getData = new ArrayList<>();
        getData = GetDataFromJSON.list(link);
        return getData;
    }

}
