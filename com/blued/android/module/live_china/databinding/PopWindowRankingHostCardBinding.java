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

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/PopWindowRankingHostCardBinding.class */
public final class PopWindowRankingHostCardBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final MaterialCardView f12491a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final CustomViewPager f12492c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final ShapeTextView g;
    private final RelativeLayout h;

    private PopWindowRankingHostCardBinding(RelativeLayout relativeLayout, MaterialCardView materialCardView, ImageView imageView, CustomViewPager customViewPager, TextView textView, TextView textView2, TextView textView3, ShapeTextView shapeTextView) {
        this.h = relativeLayout;
        this.f12491a = materialCardView;
        this.b = imageView;
        this.f12492c = customViewPager;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
        this.g = shapeTextView;
    }

    public static PopWindowRankingHostCardBinding a(View view) {
        String str;
        MaterialCardView materialCardView = (MaterialCardView) view.findViewById(R.id.cv_tabbar_root);
        if (materialCardView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_question);
            if (imageView != null) {
                CustomViewPager customViewPager = (CustomViewPager) view.findViewById(R.id.live_hour_viewpager);
                if (customViewPager != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_tab_potential_road);
                    if (textView != null) {
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_tab_summit_time);
                        if (textView2 != null) {
                            TextView textView3 = (TextView) view.findViewById(R.id.tv_tab_top_road);
                            if (textView3 != null) {
                                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.view_cursor);
                                if (shapeTextView != null) {
                                    return new PopWindowRankingHostCardBinding((RelativeLayout) view, materialCardView, imageView, customViewPager, textView, textView2, textView3, shapeTextView);
                                }
                                str = "viewCursor";
                            } else {
                                str = "tvTabTopRoad";
                            }
                        } else {
                            str = "tvTabSummitTime";
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
        return this.h;
    }
}
