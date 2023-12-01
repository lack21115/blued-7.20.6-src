package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/PopGuideAttachBinding.class */
public final class PopGuideAttachBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29535a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeLinearLayout f29536c;
    public final LinearLayout d;
    public final TextView e;
    private final LinearLayout f;

    private PopGuideAttachBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ShapeLinearLayout shapeLinearLayout, LinearLayout linearLayout2, TextView textView) {
        this.f = linearLayout;
        this.f29535a = imageView;
        this.b = imageView2;
        this.f29536c = shapeLinearLayout;
        this.d = linearLayout2;
        this.e = textView;
    }

    public static PopGuideAttachBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(2131362315);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(2131362316);
            if (imageView2 != null) {
                ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(2131362672);
                if (shapeLinearLayout != null) {
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(2131369461);
                    if (linearLayout != null) {
                        TextView textView = (TextView) view.findViewById(2131371675);
                        if (textView != null) {
                            return new PopGuideAttachBinding((LinearLayout) view, imageView, imageView2, shapeLinearLayout, linearLayout, textView);
                        }
                        str = "tvHint";
                    } else {
                        str = "rootView";
                    }
                } else {
                    str = "bubble";
                }
            } else {
                str = "arrowUp";
            }
        } else {
            str = "arrowDown";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.f;
    }
}
