package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/ItemMineHealthyBannerBinding.class */
public final class ItemMineHealthyBannerBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29231a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29232c;
    private final LinearLayout d;

    private ItemMineHealthyBannerBinding(LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.d = linearLayout;
        this.f29231a = imageView;
        this.b = textView;
        this.f29232c = textView2;
    }

    public static ItemMineHealthyBannerBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(2131365504);
        if (imageView != null) {
            TextView textView = (TextView) view.findViewById(2131371259);
            if (textView != null) {
                TextView textView2 = (TextView) view.findViewById(2131372754);
                if (textView2 != null) {
                    return new ItemMineHealthyBannerBinding((LinearLayout) view, imageView, textView, textView2);
                }
                str = "tvTitle";
            } else {
                str = "tvDes";
            }
        } else {
            str = "ivIcon";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.d;
    }
}
