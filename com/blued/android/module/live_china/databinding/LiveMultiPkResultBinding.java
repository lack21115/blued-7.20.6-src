package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveMultiPkResultBinding.class */
public final class LiveMultiPkResultBinding implements ViewBinding {
    public final ImageView a;
    public final ImageView b;
    public final ImageView c;
    private final FrameLayout d;

    private LiveMultiPkResultBinding(FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3) {
        this.d = frameLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = imageView3;
    }

    public static LiveMultiPkResultBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_multi_pk_result, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveMultiPkResultBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.live_pk_bg);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.live_pk_icon);
            if (imageView2 != null) {
                ImageView imageView3 = (ImageView) view.findViewById(R.id.live_pk_star);
                if (imageView3 != null) {
                    return new LiveMultiPkResultBinding((FrameLayout) view, imageView, imageView2, imageView3);
                }
                str = "livePkStar";
            } else {
                str = "livePkIcon";
            }
        } else {
            str = "livePkBg";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.d;
    }
}
