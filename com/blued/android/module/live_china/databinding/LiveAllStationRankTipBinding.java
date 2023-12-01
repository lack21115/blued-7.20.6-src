package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live.base.view.subscaleview.SubsamplingScaleImageView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveAllStationRankTipBinding.class */
public final class LiveAllStationRankTipBinding implements ViewBinding {
    public final ImageView a;
    public final SubsamplingScaleImageView b;
    public final FrameLayout c;
    public final TextView d;
    private final FrameLayout e;

    private LiveAllStationRankTipBinding(FrameLayout frameLayout, ImageView imageView, SubsamplingScaleImageView subsamplingScaleImageView, FrameLayout frameLayout2, TextView textView) {
        this.e = frameLayout;
        this.a = imageView;
        this.b = subsamplingScaleImageView;
        this.c = frameLayout2;
        this.d = textView;
    }

    public static LiveAllStationRankTipBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static LiveAllStationRankTipBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_all_station_rank_tip, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveAllStationRankTipBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
        if (imageView != null) {
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) view.findViewById(R.id.iv_large);
            if (subsamplingScaleImageView != null) {
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.root);
                if (frameLayout != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_title);
                    if (textView != null) {
                        return new LiveAllStationRankTipBinding((FrameLayout) view, imageView, subsamplingScaleImageView, frameLayout, textView);
                    }
                    str = "tvTitle";
                } else {
                    str = "root";
                }
            } else {
                str = "ivLarge";
            }
        } else {
            str = "ivClose";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.e;
    }
}
