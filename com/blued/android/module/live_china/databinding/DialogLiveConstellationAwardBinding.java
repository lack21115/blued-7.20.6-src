package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/DialogLiveConstellationAwardBinding.class */
public final class DialogLiveConstellationAwardBinding implements ViewBinding {
    public final FrameLayout a;
    public final ImageView b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;
    public final LinearLayout f;
    public final RecyclerView g;
    public final RecyclerView h;
    public final TextView i;
    private final FrameLayout j;

    private DialogLiveConstellationAwardBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, LinearLayout linearLayout, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView3) {
        this.j = frameLayout;
        this.a = frameLayout2;
        this.b = imageView;
        this.c = imageView2;
        this.d = textView;
        this.e = textView2;
        this.f = linearLayout;
        this.g = recyclerView;
        this.h = recyclerView2;
        this.i = textView3;
    }

    public static DialogLiveConstellationAwardBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogLiveConstellationAwardBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_live_constellation_award, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogLiveConstellationAwardBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_constellation_main);
        if (frameLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_constellation_close);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_constellation_title);
                if (imageView2 != null) {
                    TextView textView = (TextView) view.findViewById(R.id.live_constellation_king_title);
                    if (textView != null) {
                        TextView textView2 = (TextView) view.findViewById(R.id.live_constellation_spoken_title);
                        if (textView2 != null) {
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_default);
                            if (linearLayout != null) {
                                RecyclerView findViewById = view.findViewById(R.id.recycler_king);
                                if (findViewById != null) {
                                    RecyclerView findViewById2 = view.findViewById(R.id.recycler_spoken);
                                    if (findViewById2 != null) {
                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_award_detail);
                                        if (textView3 != null) {
                                            return new DialogLiveConstellationAwardBinding((FrameLayout) view, frameLayout, imageView, imageView2, textView, textView2, linearLayout, findViewById, findViewById2, textView3);
                                        }
                                        str = "tvAwardDetail";
                                    } else {
                                        str = "recyclerSpoken";
                                    }
                                } else {
                                    str = "recyclerKing";
                                }
                            } else {
                                str = "llDefault";
                            }
                        } else {
                            str = "liveConstellationSpokenTitle";
                        }
                    } else {
                        str = "liveConstellationKingTitle";
                    }
                } else {
                    str = "ivConstellationTitle";
                }
            } else {
                str = "ivConstellationClose";
            }
        } else {
            str = "flConstellationMain";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.j;
    }
}
