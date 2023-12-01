package com.blued.android.module.live_china.adapter;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.PlayingOnliveFullModeFragment;
import com.blued.android.module.live_china.fragment.PlayingOnliveSimpleModeFragment;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveModePagerAdapter.class */
public class LiveModePagerAdapter extends FragmentStatePagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    PlayingOnliveFragment f11666a;
    FragmentManager b;

    public LiveModePagerAdapter(FragmentManager fragmentManager, PlayingOnliveFragment playingOnliveFragment) {
        super(fragmentManager);
        this.f11666a = playingOnliveFragment;
        this.b = fragmentManager;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f11666a.cA;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return PlayingOnliveFullModeFragment.a(this.f11666a.s, this.f11666a.t);
        }
        return PlayingOnliveSimpleModeFragment.a(this.f11666a.s, this.f11666a.t);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }
}
