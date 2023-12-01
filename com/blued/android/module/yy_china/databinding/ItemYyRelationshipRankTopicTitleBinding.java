package com.blued.android.module.yy_china.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyRelationshipRankTopicTitleBinding.class */
public final class ItemYyRelationshipRankTopicTitleBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16797a;
    public final ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    private final ConstraintLayout f16798c;

    private ItemYyRelationshipRankTopicTitleBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, ShapeTextView shapeTextView2) {
        this.f16798c = constraintLayout;
        this.f16797a = shapeTextView;
        this.b = shapeTextView2;
    }

    public static ItemYyRelationshipRankTopicTitleBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.iv);
        if (shapeTextView != null) {
            ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv);
            if (shapeTextView2 != null) {
                return new ItemYyRelationshipRankTopicTitleBinding((ConstraintLayout) view, shapeTextView, shapeTextView2);
            }
            str = "tv";
        } else {
            str = "iv";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f16798c;
    }
}
