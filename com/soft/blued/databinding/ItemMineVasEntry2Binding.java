package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/ItemMineVasEntry2Binding.class */
public final class ItemMineVasEntry2Binding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f15546a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f15547c;
    public final TextView d;
    public final ShapeTextView e;
    public final TextView f;
    private final ShapeConstraintLayout g;

    private ItemMineVasEntry2Binding(ShapeConstraintLayout shapeConstraintLayout, ShapeTextView shapeTextView, ImageView imageView, ImageView imageView2, TextView textView, ShapeTextView shapeTextView2, TextView textView2) {
        this.g = shapeConstraintLayout;
        this.f15546a = shapeTextView;
        this.b = imageView;
        this.f15547c = imageView2;
        this.d = textView;
        this.e = shapeTextView2;
        this.f = textView2;
    }

    public static ItemMineVasEntry2Binding a(View view) {
        String str;
        ShapeTextView findViewById = view.findViewById(R.id.iv_dot);
        if (findViewById != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_left);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_right);
                if (imageView2 != null) {
                    TextView textView = (TextView) view.findViewById(2131371259);
                    if (textView != null) {
                        ShapeTextView findViewById2 = view.findViewById(R.id.tv_time);
                        if (findViewById2 != null) {
                            TextView textView2 = (TextView) view.findViewById(2131372754);
                            if (textView2 != null) {
                                return new ItemMineVasEntry2Binding((ShapeConstraintLayout) view, findViewById, imageView, imageView2, textView, findViewById2, textView2);
                            }
                            str = "tvTitle";
                        } else {
                            str = "tvTime";
                        }
                    } else {
                        str = "tvDes";
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
        return this.g;
    }
}
