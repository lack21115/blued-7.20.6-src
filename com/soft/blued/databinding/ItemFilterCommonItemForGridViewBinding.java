package com.soft.blued.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/ItemFilterCommonItemForGridViewBinding.class */
public final class ItemFilterCommonItemForGridViewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeLinearLayout f15484a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f15485c;
    private final LinearLayout d;

    private ItemFilterCommonItemForGridViewBinding(LinearLayout linearLayout, ShapeLinearLayout shapeLinearLayout, TextView textView, TextView textView2) {
        this.d = linearLayout;
        this.f15484a = shapeLinearLayout;
        this.b = textView;
        this.f15485c = textView2;
    }

    public static ItemFilterCommonItemForGridViewBinding a(View view) {
        String str;
        ShapeLinearLayout findViewById = view.findViewById(R.id.item_view);
        if (findViewById != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_desc);
            if (textView != null) {
                TextView textView2 = (TextView) view.findViewById(2131372754);
                if (textView2 != null) {
                    return new ItemFilterCommonItemForGridViewBinding((LinearLayout) view, findViewById, textView, textView2);
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
