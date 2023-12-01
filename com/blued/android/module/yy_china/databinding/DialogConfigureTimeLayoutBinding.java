package com.blued.android.module.yy_china.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogConfigureTimeLayoutBinding.class */
public final class DialogConfigureTimeLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f16317a;
    private final ConstraintLayout b;

    private DialogConfigureTimeLayoutBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView) {
        this.b = constraintLayout;
        this.f16317a = recyclerView;
    }

    public static DialogConfigureTimeLayoutBinding a(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_time_list);
        if (recyclerView != null) {
            return new DialogConfigureTimeLayoutBinding((ConstraintLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("rvTimeList"));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.b;
    }
}
