package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live.base.view.subscaleview.SubsamplingScaleImageView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/FragmentLivePlanetRuleBinding.class */
public final class FragmentLivePlanetRuleBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f11966a;
    public final SubsamplingScaleImageView b;

    /* renamed from: c  reason: collision with root package name */
    private final FrameLayout f11967c;

    private FragmentLivePlanetRuleBinding(FrameLayout frameLayout, ImageView imageView, SubsamplingScaleImageView subsamplingScaleImageView) {
        this.f11967c = frameLayout;
        this.f11966a = imageView;
        this.b = subsamplingScaleImageView;
    }

    public static FragmentLivePlanetRuleBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static FragmentLivePlanetRuleBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_live_planet_rule, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static FragmentLivePlanetRuleBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
        if (imageView != null) {
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) view.findViewById(R.id.iv_planet);
            if (subsamplingScaleImageView != null) {
                return new FragmentLivePlanetRuleBinding((FrameLayout) view, imageView, subsamplingScaleImageView);
            }
            str = "ivPlanet";
        } else {
            str = "ivBack";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.f11967c;
    }
}
