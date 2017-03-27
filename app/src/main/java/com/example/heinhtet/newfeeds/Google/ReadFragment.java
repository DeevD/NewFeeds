package com.example.heinhtet.newfeeds.Google;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.heinhtet.newfeeds.R;
import com.squareup.picasso.Picasso;

import static com.example.heinhtet.newfeeds.R.id.read_detail_articles;

/**
 * Created by heinhtet on 2/19/17.
 */

public class ReadFragment extends Fragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.read_layout, container, false);

        Intent intent = getActivity().getIntent();
        Google google = (Google) intent.getSerializableExtra("item");

        UpdateUI(google);

        return view;
    }


    private void UpdateUI(Google google) {
        TextView readTitle, readDes, readAuthor, readTime;
        ImageView readImage;

        readTitle = (TextView) view.findViewById(R.id.read_title);
        readDes = (TextView) view.findViewById(read_detail_articles);
        readAuthor = (TextView) view.findViewById(R.id.read_author);
        readTime = (TextView) view.findViewById(R.id.read_time);
        readImage = (ImageView) view.findViewById(R.id.read_imageView);

        readTitle.setText(google.getmTitle());
        readDes.setText(google.getmDescription());
        readAuthor.setText(google.getmAuthor());
        readTime.setText(google.getmPublishedAt());
        Picasso.with(getActivity()).load(google.getmImageUrl()).into(readImage);

    }
}
