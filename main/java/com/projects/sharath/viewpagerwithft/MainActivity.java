package com.projects.sharath.viewpagerwithft;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ViewPagerModel> modelList;
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        modelList = new ArrayList<>();

        String quotes[] = {" Only I can change my life. No one can do it for me. ",
                " There is only one happiness in this life, to love and be loved.",
                " You can't really be strong until you see a funny side to things "};

        String names[] = {"Carol Burnett", "George Sand", "Ken Kesey"};

        String quotes_type[] = {"MOTIVATION", "LOVE", "STRONG"};

        String roles[] = {"Actress", "French Novelist", "American Novelist"};

        int images[] = {R.drawable.burnett, R.drawable.sand, R.drawable.kesey};

        for (int i = 0 ; i < images.length ; i++)
        {
            ViewPagerModel viewPagerModel = new ViewPagerModel();
            viewPagerModel.setQuotes(quotes[i]);
            viewPagerModel.setNames(names[i]);
            viewPagerModel.setQuote_types(quotes_type[i]);
            viewPagerModel.setRoles(roles[i]);
            viewPagerModel.setProfile(images[i]);
            modelList.add(viewPagerModel);
        }
        viewPagerAdapter = new ViewPagerAdapter(modelList,this);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        viewPager.setAdapter(viewPagerAdapter);
    }


    public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }
}
