package com.soft.blued.ui.find.fragment;

import android.os.Bundle;
import android.view.View;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.base.dialog.CommonDialogFragment;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/FindSearchMapDialogFragment.class */
public class FindSearchMapDialogFragment extends CommonDialogFragment {
    public void a(View view) {
    }

    public int d() {
        return R.layout.dialog_fragment_filter;
    }

    public int f() {
        return (int) ((AppInfo.m / 11.0f) * 10.0f);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.fragment.app.Fragment, com.soft.blued.ui.find.fragment.FindSearchMapActivity] */
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ?? findSearchMapActivity = new FindSearchMapActivity();
        findSearchMapActivity.setArguments(getArguments());
        getChildFragmentManager().beginTransaction().replace(R.id.fm_content, findSearchMapActivity).commitAllowingStateLoss();
    }
}
