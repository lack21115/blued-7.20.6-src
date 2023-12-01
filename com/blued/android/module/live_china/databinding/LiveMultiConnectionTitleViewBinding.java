package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.view.LiveMultiPkCountDownView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveMultiConnectionTitleViewBinding.class */
public final class LiveMultiConnectionTitleViewBinding implements ViewBinding {
    public final LiveMultiPkCountDownView a;
    public final ImageView b;
    public final ImageView c;
    public final TextView d;
    public final Space e;
    private final FrameLayout f;

    private LiveMultiConnectionTitleViewBinding(FrameLayout frameLayout, LiveMultiPkCountDownView liveMultiPkCountDownView, ImageView imageView, ImageView imageView2, TextView textView, Space space) {
        this.f = frameLayout;
        this.a = liveMultiPkCountDownView;
        this.b = imageView;
        this.c = imageView2;
        this.d = textView;
        this.e = space;
    }

    public static LiveMultiConnectionTitleViewBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_multi_connection_title_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveMultiConnectionTitleViewBinding a(View view) {
        String str;
        LiveMultiPkCountDownView liveMultiPkCountDownView = (LiveMultiPkCountDownView) view.findViewById(R.id.count_down_view);
        if (liveMultiPkCountDownView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_icon);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_info);
                if (imageView2 != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_title);
                    if (textView != null) {
                        Space space = (Space) view.findViewById(R.id.view_space);
                        if (space != null) {
                            return new LiveMultiConnectionTitleViewBinding((FrameLayout) view, liveMultiPkCountDownView, imageView, imageView2, textView, space);
                        }
                        str = "viewSpace";
                    } else {
                        str = "tvTitle";
                    }
                } else {
                    str = "ivInfo";
                }
            } else {
                str = "ivIcon";
            }
        } else {
            str = "countDownView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.f;
    }
}
