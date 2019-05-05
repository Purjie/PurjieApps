package com.purnamaadjie.myapplication;
// 1 Mei 2019 10116079 Purnama Adjie AKB-2

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class IntroViewPagerAdapter extends PagerAdapter {

    Context mcContext;
    List<ScreenItem> mListScreenItems;

    public IntroViewPagerAdapter(Context mcContext, List<ScreenItem> mListScreenItems) {
        this.mcContext = mcContext;
        this.mListScreenItems = mListScreenItems;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) mcContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen = inflater.inflate(R.layout.layout_screen, null);

        ImageView imgSlide = layoutScreen.findViewById(R.id.intro_img);
        TextView title = layoutScreen.findViewById(R.id.intro_title);
        TextView description = layoutScreen.findViewById(R.id.intro_description);

        title.setText(mListScreenItems.get(position).getTitle());
        description.setText(mListScreenItems.get(position).getDescription());
        imgSlide.setImageResource(mListScreenItems.get(position).getScreenImg());

        container.addView(layoutScreen);

        return layoutScreen;

    }

    @Override
    public int getCount() {
        return mListScreenItems.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View)object);

    }
}
