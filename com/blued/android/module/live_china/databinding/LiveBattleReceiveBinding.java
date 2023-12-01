package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.view.DisableScrollViewPager;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveBattleReceiveBinding.class */
public final class LiveBattleReceiveBinding implements ViewBinding {
    public final FrameLayout a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final FrameLayout f;
    public final RecyclerView g;
    public final DisableScrollViewPager h;
    private final FrameLayout i;

    private LiveBattleReceiveBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, FrameLayout frameLayout3, RecyclerView recyclerView, DisableScrollViewPager disableScrollViewPager) {
        this.i = frameLayout;
        this.a = frameLayout2;
        this.b = imageView;
        this.c = imageView2;
        this.d = imageView3;
        this.e = imageView4;
        this.f = frameLayout3;
        this.g = recyclerView;
        this.h = disableScrollViewPager;
    }

    public static LiveBattleReceiveBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_battle_receive, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveBattleReceiveBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_buy);
        if (frameLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_box);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_left);
                if (imageView2 != null) {
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_receive);
                    if (imageView3 != null) {
                        ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_right);
                        if (imageView4 != null) {
                            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.root);
                            if (frameLayout2 != null) {
                                RecyclerView findViewById = view.findViewById(R.id.rv_list);
                                if (findViewById != null) {
                                    DisableScrollViewPager disableScrollViewPager = (DisableScrollViewPager) view.findViewById(R.id.view_pager);
                                    if (disableScrollViewPager != null) {
                                        return new LiveBattleReceiveBinding((FrameLayout) view, frameLayout, imageView, imageView2, imageView3, imageView4, frameLayout2, findViewById, disableScrollViewPager);
                                    }
                                    str = "viewPager";
                                } else {
                                    str = "rvList";
                                }
                            } else {
                                str = "root";
                            }
                        } else {
                            str = "ivRight";
                        }
                    } else {
                        str = "ivReceive";
                    }
                } else {
                    str = "ivLeft";
                }
            } else {
                str = "ivBox";
            }
        } else {
            str = "flBuy";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.i;
    }
}
