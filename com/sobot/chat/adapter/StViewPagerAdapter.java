package com.sobot.chat.adapter;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.sobot.chat.fragment.SobotBaseFragment;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/StViewPagerAdapter.class */
public class StViewPagerAdapter extends SmartFragmentStatePagerAdapter {
    private Context context;
    private List<SobotBaseFragment> pagers;
    private String[] tabs;

    public StViewPagerAdapter(Context context, FragmentManager fragmentManager, String[] strArr, List<SobotBaseFragment> list) {
        super(fragmentManager);
        this.tabs = strArr;
        this.pagers = list;
        this.context = context;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.pagers.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        return this.pagers.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        String[] strArr = this.tabs;
        return (strArr == null || i >= strArr.length) ? "" : strArr[i];
    }
}
