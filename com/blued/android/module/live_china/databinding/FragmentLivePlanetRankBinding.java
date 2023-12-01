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
    public final ImageView a;
    public final TextView b;
    public final TextView c;
    public final ViewPager d;
    private final FrameLayout e;

    private FragmentLivePlanetRankBinding(FrameLayout frameLayout, ImageView imageView, TextView textView, TextView textView2, ViewPager viewPager) {
        this.e = frameLayout;
        this.a = imageView;
        this.b = textView;
        this.c = textView2;
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
                    ViewPager findViewById = view.findViewById(R.id.view_pager);
                    if (findViewById != null) {
                        return new FragmentLivePlanetRankBinding((FrameLayout) view, imageView, textView, textView2, findViewById);
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

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.e;
    }
}
