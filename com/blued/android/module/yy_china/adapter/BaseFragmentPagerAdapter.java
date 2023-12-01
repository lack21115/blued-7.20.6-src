package com.blued.android.module.yy_china.adapter;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/BaseFragmentPagerAdapter.class */
public class BaseFragmentPagerAdapter extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    protected List<Fragment> f16113a;
    private Fragment b;

    public BaseFragmentPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.f16113a = new ArrayList();
    }

    public BaseFragmentPagerAdapter(FragmentManager fragmentManager, int i) {
        super(fragmentManager, i);
        this.f16113a = new ArrayList();
    }

    public Fragment a() {
        return this.b;
    }

    public void a(List<Fragment> list) {
        if (list != null) {
            this.f16113a.clear();
            this.f16113a.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<Fragment> list = this.f16113a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.f16113a.get(i);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public long getItemId(int i) {
        return this.f16113a.get(i).hashCode();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        if (a() != obj) {
            this.b = (Fragment) obj;
        }
        super.setPrimaryItem(viewGroup, i, obj);
    }
}
