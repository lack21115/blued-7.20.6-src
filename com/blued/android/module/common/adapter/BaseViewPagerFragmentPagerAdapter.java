package com.blued.android.module.common.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.blued.android.core.ui.BaseFragment;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adapter/BaseViewPagerFragmentPagerAdapter.class */
public abstract class BaseViewPagerFragmentPagerAdapter extends FragmentStatePagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    FragmentManager f10435a;
    protected List<BaseFragment> b;

    /* renamed from: c  reason: collision with root package name */
    protected List<String> f10436c;
    private int d;

    public BaseViewPagerFragmentPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.b = new ArrayList();
        this.f10436c = new ArrayList();
        this.f10435a = fragmentManager;
    }

    private String a(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(List<BaseFragment> list) {
        this.b = list;
    }

    protected abstract BaseFragment b(int i);

    public void b(List<String> list) {
        this.f10436c = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.b.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        String a2 = a(this.d, i);
        if (i >= this.b.size()) {
            Fragment findFragmentByTag = this.f10435a.findFragmentByTag(a2);
            BaseFragment baseFragment = findFragmentByTag;
            if (findFragmentByTag == 0) {
                baseFragment = b(i);
            }
            this.b.add(baseFragment);
            return baseFragment;
        } else if (this.b.get(i) == null) {
            Fragment findFragmentByTag2 = this.f10435a.findFragmentByTag(a2);
            BaseFragment baseFragment2 = findFragmentByTag2;
            if (findFragmentByTag2 == 0) {
                baseFragment2 = b(i);
            }
            this.b.set(i, baseFragment2);
            return baseFragment2;
        } else {
            return this.b.get(i);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                return -2;
            }
            if (obj.hashCode() == this.b.hashCode()) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.f10436c.get(i);
    }
}
