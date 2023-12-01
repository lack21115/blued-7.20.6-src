package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/FragmentLivePlanetRecordBinding.class */
public final class FragmentLivePlanetRecordBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f11964a;
    public final LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final SmartRefreshLayout f11965c;
    public final RecyclerView d;
    private final FrameLayout e;

    private FragmentLivePlanetRecordBinding(FrameLayout frameLayout, ImageView imageView, LinearLayout linearLayout, SmartRefreshLayout smartRefreshLayout, RecyclerView recyclerView) {
        this.e = frameLayout;
        this.f11964a = imageView;
        this.b = linearLayout;
        this.f11965c = smartRefreshLayout;
        this.d = recyclerView;
    }

    public static FragmentLivePlanetRecordBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static FragmentLivePlanetRecordBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_live_planet_record, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static FragmentLivePlanetRecordBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_empty);
            if (linearLayout != null) {
                SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refresh_layout);
                if (smartRefreshLayout != null) {
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
                    if (recyclerView != null) {
                        return new FragmentLivePlanetRecordBinding((FrameLayout) view, imageView, linearLayout, smartRefreshLayout, recyclerView);
                    }
                    str = "rvList";
                } else {
                    str = "refreshLayout";
                }
            } else {
                str = "llEmpty";
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
