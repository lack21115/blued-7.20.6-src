package com.blued.android.module.live_china.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.blued.android.core.AppInfo;
import java.util.ArrayList;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePictureFragment.class */
public class LivePictureFragment extends LiveBaseDialogFragment {
    private ArrayList<String> d;

    @Override // com.blued.android.module.live_china.fragment.LiveBaseDialogFragment
    public void d() {
        if (getArguments() != null) {
            this.d = getArguments().getStringArrayList("picture_url_list");
        }
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseDialogFragment
    public int e() {
        return AppInfo.l;
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseDialogFragment
    public int f() {
        return AppInfo.m;
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseDialogFragment
    public int g() {
        return 0;
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseDialogFragment
    public FragmentPagerAdapter h() {
        return new FragmentPagerAdapter(getChildFragmentManager()) { // from class: com.blued.android.module.live_china.fragment.LivePictureFragment.1
            public int getCount() {
                return 1;
            }

            public Fragment getItem(int i) {
                LivePhotoDetailFragment livePhotoDetailFragment = new LivePhotoDetailFragment();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("picture_url_list", LivePictureFragment.this.d);
                livePhotoDetailFragment.setArguments(bundle);
                return livePhotoDetailFragment;
            }
        };
    }
}
