package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LivePlanetBroadcastBinding.class */
public final class LivePlanetBroadcastBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final HorizontalScrollView f12360a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    private final FrameLayout f12361c;

    private LivePlanetBroadcastBinding(FrameLayout frameLayout, HorizontalScrollView horizontalScrollView, TextView textView) {
        this.f12361c = frameLayout;
        this.f12360a = horizontalScrollView;
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

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.f12361c;
    }
}
