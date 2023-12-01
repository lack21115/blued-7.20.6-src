package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ViewFlipper;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LayoutLiveHotRedBinding.class */
public final class LayoutLiveHotRedBinding implements ViewBinding {
    public final ImageView a;
    public final ImageView b;
    public final ViewFlipper c;
    public final ImageView d;
    private final FrameLayout e;

    private LayoutLiveHotRedBinding(FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ViewFlipper viewFlipper, ImageView imageView3) {
        this.e = frameLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = viewFlipper;
        this.d = imageView3;
    }

    public static LayoutLiveHotRedBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_live_hot_red, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LayoutLiveHotRedBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.flipper_next);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.flipper_pre);
            if (imageView2 != null) {
                ViewFlipper viewFlipper = (ViewFlipper) view.findViewById(R.id.flipper_recommend_hot_red_anchor);
                if (viewFlipper != null) {
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.flipper_show);
                    if (imageView3 != null) {
                        return new LayoutLiveHotRedBinding((FrameLayout) view, imageView, imageView2, viewFlipper, imageView3);
                    }
                    str = "flipperShow";
                } else {
                    str = "flipperRecommendHotRedAnchor";
                }
            } else {
                str = "flipperPre";
            }
        } else {
            str = "flipperNext";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.e;
    }
}
