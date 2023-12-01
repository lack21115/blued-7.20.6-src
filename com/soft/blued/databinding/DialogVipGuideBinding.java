package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/DialogVipGuideBinding.class */
public final class DialogVipGuideBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f28728a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    private final ConstraintLayout f28729c;

    private DialogVipGuideBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        this.f28729c = constraintLayout;
        this.f28728a = imageView;
        this.b = textView;
    }

    public static DialogVipGuideBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(2131365126);
        if (imageView != null) {
            TextView textView = (TextView) view.findViewById(2131371164);
            if (textView != null) {
                return new DialogVipGuideBinding((ConstraintLayout) view, imageView, textView);
            }
            str = "tvConfirm";
        } else {
            str = "ivBg";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f28729c;
    }
}
