package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LivePkCenterBinding.class */
public final class LivePkCenterBinding implements ViewBinding {
    public final ShapeFrameLayout a;
    public final ImageView b;
    public final ImageView c;
    public final LinearLayout d;
    public final ImageView e;
    public final View f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final LinearLayout k;
    public final ShapeTextView l;
    private final FrameLayout m;

    private LivePkCenterBinding(FrameLayout frameLayout, ShapeFrameLayout shapeFrameLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, ImageView imageView3, View view, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, LinearLayout linearLayout2, ShapeTextView shapeTextView) {
        this.m = frameLayout;
        this.a = shapeFrameLayout;
        this.b = imageView;
        this.c = imageView2;
        this.d = linearLayout;
        this.e = imageView3;
        this.f = view;
        this.g = imageView4;
        this.h = imageView5;
        this.i = imageView6;
        this.j = imageView7;
        this.k = linearLayout2;
        this.l = shapeTextView;
    }

    public static LivePkCenterBinding a(View view) {
        String str;
        ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) view.findViewById(R.id.content_layout);
        if (shapeFrameLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.live_make_friend_btn);
                if (imageView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.live_pk_center_btn_layout);
                    if (linearLayout != null) {
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.live_pk_center_help);
                        if (imageView3 != null) {
                            View findViewById = view.findViewById(R.id.live_pk_center_layer);
                            if (findViewById != null) {
                                ImageView imageView4 = (ImageView) view.findViewById(R.id.live_pk_dared_btn);
                                if (imageView4 != null) {
                                    ImageView imageView5 = (ImageView) view.findViewById(R.id.live_pk_friend_btn);
                                    if (imageView5 != null) {
                                        ImageView imageView6 = (ImageView) view.findViewById(R.id.live_pk_whole_btn);
                                        if (imageView6 != null) {
                                            ImageView imageView7 = (ImageView) view.findViewById(R.id.live_rtc_friend_btn);
                                            if (imageView7 != null) {
                                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_loading);
                                                if (linearLayout2 != null) {
                                                    ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.view_dot);
                                                    if (shapeTextView != null) {
                                                        return new LivePkCenterBinding((FrameLayout) view, shapeFrameLayout, imageView, imageView2, linearLayout, imageView3, findViewById, imageView4, imageView5, imageView6, imageView7, linearLayout2, shapeTextView);
                                                    }
                                                    str = "viewDot";
                                                } else {
                                                    str = "llLoading";
                                                }
                                            } else {
                                                str = "liveRtcFriendBtn";
                                            }
                                        } else {
                                            str = "livePkWholeBtn";
                                        }
                                    } else {
                                        str = "livePkFriendBtn";
                                    }
                                } else {
                                    str = "livePkDaredBtn";
                                }
                            } else {
                                str = "livePkCenterLayer";
                            }
                        } else {
                            str = "livePkCenterHelp";
                        }
                    } else {
                        str = "livePkCenterBtnLayout";
                    }
                } else {
                    str = "liveMakeFriendBtn";
                }
            } else {
                str = "ivBack";
            }
        } else {
            str = "contentLayout";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.m;
    }
}
