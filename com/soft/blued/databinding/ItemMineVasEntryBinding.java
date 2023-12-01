package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/ItemMineVasEntryBinding.class */
public final class ItemMineVasEntryBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f15550a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f15551c;
    public final LinearLayout d;
    public final TextView e;
    public final ShapeTextView f;
    public final TextView g;
    private final ShapeConstraintLayout h;

    private ItemMineVasEntryBinding(ShapeConstraintLayout shapeConstraintLayout, ShapeTextView shapeTextView, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, TextView textView, ShapeTextView shapeTextView2, TextView textView2) {
        this.h = shapeConstraintLayout;
        this.f15550a = shapeTextView;
        this.b = imageView;
        this.f15551c = imageView2;
        this.d = linearLayout;
        this.e = textView;
        this.f = shapeTextView2;
        this.g = textView2;
    }

    public static ItemMineVasEntryBinding a(View view) {
        String str;
        ShapeTextView findViewById = view.findViewById(R.id.iv_dot);
        if (findViewById != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_left);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_right);
                if (imageView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_icon);
                    if (linearLayout != null) {
                        TextView textView = (TextView) view.findViewById(2131371259);
                        if (textView != null) {
                            ShapeTextView findViewById2 = view.findViewById(R.id.tv_time);
                            if (findViewById2 != null) {
                                TextView textView2 = (TextView) view.findViewById(2131372754);
                                if (textView2 != null) {
                                    return new ItemMineVasEntryBinding((ShapeConstraintLayout) view, findViewById, imageView, imageView2, linearLayout, textView, findViewById2, textView2);
                                }
                                str = "tvTitle";
                            } else {
                                str = "tvTime";
                            }
                        } else {
                            str = "tvDes";
                        }
                    } else {
                        str = "llIcon";
                    }
                } else {
                    str = "ivRight";
                }
            } else {
                str = "ivLeft";
            }
        } else {
            str = "ivDot";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ShapeConstraintLayout getRoot() {
        return this.h;
    }
}
