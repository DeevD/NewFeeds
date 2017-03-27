package com.example.heinhtet.newfeeds;

/**
 * Created by heinhtet on 2/19/17.
 */

public class Categories {
    String MkeyWord;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getMkeyWord() {
        return MkeyWord;
    }

    public void setMkeyWord(String mkeyWord) {
        MkeyWord = mkeyWord;
    }

    String des;

    public Categories(String keyWord,String desction){
        MkeyWord = keyWord;
        des = desction;
    }
}
