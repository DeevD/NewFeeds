package com.example.heinhtet.newfeeds.MTV;

/**
 * Created by heinhtet on 2/21/17.
 */

public class MTV {


    String mTitle;
    String mDescription;
    String mImageUrl;
    String mUrl;
    String mPublishedAt;
    String mAuthor;

    public MTV(String title, String description, String imgeUrl, String url, String publishedAt, String Author) {
        mTitle = title;
        mDescription = description;
        mImageUrl = imgeUrl;
        mUrl = url;
        mPublishedAt = publishedAt;
        mAuthor = Author;

    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getmPublishedAt() {
        return mPublishedAt;
    }

    public void setmPublishedAt(String mPublishedAt) {
        this.mPublishedAt = mPublishedAt;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public void setmAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }




}
