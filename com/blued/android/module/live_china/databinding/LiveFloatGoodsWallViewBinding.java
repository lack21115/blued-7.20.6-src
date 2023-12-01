package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.view.LineProgressView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveFloatGoodsWallViewBinding.class */
public final class LiveFloatGoodsWallViewBinding implements ViewBinding {
    public final FrameLayout a;
    public final ImageView b;
    public final TextView c;
    public final TextView d;
    public final LineProgressView e;
    private final FrameLayout f;

    private LiveFloatGoodsWallViewBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, TextView textView, TextView textView2, LineProgressView lineProgressView) {
        this.f = frameLayout;
        this.a = frameLayout2;
        this.b = imageView;
        this.c = textView;
        this.d = textView2;
        this.e = lineProgressView;
    }

    public static LiveFloatGoodsWallViewBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_root);
        if (frameLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_icon);
            if (imageView != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_progress);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_title);
                    if (textView2 != null) {
                        LineProgressView lineProgressView = (LineProgressView) view.findViewById(R.id.view_progress);
                        if (lineProgressView != null) {
                            return new LiveFloatGoodsWallViewBinding((FrameLayout) view, frameLayout, imageView, textView, textView2, lineProgressView);
                        }
                        str = "viewProgress";
                    } else {
                        str = "tvTitle";
                    }
                } else {
                    str = "tvProgress";
                }
            } else {
                str = "ivIcon";
            }
        } else {
            str = "flRoot";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.f;
    }
}
