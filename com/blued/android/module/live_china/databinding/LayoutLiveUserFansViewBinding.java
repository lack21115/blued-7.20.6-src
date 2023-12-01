package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LayoutLiveUserFansViewBinding.class */
public final class LayoutLiveUserFansViewBinding implements ViewBinding {
    public final FrameLayout a;
    public final ShapeFrameLayout b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final ShapeTextView f;
    public final ImageView g;
    public final ShapeTextView h;
    private final FrameLayout i;

    private LayoutLiveUserFansViewBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ShapeFrameLayout shapeFrameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ShapeTextView shapeTextView, ImageView imageView4, ShapeTextView shapeTextView2) {
        this.i = frameLayout;
        this.a = frameLayout2;
        this.b = shapeFrameLayout;
        this.c = imageView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = shapeTextView;
        this.g = imageView4;
        this.h = shapeTextView2;
    }

    public static LayoutLiveUserFansViewBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_live_user_fans_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LayoutLiveUserFansViewBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_follow);
        if (frameLayout != null) {
            ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) view.findViewById(R.id.fl_live_fans);
            if (shapeFrameLayout != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.img_live_fans_heart_bg);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.img_live_fans_star);
                    if (imageView2 != null) {
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.live_add_follow_overshoot_bg);
                        if (imageView3 != null) {
                            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.live_fans_dot_tips);
                            if (shapeTextView != null) {
                                ImageView imageView4 = (ImageView) view.findViewById(R.id.live_fans_start);
                                if (imageView4 != null) {
                                    ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.live_follow_btn);
                                    if (shapeTextView2 != null) {
                                        return new LayoutLiveUserFansViewBinding((FrameLayout) view, frameLayout, shapeFrameLayout, imageView, imageView2, imageView3, shapeTextView, imageView4, shapeTextView2);
                                    }
                                    str = "liveFollowBtn";
                                } else {
                                    str = "liveFansStart";
                                }
                            } else {
                                str = "liveFansDotTips";
                            }
                        } else {
                            str = "liveAddFollowOvershootBg";
                        }
                    } else {
                        str = "imgLiveFansStar";
                    }
                } else {
                    str = "imgLiveFansHeartBg";
                }
            } else {
                str = "flLiveFans";
            }
        } else {
            str = "flFollow";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.i;
    }
}
