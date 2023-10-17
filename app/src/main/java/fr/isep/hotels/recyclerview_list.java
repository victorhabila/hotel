package fr.isep.hotels;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class recyclerview_list implements Parcelable {

    private int photo_one;

    private String ad_title;
    private String booking_site;
    private String price;
    private String description;

    private String location;

    private String rating;

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public recyclerview_list(int photo_one, String ad_title, String booking_site, String price, String description, String location, String rating) {
        this.photo_one = photo_one;
        this.ad_title = ad_title;
        this.booking_site = booking_site;
        this.price = price;
        this.description = description;
        this.location = location;
        this.rating = rating;


    }

    protected recyclerview_list(Parcel in) {
        photo_one = in.readInt();

        ad_title = in.readString();

    }


    public String getBooking_site() {
        return booking_site;
    }

    public void setBooking_site(String booking_site) {
        this.booking_site = booking_site;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        parcel.writeString(booking_site);
        parcel.writeString(price);
        parcel.writeString(description);
        parcel.writeString(location);
        parcel.writeString(rating);

    }
}
