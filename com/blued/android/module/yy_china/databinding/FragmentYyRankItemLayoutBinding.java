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
    public final ImageView a;
    public final ViewPager b;
    public final RecyclerView c;
    private final ConstraintLayout d;

    private FragmentYyRankItemLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, ViewPager viewPager, RecyclerView recyclerView) {
        this.d = constraintLayout;
        this.a = imageView;
        this.b = viewPager;
        this.c = recyclerView;
    }

    public static FragmentYyRankItemLayoutBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.img_right);
        if (imageView != null) {
            ViewPager findViewById = view.findViewById(R.id.rank_item_view_pager);
            if (findViewById != null) {
                RecyclerView findViewById2 = view.findViewById(R.id.rv_tab_list);
                if (findViewById2 != null) {
                    return new FragmentYyRankItemLayoutBinding((ConstraintLayout) view, imageView, findViewById, findViewById2);
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

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.d;
    }
}
