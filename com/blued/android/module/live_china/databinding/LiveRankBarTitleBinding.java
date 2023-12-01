package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveRankBarTitleBinding.class */
public final class LiveRankBarTitleBinding implements ViewBinding {
    public final ImageView a;
    public final TextView b;
    private final RelativeLayout c;

    private LiveRankBarTitleBinding(RelativeLayout relativeLayout, ImageView imageView, TextView textView) {
        this.c = relativeLayout;
        this.a = imageView;
        this.b = textView;
    }

    public static LiveRankBarTitleBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
        if (imageView != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_title);
            if (textView != null) {
                return new LiveRankBarTitleBinding((RelativeLayout) view, imageView, textView);
            }
            str = "tvTitle";
        } else {
            str = "ivBack";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.c;
    }
}
