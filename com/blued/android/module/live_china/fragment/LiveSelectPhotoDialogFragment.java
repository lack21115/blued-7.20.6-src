package com.blued.android.module.live_china.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.blued.android.core.AppInfo;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.same.Logger;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveSelectPhotoDialogFragment.class */
public class LiveSelectPhotoDialogFragment extends LiveBaseDialogFragment<LiveMakeLoverFansModel> {
    @Override // com.blued.android.module.live_china.fragment.LiveBaseDialogFragment
    public void a(LiveMakeLoverFansModel liveMakeLoverFansModel) {
        super.a((LiveSelectPhotoDialogFragment) liveMakeLoverFansModel);
        Logger.d("LiveSelectPhotoDialogFragment", "clip sucess image path");
        b(liveMakeLoverFansModel);
        dismiss();
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseDialogFragment
    public void d() {
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
        return R.style.main_menu_animstyle;
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseDialogFragment
    public FragmentPagerAdapter h() {
        return new FragmentPagerAdapter(getChildFragmentManager()) { // from class: com.blued.android.module.live_china.fragment.LiveSelectPhotoDialogFragment.1
            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                return 1;
            }

            @Override // androidx.fragment.app.FragmentPagerAdapter
            public Fragment getItem(int i) {
                return new LiveShowPhotosFragment();
            }
        };
    }
}
