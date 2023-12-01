package com.blued.android.module.yy_china.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.HollowView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemTopicTypeBinding.class */
public final class ItemTopicTypeBinding implements ViewBinding {
    public final ShapeTextView a;
    public final HollowView b;
    private final ConstraintLayout c;

    private ItemTopicTypeBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, HollowView hollowView) {
        this.c = constraintLayout;
        this.a = shapeTextView;
        this.b = hollowView;
    }

    public static ItemTopicTypeBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv);
        if (shapeTextView != null) {
            HollowView hollowView = (HollowView) view.findViewById(R.id.tv_bg);
            if (hollowView != null) {
                return new ItemTopicTypeBinding((ConstraintLayout) view, shapeTextView, hollowView);
            }
            str = "tvBg";
        } else {
            str = "tv";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.c;
    }
}
