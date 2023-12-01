package com.soft.blued.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/ItemUserTagNewBinding.class */
public final class ItemUserTagNewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeLinearLayout f15649a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayout f15650c;

    private ItemUserTagNewBinding(LinearLayout linearLayout, ShapeLinearLayout shapeLinearLayout, TextView textView) {
        this.f15650c = linearLayout;
        this.f15649a = shapeLinearLayout;
        this.b = textView;
    }

    public static ItemUserTagNewBinding a(View view) {
        String str;
        ShapeLinearLayout findViewById = view.findViewById(R.id.item_view);
        if (findViewById != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_tag);
            if (textView != null) {
                return new ItemUserTagNewBinding((LinearLayout) view, findViewById, textView);
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
        return this.f15650c;
    }
}
