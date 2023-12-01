package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/FragmentLuckyBagBinding.class */
public final class FragmentLuckyBagBinding implements ViewBinding {
    public final RecyclerView a;
    private final RelativeLayout b;

    private FragmentLuckyBagBinding(RelativeLayout relativeLayout, RecyclerView recyclerView) {
        this.b = relativeLayout;
        this.a = recyclerView;
    }

    public static FragmentLuckyBagBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_lucky_bag, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static FragmentLuckyBagBinding a(View view) {
        RecyclerView findViewById = view.findViewById(R.id.rv_list);
        if (findViewById != null) {
            return new FragmentLuckyBagBinding((RelativeLayout) view, findViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("rvList"));
    }

    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.b;
    }
}
