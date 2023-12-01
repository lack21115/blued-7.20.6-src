package com.soft.blued.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/PopGroupRecoverSuperBinding.class */
public final class PopGroupRecoverSuperBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f29531a;
    public final ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f29532c;
    public final TextView d;
    private final ShapeLinearLayout e;

    private PopGroupRecoverSuperBinding(ShapeLinearLayout shapeLinearLayout, RecyclerView recyclerView, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, TextView textView) {
        this.e = shapeLinearLayout;
        this.f29531a = recyclerView;
        this.b = shapeTextView;
        this.f29532c = shapeTextView2;
        this.d = textView;
    }

    public static PopGroupRecoverSuperBinding a(View view) {
        String str;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.groupList);
        if (recyclerView != null) {
            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(2131371051);
            if (shapeTextView != null) {
                ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(2131371164);
                if (shapeTextView2 != null) {
                    TextView textView = (TextView) view.findViewById(2131371675);
                    if (textView != null) {
                        return new PopGroupRecoverSuperBinding((ShapeLinearLayout) view, recyclerView, shapeTextView, shapeTextView2, textView);
                    }
                    str = "tvHint";
                } else {
                    str = "tvConfirm";
                }
            } else {
                str = "tvCancel";
            }
        } else {
            str = "groupList";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ShapeLinearLayout getRoot() {
        return this.e;
    }
}
