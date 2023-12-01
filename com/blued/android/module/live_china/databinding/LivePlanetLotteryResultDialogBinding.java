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

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LivePlanetLotteryResultDialogBinding.class */
public final class LivePlanetLotteryResultDialogBinding implements ViewBinding {
    public final ImageView a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final RelativeLayout j;
    public final RelativeLayout k;
    public final LinearLayout l;
    public final RelativeLayout m;
    public final RelativeLayout n;
    public final RelativeLayout o;
    public final RelativeLayout p;
    public final RecyclerView q;
    public final TextView r;
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    private final FrameLayout y;

    private LivePlanetLotteryResultDialogBinding(FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, LinearLayout linearLayout, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.y = frameLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = imageView4;
        this.e = imageView5;
        this.f = imageView6;
        this.g = imageView7;
        this.h = imageView8;
        this.i = imageView9;
        this.j = relativeLayout;
        this.k = relativeLayout2;
        this.l = linearLayout;
        this.m = relativeLayout3;
        this.n = relativeLayout4;
        this.o = relativeLayout5;
        this.p = relativeLayout6;
        this.q = recyclerView;
        this.r = textView;
        this.s = textView2;
        this.t = textView3;
        this.u = textView4;
        this.v = textView5;
        this.w = textView6;
        this.x = textView7;
    }

    public static LivePlanetLotteryResultDialogBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static LivePlanetLotteryResultDialogBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_planet_lottery_result_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LivePlanetLotteryResultDialogBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_not_winning_loop);
            if (imageView2 != null) {
                ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_power);
                if (imageView3 != null) {
                    ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_power_lucky);
                    if (imageView4 != null) {
                        ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_winning_background);
                        if (imageView5 != null) {
                            ImageView imageView6 = (ImageView) view.findViewById(R.id.iv_winning_planet);
                            if (imageView6 != null) {
                                ImageView imageView7 = (ImageView) view.findViewById(R.id.iv_winning_planet_lucky);
                                if (imageView7 != null) {
                                    ImageView imageView8 = (ImageView) view.findViewById(R.id.iv_winning_planet_name_img);
                                    if (imageView8 != null) {
                                        ImageView imageView9 = (ImageView) view.findViewById(R.id.iv_winning_planet_name_img_lucky);
                                        if (imageView9 != null) {
                                            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.ll_winning_planet_info);
                                            if (relativeLayout != null) {
                                                RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.ll_winning_planet_info_lucky);
                                                if (relativeLayout2 != null) {
                                                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_winning_planet_info_root_lucky);
                                                    if (linearLayout != null) {
                                                        RelativeLayout relativeLayout3 = (RelativeLayout) view.findViewById(R.id.rl_close);
                                                        if (relativeLayout3 != null) {
                                                            RelativeLayout relativeLayout4 = (RelativeLayout) view.findViewById(R.id.rl_not_winning_root);
                                                            if (relativeLayout4 != null) {
                                                                RelativeLayout relativeLayout5 = (RelativeLayout) view.findViewById(R.id.rl_root);
                                                                if (relativeLayout5 != null) {
                                                                    RelativeLayout relativeLayout6 = (RelativeLayout) view.findViewById(R.id.rl_winning_root);
                                                                    if (relativeLayout6 != null) {
                                                                        RecyclerView findViewById = view.findViewById(R.id.rv_list);
                                                                        if (findViewById != null) {
                                                                            TextView textView = (TextView) view.findViewById(R.id.tv_close);
                                                                            if (textView != null) {
                                                                                TextView textView2 = (TextView) view.findViewById(R.id.tv_not_bet);
                                                                                if (textView2 != null) {
                                                                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_power);
                                                                                    if (textView3 != null) {
                                                                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_power_lucky);
                                                                                        if (textView4 != null) {
                                                                                            TextView textView5 = (TextView) view.findViewById(R.id.tv_winning_planet);
                                                                                            if (textView5 != null) {
                                                                                                TextView textView6 = (TextView) view.findViewById(R.id.tv_winning_planet_info);
                                                                                                if (textView6 != null) {
                                                                                                    TextView textView7 = (TextView) view.findViewById(R.id.tv_winning_value);
                                                                                                    if (textView7 != null) {
                                                                                                        return new LivePlanetLotteryResultDialogBinding((FrameLayout) view, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, relativeLayout, relativeLayout2, linearLayout, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, findViewById, textView, textView2, textView3, textView4, textView5, textView6, textView7);
                                                                                                    }
                                                                                                    str = "tvWinningValue";
                                                                                                } else {
                                                                                                    str = "tvWinningPlanetInfo";
                                                                                                }
                                                                                            } else {
                                                                                                str = "tvWinningPlanet";
                                                                                            }
                                                                                        } else {
                                                                                            str = "tvPowerLucky";
                                                                                        }
                                                                                    } else {
                                                                                        str = "tvPower";
                                                                                    }
                                                                                } else {
                                                                                    str = "tvNotBet";
                                                                                }
                                                                            } else {
                                                                                str = "tvClose";
                                                                            }
                                                                        } else {
                                                                            str = "rvList";
                                                                        }
                                                                    } else {
                                                                        str = "rlWinningRoot";
                                                                    }
                                                                } else {
                                                                    str = "rlRoot";
                                                                }
                                                            } else {
                                                                str = "rlNotWinningRoot";
                                                            }
                                                        } else {
                                                            str = "rlClose";
                                                        }
                                                    } else {
                                                        str = "llWinningPlanetInfoRootLucky";
                                                    }
                                                } else {
                                                    str = "llWinningPlanetInfoLucky";
                                                }
                                            } else {
                                                str = "llWinningPlanetInfo";
                                            }
                                        } else {
                                            str = "ivWinningPlanetNameImgLucky";
                                        }
                                    } else {
                                        str = "ivWinningPlanetNameImg";
                                    }
                                } else {
                                    str = "ivWinningPlanetLucky";
                                }
                            } else {
                                str = "ivWinningPlanet";
                            }
                        } else {
                            str = "ivWinningBackground";
                        }
                    } else {
                        str = "ivPowerLucky";
                    }
                } else {
                    str = "ivPower";
                }
            } else {
                str = "ivNotWinningLoop";
            }
        } else {
            str = "ivClose";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.y;
    }
}
