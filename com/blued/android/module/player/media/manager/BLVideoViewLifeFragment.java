package com.blued.android.module.player.media.manager;

import android.app.Activity;
import android.app.Fragment;
import com.blued.android.core.utils.Log;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/media/manager/BLVideoViewLifeFragment.class */
public class BLVideoViewLifeFragment extends Fragment {
    public static final String a = BLVideoViewLifeFragment.class.getSimpleName();
    private BLVideoViewCache b;

    public static void a(BLVideoViewCache bLVideoViewCache, Activity activity) {
        if (activity == null || activity.getFragmentManager() == null) {
            Log.c(a, "activity is null");
            return;
        }
        try {
            Log.c(a, "PLVideoViewLifeFragment new instance");
            BLVideoViewLifeFragment bLVideoViewLifeFragment = new BLVideoViewLifeFragment();
            bLVideoViewLifeFragment.b = bLVideoViewCache;
            activity.getFragmentManager().beginTransaction().add(bLVideoViewLifeFragment, a).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        Log.c(a, "onDestroy");
        BLVideoViewCache bLVideoViewCache = this.b;
        if (bLVideoViewCache != null) {
            bLVideoViewCache.a();
        }
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onHiddenChanged(boolean z) {
        Tracker.onHiddenChanged(this, z);
        super.onHiddenChanged(z);
    }

    @Override // android.app.Fragment
    public void onPause() {
        Tracker.onPause(this);
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        Tracker.onResume(this);
        super.onResume();
    }

    @Override // android.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Tracker.setUserVisibleHint(this, z);
        super.setUserVisibleHint(z);
    }
}
