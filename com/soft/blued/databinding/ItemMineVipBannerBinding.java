package com.soft.blued.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/ItemMineVipBannerBinding.class */
public final class ItemMineVipBannerBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f15553a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayout f15554c;

    private ItemMineVipBannerBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView) {
        this.f15554c = linearLayout;
        this.f15553a = linearLayout2;
        this.b = textView;
    }

    public static ItemMineVipBannerBinding a(View view) {
        String str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(2131366742);
        if (linearLayout != null) {
            TextView textView = (TextView) view.findViewById(2131371186);
            if (textView != null) {
                return new ItemMineVipBannerBinding((LinearLayout) view, linearLayout, textView);
            }
            str = "tvContent";
        } else {
            str = "layout";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.f15554c;
    }
}
