package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;
import com.blued.android.module.svgaplayer.SVGAImageView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveBattleBuyReceiveBinding.class */
public final class LiveBattleBuyReceiveBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f12135a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f12136c;
    public final LinearLayout d;
    public final RelativeLayout e;
    public final RecyclerView f;
    public final SVGAImageView g;
    public final TextView h;
    public final TextView i;
    private final RelativeLayout j;

    private LiveBattleBuyReceiveBinding(RelativeLayout relativeLayout, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, RelativeLayout relativeLayout2, RecyclerView recyclerView, SVGAImageView sVGAImageView, TextView textView, TextView textView2) {
        this.j = relativeLayout;
        this.f12135a = frameLayout;
        this.b = imageView;
        this.f12136c = imageView2;
        this.d = linearLayout;
        this.e = relativeLayout2;
        this.f = recyclerView;
        this.g = sVGAImageView;
        this.h = textView;
        this.i = textView2;
    }

    public static LiveBattleBuyReceiveBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_battle_buy_receive, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveBattleBuyReceiveBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_content);
        if (frameLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_scatter_flower);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_title);
                if (imageView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_experience);
                    if (linearLayout != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.root);
                        if (relativeLayout != null) {
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
                            if (recyclerView != null) {
                                SVGAImageView sVGAImageView = (SVGAImageView) view.findViewById(R.id.svg_backlight);
                                if (sVGAImageView != null) {
                                    TextView textView = (TextView) view.findViewById(R.id.tv_experience);
                                    if (textView != null) {
                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_ok);
                                        if (textView2 != null) {
                                            return new LiveBattleBuyReceiveBinding((RelativeLayout) view, frameLayout, imageView, imageView2, linearLayout, relativeLayout, recyclerView, sVGAImageView, textView, textView2);
                                        }
                                        str = "tvOk";
                                    } else {
                                        str = "tvExperience";
                                    }
                                } else {
                                    str = "svgBacklight";
                                }
                            } else {
                                str = "rvList";
                            }
                        } else {
                            str = "root";
                        }
                    } else {
                        str = "llExperience";
                    }
                } else {
                    str = "ivTitle";
                }
            } else {
                str = "ivScatterFlower";
            }
        } else {
            str = "flContent";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.j;
    }
}
