package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CustomViewPager;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/PopWindowRankingHourCardBinding.class */
public final class PopWindowRankingHourCardBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final CardView f12494a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final CustomViewPager f12495c;
    public final RelativeLayout d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final ShapeTextView i;
    private final FrameLayout j;

    private PopWindowRankingHourCardBinding(FrameLayout frameLayout, CardView cardView, ImageView imageView, CustomViewPager customViewPager, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, ShapeTextView shapeTextView) {
        this.j = frameLayout;
        this.f12494a = cardView;
        this.b = imageView;
        this.f12495c = customViewPager;
        this.d = relativeLayout;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
        this.h = textView4;
        this.i = shapeTextView;
    }

    public static PopWindowRankingHourCardBinding a(View view) {
        String str;
        CardView cardView = (CardView) view.findViewById(R.id.cv_tabbar_root);
        if (cardView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
            if (imageView != null) {
                CustomViewPager customViewPager = (CustomViewPager) view.findViewById(R.id.live_hour_viewpager);
                if (customViewPager != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_previous_hour_btn);
                    if (relativeLayout != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_previous_hour);
                        if (textView != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_tab_potential_road);
                            if (textView2 != null) {
                                TextView textView3 = (TextView) view.findViewById(R.id.tv_tab_summit_time);
                                if (textView3 != null) {
                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_tab_top_road);
                                    if (textView4 != null) {
                                        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.view_cursor);
                                        if (shapeTextView != null) {
                                            return new PopWindowRankingHourCardBinding((FrameLayout) view, cardView, imageView, customViewPager, relativeLayout, textView, textView2, textView3, textView4, shapeTextView);
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
                            str = "tvPreviousHour";
                        }
                    } else {
                        str = "rlPreviousHourBtn";
                    }
                } else {
                    str = "liveHourViewpager";
                }
            } else {
                str = "ivBack";
            }
        } else {
            str = "cvTabbarRoot";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.j;
    }
}
