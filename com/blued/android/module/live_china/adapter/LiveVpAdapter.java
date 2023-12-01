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
    private ArrayList<Fragment> a;

    public void destroyItem(ViewGroup container, int i, Object object) {
        Intrinsics.e(container, "container");
        Intrinsics.e(object, "object");
        super.destroyItem(container, i, object);
    }

    public int getCount() {
        return this.a.size();
    }

    public Fragment getItem(int i) {
        Fragment fragment = this.a.get(i);
        Intrinsics.c(fragment, "pagerFragment[position]");
        return fragment;
    }
}
