package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LivePlanetTimeBinding.class */
public final class LivePlanetTimeBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f12375a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f12376c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final TextView g;
    private final FrameLayout h;

    private LivePlanetTimeBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, TextView textView) {
        this.h = frameLayout;
        this.f12375a = frameLayout2;
        this.b = imageView;
        this.f12376c = imageView2;
        this.d = imageView3;
        this.e = imageView4;
        this.f = imageView5;
        this.g = textView;
    }

    public static LivePlanetTimeBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_time_root);
        if (frameLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_time_1);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_time_2);
                if (imageView2 != null) {
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_time_3);
                    if (imageView3 != null) {
                        ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_time_4);
                        if (imageView4 != null) {
                            ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_time_division);
                            if (imageView5 != null) {
                                TextView textView = (TextView) view.findViewById(R.id.tv_probe_ing);
                                if (textView != null) {
                                    return new LivePlanetTimeBinding((FrameLayout) view, frameLayout, imageView, imageView2, imageView3, imageView4, imageView5, textView);
                                }
                                str = "tvProbeIng";
                            } else {
                                str = "ivTimeDivision";
                            }
                        } else {
                            str = "ivTime4";
                        }
                    } else {
                        str = "ivTime3";
                    }
                } else {
                    str = "ivTime2";
                }
            } else {
                str = "ivTime1";
            }
        } else {
            str = "flTimeRoot";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.h;
    }
}
