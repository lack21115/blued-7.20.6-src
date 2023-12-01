package com.blued.android.module.yy_china.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyHotTopicTitleBinding.class */
public final class ItemYyHotTopicTitleBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16743a;
    private final ConstraintLayout b;

    private ItemYyHotTopicTitleBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView) {
        this.b = constraintLayout;
        this.f16743a = shapeTextView;
    }

    public static ItemYyHotTopicTitleBinding a(View view) {
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv);
        if (shapeTextView != null) {
            return new ItemYyHotTopicTitleBinding((ConstraintLayout) view, shapeTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("tv"));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.b;
    }
}
