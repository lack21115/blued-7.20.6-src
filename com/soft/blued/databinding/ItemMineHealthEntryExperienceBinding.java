package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/ItemMineHealthEntryExperienceBinding.class */
public final class ItemMineHealthEntryExperienceBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeConstraintLayout f15535a;
    public final ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f15536c;
    public final TextView d;
    public final TextView e;
    private final ShapeConstraintLayout f;

    private ItemMineHealthEntryExperienceBinding(ShapeConstraintLayout shapeConstraintLayout, ShapeConstraintLayout shapeConstraintLayout2, ShapeTextView shapeTextView, ImageView imageView, TextView textView, TextView textView2) {
        this.f = shapeConstraintLayout;
        this.f15535a = shapeConstraintLayout2;
        this.b = shapeTextView;
        this.f15536c = imageView;
        this.d = textView;
        this.e = textView2;
    }

    public static ItemMineHealthEntryExperienceBinding a(View view) {
        String str;
        ShapeConstraintLayout findViewById = view.findViewById(2131363075);
        if (findViewById != null) {
            ShapeTextView findViewById2 = view.findViewById(R.id.iv_dot);
            if (findViewById2 != null) {
                ImageView imageView = (ImageView) view.findViewById(2131365504);
                if (imageView != null) {
                    TextView textView = (TextView) view.findViewById(2131371259);
                    if (textView != null) {
                        TextView textView2 = (TextView) view.findViewById(2131372754);
                        if (textView2 != null) {
                            return new ItemMineHealthEntryExperienceBinding((ShapeConstraintLayout) view, findViewById, findViewById2, imageView, textView, textView2);
                        }
                        str = "tvTitle";
                    } else {
                        str = "tvDes";
                    }
                } else {
                    str = "ivIcon";
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
        return this.f;
    }
}
