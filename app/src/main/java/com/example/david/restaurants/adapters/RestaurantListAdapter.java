package com.example.david.restaurants.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.david.restaurants.R;
import com.example.david.restaurants.UI.RestaurantDetailActivity;
import com.example.david.restaurants.models.Restaurant;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by david on 9/11/17.
 */

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.RestaurantViewHolder> {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200 ;
    private ArrayList<Restaurant> mRestaurants = new ArrayList<>();
    private Context mContext;

    public RestaurantListAdapter(Context context, ArrayList<Restaurant> restaurants) {
        mContext = context;
        mRestaurants = restaurants;
    }

    @Override
    public RestaurantListAdapter.RestaurantViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_list_item, parent, false);
        RestaurantViewHolder viewHolder = new RestaurantViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RestaurantListAdapter.RestaurantViewHolder holder, int position) {
        holder.bindRestaurant((mRestaurants.get(position)));
    }


    @Override
    public int getItemCount() {
        return mRestaurants.size();
    }

    public class RestaurantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @Bind((R.id.restaurantImageView))
        ImageView mRestaurantImageView;
        @Bind(R.id.restaurantNameTextView)
        TextView mNameTextView;
        @Bind(R.id.ratingTextView) TextView mRatingTextView;
        @Bind(R.id.categoryTextView) TextView mCategoryTextView;


        private Context context;

        public RestaurantViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, RestaurantDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("restaurants", Parcels.wrap(mRestaurants));
            mContext.startActivity(intent);
        }

        public void bindRestaurant(Restaurant restaurant) {
            Picasso.with(mContext)
                    .load(restaurant.getImageUrl())
                    .resize(MAX_WIDTH, MAX_HEIGHT)
                    .centerCrop()
                    .into(mRestaurantImageView);
            mNameTextView.setText(restaurant.getName());
            //mCategoryTextView.setText(restaurant.getCategories().get(0));
            mRatingTextView.setText("Rating: " + restaurant.getRating() + "/5");
        }
    }


//    public static class MyRestaurantsArrayAdapter extends ArrayAdapter {
//        private Context mContext;
//        private String[] mRestaurants;
//        private String[] mCuisines;
//
//        public MyRestaurantsArrayAdapter(Context mContext, int resource, String[] mRestaurants, String[] mCuisines) {
//            super(mContext, resource);
//            this.mContext = mContext;
//            this.mRestaurants = mRestaurants;
//            this.mCuisines = mCuisines;
//        }
//
//        @Override
//        public Object getItem(int position) {
//            String restaurant = mRestaurants[position];
//            String cuisine = mCuisines[position];
//            return String.format("%s \nServes great: %s", restaurant, cuisine);
//        }
//
//        @Override
//        public int getCount() {
//            return mRestaurants.length;
//        }
//
//
//    }
}
