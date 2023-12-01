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
    public final ShapeTextView f29240a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f29241c;
    public final LinearLayout d;
    public final TextView e;
    public final ShapeTextView f;
    public final TextView g;
    private final ShapeConstraintLayout h;

    private ItemMineVasEntryBinding(ShapeConstraintLayout shapeConstraintLayout, ShapeTextView shapeTextView, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, TextView textView, ShapeTextView shapeTextView2, TextView textView2) {
        this.h = shapeConstraintLayout;
        this.f29240a = shapeTextView;
        this.b = imageView;
        this.f29241c = imageView2;
        this.d = linearLayout;
        this.e = textView;
        this.f = shapeTextView2;
        this.g = textView2;
    }

    public static ItemMineVasEntryBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(2131365270);
        if (shapeTextView != null) {
            ImageView imageView = (ImageView) view.findViewById(2131365540);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(2131365826);
                if (imageView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_icon);
                    if (linearLayout != null) {
                        TextView textView = (TextView) view.findViewById(2131371259);
                        if (textView != null) {
                            ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(2131372721);
                            if (shapeTextView2 != null) {
                                TextView textView2 = (TextView) view.findViewById(2131372754);
                                if (textView2 != null) {
                                    return new ItemMineVasEntryBinding((ShapeConstraintLayout) view, shapeTextView, imageView, imageView2, linearLayout, textView, shapeTextView2, textView2);
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
