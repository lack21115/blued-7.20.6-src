package com.soft.blued.databinding;

import android.view.View;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/ItemMineHealthEntryExperienceMidBinding.class */
public final class ItemMineHealthEntryExperienceMidBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeConstraintLayout f15537a;
    public final ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f15538c;
    public final ViewFlipper d;
    private final ShapeConstraintLayout e;

    private ItemMineHealthEntryExperienceMidBinding(ShapeConstraintLayout shapeConstraintLayout, ShapeConstraintLayout shapeConstraintLayout2, ShapeTextView shapeTextView, TextView textView, ViewFlipper viewFlipper) {
        this.e = shapeConstraintLayout;
        this.f15537a = shapeConstraintLayout2;
        this.b = shapeTextView;
        this.f15538c = textView;
        this.d = viewFlipper;
    }

    public static ItemMineHealthEntryExperienceMidBinding a(View view) {
        String str;
        ShapeConstraintLayout findViewById = view.findViewById(2131363075);
        if (findViewById != null) {
            ShapeTextView findViewById2 = view.findViewById(R.id.iv_dot);
            if (findViewById2 != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_divider);
                if (textView != null) {
                    ViewFlipper viewFlipper = (ViewFlipper) view.findViewById(R.id.vf_health_goods);
                    if (viewFlipper != null) {
                        return new ItemMineHealthEntryExperienceMidBinding((ShapeConstraintLayout) view, findViewById, findViewById2, textView, viewFlipper);
                    }
                    str = "vfHealthGoods";
                } else {
                    str = "tvDivider";
                }
            } else {
                str = "ivDot";
            }
        } else {
            str = "contentView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ShapeConstraintLayout getRoot() {
        return this.e;
    }
}
