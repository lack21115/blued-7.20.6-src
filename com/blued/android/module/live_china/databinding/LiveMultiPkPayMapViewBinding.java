package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.svgaplayer.SVGAImageView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveMultiPkPayMapViewBinding.class */
public final class LiveMultiPkPayMapViewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f12298a;
    public final FrameLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f12299c;
    public final ImageView d;
    public final ImageView e;
    public final SVGAImageView f;
    public final SVGAImageView g;
    public final ImageView h;
    public final ImageView i;
    public final ShapeFrameLayout j;
    public final ShapeTextView k;
    public final TextView l;
    private final FrameLayout m;

    private LiveMultiPkPayMapViewBinding(FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, ImageView imageView, ImageView imageView2, SVGAImageView sVGAImageView, SVGAImageView sVGAImageView2, ImageView imageView3, ImageView imageView4, ShapeFrameLayout shapeFrameLayout, ShapeTextView shapeTextView, TextView textView) {
        this.m = frameLayout;
        this.f12298a = frameLayout2;
        this.b = frameLayout3;
        this.f12299c = frameLayout4;
        this.d = imageView;
        this.e = imageView2;
        this.f = sVGAImageView;
        this.g = sVGAImageView2;
        this.h = imageView3;
        this.i = imageView4;
        this.j = shapeFrameLayout;
        this.k = shapeTextView;
        this.l = textView;
    }

    public static LiveMultiPkPayMapViewBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_multi_pk_pay_map_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveMultiPkPayMapViewBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_first_pay);
        if (frameLayout != null) {
            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.fl_map_pay);
            if (frameLayout2 != null) {
                FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.fl_root);
                if (frameLayout3 != null) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_first_anim);
                    if (imageView != null) {
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_first_bg);
                        if (imageView2 != null) {
                            SVGAImageView sVGAImageView = (SVGAImageView) view.findViewById(R.id.iv_mvp_anim_1);
                            if (sVGAImageView != null) {
                                SVGAImageView sVGAImageView2 = (SVGAImageView) view.findViewById(R.id.iv_mvp_anim_2);
                                if (sVGAImageView2 != null) {
                                    ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_mvp_avatar);
                                    if (imageView3 != null) {
                                        ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_pay_avatar);
                                        if (imageView4 != null) {
                                            ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) view.findViewById(R.id.sf_first_name);
                                            if (shapeFrameLayout != null) {
                                                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_mvp_name);
                                                if (shapeTextView != null) {
                                                    TextView textView = (TextView) view.findViewById(R.id.tv_pay_name);
                                                    if (textView != null) {
                                                        return new LiveMultiPkPayMapViewBinding((FrameLayout) view, frameLayout, frameLayout2, frameLayout3, imageView, imageView2, sVGAImageView, sVGAImageView2, imageView3, imageView4, shapeFrameLayout, shapeTextView, textView);
                                                    }
                                                    str = "tvPayName";
                                                } else {
                                                    str = "tvMvpName";
                                                }
                                            } else {
                                                str = "sfFirstName";
                                            }
                                        } else {
                                            str = "ivPayAvatar";
                                        }
                                    } else {
                                        str = "ivMvpAvatar";
                                    }
                                } else {
                                    str = "ivMvpAnim2";
                                }
                            } else {
                                str = "ivMvpAnim1";
                            }
                        } else {
                            str = "ivFirstBg";
                        }
                    } else {
                        str = "ivFirstAnim";
                    }
                } else {
                    str = "flRoot";
                }
            } else {
                str = "flMapPay";
            }
        } else {
            str = "flFirstPay";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.m;
    }
}
