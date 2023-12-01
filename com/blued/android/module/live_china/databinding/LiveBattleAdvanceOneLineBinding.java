package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveBattleAdvanceOneLineBinding.class */
public final class LiveBattleAdvanceOneLineBinding implements ViewBinding {
    public final ImageView a;
    public final FrameLayout b;
    public final RecyclerView c;
    public final RecyclerView d;
    public final TextView e;
    public final TextView f;
    public final FrameLayout g;
    private final FrameLayout h;

    private LiveBattleAdvanceOneLineBinding(FrameLayout frameLayout, ImageView imageView, FrameLayout frameLayout2, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView, TextView textView2, FrameLayout frameLayout3) {
        this.h = frameLayout;
        this.a = imageView;
        this.b = frameLayout2;
        this.c = recyclerView;
        this.d = recyclerView2;
        this.e = textView;
        this.f = textView2;
        this.g = frameLayout3;
    }

    public static LiveBattleAdvanceOneLineBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_battle_advance_one_line, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveBattleAdvanceOneLineBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
        if (imageView != null) {
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.root);
            if (frameLayout != null) {
                RecyclerView findViewById = view.findViewById(R.id.rv_list);
                if (findViewById != null) {
                    RecyclerView findViewById2 = view.findViewById(R.id.rv_list_advance);
                    if (findViewById2 != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_buy);
                        if (textView != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_title);
                            if (textView2 != null) {
                                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.view_advance);
                                if (frameLayout2 != null) {
                                    return new LiveBattleAdvanceOneLineBinding((FrameLayout) view, imageView, frameLayout, findViewById, findViewById2, textView, textView2, frameLayout2);
                                }
                                str = "viewAdvance";
                            } else {
                                str = "tvTitle";
                            }
                        } else {
                            str = "tvBuy";
                        }
                    } else {
                        str = "rvListAdvance";
                    }
                } else {
                    str = "rvList";
                }
            } else {
                str = "root";
            }
        } else {
            str = "ivClose";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.h;
    }
}
