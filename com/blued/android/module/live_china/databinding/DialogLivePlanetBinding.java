package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live.base.view.clickanimview.BamFrameLayout;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.view.LivePlanetAreaView;
import com.blued.android.module.live_china.view.LivePlanetBroadcastView;
import com.blued.android.module.live_china.view.LivePlanetTimeView;
import com.blued.android.module.svgaplayer.SVGAImageView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/DialogLivePlanetBinding.class */
public final class DialogLivePlanetBinding implements ViewBinding {
    public final LivePlanetAreaView A;
    public final LivePlanetAreaView B;
    public final SVGAImageView C;
    public final TextView D;
    public final TextView E;
    public final TextView F;
    public final TextView G;
    public final TextView H;
    public final TextView I;
    public final TextView J;
    public final TextView K;
    public final TextView L;
    public final TextView M;
    public final TextView N;
    public final TextView O;
    public final TextView P;
    public final TextView Q;
    public final TextView R;
    private final FrameLayout S;
    public final LivePlanetBroadcastView a;
    public final BamFrameLayout b;
    public final BamFrameLayout c;
    public final BamFrameLayout d;
    public final FrameLayout e;
    public final FrameLayout f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final ImageView k;
    public final ImageView l;
    public final ImageView m;
    public final ImageView n;
    public final ImageView o;
    public final ImageView p;
    public final LinearLayout q;
    public final LinearLayout r;
    public final FrameLayout s;
    public final LivePlanetTimeView t;
    public final LivePlanetAreaView u;
    public final LivePlanetAreaView v;
    public final LivePlanetAreaView w;
    public final LivePlanetAreaView x;
    public final LivePlanetAreaView y;
    public final LivePlanetAreaView z;

    private DialogLivePlanetBinding(FrameLayout frameLayout, LivePlanetBroadcastView livePlanetBroadcastView, BamFrameLayout bamFrameLayout, BamFrameLayout bamFrameLayout2, BamFrameLayout bamFrameLayout3, FrameLayout frameLayout2, FrameLayout frameLayout3, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, LinearLayout linearLayout, LinearLayout linearLayout2, FrameLayout frameLayout4, LivePlanetTimeView livePlanetTimeView, LivePlanetAreaView livePlanetAreaView, LivePlanetAreaView livePlanetAreaView2, LivePlanetAreaView livePlanetAreaView3, LivePlanetAreaView livePlanetAreaView4, LivePlanetAreaView livePlanetAreaView5, LivePlanetAreaView livePlanetAreaView6, LivePlanetAreaView livePlanetAreaView7, LivePlanetAreaView livePlanetAreaView8, SVGAImageView sVGAImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15) {
        this.S = frameLayout;
        this.a = livePlanetBroadcastView;
        this.b = bamFrameLayout;
        this.c = bamFrameLayout2;
        this.d = bamFrameLayout3;
        this.e = frameLayout2;
        this.f = frameLayout3;
        this.g = imageView;
        this.h = imageView2;
        this.i = imageView3;
        this.j = imageView4;
        this.k = imageView5;
        this.l = imageView6;
        this.m = imageView7;
        this.n = imageView8;
        this.o = imageView9;
        this.p = imageView10;
        this.q = linearLayout;
        this.r = linearLayout2;
        this.s = frameLayout4;
        this.t = livePlanetTimeView;
        this.u = livePlanetAreaView;
        this.v = livePlanetAreaView2;
        this.w = livePlanetAreaView3;
        this.x = livePlanetAreaView4;
        this.y = livePlanetAreaView5;
        this.z = livePlanetAreaView6;
        this.A = livePlanetAreaView7;
        this.B = livePlanetAreaView8;
        this.C = sVGAImageView;
        this.D = textView;
        this.E = textView2;
        this.F = textView3;
        this.G = textView4;
        this.H = textView5;
        this.I = textView6;
        this.J = textView7;
        this.K = textView8;
        this.L = textView9;
        this.M = textView10;
        this.N = textView11;
        this.O = textView12;
        this.P = textView13;
        this.Q = textView14;
        this.R = textView15;
    }

    public static DialogLivePlanetBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogLivePlanetBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_live_planet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogLivePlanetBinding a(View view) {
        String str;
        LivePlanetBroadcastView livePlanetBroadcastView = (LivePlanetBroadcastView) view.findViewById(R.id.broadcast);
        if (livePlanetBroadcastView != null) {
            BamFrameLayout bamFrameLayout = (BamFrameLayout) view.findViewById(R.id.fl_add_dispatch_1);
            if (bamFrameLayout != null) {
                BamFrameLayout bamFrameLayout2 = (BamFrameLayout) view.findViewById(R.id.fl_add_dispatch_2);
                if (bamFrameLayout2 != null) {
                    BamFrameLayout bamFrameLayout3 = (BamFrameLayout) view.findViewById(R.id.fl_add_dispatch_3);
                    if (bamFrameLayout3 != null) {
                        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_give_num_root);
                        if (frameLayout != null) {
                            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.fl_planet_area_root);
                            if (frameLayout2 != null) {
                                ImageView imageView = (ImageView) view.findViewById(R.id.iv_fly_star);
                                if (imageView != null) {
                                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_give_num_arrows);
                                    if (imageView2 != null) {
                                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_planet_haiwang);
                                        if (imageView3 != null) {
                                            ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_planet_huoxing);
                                            if (imageView4 != null) {
                                                ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_planet_jinxing);
                                                if (imageView5 != null) {
                                                    ImageView imageView6 = (ImageView) view.findViewById(R.id.iv_planet_mingwang);
                                                    if (imageView6 != null) {
                                                        ImageView imageView7 = (ImageView) view.findViewById(R.id.iv_planet_muxing);
                                                        if (imageView7 != null) {
                                                            ImageView imageView8 = (ImageView) view.findViewById(R.id.iv_planet_shuixing);
                                                            if (imageView8 != null) {
                                                                ImageView imageView9 = (ImageView) view.findViewById(R.id.iv_planet_tianwang);
                                                                if (imageView9 != null) {
                                                                    ImageView imageView10 = (ImageView) view.findViewById(R.id.iv_planet_tuxing);
                                                                    if (imageView10 != null) {
                                                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_gift_root);
                                                                        if (linearLayout != null) {
                                                                            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_my_airship_root);
                                                                            if (linearLayout2 != null) {
                                                                                FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.loading);
                                                                                if (frameLayout3 != null) {
                                                                                    LivePlanetTimeView livePlanetTimeView = (LivePlanetTimeView) view.findViewById(R.id.lptv_time);
                                                                                    if (livePlanetTimeView != null) {
                                                                                        LivePlanetAreaView livePlanetAreaView = (LivePlanetAreaView) view.findViewById(R.id.planet_area_1);
                                                                                        if (livePlanetAreaView != null) {
                                                                                            LivePlanetAreaView livePlanetAreaView2 = (LivePlanetAreaView) view.findViewById(R.id.planet_area_2);
                                                                                            if (livePlanetAreaView2 != null) {
                                                                                                LivePlanetAreaView livePlanetAreaView3 = (LivePlanetAreaView) view.findViewById(R.id.planet_area_3);
                                                                                                if (livePlanetAreaView3 != null) {
                                                                                                    LivePlanetAreaView livePlanetAreaView4 = (LivePlanetAreaView) view.findViewById(R.id.planet_area_4);
                                                                                                    if (livePlanetAreaView4 != null) {
                                                                                                        LivePlanetAreaView livePlanetAreaView5 = (LivePlanetAreaView) view.findViewById(R.id.planet_area_5);
                                                                                                        if (livePlanetAreaView5 != null) {
                                                                                                            LivePlanetAreaView livePlanetAreaView6 = (LivePlanetAreaView) view.findViewById(R.id.planet_area_6);
                                                                                                            if (livePlanetAreaView6 != null) {
                                                                                                                LivePlanetAreaView livePlanetAreaView7 = (LivePlanetAreaView) view.findViewById(R.id.planet_area_7);
                                                                                                                if (livePlanetAreaView7 != null) {
                                                                                                                    LivePlanetAreaView livePlanetAreaView8 = (LivePlanetAreaView) view.findViewById(R.id.planet_area_8);
                                                                                                                    if (livePlanetAreaView8 != null) {
                                                                                                                        SVGAImageView sVGAImageView = (SVGAImageView) view.findViewById(R.id.svg_background);
                                                                                                                        if (sVGAImageView != null) {
                                                                                                                            TextView textView = (TextView) view.findViewById(R.id.tv_add_dispatch_1);
                                                                                                                            if (textView != null) {
                                                                                                                                TextView textView2 = (TextView) view.findViewById(R.id.tv_add_dispatch_2);
                                                                                                                                if (textView2 != null) {
                                                                                                                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_add_dispatch_3);
                                                                                                                                    if (textView3 != null) {
                                                                                                                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_add_dispatch_shadow_1);
                                                                                                                                        if (textView4 != null) {
                                                                                                                                            TextView textView5 = (TextView) view.findViewById(R.id.tv_add_dispatch_shadow_2);
                                                                                                                                            if (textView5 != null) {
                                                                                                                                                TextView textView6 = (TextView) view.findViewById(R.id.tv_add_dispatch_shadow_3);
                                                                                                                                                if (textView6 != null) {
                                                                                                                                                    TextView textView7 = (TextView) view.findViewById(R.id.tv_give);
                                                                                                                                                    if (textView7 != null) {
                                                                                                                                                        TextView textView8 = (TextView) view.findViewById(R.id.tv_give_num);
                                                                                                                                                        if (textView8 != null) {
                                                                                                                                                            TextView textView9 = (TextView) view.findViewById(R.id.tv_my_airship_count);
                                                                                                                                                            if (textView9 != null) {
                                                                                                                                                                TextView textView10 = (TextView) view.findViewById(R.id.tv_my_airship_hint);
                                                                                                                                                                if (textView10 != null) {
                                                                                                                                                                    TextView textView11 = (TextView) view.findViewById(R.id.tv_my_dispatch);
                                                                                                                                                                    if (textView11 != null) {
                                                                                                                                                                        TextView textView12 = (TextView) view.findViewById(R.id.tv_ranking);
                                                                                                                                                                        if (textView12 != null) {
                                                                                                                                                                            TextView textView13 = (TextView) view.findViewById(R.id.tv_record);
                                                                                                                                                                            if (textView13 != null) {
                                                                                                                                                                                TextView textView14 = (TextView) view.findViewById(R.id.tv_rule);
                                                                                                                                                                                if (textView14 != null) {
                                                                                                                                                                                    TextView textView15 = (TextView) view.findViewById(R.id.tv_select_area_hint);
                                                                                                                                                                                    if (textView15 != null) {
                                                                                                                                                                                        return new DialogLivePlanetBinding((FrameLayout) view, livePlanetBroadcastView, bamFrameLayout, bamFrameLayout2, bamFrameLayout3, frameLayout, frameLayout2, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, linearLayout, linearLayout2, frameLayout3, livePlanetTimeView, livePlanetAreaView, livePlanetAreaView2, livePlanetAreaView3, livePlanetAreaView4, livePlanetAreaView5, livePlanetAreaView6, livePlanetAreaView7, livePlanetAreaView8, sVGAImageView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15);
                                                                                                                                                                                    }
                                                                                                                                                                                    str = "tvSelectAreaHint";
                                                                                                                                                                                } else {
                                                                                                                                                                                    str = "tvRule";
                                                                                                                                                                                }
                                                                                                                                                                            } else {
                                                                                                                                                                                str = "tvRecord";
                                                                                                                                                                            }
                                                                                                                                                                        } else {
                                                                                                                                                                            str = "tvRanking";
                                                                                                                                                                        }
                                                                                                                                                                    } else {
                                                                                                                                                                        str = "tvMyDispatch";
                                                                                                                                                                    }
                                                                                                                                                                } else {
                                                                                                                                                                    str = "tvMyAirshipHint";
                                                                                                                                                                }
                                                                                                                                                            } else {
                                                                                                                                                                str = "tvMyAirshipCount";
                                                                                                                                                            }
                                                                                                                                                        } else {
                                                                                                                                                            str = "tvGiveNum";
                                                                                                                                                        }
                                                                                                                                                    } else {
                                                                                                                                                        str = "tvGive";
                                                                                                                                                    }
                                                                                                                                                } else {
                                                                                                                                                    str = "tvAddDispatchShadow3";
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                str = "tvAddDispatchShadow2";
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            str = "tvAddDispatchShadow1";
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        str = "tvAddDispatch3";
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    str = "tvAddDispatch2";
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                str = "tvAddDispatch1";
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            str = "svgBackground";
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        str = "planetArea8";
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    str = "planetArea7";
                                                                                                                }
                                                                                                            } else {
                                                                                                                str = "planetArea6";
                                                                                                            }
                                                                                                        } else {
                                                                                                            str = "planetArea5";
                                                                                                        }
                                                                                                    } else {
                                                                                                        str = "planetArea4";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "planetArea3";
                                                                                                }
                                                                                            } else {
                                                                                                str = "planetArea2";
                                                                                            }
                                                                                        } else {
                                                                                            str = "planetArea1";
                                                                                        }
                                                                                    } else {
                                                                                        str = "lptvTime";
                                                                                    }
                                                                                } else {
                                                                                    str = "loading";
                                                                                }
                                                                            } else {
                                                                                str = "llMyAirshipRoot";
                                                                            }
                                                                        } else {
                                                                            str = "llGiftRoot";
                                                                        }
                                                                    } else {
                                                                        str = "ivPlanetTuxing";
                                                                    }
                                                                } else {
                                                                    str = "ivPlanetTianwang";
                                                                }
                                                            } else {
                                                                str = "ivPlanetShuixing";
                                                            }
                                                        } else {
                                                            str = "ivPlanetMuxing";
                                                        }
                                                    } else {
                                                        str = "ivPlanetMingwang";
                                                    }
                                                } else {
                                                    str = "ivPlanetJinxing";
                                                }
                                            } else {
                                                str = "ivPlanetHuoxing";
                                            }
                                        } else {
                                            str = "ivPlanetHaiwang";
                                        }
                                    } else {
                                        str = "ivGiveNumArrows";
                                    }
                                } else {
                                    str = "ivFlyStar";
                                }
                            } else {
                                str = "flPlanetAreaRoot";
                            }
                        } else {
                            str = "flGiveNumRoot";
                        }
                    } else {
                        str = "flAddDispatch3";
                    }
                } else {
                    str = "flAddDispatch2";
                }
            } else {
                str = "flAddDispatch1";
            }
        } else {
            str = "broadcast";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.S;
    }
}
