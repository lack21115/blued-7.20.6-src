package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LayoutOnlineUserTipsBinding.class */
public final class LayoutOnlineUserTipsBinding implements ViewBinding {
    public final ImageView a;
    public final ShapeTextView b;
    private final ConstraintLayout c;

    private LayoutOnlineUserTipsBinding(ConstraintLayout constraintLayout, ImageView imageView, ShapeTextView shapeTextView) {
        this.c = constraintLayout;
        this.a = imageView;
        this.b = shapeTextView;
    }

    public static LayoutOnlineUserTipsBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_online_user_tips, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LayoutOnlineUserTipsBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.img_up_arrow);
        if (imageView != null) {
            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.stv_online_user_tips);
            if (shapeTextView != null) {
                return new LayoutOnlineUserTipsBinding((ConstraintLayout) view, imageView, shapeTextView);
            }
            str = "stvOnlineUserTips";
        } else {
            str = "imgUpArrow";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.c;
    }
}
