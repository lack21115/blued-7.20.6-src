package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/DialogLiveMedalExplainBinding.class */
public final class DialogLiveMedalExplainBinding implements ViewBinding {
    public final RecyclerView a;
    public final ImageView b;
    private final FrameLayout c;

    private DialogLiveMedalExplainBinding(FrameLayout frameLayout, RecyclerView recyclerView, ImageView imageView) {
        this.c = frameLayout;
        this.a = recyclerView;
        this.b = imageView;
    }

    public static DialogLiveMedalExplainBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogLiveMedalExplainBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_live_medal_explain, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogLiveMedalExplainBinding a(View view) {
        String str;
        RecyclerView findViewById = view.findViewById(R.id.rv_medal_explain);
        if (findViewById != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.tv_live_desc_back);
            if (imageView != null) {
                return new DialogLiveMedalExplainBinding((FrameLayout) view, findViewById, imageView);
            }
            str = "tvLiveDescBack";
        } else {
            str = "rvMedalExplain";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.c;
    }
}
