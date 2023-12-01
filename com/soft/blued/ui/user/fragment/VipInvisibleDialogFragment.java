package com.soft.blued.ui.user.fragment;

import android.os.Bundle;
import android.view.View;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.base.dialog.CommonDialogFragment;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VipInvisibleDialogFragment.class */
public class VipInvisibleDialogFragment extends CommonDialogFragment {
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f34162c;

    @Override // com.blued.android.module.common.base.dialog.CommonDialogFragment
    public void a(View view) {
    }

    @Override // com.blued.android.module.common.base.dialog.CommonDialogFragment
    public int d() {
        return R.layout.dialog_fragment_filter;
    }

    @Override // com.blued.android.module.common.base.dialog.CommonDialogFragment
    public int f() {
        return (int) ((AppInfo.m / 6.0f) * 5.0f);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        VipInvisibleFragment vipInvisibleFragment = new VipInvisibleFragment();
        vipInvisibleFragment.f34163a = this;
        Bundle bundle2 = new Bundle();
        bundle2.putString("title", this.b);
        bundle2.putString("KEY_VIP_DETAIL", this.f34162c);
        vipInvisibleFragment.setArguments(bundle2);
        getChildFragmentManager().beginTransaction().replace(R.id.fm_content, vipInvisibleFragment).commitAllowingStateLoss();
    }
}
