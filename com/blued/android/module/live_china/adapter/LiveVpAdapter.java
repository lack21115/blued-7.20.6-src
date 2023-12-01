package com.blued.android.module.live_china.adapter;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveVpAdapter.class */
public final class LiveVpAdapter extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<Fragment> f11708a;

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int i, Object object) {
        Intrinsics.e(container, "container");
        Intrinsics.e(object, "object");
        super.destroyItem(container, i, object);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f11708a.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        Fragment fragment = this.f11708a.get(i);
        Intrinsics.c(fragment, "pagerFragment[position]");
        return fragment;
    }
}
