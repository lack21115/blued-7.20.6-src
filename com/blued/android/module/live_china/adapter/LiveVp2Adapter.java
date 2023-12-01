package com.blued.android.module.live_china.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveVp2Adapter.class */
public final class LiveVp2Adapter extends FragmentStateAdapter {
    private ArrayList<Fragment> e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveVp2Adapter(FragmentManager fragmentManager, Lifecycle lifecycle, ArrayList<Fragment> pagerFragment) {
        super(fragmentManager, lifecycle);
        Intrinsics.e(fragmentManager, "fragmentManager");
        Intrinsics.e(lifecycle, "lifecycle");
        Intrinsics.e(pagerFragment, "pagerFragment");
        this.e = pagerFragment;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public boolean containsItem(long j) {
        Fragment fragment;
        Iterator<Fragment> it = this.e.iterator();
        while (true) {
            if (!it.hasNext()) {
                fragment = null;
                break;
            }
            fragment = it.next();
            if (((long) fragment.hashCode()) == j) {
                break;
            }
        }
        return fragment != null;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int i) {
        Fragment fragment = this.e.get(i);
        Intrinsics.c(fragment, "pagerFragment[position]");
        return fragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.e.size();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return this.e.get(i).hashCode();
    }
}
