package com.soft.blued.ui.user.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.anythink.expressad.a;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.base.dialog.CommonDialogFragment;
import com.soft.blued.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VIPInvisibleToUserDialogFragment.class */
public class VIPInvisibleToUserDialogFragment extends CommonDialogFragment {
    private String b = "";

    public void a(View view) {
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.b = str;
    }

    public int d() {
        return R.layout.dialog_fragment_filter;
    }

    public int f() {
        return (int) ((AppInfo.m / 6.0f) * 5);
    }

    public final String h() {
        return this.b;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, a.B);
        super.onViewCreated(view, bundle);
        VipInvisibleToUserFragment vipInvisibleToUserFragment = new VipInvisibleToUserFragment();
        vipInvisibleToUserFragment.a(this);
        Bundle bundle2 = new Bundle();
        bundle2.putString("KEY_VIP_DETAIL", this.b);
        vipInvisibleToUserFragment.setArguments(bundle2);
        getChildFragmentManager().beginTransaction().replace(R.id.fm_content, (Fragment) vipInvisibleToUserFragment).commitAllowingStateLoss();
    }
}
