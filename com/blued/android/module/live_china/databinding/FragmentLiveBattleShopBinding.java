package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/FragmentLiveBattleShopBinding.class */
public final class FragmentLiveBattleShopBinding implements ViewBinding {
    public final ProgressBar a;
    public final FrameLayout b;
    public final FrameLayout c;
    private final FrameLayout d;

    private FragmentLiveBattleShopBinding(FrameLayout frameLayout, ProgressBar progressBar, FrameLayout frameLayout2, FrameLayout frameLayout3) {
        this.d = frameLayout;
        this.a = progressBar;
        this.b = frameLayout2;
        this.c = frameLayout3;
    }

    public static FragmentLiveBattleShopBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_live_battle_shop, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static FragmentLiveBattleShopBinding a(View view) {
        String str;
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.bar);
        if (progressBar != null) {
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content_view);
            if (frameLayout != null) {
                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.fl_root);
                if (frameLayout2 != null) {
                    return new FragmentLiveBattleShopBinding((FrameLayout) view, progressBar, frameLayout, frameLayout2);
                }
                str = "flRoot";
            } else {
                str = "contentView";
            }
        } else {
            str = "bar";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.d;
    }
}
