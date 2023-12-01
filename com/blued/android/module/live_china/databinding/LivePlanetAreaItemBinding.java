package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live.base.view.clickanimview.BamFrameLayout;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LivePlanetAreaItemBinding.class */
public final class LivePlanetAreaItemBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final BamFrameLayout f12358a;
    public final FrameLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f12359c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final View g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final LinearLayout k;
    public final TextView l;
    public final TextView m;
    private final RelativeLayout n;

    private LivePlanetAreaItemBinding(RelativeLayout relativeLayout, BamFrameLayout bamFrameLayout, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, View view, ImageView imageView5, ImageView imageView6, ImageView imageView7, LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.n = relativeLayout;
        this.f12358a = bamFrameLayout;
        this.b = frameLayout;
        this.f12359c = imageView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = imageView4;
        this.g = view;
        this.h = imageView5;
        this.i = imageView6;
        this.j = imageView7;
        this.k = linearLayout;
        this.l = textView;
        this.m = textView2;
    }

    public static LivePlanetAreaItemBinding a(View view) {
        String str;
        BamFrameLayout bamFrameLayout = (BamFrameLayout) view.findViewById(R.id.fl_count_root);
        if (bamFrameLayout != null) {
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_power);
            if (frameLayout != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_border_blue);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_border_default);
                    if (imageView2 != null) {
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_border_gold);
                        if (imageView3 != null) {
                            ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_close);
                            if (imageView4 != null) {
                                View findViewById = view.findViewById(R.id.iv_dispatch_ing);
                                if (findViewById != null) {
                                    ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_lottery_border);
                                    if (imageView5 != null) {
                                        ImageView imageView6 = (ImageView) view.findViewById(R.id.iv_lottery_border_jack);
                                        if (imageView6 != null) {
                                            ImageView imageView7 = (ImageView) view.findViewById(R.id.iv_name);
                                            if (imageView7 != null) {
                                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_name_root);
                                                if (linearLayout != null) {
                                                    TextView textView = (TextView) view.findViewById(R.id.tv_num);
                                                    if (textView != null) {
                                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_power);
                                                        if (textView2 != null) {
                                                            return new LivePlanetAreaItemBinding((RelativeLayout) view, bamFrameLayout, frameLayout, imageView, imageView2, imageView3, imageView4, findViewById, imageView5, imageView6, imageView7, linearLayout, textView, textView2);
                                                        }
                                                        str = "tvPower";
                                                    } else {
                                                        str = "tvNum";
                                                    }
                                                } else {
                                                    str = "llNameRoot";
                                                }
                                            } else {
                                                str = "ivName";
                                            }
                                        } else {
                                            str = "ivLotteryBorderJack";
                                        }
                                    } else {
                                        str = "ivLotteryBorder";
                                    }
                                } else {
                                    str = "ivDispatchIng";
                                }
                            } else {
                                str = "ivClose";
                            }
                        } else {
                            str = "ivBorderGold";
                        }
                    } else {
                        str = "ivBorderDefault";
                    }
                } else {
                    str = "ivBorderBlue";
                }
            } else {
                str = "flPower";
            }
        } else {
            str = "flCountRoot";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.n;
    }
}
