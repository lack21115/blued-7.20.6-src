package com.blued.android.framework.ui.viewbinding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpPresenter;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/viewbinding/ViewBindingFragment.class */
public abstract class ViewBindingFragment<T extends MvpPresenter> extends MvpFragment<T> {
    public abstract View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.i != null) {
            if (this.i.getParent() != null) {
                ((ViewGroup) this.i.getParent()).removeView(this.i);
            }
            return this.i;
        }
        this.i = a(layoutInflater, viewGroup, bundle);
        if (this.h != null) {
            this.h.a(getActivity(), this);
        }
        return this.i;
    }
}
