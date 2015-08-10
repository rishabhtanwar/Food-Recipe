package Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodrecipes.R;

import java.util.ArrayList;
import java.util.List;

import Extras.GridItem;

/**
 * Created by nishant on 9/8/15.
 */
public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {
    List<GridItem> mItems;

    public GridAdapter() {
        super();
        mItems = new ArrayList<GridItem>();
        GridItem food = new GridItem();
        food.setName("Popular");
        food.setThumbnail(R.drawable.popular);
        mItems.add(food);

        food = new GridItem();
        food.setName("Fruits & Vegetables");
        food.setThumbnail(R.drawable.fruit_veg);
        mItems.add(food);

        food = new GridItem();
        food.setName("Food & Drinks");
        food.setThumbnail(R.drawable.soft_drinks);
        mItems.add(food);

        food = new GridItem();
        food.setName("Breakfast & Dairy");
        food.setThumbnail(R.drawable.breakfast);
        mItems.add(food);

        food = new GridItem();
        food.setName("Staples & Spices");
        food.setThumbnail(R.drawable.staples_spice);
        mItems.add(food);

        food = new GridItem();
        food.setName("Bath & Beauty");
        food.setThumbnail(R.drawable.bath_beauty);
        mItems.add(food);

        food = new GridItem();
        food.setName("Home & Hyginene");
        food.setThumbnail(R.drawable.hygiene);
        mItems.add(food);

        food = new GridItem();
        food.setName("BabyNeeds");
        food.setThumbnail(R.drawable.baby_needs);
        mItems.add(food);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        GridItem Recipes = mItems.get(i);
        viewHolder.tvfood.setText(Recipes.getName());
        viewHolder.imgThumbnail.setImageResource(Recipes.getThumbnail());
    }

    @Override
    public int getItemCount() {

        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imgThumbnail;
        public TextView tvfood;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);
            tvfood = (TextView)itemView.findViewById(R.id.tv_food);
        }
    }
}
