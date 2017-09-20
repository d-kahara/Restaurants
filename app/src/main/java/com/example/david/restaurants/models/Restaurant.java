package com.example.david.restaurants.models;

import java.util.ArrayList;
import java.util.List;

import org.parceler.Parcel;



@Parcel
public class Restaurant {

        String name;
        String phone;
        String website;
        double rating;
        String imageUrl;
        List<String> address = new ArrayList<>();
//        private double mLatitude;
//        private double mLongitude;
//      private ArrayList<String> mCategories = new ArrayList<>();

        public Restaurant() {}

        public Restaurant(String name, String phone, String website,double rating, String imageUrl, ArrayList<String> address) {
            this.name = name;
            this.phone = phone;
            this.website = website;
            this.rating = rating;
            this.imageUrl = imageUrl;
            this.address = address;
//            this.mLatitude = latitude;
//            this.mLongitude = longitude;
//            this.mCategories = categories;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }

        public String getWebsite() {
            return  website;
        }

        public double getRating() {
            return rating;
        }

        public String getImageUrl(){
            return imageUrl;
        }

        public List<String> getAddress() {
            return address;
        }

//        }

//        public ArrayList<String> getCategories() {
//            return mCategories;
//        }

}