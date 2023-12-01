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

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveBattleBuyTipBinding.class */
public final class LiveBattleBuyTipBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f12137a;
    public final SubsamplingScaleImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f12138c;
    public final TextView d;
    private final FrameLayout e;

    private LiveBattleBuyTipBinding(FrameLayout frameLayout, ImageView imageView, SubsamplingScaleImageView subsamplingScaleImageView, FrameLayout frameLayout2, TextView textView) {
        this.e = frameLayout;
        this.f12137a = imageView;
        this.b = subsamplingScaleImageView;
        this.f12138c = frameLayout2;
        this.d = textView;
    }

    public static LiveBattleBuyTipBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_battle_buy_tip, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveBattleBuyTipBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
        if (imageView != null) {
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) view.findViewById(R.id.iv_large);
            if (subsamplingScaleImageView != null) {
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.root);
                if (frameLayout != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_title);
                    if (textView != null) {
                        return new LiveBattleBuyTipBinding((FrameLayout) view, imageView, subsamplingScaleImageView, frameLayout, textView);
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

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.e;
    }
}
