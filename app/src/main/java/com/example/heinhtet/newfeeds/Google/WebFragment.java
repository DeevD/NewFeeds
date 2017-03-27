package com.example.heinhtet.newfeeds.Google;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.heinhtet.newfeeds.R;

/**
 * Created by heinhtet on 2/19/17.
 */

public class WebFragment extends android.support.v4.app.Fragment {
    ProgressBar progressBar;
    WebView webView;

    String url;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.web_fragment, container, false);
        progressBar = (ProgressBar)view.findViewById(R.id.pg);
        Intent intent = getActivity().getIntent();
        Google google = (Google) intent.getSerializableExtra("item");
        url = google.getmUrl();
        webView = (WebView) view.findViewById(R.id.web_layout);

        progressBar.setVisibility(View.VISIBLE);

        (new Handler()).postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
            }
        }, 5000);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadsImagesAutomatically(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new MyBrowser());
        webView.loadUrl(url);

        return view;
    }


    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            progressBar.setVisibility(View.VISIBLE);
            view.loadUrl(url);
            return true;
        }
    }
}
