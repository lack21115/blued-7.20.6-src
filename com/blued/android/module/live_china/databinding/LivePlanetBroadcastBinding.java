package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LivePlanetBroadcastBinding.class */
public final class LivePlanetBroadcastBinding implements ViewBinding {
    public final HorizontalScrollView a;
    public final TextView b;
    private final FrameLayout c;

    private LivePlanetBroadcastBinding(FrameLayout frameLayout, HorizontalScrollView horizontalScrollView, TextView textView) {
        this.c = frameLayout;
        this.a = horizontalScrollView;
        this.b = textView;
    }

    public static LivePlanetBroadcastBinding a(View view) {
        String str;
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) view.findViewById(R.id.hsv);
        if (horizontalScrollView != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_broadcast);
            if (textView != null) {
                return new LivePlanetBroadcastBinding((FrameLayout) view, horizontalScrollView, textView);
            }
            str = "tvBroadcast";
        } else {
            str = "hsv";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.c;
    }
}
