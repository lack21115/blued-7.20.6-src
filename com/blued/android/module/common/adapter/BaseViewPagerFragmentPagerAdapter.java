package com.blued.android.module.common.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.blued.android.core.ui.BaseFragment;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adapter/BaseViewPagerFragmentPagerAdapter.class */
public abstract class BaseViewPagerFragmentPagerAdapter extends FragmentStatePagerAdapter {
    FragmentManager a;
    protected List<BaseFragment> b;
    protected List<String> c;
    private int d;

    public BaseViewPagerFragmentPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.a = fragmentManager;
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
        this.c = list;
    }

    public int getCount() {
        return this.b.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v23, types: [androidx.fragment.app.Fragment] */
    /* JADX WARN: Type inference failed for: r0v5, types: [androidx.fragment.app.Fragment] */
    public Fragment getItem(int i) {
        String a = a(this.d, i);
        if (i >= this.b.size()) {
            ?? findFragmentByTag = this.a.findFragmentByTag(a);
            BaseFragment baseFragment = findFragmentByTag;
            if (findFragmentByTag == 0) {
                baseFragment = b(i);
            }
            this.b.add(baseFragment);
            return baseFragment;
        } else if (this.b.get(i) == null) {
            ?? findFragmentByTag2 = this.a.findFragmentByTag(a);
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

    public CharSequence getPageTitle(int i) {
        return this.c.get(i);
    }
}
