package com.blued.android.module.live_china.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.blued.android.core.AppInfo;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMakeLoverOkDialogFragment.class */
public class LiveMakeLoverOkDialogFragment extends LiveBaseDialogFragment {
    private IDialogEvent d;
    private long e;
    private int f;
    private LiveMakeLoverFansModel g;
    private LiveMakeLoverFansModel h;
    private String i;
    private boolean j;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMakeLoverOkDialogFragment$IDialogEvent.class */
    public interface IDialogEvent {
        void a();
    }

    public void a(IDialogEvent iDialogEvent) {
        this.d = iDialogEvent;
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseDialogFragment
    public void d() {
        if (getArguments() != null) {
            this.e = getArguments().getLong("lid");
            this.f = getArguments().getInt("from");
            this.g = (LiveMakeLoverFansModel) getArguments().getSerializable("chosen");
            this.h = (LiveMakeLoverFansModel) getArguments().getSerializable("chooser");
            this.i = getArguments().getString("apngLocalUrl");
            this.j = getArguments().getBoolean("confirm");
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
        return new FragmentPagerAdapter(getChildFragmentManager()) { // from class: com.blued.android.module.live_china.fragment.LiveMakeLoverOkDialogFragment.1
            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                return 1;
            }

            @Override // androidx.fragment.app.FragmentPagerAdapter
            public Fragment getItem(int i) {
                if (LiveMakeLoverOkDialogFragment.this.j) {
                    LiveMakeLoverOkFragment liveMakeLoverOkFragment = new LiveMakeLoverOkFragment();
                    Bundle bundle = new Bundle();
                    bundle.putLong("lid", LiveMakeLoverOkDialogFragment.this.e);
                    bundle.putSerializable("chosen", LiveMakeLoverOkDialogFragment.this.g);
                    bundle.putSerializable("chooser", LiveMakeLoverOkDialogFragment.this.h);
                    liveMakeLoverOkFragment.setArguments(bundle);
                    return liveMakeLoverOkFragment;
                }
                LiveMakeLoverMatchFragment liveMakeLoverMatchFragment = new LiveMakeLoverMatchFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putLong("lid", LiveMakeLoverOkDialogFragment.this.e);
                bundle2.putInt("from", LiveMakeLoverOkDialogFragment.this.f);
                bundle2.putSerializable("chosen", LiveMakeLoverOkDialogFragment.this.g);
                bundle2.putSerializable("chooser", LiveMakeLoverOkDialogFragment.this.h);
                bundle2.putString("apngLocalUrl", LiveMakeLoverOkDialogFragment.this.i);
                liveMakeLoverMatchFragment.setArguments(bundle2);
                return liveMakeLoverMatchFragment;
            }
        };
    }

    public void j() {
        IDialogEvent iDialogEvent = this.d;
        if (iDialogEvent != null) {
            iDialogEvent.a();
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.blued.android.module.live_china.fragment.LiveBaseDialogFragment, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        j();
    }
}
