package com.soft.blued.ui.feed.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.live_china.fragment.LiveBaseDialogFragment;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.soft.blued.utils.Logger;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/LiveClipPhotoFragment.class */
public class LiveClipPhotoFragment extends LiveBaseDialogFragment<LiveMakeLoverFansModel> {
    private String d;
    private String e;
    private int f;

    public void a(LiveMakeLoverFansModel liveMakeLoverFansModel) {
        super.a(liveMakeLoverFansModel);
        Logger.e("LiveClipPhotoFragment", "onDismiss result = ");
        if (getParentFragment() != null && (getParentFragment() instanceof LiveBaseDialogFragment)) {
            Logger.e("LiveClipPhotoFragment", "onDismiss parentFragment = " + getParentFragment().getClass().getSimpleName());
            getParentFragment().a(liveMakeLoverFansModel);
        }
        dismiss();
    }

    public void d() {
        if (getArguments() != null) {
            this.e = getArguments().getString("select_http_url");
            this.d = getArguments().getString("photo_path");
            this.f = getArguments().getInt("select_photo");
        }
    }

    public int e() {
        return AppInfo.l;
    }

    public int f() {
        return AppInfo.m;
    }

    public int g() {
        return 0;
    }

    public FragmentPagerAdapter h() {
        return new FragmentPagerAdapter(getChildFragmentManager()) { // from class: com.soft.blued.ui.feed.fragment.LiveClipPhotoFragment.1
            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                return 1;
            }

            @Override // androidx.fragment.app.FragmentPagerAdapter
            public Fragment getItem(int i) {
                BaseFragment clipPhotoFragment = new ClipPhotoFragment();
                Bundle bundle = new Bundle();
                bundle.putString("select_http_url", LiveClipPhotoFragment.this.e);
                bundle.putString("photo_path", LiveClipPhotoFragment.this.d);
                bundle.putInt("select_photo", LiveClipPhotoFragment.this.f);
                clipPhotoFragment.setArguments(bundle);
                return clipPhotoFragment;
            }
        };
    }
}
