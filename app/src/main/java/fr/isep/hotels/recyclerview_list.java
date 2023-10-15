package fr.isep.hotels;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class recyclerview_list implements Parcelable {

    private int photo_one;

    private String ad_title;


    public recyclerview_list(int photo_one, String ad_title) {
        this.photo_one = photo_one;
        this.ad_title = ad_title;
    }



    protected recyclerview_list(Parcel in) {
        photo_one = in.readInt();

        ad_title = in.readString();

    }



    public static final Creator<recyclerview_list> CREATOR = new Creator<recyclerview_list>() {
        @Override
        public recyclerview_list createFromParcel(Parcel in) {
            return new recyclerview_list(in);
        }

        @Override
        public recyclerview_list[] newArray(int size) {
            return new recyclerview_list[size];
        }
    };

    public int getPhoto_one() {
        return photo_one;
    }

    public void setPhoto_one(int photo_one) {
        this.photo_one = photo_one;
    }


    public String getAd_title() {
        return ad_title;
    }

    public void setAd_title(String ad_title) {
        this.ad_title = ad_title;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(photo_one);

        parcel.writeString(ad_title);

    }
}
