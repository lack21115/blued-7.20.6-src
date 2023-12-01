package com.blued.android.module.yy_china.adapter;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/BaseFragmentPagerAdapter.class */
public class BaseFragmentPagerAdapter extends FragmentPagerAdapter {
    protected List<Fragment> a;
    private Fragment b;

    public BaseFragmentPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.a = new ArrayList();
    }

    public BaseFragmentPagerAdapter(FragmentManager fragmentManager, int i) {
        super(fragmentManager, i);
        this.a = new ArrayList();
    }

    public Fragment a() {
        return this.b;
    }

    public void a(List<Fragment> list) {
        if (list != null) {
            this.a.clear();
            this.a.addAll(list);
            notifyDataSetChanged();
        }
    }

    public int getCount() {
        List<Fragment> list = this.a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public Fragment getItem(int i) {
        return this.a.get(i);
    }

    public long getItemId(int i) {
        return this.a.get(i).hashCode();
    }

    public int getItemPosition(Object obj) {
        return -2;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        if (a() != obj) {
            this.b = (Fragment) obj;
        }
        super.setPrimaryItem(viewGroup, i, obj);
    }
}
