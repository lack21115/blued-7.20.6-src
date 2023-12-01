package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CustomViewPager;
import com.blued.android.module.live_china.R;
import com.google.android.material.card.MaterialCardView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/PopWindowRankingUnionCardBinding.class */
public final class PopWindowRankingUnionCardBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final MaterialCardView f12504a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final CustomViewPager f12505c;
    public final TextView d;
    public final TextView e;
    public final ShapeTextView f;
    private final RelativeLayout g;

    private PopWindowRankingUnionCardBinding(RelativeLayout relativeLayout, MaterialCardView materialCardView, ImageView imageView, CustomViewPager customViewPager, TextView textView, TextView textView2, ShapeTextView shapeTextView) {
        this.g = relativeLayout;
        this.f12504a = materialCardView;
        this.b = imageView;
        this.f12505c = customViewPager;
        this.d = textView;
        this.e = textView2;
        this.f = shapeTextView;
    }

    public static PopWindowRankingUnionCardBinding a(View view) {
        String str;
        MaterialCardView materialCardView = (MaterialCardView) view.findViewById(R.id.cv_tabbar_root);
        if (materialCardView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_question);
            if (imageView != null) {
                CustomViewPager customViewPager = (CustomViewPager) view.findViewById(R.id.live_hour_viewpager);
                if (customViewPager != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_tab_potential_road);
                    if (textView != null) {
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_tab_top_road);
                        if (textView2 != null) {
                            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.view_cursor);
                            if (shapeTextView != null) {
                                return new PopWindowRankingUnionCardBinding((RelativeLayout) view, materialCardView, imageView, customViewPager, textView, textView2, shapeTextView);
                            }
                            str = "viewCursor";
                        } else {
                            str = "tvTabTopRoad";
                        }
                    } else {
                        str = "tvTabPotentialRoad";
                    }
                } else {
                    str = "liveHourViewpager";
                }
            } else {
                str = "ivQuestion";
            }
        } else {
            str = "cvTabbarRoot";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.g;
    }
}
