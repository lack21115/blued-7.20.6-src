package com.sobot.chat.adapter.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/base/SobotBasePagerAdapter.class */
public class SobotBasePagerAdapter<T> extends PagerAdapter {
    protected Context context;
    protected ArrayList<T> list;

    public SobotBasePagerAdapter(Context context, ArrayList<T> arrayList) {
        this.list = arrayList;
        this.context = context;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.list.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
