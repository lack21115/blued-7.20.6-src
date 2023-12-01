package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/ItemMineZhealthEntryBinding.class */
public final class ItemMineZhealthEntryBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeConstraintLayout f15555a;
    public final ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f15556c;
    public final ImageView d;
    public final LinearLayout e;
    public final TextView f;
    public final TextView g;
    private final ShapeConstraintLayout h;

    private ItemMineZhealthEntryBinding(ShapeConstraintLayout shapeConstraintLayout, ShapeConstraintLayout shapeConstraintLayout2, ShapeTextView shapeTextView, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.h = shapeConstraintLayout;
        this.f15555a = shapeConstraintLayout2;
        this.b = shapeTextView;
        this.f15556c = imageView;
        this.d = imageView2;
        this.e = linearLayout;
        this.f = textView;
        this.g = textView2;
    }

    public static ItemMineZhealthEntryBinding a(View view) {
        String str;
        ShapeConstraintLayout findViewById = view.findViewById(2131363075);
        if (findViewById != null) {
            ShapeTextView findViewById2 = view.findViewById(R.id.iv_dot);
            if (findViewById2 != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_icon1);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_icon2);
                    if (imageView2 != null) {
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_icon);
                        if (linearLayout != null) {
                            TextView textView = (TextView) view.findViewById(2131371259);
                            if (textView != null) {
                                TextView textView2 = (TextView) view.findViewById(2131372754);
                                if (textView2 != null) {
                                    return new ItemMineZhealthEntryBinding((ShapeConstraintLayout) view, findViewById, findViewById2, imageView, imageView2, linearLayout, textView, textView2);
                                }
                                str = "tvTitle";
                            } else {
                                str = "tvDes";
                            }
                        } else {
                            str = "llIcon";
                        }
                    } else {
                        str = "ivIcon2";
                    }
                } else {
                    str = "ivIcon1";
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
        return this.h;
    }
}
