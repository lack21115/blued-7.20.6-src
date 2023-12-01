package com.blued.android.framework.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.framework.R;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/activity/PreloadFragment.class */
public abstract class PreloadFragment extends KeyBoardFragment {
    protected View b;
    public boolean c;
    private boolean j;

    public abstract void a(View view);

    @Override // com.blued.android.framework.activity.keyboardpage.KeyBoardFragment, com.blued.android.framework.activity.HomeTabFragment, com.blued.android.core.ui.BaseFragment, com.blued.android.core.utils.PageTimeUtils.APMInterface
    public String getPageBizName() {
        return null;
    }

    @Override // com.blued.android.framework.activity.keyboardpage.KeyBoardFragment, com.blued.android.framework.activity.HomeTabFragment, com.blued.android.core.ui.BaseFragment
    public boolean isClosePageAPM() {
        return false;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_preload, viewGroup, false);
            boolean z = this.j;
            if (z) {
                setUserVisibleHint(z);
            }
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void setUserVisibleHint(boolean z) {
        View view;
        this.j = z;
        super.setUserVisibleHint(z);
        if (!z || this.c || (view = this.b) == null) {
            return;
        }
        a(view);
        this.c = true;
    }
}
