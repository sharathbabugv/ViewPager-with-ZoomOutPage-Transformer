package com.projects.sharath.viewpagerwithft;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Sharath on 14-Jun-18.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private List<ViewPagerModel> modelList;
    private Context context;

    public ViewPagerAdapter(List<ViewPagerModel> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.viewpager_contents, container, false);
        //container is a viewgroup.
        container.addView(view);

        TextView quotes = view.findViewById(R.id.quotes);
        quotes.setText(modelList.get(position).getQuotes());

        TextView names = view.findViewById(R.id.name);
        names.setText(modelList.get(position).getNames());

        TextView quotes_types = view.findViewById(R.id.quote_type);
        quotes_types.setText(modelList.get(position).getQuote_types());

        TextView role = view.findViewById(R.id.roles);
        role.setText(modelList.get(position).getRoles());

        ImageView profile = view.findViewById(R.id.profileimage);
        profile.setImageResource(modelList.get(position).getProfile());

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
