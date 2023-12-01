package com.soft.blued.ui.user.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.anythink.expressad.a;
import com.soft.blued.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/SpecialCareDialogFragment.class */
public final class SpecialCareDialogFragment extends VIPInvisibleToUserDialogFragment {
    @Override // com.soft.blued.ui.user.fragment.VIPInvisibleToUserDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, a.B);
        super.onViewCreated(view, bundle);
        VIPSpecialCareFragment vIPSpecialCareFragment = new VIPSpecialCareFragment();
        vIPSpecialCareFragment.a(this);
        Bundle bundle2 = new Bundle();
        bundle2.putString("KEY_VIP_DETAIL", h());
        vIPSpecialCareFragment.setArguments(bundle2);
        getChildFragmentManager().beginTransaction().replace(R.id.fm_content, (Fragment) vIPSpecialCareFragment).commitAllowingStateLoss();
    }
}
