package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/PopSpecialCareBinding.class */
public final class PopSpecialCareBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f15865a;
    public final ConstraintLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f15866c;
    public final TextView d;
    private final ConstraintLayout e;

    private PopSpecialCareBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView, TextView textView2) {
        this.e = constraintLayout;
        this.f15865a = imageView;
        this.b = constraintLayout2;
        this.f15866c = textView;
        this.d = textView2;
    }

    public static PopSpecialCareBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(2131365207);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(2131367744);
            if (constraintLayout != null) {
                TextView textView = (TextView) view.findViewById(2131371186);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(2131372754);
                    if (textView2 != null) {
                        return new PopSpecialCareBinding((ConstraintLayout) view, imageView, constraintLayout, textView, textView2);
                    }
                    str = "tvTitle";
                } else {
                    str = "tvContent";
                }
            } else {
                str = "llDialog";
            }
        } else {
            str = "ivClose";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.e;
    }
}
