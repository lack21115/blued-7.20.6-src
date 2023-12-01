package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;
import com.blued.android.module.svgaplayer.SVGAImageView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveBattleRandomAwardDialogBinding.class */
public final class LiveBattleRandomAwardDialogBinding implements ViewBinding {
    public final ImageView a;
    public final ProgressBar b;
    public final RelativeLayout c;
    public final RecyclerView d;
    public final SVGAImageView e;
    private final FrameLayout f;

    private LiveBattleRandomAwardDialogBinding(FrameLayout frameLayout, ImageView imageView, ProgressBar progressBar, RelativeLayout relativeLayout, RecyclerView recyclerView, SVGAImageView sVGAImageView) {
        this.f = frameLayout;
        this.a = imageView;
        this.b = progressBar;
        this.c = relativeLayout;
        this.d = recyclerView;
        this.e = sVGAImageView;
    }

    public static LiveBattleRandomAwardDialogBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static LiveBattleRandomAwardDialogBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_battle_random_award_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveBattleRandomAwardDialogBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
        if (imageView != null) {
            ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.loading);
            if (progressBar != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_root);
                if (relativeLayout != null) {
                    RecyclerView findViewById = view.findViewById(R.id.rv_list);
                    if (findViewById != null) {
                        SVGAImageView sVGAImageView = (SVGAImageView) view.findViewById(R.id.svg_float);
                        if (sVGAImageView != null) {
                            return new LiveBattleRandomAwardDialogBinding((FrameLayout) view, imageView, progressBar, relativeLayout, findViewById, sVGAImageView);
                        }
                        str = "svgFloat";
                    } else {
                        str = "rvList";
                    }
                } else {
                    str = "rlRoot";
                }
            } else {
                str = "loading";
            }
        } else {
            str = "ivClose";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.f;
    }
}
