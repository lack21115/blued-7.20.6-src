package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/DialogLiveRandomGiftInfoBinding.class */
public final class DialogLiveRandomGiftInfoBinding implements ViewBinding {
    public final ImageView a;
    public final ImageView b;
    public final ScrollView c;
    private final FrameLayout d;

    private DialogLiveRandomGiftInfoBinding(FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ScrollView scrollView) {
        this.d = frameLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = scrollView;
    }

    public static DialogLiveRandomGiftInfoBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogLiveRandomGiftInfoBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_live_random_gift_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogLiveRandomGiftInfoBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_info);
            if (imageView2 != null) {
                ScrollView scrollView = (ScrollView) view.findViewById(R.id.sv_info);
                if (scrollView != null) {
                    return new DialogLiveRandomGiftInfoBinding((FrameLayout) view, imageView, imageView2, scrollView);
                }
                str = "svInfo";
            } else {
                str = "ivInfo";
            }
        } else {
            str = "ivClose";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.d;
    }
}
