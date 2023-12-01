package com.soft.blued.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FragmentWelcomeNewBinding.class */
public final class FragmentWelcomeNewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f15352a;

    private FragmentWelcomeNewBinding(ConstraintLayout constraintLayout) {
        this.f15352a = constraintLayout;
    }

    public static FragmentWelcomeNewBinding a(View view) {
        if (view != null) {
            return new FragmentWelcomeNewBinding((ConstraintLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f15352a;
    }
}
