package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.TabPageIndicatorWithDot;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyKtvMusicCenterBinding.class */
public final class FragmentYyKtvMusicCenterBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f16517a;
    public final ShapeLinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewPager f16518c;
    public final TabPageIndicatorWithDot d;
    public final ShapeTextView e;
    public final TextView f;
    private final ConstraintLayout g;

    private FragmentYyKtvMusicCenterBinding(ConstraintLayout constraintLayout, View view, ShapeLinearLayout shapeLinearLayout, ViewPager viewPager, TabPageIndicatorWithDot tabPageIndicatorWithDot, ShapeTextView shapeTextView, TextView textView) {
        this.g = constraintLayout;
        this.f16517a = view;
        this.b = shapeLinearLayout;
        this.f16518c = viewPager;
        this.d = tabPageIndicatorWithDot;
        this.e = shapeTextView;
        this.f = textView;
    }

    public static FragmentYyKtvMusicCenterBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.cover_view);
        if (findViewById != null) {
            ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.ll_search_music);
            if (shapeLinearLayout != null) {
                ViewPager viewPager = (ViewPager) view.findViewById(R.id.music_view_pager);
                if (viewPager != null) {
                    TabPageIndicatorWithDot tabPageIndicatorWithDot = (TabPageIndicatorWithDot) view.findViewById(R.id.tablayout);
                    if (tabPageIndicatorWithDot != null) {
                        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_available_amount);
                        if (shapeTextView != null) {
                            TextView textView = (TextView) view.findViewById(R.id.tv_red_envelope_title);
                            if (textView != null) {
                                return new FragmentYyKtvMusicCenterBinding((ConstraintLayout) view, findViewById, shapeLinearLayout, viewPager, tabPageIndicatorWithDot, shapeTextView, textView);
                            }
                            str = "tvRedEnvelopeTitle";
                        } else {
                            str = "tvAvailableAmount";
                        }
                    } else {
                        str = "tablayout";
                    }
                } else {
                    str = "musicViewPager";
                }
            } else {
                str = "llSearchMusic";
            }
        } else {
            str = "coverView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.g;
    }
}
