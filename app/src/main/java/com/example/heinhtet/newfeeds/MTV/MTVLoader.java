package com.example.heinhtet.newfeeds.MTV;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heinhtet on 2/21/17.
 */
public class MTVLoader extends AsyncTaskLoader<List<MTV>> {
    public static String link ;


    public MTVLoader(Context context, String mtvLink) {
        super(context);
        link = mtvLink;
    }
    @Override
    protected void onStartLoading () {
        forceLoad();
    }

    @Override
    public List<MTV> loadInBackground() {
        List<MTV> getListData =new ArrayList<>();
        getListData =  GetDataFromJSONsimple.list(link);
        return getListData;
    }


}
