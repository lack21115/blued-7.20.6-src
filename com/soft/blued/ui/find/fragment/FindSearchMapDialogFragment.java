package com.soft.blued.ui.find.fragment;

import android.os.Bundle;
import android.view.View;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.base.dialog.CommonDialogFragment;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/FindSearchMapDialogFragment.class */
public class FindSearchMapDialogFragment extends CommonDialogFragment {
    @Override // com.blued.android.module.common.base.dialog.CommonDialogFragment
    public void a(View view) {
    }

    @Override // com.blued.android.module.common.base.dialog.CommonDialogFragment
    public int d() {
        return R.layout.dialog_fragment_filter;
    }

    @Override // com.blued.android.module.common.base.dialog.CommonDialogFragment
    public int f() {
        return (int) ((AppInfo.m / 11.0f) * 10.0f);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FindSearchMapActivity findSearchMapActivity = new FindSearchMapActivity();
        findSearchMapActivity.setArguments(getArguments());
        getChildFragmentManager().beginTransaction().replace(R.id.fm_content, findSearchMapActivity).commitAllowingStateLoss();
    }
}
