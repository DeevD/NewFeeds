package com.example.heinhtet.newfeeds.Google;

import java.io.Serializable;

/**
 * Created by heinhtet on 2/18/17.
 */
public class Google implements Serializable {
    String mTitle;
    String mDescription;
    String mImageUrl;

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

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
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

    String mUrl;
    String mPublishedAt;
    String mAuthor;

    public Google(String title, String description, String imgeUrl, String url, String publishedAt, String Author) {
        mTitle = title;
        mDescription = description;
        mImageUrl = imgeUrl;
        mUrl = url;
        mPublishedAt = publishedAt;
        mAuthor = Author;

    }

}
