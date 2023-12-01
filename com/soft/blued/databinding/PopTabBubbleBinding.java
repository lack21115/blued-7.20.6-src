package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/PopTabBubbleBinding.class */
public final class PopTabBubbleBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f15867a;
    public final ConstraintLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f15868c;
    private final ConstraintLayout d;

    private PopTabBubbleBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView) {
        this.d = constraintLayout;
        this.f15867a = imageView;
        this.b = constraintLayout2;
        this.f15868c = textView;
    }

    public static PopTabBubbleBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_header);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(2131369459);
            if (constraintLayout != null) {
                TextView textView = (TextView) view.findViewById(2131370786);
                if (textView != null) {
                    return new PopTabBubbleBinding((ConstraintLayout) view, imageView, constraintLayout, textView);
                }
                str = "tv";
            } else {
                str = "root";
            }
        } else {
            str = "ivHeader";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.d;
    }
}
