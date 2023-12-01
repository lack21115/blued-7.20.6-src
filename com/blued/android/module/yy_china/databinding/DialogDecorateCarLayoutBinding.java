package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.BluedNoScrollViewPager;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogDecorateCarLayoutBinding.class */
public final class DialogDecorateCarLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f16326a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final View f16327c;
    public final ImageView d;
    public final View e;
    public final View f;
    public final ConstraintLayout g;
    public final ConstraintLayout h;
    public final ConstraintLayout i;
    public final SVGAImageView j;
    public final SVGAImageView k;
    public final BluedNoScrollViewPager l;
    private final ConstraintLayout m;

    private DialogDecorateCarLayoutBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, View view, ImageView imageView, View view2, View view3, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, SVGAImageView sVGAImageView, SVGAImageView sVGAImageView2, BluedNoScrollViewPager bluedNoScrollViewPager) {
        this.m = constraintLayout;
        this.f16326a = textView;
        this.b = textView2;
        this.f16327c = view;
        this.d = imageView;
        this.e = view2;
        this.f = view3;
        this.g = constraintLayout2;
        this.h = constraintLayout3;
        this.i = constraintLayout4;
        this.j = sVGAImageView;
        this.k = sVGAImageView2;
        this.l = bluedNoScrollViewPager;
    }

    public static DialogDecorateCarLayoutBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.btn_introduction);
        if (textView != null) {
            TextView textView2 = (TextView) view.findViewById(R.id.btn_logs);
            if (textView2 != null) {
                View findViewById = view.findViewById(R.id.cover_view);
                if (findViewById != null) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.img_btn_more);
                    if (imageView != null) {
                        View findViewById2 = view.findViewById(R.id.line_view);
                        if (findViewById2 != null) {
                            View findViewById3 = view.findViewById(R.id.ll_menu_cover_view);
                            if (findViewById3 != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.ll_menu_layout);
                                if (constraintLayout != null) {
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.ll_page_left);
                                    if (constraintLayout2 != null) {
                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.ll_page_right);
                                        if (constraintLayout3 != null) {
                                            SVGAImageView sVGAImageView = (SVGAImageView) view.findViewById(R.id.tab_left_svga);
                                            if (sVGAImageView != null) {
                                                SVGAImageView sVGAImageView2 = (SVGAImageView) view.findViewById(R.id.tab_right_svga);
                                                if (sVGAImageView2 != null) {
                                                    BluedNoScrollViewPager bluedNoScrollViewPager = (BluedNoScrollViewPager) view.findViewById(R.id.view_pager);
                                                    if (bluedNoScrollViewPager != null) {
                                                        return new DialogDecorateCarLayoutBinding((ConstraintLayout) view, textView, textView2, findViewById, imageView, findViewById2, findViewById3, constraintLayout, constraintLayout2, constraintLayout3, sVGAImageView, sVGAImageView2, bluedNoScrollViewPager);
                                                    }
                                                    str = "viewPager";
                                                } else {
                                                    str = "tabRightSvga";
                                                }
                                            } else {
                                                str = "tabLeftSvga";
                                            }
                                        } else {
                                            str = "llPageRight";
                                        }
                                    } else {
                                        str = "llPageLeft";
                                    }
                                } else {
                                    str = "llMenuLayout";
                                }
                            } else {
                                str = "llMenuCoverView";
                            }
                        } else {
                            str = "lineView";
                        }
                    } else {
                        str = "imgBtnMore";
                    }
                } else {
                    str = "coverView";
                }
            } else {
                str = "btnLogs";
            }
        } else {
            str = "btnIntroduction";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.m;
    }
}
