package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyRankItemLayoutBinding.class */
public final class FragmentYyRankItemLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f16533a;
    public final ViewPager b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f16534c;
    private final ConstraintLayout d;

    private FragmentYyRankItemLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, ViewPager viewPager, RecyclerView recyclerView) {
        this.d = constraintLayout;
        this.f16533a = imageView;
        this.b = viewPager;
        this.f16534c = recyclerView;
    }

    public static FragmentYyRankItemLayoutBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.img_right);
        if (imageView != null) {
            ViewPager viewPager = (ViewPager) view.findViewById(R.id.rank_item_view_pager);
            if (viewPager != null) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_tab_list);
                if (recyclerView != null) {
                    return new FragmentYyRankItemLayoutBinding((ConstraintLayout) view, imageView, viewPager, recyclerView);
                }
                str = "rvTabList";
            } else {
                str = "rankItemViewPager";
            }
        } else {
            str = "imgRight";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.d;
    }
}
