package com.blued.android.framework.activity;

import android.os.Bundle;
import android.view.View;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/activity/HomeTabFragment.class */
public abstract class HomeTabFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    public boolean f9776a = false;

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.utils.PageTimeUtils.APMInterface
    public String getPageBizName() {
        return super.getPageBizName();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public boolean isClosePageAPM() {
        return super.isClosePageAPM();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.f9776a) {
            return;
        }
        if (!x_()) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + StatusBarHelper.a(getContext()), view.getPaddingRight(), view.getPaddingBottom());
        }
        this.f9776a = true;
    }

    public abstract boolean x_();
}
