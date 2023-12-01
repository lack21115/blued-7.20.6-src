package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.module.common.view.LinePageIndicator;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/DialogLiveMedalDetailBinding.class */
public final class DialogLiveMedalDetailBinding implements ViewBinding {
    public final LinePageIndicator a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final ViewPager e;
    private final FrameLayout f;

    private DialogLiveMedalDetailBinding(FrameLayout frameLayout, LinePageIndicator linePageIndicator, ImageView imageView, ImageView imageView2, ImageView imageView3, ViewPager viewPager) {
        this.f = frameLayout;
        this.a = linePageIndicator;
        this.b = imageView;
        this.c = imageView2;
        this.d = imageView3;
        this.e = viewPager;
    }

    public static DialogLiveMedalDetailBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogLiveMedalDetailBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_live_medal_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogLiveMedalDetailBinding a(View view) {
        String str;
        LinePageIndicator linePageIndicator = (LinePageIndicator) view.findViewById(R.id.indicator_medal);
        if (linePageIndicator != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_left_slip);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_live_medal_title_back);
                if (imageView2 != null) {
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_right_slip);
                    if (imageView3 != null) {
                        ViewPager findViewById = view.findViewById(R.id.vp_medal_detail);
                        if (findViewById != null) {
                            return new DialogLiveMedalDetailBinding((FrameLayout) view, linePageIndicator, imageView, imageView2, imageView3, findViewById);
                        }
                        str = "vpMedalDetail";
                    } else {
                        str = "ivRightSlip";
                    }
                } else {
                    str = "ivLiveMedalTitleBack";
                }
            } else {
                str = "ivLeftSlip";
            }
        } else {
            str = "indicatorMedal";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.f;
    }
}
