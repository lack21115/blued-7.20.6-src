package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/PopDiscoveryFeedBinding.class */
public final class PopDiscoveryFeedBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29514a;
    public final ConstraintLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29515c;
    private final ConstraintLayout d;

    private PopDiscoveryFeedBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView) {
        this.d = constraintLayout;
        this.f29514a = imageView;
        this.b = constraintLayout2;
        this.f29515c = textView;
    }

    public static PopDiscoveryFeedBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(2131365477);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(2131369459);
            if (constraintLayout != null) {
                TextView textView = (TextView) view.findViewById(2131370786);
                if (textView != null) {
                    return new PopDiscoveryFeedBinding((ConstraintLayout) view, imageView, constraintLayout, textView);
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
