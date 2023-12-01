package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveOperationChildDefaultViewBinding.class */
public final class LiveOperationChildDefaultViewBinding implements ViewBinding {
    public final ShapeFrameLayout a;
    public final ImageView b;
    public final RelativeLayout c;
    public final ShapeTextView d;
    public final TextView e;
    private final RelativeLayout f;

    private LiveOperationChildDefaultViewBinding(RelativeLayout relativeLayout, ShapeFrameLayout shapeFrameLayout, ImageView imageView, RelativeLayout relativeLayout2, ShapeTextView shapeTextView, TextView textView) {
        this.f = relativeLayout;
        this.a = shapeFrameLayout;
        this.b = imageView;
        this.c = relativeLayout2;
        this.d = shapeTextView;
        this.e = textView;
    }

    public static LiveOperationChildDefaultViewBinding a(View view) {
        String str;
        ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) view.findViewById(R.id.fl_title_root);
        if (shapeFrameLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_icon);
            if (imageView != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_root);
                if (relativeLayout != null) {
                    ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_tag);
                    if (shapeTextView != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_title);
                        if (textView != null) {
                            return new LiveOperationChildDefaultViewBinding((RelativeLayout) view, shapeFrameLayout, imageView, relativeLayout, shapeTextView, textView);
                        }
                        str = "tvTitle";
                    } else {
                        str = "tvTag";
                    }
                } else {
                    str = "rlRoot";
                }
            } else {
                str = "ivIcon";
            }
        } else {
            str = "flTitleRoot";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.f;
    }
}
