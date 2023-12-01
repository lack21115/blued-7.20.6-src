package com.soft.blued.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FragmentDateTodaySearchBinding.class */
public final class FragmentDateTodaySearchBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f15119a;
    public final View b;

    /* renamed from: c  reason: collision with root package name */
    public final View f15120c;
    public final View d;
    public final View e;
    public final View f;
    public final View g;
    public final View h;
    public final View i;
    public final FrameLayout j;
    public final FrameLayout k;
    public final FrameLayout l;
    public final FrameLayout m;
    public final LinearLayout n;
    public final ImageView o;
    public final ImageView p;
    public final ImageView q;
    public final SVGAImageView r;
    public final SVGAImageView s;
    public final SVGAImageView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    private final FrameLayout x;

    private FragmentDateTodaySearchBinding(FrameLayout frameLayout, View view, View view2, View view3, View view4, View view5, View view6, View view7, View view8, View view9, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, FrameLayout frameLayout5, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, SVGAImageView sVGAImageView, SVGAImageView sVGAImageView2, SVGAImageView sVGAImageView3, TextView textView, TextView textView2, TextView textView3) {
        this.x = frameLayout;
        this.f15119a = view;
        this.b = view2;
        this.f15120c = view3;
        this.d = view4;
        this.e = view5;
        this.f = view6;
        this.g = view7;
        this.h = view8;
        this.i = view9;
        this.j = frameLayout2;
        this.k = frameLayout3;
        this.l = frameLayout4;
        this.m = frameLayout5;
        this.n = linearLayout;
        this.o = imageView;
        this.p = imageView2;
        this.q = imageView3;
        this.r = sVGAImageView;
        this.s = sVGAImageView2;
        this.t = sVGAImageView3;
        this.u = textView;
        this.v = textView2;
        this.w = textView3;
    }

    public static FragmentDateTodaySearchBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_date_today_search, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static FragmentDateTodaySearchBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.bg_bottom_anim1);
        if (findViewById != null) {
            View findViewById2 = view.findViewById(R.id.bg_bottom_anim2);
            if (findViewById2 != null) {
                View findViewById3 = view.findViewById(R.id.bg_bottom_anim3);
                if (findViewById3 != null) {
                    View findViewById4 = view.findViewById(R.id.bg_top_anim11);
                    if (findViewById4 != null) {
                        View findViewById5 = view.findViewById(R.id.bg_top_anim12);
                        if (findViewById5 != null) {
                            View findViewById6 = view.findViewById(R.id.bg_top_anim21);
                            if (findViewById6 != null) {
                                View findViewById7 = view.findViewById(R.id.bg_top_anim22);
                                if (findViewById7 != null) {
                                    View findViewById8 = view.findViewById(R.id.bg_top_anim31);
                                    if (findViewById8 != null) {
                                        View findViewById9 = view.findViewById(R.id.bg_top_anim32);
                                        if (findViewById9 != null) {
                                            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_header_him);
                                            if (frameLayout != null) {
                                                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.fl_header_self);
                                                if (frameLayout2 != null) {
                                                    FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.fl_modify_purpose);
                                                    if (frameLayout3 != null) {
                                                        FrameLayout frameLayout4 = (FrameLayout) view.findViewById(R.id.fl_search);
                                                        if (frameLayout4 != null) {
                                                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.fl_search_failure);
                                                            if (linearLayout != null) {
                                                                ImageView imageView = (ImageView) view.findViewById(R.id.iv_header_him);
                                                                if (imageView != null) {
                                                                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_header_self);
                                                                    if (imageView2 != null) {
                                                                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_match_success);
                                                                        if (imageView3 != null) {
                                                                            SVGAImageView findViewById10 = view.findViewById(R.id.svga_match_heart_anim);
                                                                            if (findViewById10 != null) {
                                                                                SVGAImageView findViewById11 = view.findViewById(R.id.svga_match_small_heart_anim);
                                                                                if (findViewById11 != null) {
                                                                                    SVGAImageView findViewById12 = view.findViewById(R.id.svga_search_anim);
                                                                                    if (findViewById12 != null) {
                                                                                        TextView textView = (TextView) view.findViewById(2131371051);
                                                                                        if (textView != null) {
                                                                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_search_hint);
                                                                                            if (textView2 != null) {
                                                                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_try_later);
                                                                                                if (textView3 != null) {
                                                                                                    return new FragmentDateTodaySearchBinding((FrameLayout) view, findViewById, findViewById2, findViewById3, findViewById4, findViewById5, findViewById6, findViewById7, findViewById8, findViewById9, frameLayout, frameLayout2, frameLayout3, frameLayout4, linearLayout, imageView, imageView2, imageView3, findViewById10, findViewById11, findViewById12, textView, textView2, textView3);
                                                                                                }
                                                                                                str = "tvTryLater";
                                                                                            } else {
                                                                                                str = "tvSearchHint";
                                                                                            }
                                                                                        } else {
                                                                                            str = "tvCancel";
                                                                                        }
                                                                                    } else {
                                                                                        str = "svgaSearchAnim";
                                                                                    }
                                                                                } else {
                                                                                    str = "svgaMatchSmallHeartAnim";
                                                                                }
                                                                            } else {
                                                                                str = "svgaMatchHeartAnim";
                                                                            }
                                                                        } else {
                                                                            str = "ivMatchSuccess";
                                                                        }
                                                                    } else {
                                                                        str = "ivHeaderSelf";
                                                                    }
                                                                } else {
                                                                    str = "ivHeaderHim";
                                                                }
                                                            } else {
                                                                str = "flSearchFailure";
                                                            }
                                                        } else {
                                                            str = "flSearch";
                                                        }
                                                    } else {
                                                        str = "flModifyPurpose";
                                                    }
                                                } else {
                                                    str = "flHeaderSelf";
                                                }
                                            } else {
                                                str = "flHeaderHim";
                                            }
                                        } else {
                                            str = "bgTopAnim32";
                                        }
                                    } else {
                                        str = "bgTopAnim31";
                                    }
                                } else {
                                    str = "bgTopAnim22";
                                }
                            } else {
                                str = "bgTopAnim21";
                            }
                        } else {
                            str = "bgTopAnim12";
                        }
                    } else {
                        str = "bgTopAnim11";
                    }
                } else {
                    str = "bgBottomAnim3";
                }
            } else {
                str = "bgBottomAnim2";
            }
        } else {
            str = "bgBottomAnim1";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.x;
    }
}
