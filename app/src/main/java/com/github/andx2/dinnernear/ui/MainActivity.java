package com.github.andx2.dinnernear.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RatingBar;

import com.github.andx2.dinnernear.R;
import com.github.andx2.dinnernear.utils.ImageHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by savos on 07.08.2016.
 */

public class MainActivity extends AppCompatActivity {

    RecyclerView imgList;
    Toolbar toolbar;
    AppBarLayout.LayoutParams mAppbarParams = null;
    CollapsingToolbarLayout collapsingToolbarLayout;
    RatingBar ratingBar;
    private boolean detailsVisible = false;
    LinearLayout detailsLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        imgList = (RecyclerView)findViewById(R.id.img_list);
        toolbar = (Toolbar)findViewById(R.id.main_toolbar);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.main_collapsing_toolbar);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        detailsLayout = (LinearLayout)findViewById(R.id.details_layout);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        imgList.setLayoutManager(layoutManager);

        //region ====filling recyclerViewImage stub pictures
        List<Bitmap> list = new ArrayList();
        list.add(ImageHelper.decodeSampledBitmapFromResource(getResources(), R.drawable.img1, 100, 100));
        list.add(ImageHelper.decodeSampledBitmapFromResource(getResources(), R.drawable.img2, 100, 100));
        list.add(ImageHelper.decodeSampledBitmapFromResource(getResources(), R.drawable.img3, 100, 100));
        list.add(ImageHelper.decodeSampledBitmapFromResource(getResources(), R.drawable.img4, 100, 100));
        list.add(ImageHelper.decodeSampledBitmapFromResource(getResources(), R.drawable.img5, 100, 100));
        list.add(ImageHelper.decodeSampledBitmapFromResource(getResources(), R.drawable.img6, 100, 100));
        list.add(ImageHelper.decodeSampledBitmapFromResource(getResources(), R.drawable.img7, 100, 100));
        list.add(ImageHelper.decodeSampledBitmapFromResource(getResources(), R.drawable.img8, 100, 100));
        //end region

        ImageListAdapter adapter = new ImageListAdapter(list);
        imgList.setAdapter(adapter);

        setupToolbar();

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_details:
                Log.d("DebugTag", "onOptionsItemSelected - menu_item_details");
                if (detailsVisible == false){
                    detailsVisible = true;
                    detailsLayout.setVisibility(View.VISIBLE);
                }else {
                    detailsVisible = false;
                    detailsLayout.setVisibility(View.GONE);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        mAppbarParams = (AppBarLayout.LayoutParams) collapsingToolbarLayout.getLayoutParams();
        ratingBar.setNumStars(5);
        ratingBar.setRating(3.6f);
        if (actionBar != null) {
            Log.d("DebugTag", "actionBar != null");
            actionBar.setTitle(R.string.title_stub);

        }
    }
}
