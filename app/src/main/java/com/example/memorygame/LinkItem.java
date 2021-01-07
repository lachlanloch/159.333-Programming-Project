package com.example.memorygame;

import android.os.Parcel;
import android.os.Parcelable;

public class LinkItem implements Parcelable {
    private int key;
    private int resId;

    public LinkItem() {
    }

    protected LinkItem(Parcel in) {
        key = in.readInt();
        resId = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(key);
        dest.writeInt(resId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LinkItem> CREATOR = new Creator<LinkItem>() {
        @Override
        public com.example.memorygame.LinkItem createFromParcel(Parcel in) {
            return new com.example.memorygame.LinkItem(in);
        }

        @Override
        public com.example.memorygame.LinkItem[] newArray(int size) {
            return new com.example.memorygame.LinkItem[size];
        }
    };

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }


    @Override
    public String toString() {
        return "LinkItem{" +
                "key=" + key +
                ", resId=" + resId +
                '}';
    }
}
