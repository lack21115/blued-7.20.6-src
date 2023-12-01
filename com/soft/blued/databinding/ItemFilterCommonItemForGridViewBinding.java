package com.soft.blued.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/ItemFilterCommonItemForGridViewBinding.class */
public final class ItemFilterCommonItemForGridViewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeLinearLayout f29174a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29175c;
    private final LinearLayout d;

    private ItemFilterCommonItemForGridViewBinding(LinearLayout linearLayout, ShapeLinearLayout shapeLinearLayout, TextView textView, TextView textView2) {
        this.d = linearLayout;
        this.f29174a = shapeLinearLayout;
        this.b = textView;
        this.f29175c = textView2;
    }

    public static ItemFilterCommonItemForGridViewBinding a(View view) {
        String str;
        ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(2131364999);
        if (shapeLinearLayout != null) {
            TextView textView = (TextView) view.findViewById(2131371262);
            if (textView != null) {
                TextView textView2 = (TextView) view.findViewById(2131372754);
                if (textView2 != null) {
                    return new ItemFilterCommonItemForGridViewBinding((LinearLayout) view, shapeLinearLayout, textView, textView2);
                }
                str = "tvTitle";
            } else {
                str = "tvDesc";
            }
        } else {
            str = "itemView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.d;
    }
}
