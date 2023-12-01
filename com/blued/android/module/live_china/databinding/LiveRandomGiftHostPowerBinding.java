package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveRandomGiftHostPowerBinding.class */
public final class LiveRandomGiftHostPowerBinding implements ViewBinding {
    public final LinearLayout a;
    public final RelativeLayout b;
    public final RecyclerView c;
    public final TextView d;
    private final FrameLayout e;

    private LiveRandomGiftHostPowerBinding(FrameLayout frameLayout, LinearLayout linearLayout, RelativeLayout relativeLayout, RecyclerView recyclerView, TextView textView) {
        this.e = frameLayout;
        this.a = linearLayout;
        this.b = relativeLayout;
        this.c = recyclerView;
        this.d = textView;
    }

    public static LiveRandomGiftHostPowerBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_random_gift_host_power, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveRandomGiftHostPowerBinding a(View view) {
        String str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_root);
        if (linearLayout != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_empty);
            if (relativeLayout != null) {
                RecyclerView findViewById = view.findViewById(R.id.rv_list);
                if (findViewById != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_belted);
                    if (textView != null) {
                        return new LiveRandomGiftHostPowerBinding((FrameLayout) view, linearLayout, relativeLayout, findViewById, textView);
                    }
                    str = "tvBelted";
                } else {
                    str = "rvList";
                }
            } else {
                str = "rlEmpty";
            }
        } else {
            str = "llRoot";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.e;
    }
}
