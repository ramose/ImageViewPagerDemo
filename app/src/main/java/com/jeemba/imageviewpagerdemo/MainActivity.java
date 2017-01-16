package com.jeemba.imageviewpagerdemo;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    private LinearLayout pager_indicator;
    private int dotsCount;
    private ImageView[] dots;

    private String[] images = {
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMjQzNjc1MTA3Ml5BMl5BanBnXkFtZTgwMTM0ODAwNzE@._V1_SX300.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMjMxMzMzMzU3Nl5BMl5BanBnXkFtZTgwMjM5ODQ2NzE@._V1_SX300.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BNTM3OTc0MzM2OV5BMl5BanBnXkFtZTYwNzUwMTI3._V1_SX300.jpg",
            "https://images-na.ssl-images-amazon.com/images/M/MV5BYThjYzcyYzItNTVjNy00NDk0LTgwMWQtYjMwNmNlNWJhMzMyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(MainActivity.this, images);
        viewPager.setAdapter(viewPagerAdapter);

        viewPager.addOnPageChangeListener(this);
        pager_indicator = (LinearLayout)findViewById(R.id.viewPagerCountDots);
        setUiPageViewController();


    }

    private void setUiPageViewController() {

        dotsCount = viewPagerAdapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            pager_indicator.addView(dots[i], params);
        }

        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < dotsCount; i++) {
//            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));
            dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.nonselecteditem_dot));
        }
        dots[position].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.selecteditem_dot));

//        dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
