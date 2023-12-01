package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewDecorateCarTabBinding.class */
public final class ViewDecorateCarTabBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f16850a;
    public final View b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16851c;
    private final ConstraintLayout d;

    private ViewDecorateCarTabBinding(ConstraintLayout constraintLayout, ImageView imageView, View view, TextView textView) {
        this.d = constraintLayout;
        this.f16850a = imageView;
        this.b = view;
        this.f16851c = textView;
    }

    public static ViewDecorateCarTabBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_decorate_car_tab, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewDecorateCarTabBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.img_checked_tab);
        if (imageView != null) {
            View findViewById = view.findViewById(R.id.img_point);
            if (findViewById != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_tab_name);
                if (textView != null) {
                    return new ViewDecorateCarTabBinding((ConstraintLayout) view, imageView, findViewById, textView);
                }
                str = "tvTabName";
            } else {
                str = "imgPoint";
            }
        } else {
            str = "imgCheckedTab";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.d;
    }
}
