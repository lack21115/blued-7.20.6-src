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
    PlayingOnliveFragment a;
    FragmentManager b;

    public LiveModePagerAdapter(FragmentManager fragmentManager, PlayingOnliveFragment playingOnliveFragment) {
        super(fragmentManager);
        this.a = playingOnliveFragment;
        this.b = fragmentManager;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
    }

    public int getCount() {
        return this.a.cA;
    }

    public Fragment getItem(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return PlayingOnliveFullModeFragment.a(this.a.s, this.a.t);
        }
        return PlayingOnliveSimpleModeFragment.a(this.a.s, this.a.t);
    }

    public int getItemPosition(Object obj) {
        return -2;
    }
}
