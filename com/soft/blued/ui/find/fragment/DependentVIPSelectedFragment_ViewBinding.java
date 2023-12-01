package com.soft.blued.ui.find.fragment;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/DependentVIPSelectedFragment_ViewBinding.class */
public class DependentVIPSelectedFragment_ViewBinding implements Unbinder {
    private DependentVIPSelectedFragment b;

    public DependentVIPSelectedFragment_ViewBinding(DependentVIPSelectedFragment dependentVIPSelectedFragment, View view) {
        this.b = dependentVIPSelectedFragment;
        dependentVIPSelectedFragment.title = (CommonTopTitleNoTrans) Utils.a(view, 2131370694, "field 'title'", CommonTopTitleNoTrans.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        DependentVIPSelectedFragment dependentVIPSelectedFragment = this.b;
        if (dependentVIPSelectedFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        dependentVIPSelectedFragment.title = null;
    }
}
