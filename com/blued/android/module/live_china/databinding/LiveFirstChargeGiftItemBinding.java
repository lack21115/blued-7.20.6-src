package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveFirstChargeGiftItemBinding.class */
public final class LiveFirstChargeGiftItemBinding implements ViewBinding {
    public final ImageView a;
    public final TextView b;
    public final TextView c;
    private final FrameLayout d;

    private LiveFirstChargeGiftItemBinding(FrameLayout frameLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.d = frameLayout;
        this.a = imageView;
        this.b = textView;
        this.c = textView2;
    }

    public static LiveFirstChargeGiftItemBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_first_charge_gift_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveFirstChargeGiftItemBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_avatar);
        if (imageView != null) {
            TextView textView = (TextView) view.findViewById(R.id.iv_count);
            if (textView != null) {
                TextView textView2 = (TextView) view.findViewById(R.id.tv_name);
                if (textView2 != null) {
                    return new LiveFirstChargeGiftItemBinding((FrameLayout) view, imageView, textView, textView2);
                }
                str = "tvName";
            } else {
                str = "ivCount";
            }
        } else {
            str = "ivAvatar";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.d;
    }
}
