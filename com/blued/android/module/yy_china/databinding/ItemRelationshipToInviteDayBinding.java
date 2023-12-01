package com.blued.android.module.yy_china.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemRelationshipToInviteDayBinding.class */
public final class ItemRelationshipToInviteDayBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16649a;
    private final ConstraintLayout b;

    private ItemRelationshipToInviteDayBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView) {
        this.b = constraintLayout;
        this.f16649a = shapeTextView;
    }

    public static ItemRelationshipToInviteDayBinding a(View view) {
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_day);
        if (shapeTextView != null) {
            return new ItemRelationshipToInviteDayBinding((ConstraintLayout) view, shapeTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("tvDay"));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.b;
    }
}
