package com.soft.blued.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/ItemUserTagNewBinding.class */
public final class ItemUserTagNewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeLinearLayout f29339a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayout f29340c;

    private ItemUserTagNewBinding(LinearLayout linearLayout, ShapeLinearLayout shapeLinearLayout, TextView textView) {
        this.f29340c = linearLayout;
        this.f29339a = shapeLinearLayout;
        this.b = textView;
    }

    public static ItemUserTagNewBinding a(View view) {
        String str;
        ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(2131364999);
        if (shapeLinearLayout != null) {
            TextView textView = (TextView) view.findViewById(2131372678);
            if (textView != null) {
                return new ItemUserTagNewBinding((LinearLayout) view, shapeLinearLayout, textView);
            }
            str = "tvTag";
        } else {
            str = "itemView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.f29340c;
    }
}
