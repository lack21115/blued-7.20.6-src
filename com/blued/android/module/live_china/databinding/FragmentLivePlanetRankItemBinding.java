package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/FragmentLivePlanetRankItemBinding.class */
public final class FragmentLivePlanetRankItemBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f11962a;
    public final RecyclerView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f11963c;
    private final FrameLayout d;

    private FragmentLivePlanetRankItemBinding(FrameLayout frameLayout, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView) {
        this.d = frameLayout;
        this.f11962a = linearLayout;
        this.b = recyclerView;
        this.f11963c = textView;
    }

    public static FragmentLivePlanetRankItemBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static FragmentLivePlanetRankItemBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_live_planet_rank_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static FragmentLivePlanetRankItemBinding a(View view) {
        String str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_empty);
        if (linearLayout != null) {
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
            if (recyclerView != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_empty);
                if (textView != null) {
                    return new FragmentLivePlanetRankItemBinding((FrameLayout) view, linearLayout, recyclerView, textView);
                }
                str = "tvEmpty";
            } else {
                str = "rvList";
            }
        } else {
            str = "llEmpty";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.d;
    }
}
