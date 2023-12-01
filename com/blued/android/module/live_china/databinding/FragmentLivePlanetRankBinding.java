package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/FragmentLivePlanetRankBinding.class */
public final class FragmentLivePlanetRankBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f11960a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f11961c;
    public final ViewPager d;
    private final FrameLayout e;

    private FragmentLivePlanetRankBinding(FrameLayout frameLayout, ImageView imageView, TextView textView, TextView textView2, ViewPager viewPager) {
        this.e = frameLayout;
        this.f11960a = imageView;
        this.b = textView;
        this.f11961c = textView2;
        this.d = viewPager;
    }

    public static FragmentLivePlanetRankBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static FragmentLivePlanetRankBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_live_planet_rank, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static FragmentLivePlanetRankBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
        if (imageView != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_author);
            if (textView != null) {
                TextView textView2 = (TextView) view.findViewById(R.id.tv_user);
                if (textView2 != null) {
                    ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
                    if (viewPager != null) {
                        return new FragmentLivePlanetRankBinding((FrameLayout) view, imageView, textView, textView2, viewPager);
                    }
                    str = "viewPager";
                } else {
                    str = "tvUser";
                }
            } else {
                str = "tvAuthor";
            }
        } else {
            str = "ivBack";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.e;
    }
}
