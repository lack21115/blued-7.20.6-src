package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/ItemFilterNewConstellationBinding.class */
public final class ItemFilterNewConstellationBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f29176a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29177c;
    private final LinearLayout d;

    private ItemFilterNewConstellationBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, TextView textView) {
        this.d = linearLayout;
        this.f29176a = linearLayout2;
        this.b = imageView;
        this.f29177c = textView;
    }

    public static ItemFilterNewConstellationBinding a(View view) {
        String str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(2131364999);
        if (linearLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(2131365217);
            if (imageView != null) {
                TextView textView = (TextView) view.findViewById(2131371168);
                if (textView != null) {
                    return new ItemFilterNewConstellationBinding((LinearLayout) view, linearLayout, imageView, textView);
                }
                str = "tvConstellation";
            } else {
                str = "ivConstellation";
            }
        } else {
            str = "itemView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.d;
    }
}
