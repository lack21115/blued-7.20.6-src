package com.soft.blued.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.NoScrollViewPager;
import com.blued.android.module.common.view.PageTabLayout;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FragmentVirtualImageSelectBinding.class */
public final class FragmentVirtualImageSelectBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final CardView f29029a;
    public final FrameLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f29030c;
    public final FrameLayout d;
    public final FrameLayout e;
    public final ImageView f;
    public final ImageView g;
    public final ShapeLinearLayout h;
    public final PageTabLayout i;
    public final TextView j;
    public final ShapeTextView k;
    public final ShapeTextView l;
    public final NoScrollViewPager m;
    private final RelativeLayout n;

    private FragmentVirtualImageSelectBinding(RelativeLayout relativeLayout, CardView cardView, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, ImageView imageView, ImageView imageView2, ShapeLinearLayout shapeLinearLayout, PageTabLayout pageTabLayout, TextView textView, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, NoScrollViewPager noScrollViewPager) {
        this.n = relativeLayout;
        this.f29029a = cardView;
        this.b = frameLayout;
        this.f29030c = frameLayout2;
        this.d = frameLayout3;
        this.e = frameLayout4;
        this.f = imageView;
        this.g = imageView2;
        this.h = shapeLinearLayout;
        this.i = pageTabLayout;
        this.j = textView;
        this.k = shapeTextView;
        this.l = shapeTextView2;
        this.m = noScrollViewPager;
    }

    public static FragmentVirtualImageSelectBinding a(View view) {
        String str;
        CardView cardView = (CardView) view.findViewById(R.id.cv_marketing);
        if (cardView != null) {
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_back);
            if (frameLayout != null) {
                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.fl_bean_count);
                if (frameLayout2 != null) {
                    FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.fl_buy_count);
                    if (frameLayout3 != null) {
                        FrameLayout frameLayout4 = (FrameLayout) view.findViewById(R.id.fl_save);
                        if (frameLayout4 != null) {
                            ImageView imageView = (ImageView) view.findViewById(2131365114);
                            if (imageView != null) {
                                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_marketing);
                                if (imageView2 != null) {
                                    ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.ll_panel);
                                    if (shapeLinearLayout != null) {
                                        PageTabLayout pageTabLayout = (PageTabLayout) view.findViewById(R.id.tabLayout);
                                        if (pageTabLayout != null) {
                                            TextView textView = (TextView) view.findViewById(R.id.tv_bean_count);
                                            if (textView != null) {
                                                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_buy_count);
                                                if (shapeTextView != null) {
                                                    ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(2131372499);
                                                    if (shapeTextView2 != null) {
                                                        NoScrollViewPager noScrollViewPager = (NoScrollViewPager) view.findViewById(2131373100);
                                                        if (noScrollViewPager != null) {
                                                            return new FragmentVirtualImageSelectBinding((RelativeLayout) view, cardView, frameLayout, frameLayout2, frameLayout3, frameLayout4, imageView, imageView2, shapeLinearLayout, pageTabLayout, textView, shapeTextView, shapeTextView2, noScrollViewPager);
                                                        }
                                                        str = "viewPager";
                                                    } else {
                                                        str = "tvSave";
                                                    }
                                                } else {
                                                    str = "tvBuyCount";
                                                }
                                            } else {
                                                str = "tvBeanCount";
                                            }
                                        } else {
                                            str = "tabLayout";
                                        }
                                    } else {
                                        str = "llPanel";
                                    }
                                } else {
                                    str = "ivMarketing";
                                }
                            } else {
                                str = "ivBack";
                            }
                        } else {
                            str = "flSave";
                        }
                    } else {
                        str = "flBuyCount";
                    }
                } else {
                    str = "flBeanCount";
                }
            } else {
                str = "flBack";
            }
        } else {
            str = "cvMarketing";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.n;
    }
}
