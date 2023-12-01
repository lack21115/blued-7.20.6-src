package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewAdInGiftListBinding.class */
public final class ViewAdInGiftListBinding implements ViewBinding {
    public final ImageView a;
    public final ConstraintLayout b;
    public final ConstraintLayout c;
    public final ShapeTextView d;
    private final FrameLayout e;

    private ViewAdInGiftListBinding(FrameLayout frameLayout, ImageView imageView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ShapeTextView shapeTextView) {
        this.e = frameLayout;
        this.a = imageView;
        this.b = constraintLayout;
        this.c = constraintLayout2;
        this.d = shapeTextView;
    }

    public static ViewAdInGiftListBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_ad_in_gift_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewAdInGiftListBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.img_ad_background);
        if (imageView != null) {
            ConstraintLayout findViewById = view.findViewById(R.id.ll_ad_activity);
            if (findViewById != null) {
                ConstraintLayout findViewById2 = view.findViewById(R.id.ll_ad_recharge);
                if (findViewById2 != null) {
                    ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_ad_content);
                    if (shapeTextView != null) {
                        return new ViewAdInGiftListBinding((FrameLayout) view, imageView, findViewById, findViewById2, shapeTextView);
                    }
                    str = "tvAdContent";
                } else {
                    str = "llAdRecharge";
                }
            } else {
                str = "llAdActivity";
            }
        } else {
            str = "imgAdBackground";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.e;
    }
}
