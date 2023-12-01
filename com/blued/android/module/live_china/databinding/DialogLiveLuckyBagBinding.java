package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.module.common.view.SlopeLoadingView;
import com.blued.android.module.live_china.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/DialogLiveLuckyBagBinding.class */
public final class DialogLiveLuckyBagBinding implements ViewBinding {
    public final AppBarLayout a;
    public final ConstraintLayout b;
    public final ConstraintLayout c;
    public final ConstraintLayout d;
    public final CollapsingToolbarLayout e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final ImageView k;
    public final SlopeLoadingView l;
    public final RecyclerView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    public final ViewPager s;
    private final ConstraintLayout t;

    private DialogLiveLuckyBagBinding(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, CollapsingToolbarLayout collapsingToolbarLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, SlopeLoadingView slopeLoadingView, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, ViewPager viewPager) {
        this.t = constraintLayout;
        this.a = appBarLayout;
        this.b = constraintLayout2;
        this.c = constraintLayout3;
        this.d = constraintLayout4;
        this.e = collapsingToolbarLayout;
        this.f = imageView;
        this.g = imageView2;
        this.h = imageView3;
        this.i = imageView4;
        this.j = imageView5;
        this.k = imageView6;
        this.l = slopeLoadingView;
        this.m = recyclerView;
        this.n = textView;
        this.o = textView2;
        this.p = textView3;
        this.q = textView4;
        this.r = textView5;
        this.s = viewPager;
    }

    public static DialogLiveLuckyBagBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogLiveLuckyBagBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_live_lucky_bag, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogLiveLuckyBagBinding a(View view) {
        String str;
        AppBarLayout findViewById = view.findViewById(R.id.abl);
        if (findViewById != null) {
            ConstraintLayout findViewById2 = view.findViewById(R.id.cl_head_root);
            if (findViewById2 != null) {
                ConstraintLayout findViewById3 = view.findViewById(R.id.cl_send);
                if (findViewById3 != null) {
                    ConstraintLayout findViewById4 = view.findViewById(R.id.cl_send_root);
                    if (findViewById4 != null) {
                        CollapsingToolbarLayout findViewById5 = view.findViewById(R.id.ctl);
                        if (findViewById5 != null) {
                            ImageView imageView = (ImageView) view.findViewById(R.id.iv_beans);
                            if (imageView != null) {
                                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_cursor);
                                if (imageView2 != null) {
                                    ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_give);
                                    if (imageView3 != null) {
                                        ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_give_beans);
                                        if (imageView4 != null) {
                                            ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_head_gift);
                                            if (imageView5 != null) {
                                                ImageView imageView6 = (ImageView) view.findViewById(R.id.iv_info);
                                                if (imageView6 != null) {
                                                    SlopeLoadingView slopeLoadingView = (SlopeLoadingView) view.findViewById(R.id.loading);
                                                    if (slopeLoadingView != null) {
                                                        RecyclerView findViewById6 = view.findViewById(R.id.rv_tab_list);
                                                        if (findViewById6 != null) {
                                                            TextView textView = (TextView) view.findViewById(R.id.tv_gift_name);
                                                            if (textView != null) {
                                                                TextView textView2 = (TextView) view.findViewById(R.id.tv_gift_price);
                                                                if (textView2 != null) {
                                                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_give_gift_name);
                                                                    if (textView3 != null) {
                                                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_give_gift_price);
                                                                        if (textView4 != null) {
                                                                            TextView textView5 = (TextView) view.findViewById(R.id.tv_lucky_come_tag);
                                                                            if (textView5 != null) {
                                                                                ViewPager findViewById7 = view.findViewById(R.id.vp_lucky_bag);
                                                                                if (findViewById7 != null) {
                                                                                    return new DialogLiveLuckyBagBinding((ConstraintLayout) view, findViewById, findViewById2, findViewById3, findViewById4, findViewById5, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, slopeLoadingView, findViewById6, textView, textView2, textView3, textView4, textView5, findViewById7);
                                                                                }
                                                                                str = "vpLuckyBag";
                                                                            } else {
                                                                                str = "tvLuckyComeTag";
                                                                            }
                                                                        } else {
                                                                            str = "tvGiveGiftPrice";
                                                                        }
                                                                    } else {
                                                                        str = "tvGiveGiftName";
                                                                    }
                                                                } else {
                                                                    str = "tvGiftPrice";
                                                                }
                                                            } else {
                                                                str = "tvGiftName";
                                                            }
                                                        } else {
                                                            str = "rvTabList";
                                                        }
                                                    } else {
                                                        str = "loading";
                                                    }
                                                } else {
                                                    str = "ivInfo";
                                                }
                                            } else {
                                                str = "ivHeadGift";
                                            }
                                        } else {
                                            str = "ivGiveBeans";
                                        }
                                    } else {
                                        str = "ivGive";
                                    }
                                } else {
                                    str = "ivCursor";
                                }
                            } else {
                                str = "ivBeans";
                            }
                        } else {
                            str = "ctl";
                        }
                    } else {
                        str = "clSendRoot";
                    }
                } else {
                    str = "clSend";
                }
            } else {
                str = "clHeadRoot";
            }
        } else {
            str = "abl";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.t;
    }
}
