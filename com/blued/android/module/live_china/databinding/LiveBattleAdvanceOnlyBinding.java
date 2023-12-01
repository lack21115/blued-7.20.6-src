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

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveBattleAdvanceOnlyBinding.class */
public final class LiveBattleAdvanceOnlyBinding implements ViewBinding {
    public final FrameLayout a;
    public final ImageView b;
    public final ImageView c;
    public final FrameLayout d;
    public final RecyclerView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    private final FrameLayout i;

    private LiveBattleAdvanceOnlyBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, ImageView imageView2, FrameLayout frameLayout3, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3) {
        this.i = frameLayout;
        this.a = frameLayout2;
        this.b = imageView;
        this.c = imageView2;
        this.d = frameLayout3;
        this.e = recyclerView;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
    }

    public static LiveBattleAdvanceOnlyBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_battle_advance_only, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveBattleAdvanceOnlyBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_buy);
        if (frameLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_flag);
                if (imageView2 != null) {
                    FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.root);
                    if (frameLayout2 != null) {
                        RecyclerView findViewById = view.findViewById(R.id.rv_list_advance);
                        if (findViewById != null) {
                            TextView textView = (TextView) view.findViewById(R.id.tv_buy);
                            if (textView != null) {
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_desc);
                                if (textView2 != null) {
                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_title);
                                    if (textView3 != null) {
                                        return new LiveBattleAdvanceOnlyBinding((FrameLayout) view, frameLayout, imageView, imageView2, frameLayout2, findViewById, textView, textView2, textView3);
                                    }
                                    str = "tvTitle";
                                } else {
                                    str = "tvDesc";
                                }
                            } else {
                                str = "tvBuy";
                            }
                        } else {
                            str = "rvListAdvance";
                        }
                    } else {
                        str = "root";
                    }
                } else {
                    str = "ivFlag";
                }
            } else {
                str = "ivClose";
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
