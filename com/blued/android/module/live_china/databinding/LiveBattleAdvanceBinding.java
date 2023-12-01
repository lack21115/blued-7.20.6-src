package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveBattleAdvanceBinding.class */
public final class LiveBattleAdvanceBinding implements ViewBinding {
    public final FrameLayout a;
    public final CardView b;
    public final FrameLayout c;
    public final ImageView d;
    public final ImageView e;
    public final RecyclerView f;
    public final RecyclerView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final FrameLayout k;
    public final FrameLayout l;
    private final FrameLayout m;

    private LiveBattleAdvanceBinding(FrameLayout frameLayout, FrameLayout frameLayout2, CardView cardView, FrameLayout frameLayout3, ImageView imageView, ImageView imageView2, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView, TextView textView2, TextView textView3, FrameLayout frameLayout4, FrameLayout frameLayout5) {
        this.m = frameLayout;
        this.a = frameLayout2;
        this.b = cardView;
        this.c = frameLayout3;
        this.d = imageView;
        this.e = imageView2;
        this.f = recyclerView;
        this.g = recyclerView2;
        this.h = textView;
        this.i = textView2;
        this.j = textView3;
        this.k = frameLayout4;
        this.l = frameLayout5;
    }

    public static LiveBattleAdvanceBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_battle_advance, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveBattleAdvanceBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_buy);
        if (frameLayout != null) {
            CardView findViewById = view.findViewById(R.id.fl_card);
            if (findViewById != null) {
                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.fl_wrap);
                if (frameLayout2 != null) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
                    if (imageView != null) {
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_to_get);
                        if (imageView2 != null) {
                            RecyclerView findViewById2 = view.findViewById(R.id.rv_list);
                            if (findViewById2 != null) {
                                RecyclerView findViewById3 = view.findViewById(R.id.rv_list_advance);
                                if (findViewById3 != null) {
                                    TextView textView = (TextView) view.findViewById(R.id.tv_buy);
                                    if (textView != null) {
                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_desc);
                                        if (textView2 != null) {
                                            TextView textView3 = (TextView) view.findViewById(R.id.tv_title);
                                            if (textView3 != null) {
                                                FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.view_advance);
                                                if (frameLayout3 != null) {
                                                    FrameLayout frameLayout4 = (FrameLayout) view.findViewById(R.id.view_root);
                                                    if (frameLayout4 != null) {
                                                        return new LiveBattleAdvanceBinding((FrameLayout) view, frameLayout, findViewById, frameLayout2, imageView, imageView2, findViewById2, findViewById3, textView, textView2, textView3, frameLayout3, frameLayout4);
                                                    }
                                                    str = "viewRoot";
                                                } else {
                                                    str = "viewAdvance";
                                                }
                                            } else {
                                                str = "tvTitle";
                                            }
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
                                str = "rvList";
                            }
                        } else {
                            str = "ivToGet";
                        }
                    } else {
                        str = "ivClose";
                    }
                } else {
                    str = "flWrap";
                }
            } else {
                str = "flCard";
            }
        } else {
            str = "flBuy";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.m;
    }
}
