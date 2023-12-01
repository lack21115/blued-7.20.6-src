package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.CircleProgressView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveGiftSetComboLayoutBinding.class */
public final class LiveGiftSetComboLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f12228a;
    public final FrameLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f12229c;
    public final CircleProgressView d;
    public final TextView e;
    private final FrameLayout f;

    private LiveGiftSetComboLayoutBinding(FrameLayout frameLayout, ImageView imageView, FrameLayout frameLayout2, ImageView imageView2, CircleProgressView circleProgressView, TextView textView) {
        this.f = frameLayout;
        this.f12228a = imageView;
        this.b = frameLayout2;
        this.f12229c = imageView2;
        this.d = circleProgressView;
        this.e = textView;
    }

    public static LiveGiftSetComboLayoutBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_gift_set_combo_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveGiftSetComboLayoutBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.live_gift_combo_btn_click_bg);
        if (imageView != null) {
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.live_gift_combo_btn_layout);
            if (frameLayout != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.live_gift_combo_btn_mid);
                if (imageView2 != null) {
                    CircleProgressView circleProgressView = (CircleProgressView) view.findViewById(R.id.live_gift_combo_progress);
                    if (circleProgressView != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_time);
                        if (textView != null) {
                            return new LiveGiftSetComboLayoutBinding((FrameLayout) view, imageView, frameLayout, imageView2, circleProgressView, textView);
                        }
                        str = "tvTime";
                    } else {
                        str = "liveGiftComboProgress";
                    }
                } else {
                    str = "liveGiftComboBtnMid";
                }
            } else {
                str = "liveGiftComboBtnLayout";
            }
        } else {
            str = "liveGiftComboBtnClickBg";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.f;
    }
}
