package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveGiftSetTaskItemBinding.class */
public final class LiveGiftSetTaskItemBinding implements ViewBinding {
    public final ImageView a;
    public final FrameLayout b;
    public final TextView c;
    public final TextView d;
    private final RelativeLayout e;

    private LiveGiftSetTaskItemBinding(RelativeLayout relativeLayout, ImageView imageView, FrameLayout frameLayout, TextView textView, TextView textView2) {
        this.e = relativeLayout;
        this.a = imageView;
        this.b = frameLayout;
        this.c = textView;
        this.d = textView2;
    }

    public static LiveGiftSetTaskItemBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static LiveGiftSetTaskItemBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_gift_set_task_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveGiftSetTaskItemBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_icon);
        if (imageView != null) {
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.rl_lay);
            if (frameLayout != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_name);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_progress);
                    if (textView2 != null) {
                        return new LiveGiftSetTaskItemBinding((RelativeLayout) view, imageView, frameLayout, textView, textView2);
                    }
                    str = "tvProgress";
                } else {
                    str = "tvName";
                }
            } else {
                str = "rlLay";
            }
        } else {
            str = "ivIcon";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.e;
    }
}
