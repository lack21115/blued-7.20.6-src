package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.view.MarqueeTextView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveOperationDescViewBinding.class */
public final class LiveOperationDescViewBinding implements ViewBinding {
    public final ShapeFrameLayout a;
    public final ImageView b;
    public final RelativeLayout c;
    public final MarqueeTextView d;
    public final ShapeTextView e;
    public final TextView f;
    private final RelativeLayout g;

    private LiveOperationDescViewBinding(RelativeLayout relativeLayout, ShapeFrameLayout shapeFrameLayout, ImageView imageView, RelativeLayout relativeLayout2, MarqueeTextView marqueeTextView, ShapeTextView shapeTextView, TextView textView) {
        this.g = relativeLayout;
        this.a = shapeFrameLayout;
        this.b = imageView;
        this.c = relativeLayout2;
        this.d = marqueeTextView;
        this.e = shapeTextView;
        this.f = textView;
    }

    public static LiveOperationDescViewBinding a(View view) {
        String str;
        ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) view.findViewById(R.id.fl_title_root);
        if (shapeFrameLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_desc_icon);
            if (imageView != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_icon_root);
                if (relativeLayout != null) {
                    MarqueeTextView marqueeTextView = (MarqueeTextView) view.findViewById(R.id.tv_des);
                    if (marqueeTextView != null) {
                        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_tag);
                        if (shapeTextView != null) {
                            TextView textView = (TextView) view.findViewById(R.id.tv_title);
                            if (textView != null) {
                                return new LiveOperationDescViewBinding((RelativeLayout) view, shapeFrameLayout, imageView, relativeLayout, marqueeTextView, shapeTextView, textView);
                            }
                            str = "tvTitle";
                        } else {
                            str = "tvTag";
                        }
                    } else {
                        str = "tvDes";
                    }
                } else {
                    str = "rlIconRoot";
                }
            } else {
                str = "ivDescIcon";
            }
        } else {
            str = "flTitleRoot";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.g;
    }
}
