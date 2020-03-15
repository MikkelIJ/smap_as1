package com.mikkel.mikkeljensen_au529152_fall_assignment1;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

public class Animalitem {
    private int mImageResource;
    private String mWord;
    private String mPronounced;
    private String mRating;
    private String mDescription;
    private String mNotes;

    public Animalitem(String mWord, String mPronounced, String mDescription) {
        this.mWord = mWord;
        this.mPronounced = mPronounced;
        this.mDescription = mDescription;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public void setmImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

    public String getmWord() {
        Log.wtf("MELLEMRUM",mWord+"");
        if (mWord.contains(" ")) {
            Log.wtf("MELLEMRUM",mWord+"");
        }
        return mWord;
    }

    public void setmWord(String mWord) {
        this.mWord = mWord;
    }

    public String getmPronounced() {
        return mPronounced;
    }

    public void setmPronounced(String mPronounced) {
        this.mPronounced = mPronounced;
    }

    public String getmRating() {
        return mRating;
    }

    public void setmRating(String mRating) {
        this.mRating = mRating;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmNotes() {
        return mNotes;
    }

    public void setmNotes(String mNotes) {
        this.mNotes = mNotes;
    }
}
