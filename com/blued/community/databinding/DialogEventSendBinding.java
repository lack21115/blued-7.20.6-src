package com.blued.community.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/DialogEventSendBinding.class */
public final class DialogEventSendBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f18796a;
    private final ConstraintLayout b;

    private DialogEventSendBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView) {
        this.b = constraintLayout;
        this.f18796a = shapeTextView;
    }

    public static DialogEventSendBinding a(View view) {
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_ok);
        if (shapeTextView != null) {
            return new DialogEventSendBinding((ConstraintLayout) view, shapeTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("tvOk"));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.b;
    }
}
