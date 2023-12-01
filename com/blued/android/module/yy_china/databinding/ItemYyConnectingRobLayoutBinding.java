package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYBaseUserHeadView;
import com.blued.android.module.yy_china.view.YYMemberRobView;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.ktv.method.lrc.widget.LyricsBorShowingView;
import com.ktv.method.lrc.widget.LyricsBorSingSingerView;
import com.ktv.method.lrc.widget.LyricsBorSinglisView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyConnectingRobLayoutBinding.class */
public final class ItemYyConnectingRobLayoutBinding implements ViewBinding {
    public final TextView A;
    public final ShapeTextView B;
    public final TextView C;
    public final ShapeTextView D;
    public final ShapeTextView E;
    public final TextView F;
    public final ShapeTextView G;
    public final YYMemberRobView H;
    public final YYMemberRobView I;
    public final YYMemberRobView J;
    public final YYMemberRobView K;
    public final YYMemberRobView L;
    public final YYMemberRobView M;
    public final YYMemberRobView N;
    public final YYMemberRobView O;
    private final ConstraintLayout P;

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16693a;
    public final ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f16694c;
    public final LinearLayout d;
    public final Group e;
    public final Group f;
    public final Group g;
    public final Group h;
    public final YYBaseUserHeadView i;
    public final SVGAImageView j;
    public final ConstraintLayout k;
    public final ImageView l;
    public final ShapeTextView m;
    public final ShapeTextView n;
    public final ShapeTextView o;
    public final ShapeTextView p;
    public final ImageView q;
    public final LinearLayout r;
    public final LinearLayout s;
    public final LinearLayout t;
    public final LinearLayout u;
    public final LyricsBorShowingView v;
    public final LyricsBorSinglisView w;
    public final LyricsBorSingSingerView x;
    public final SVGAImageView y;
    public final ImageView z;

    private ItemYyConnectingRobLayoutBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, ConstraintLayout constraintLayout2, LinearLayout linearLayout, Group group, Group group2, Group group3, Group group4, YYBaseUserHeadView yYBaseUserHeadView, SVGAImageView sVGAImageView, ConstraintLayout constraintLayout3, ImageView imageView, ShapeTextView shapeTextView3, ShapeTextView shapeTextView4, ShapeTextView shapeTextView5, ShapeTextView shapeTextView6, ImageView imageView2, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LyricsBorShowingView lyricsBorShowingView, LyricsBorSinglisView lyricsBorSinglisView, LyricsBorSingSingerView lyricsBorSingSingerView, SVGAImageView sVGAImageView2, ImageView imageView3, TextView textView, ShapeTextView shapeTextView7, TextView textView2, ShapeTextView shapeTextView8, ShapeTextView shapeTextView9, TextView textView3, ShapeTextView shapeTextView10, YYMemberRobView yYMemberRobView, YYMemberRobView yYMemberRobView2, YYMemberRobView yYMemberRobView3, YYMemberRobView yYMemberRobView4, YYMemberRobView yYMemberRobView5, YYMemberRobView yYMemberRobView6, YYMemberRobView yYMemberRobView7, YYMemberRobView yYMemberRobView8) {
        this.P = constraintLayout;
        this.f16693a = shapeTextView;
        this.b = shapeTextView2;
        this.f16694c = constraintLayout2;
        this.d = linearLayout;
        this.e = group;
        this.f = group2;
        this.g = group3;
        this.h = group4;
        this.i = yYBaseUserHeadView;
        this.j = sVGAImageView;
        this.k = constraintLayout3;
        this.l = imageView;
        this.m = shapeTextView3;
        this.n = shapeTextView4;
        this.o = shapeTextView5;
        this.p = shapeTextView6;
        this.q = imageView2;
        this.r = linearLayout2;
        this.s = linearLayout3;
        this.t = linearLayout4;
        this.u = linearLayout5;
        this.v = lyricsBorShowingView;
        this.w = lyricsBorSinglisView;
        this.x = lyricsBorSingSingerView;
        this.y = sVGAImageView2;
        this.z = imageView3;
        this.A = textView;
        this.B = shapeTextView7;
        this.C = textView2;
        this.D = shapeTextView8;
        this.E = shapeTextView9;
        this.F = textView3;
        this.G = shapeTextView10;
        this.H = yYMemberRobView;
        this.I = yYMemberRobView2;
        this.J = yYMemberRobView3;
        this.K = yYMemberRobView4;
        this.L = yYMemberRobView5;
        this.M = yYMemberRobView6;
        this.N = yYMemberRobView7;
        this.O = yYMemberRobView8;
    }

    public static ItemYyConnectingRobLayoutBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_sing_singger_switch);
        if (shapeTextView != null) {
            ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.btn_sing_singger_tiaoying);
            if (shapeTextView2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.con);
                if (constraintLayout != null) {
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.con_showing);
                    if (linearLayout != null) {
                        Group group = (Group) view.findViewById(R.id.gro_begin);
                        if (group != null) {
                            Group group2 = (Group) view.findViewById(R.id.group_sing_user);
                            if (group2 != null) {
                                Group group3 = (Group) view.findViewById(R.id.grp_sing_lis);
                                if (group3 != null) {
                                    Group group4 = (Group) view.findViewById(R.id.grp_sing_singer);
                                    if (group4 != null) {
                                        YYBaseUserHeadView yYBaseUserHeadView = (YYBaseUserHeadView) view.findViewById(R.id.head_user);
                                        if (yYBaseUserHeadView != null) {
                                            SVGAImageView sVGAImageView = (SVGAImageView) view.findViewById(R.id.head_user_ani);
                                            if (sVGAImageView != null) {
                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.item_rob_root);
                                                if (constraintLayout2 != null) {
                                                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_begin);
                                                    if (imageView != null) {
                                                        ShapeTextView shapeTextView3 = (ShapeTextView) view.findViewById(R.id.iv_lrc_start_1);
                                                        if (shapeTextView3 != null) {
                                                            ShapeTextView shapeTextView4 = (ShapeTextView) view.findViewById(R.id.iv_lrc_start_2);
                                                            if (shapeTextView4 != null) {
                                                                ShapeTextView shapeTextView5 = (ShapeTextView) view.findViewById(R.id.iv_lrc_start_3);
                                                                if (shapeTextView5 != null) {
                                                                    ShapeTextView shapeTextView6 = (ShapeTextView) view.findViewById(R.id.iv_lrc_start_4);
                                                                    if (shapeTextView6 != null) {
                                                                        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_send_gift);
                                                                        if (imageView2 != null) {
                                                                            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_audience_view);
                                                                            if (linearLayout2 != null) {
                                                                                LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.ll_lis_light_and_gift);
                                                                                if (linearLayout3 != null) {
                                                                                    LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.ll_lrc_start);
                                                                                    if (linearLayout4 != null) {
                                                                                        LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.ll_sing);
                                                                                        if (linearLayout5 != null) {
                                                                                            LyricsBorShowingView lyricsBorShowingView = (LyricsBorShowingView) view.findViewById(R.id.lrc_view_showing);
                                                                                            if (lyricsBorShowingView != null) {
                                                                                                LyricsBorSinglisView lyricsBorSinglisView = (LyricsBorSinglisView) view.findViewById(R.id.lrc_view_sing_lis);
                                                                                                if (lyricsBorSinglisView != null) {
                                                                                                    LyricsBorSingSingerView lyricsBorSingSingerView = (LyricsBorSingSingerView) view.findViewById(R.id.lrc_view_sing_singger);
                                                                                                    if (lyricsBorSingSingerView != null) {
                                                                                                        SVGAImageView sVGAImageView2 = (SVGAImageView) view.findViewById(R.id.svga);
                                                                                                        if (sVGAImageView2 != null) {
                                                                                                            ImageView imageView3 = (ImageView) view.findViewById(R.id.top);
                                                                                                            if (imageView3 != null) {
                                                                                                                TextView textView = (TextView) view.findViewById(R.id.tv_begin);
                                                                                                                if (textView != null) {
                                                                                                                    ShapeTextView shapeTextView7 = (ShapeTextView) view.findViewById(R.id.tv_follow);
                                                                                                                    if (shapeTextView7 != null) {
                                                                                                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_show_music_name);
                                                                                                                        if (textView2 != null) {
                                                                                                                            ShapeTextView shapeTextView8 = (ShapeTextView) view.findViewById(R.id.tv_sing_singer_time);
                                                                                                                            if (shapeTextView8 != null) {
                                                                                                                                ShapeTextView shapeTextView9 = (ShapeTextView) view.findViewById(R.id.tv_stop_music);
                                                                                                                                if (shapeTextView9 != null) {
                                                                                                                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_us_name);
                                                                                                                                    if (textView3 != null) {
                                                                                                                                        ShapeTextView shapeTextView10 = (ShapeTextView) view.findViewById(R.id.tv_want_music);
                                                                                                                                        if (shapeTextView10 != null) {
                                                                                                                                            YYMemberRobView yYMemberRobView = (YYMemberRobView) view.findViewById(R.id.user_1);
                                                                                                                                            if (yYMemberRobView != null) {
                                                                                                                                                YYMemberRobView yYMemberRobView2 = (YYMemberRobView) view.findViewById(R.id.user_2);
                                                                                                                                                if (yYMemberRobView2 != null) {
                                                                                                                                                    YYMemberRobView yYMemberRobView3 = (YYMemberRobView) view.findViewById(R.id.user_3);
                                                                                                                                                    if (yYMemberRobView3 != null) {
                                                                                                                                                        YYMemberRobView yYMemberRobView4 = (YYMemberRobView) view.findViewById(R.id.user_4);
                                                                                                                                                        if (yYMemberRobView4 != null) {
                                                                                                                                                            YYMemberRobView yYMemberRobView5 = (YYMemberRobView) view.findViewById(R.id.user_5);
                                                                                                                                                            if (yYMemberRobView5 != null) {
                                                                                                                                                                YYMemberRobView yYMemberRobView6 = (YYMemberRobView) view.findViewById(R.id.user_6);
                                                                                                                                                                if (yYMemberRobView6 != null) {
                                                                                                                                                                    YYMemberRobView yYMemberRobView7 = (YYMemberRobView) view.findViewById(R.id.user_7);
                                                                                                                                                                    if (yYMemberRobView7 != null) {
                                                                                                                                                                        YYMemberRobView yYMemberRobView8 = (YYMemberRobView) view.findViewById(R.id.user_8);
                                                                                                                                                                        if (yYMemberRobView8 != null) {
                                                                                                                                                                            return new ItemYyConnectingRobLayoutBinding((ConstraintLayout) view, shapeTextView, shapeTextView2, constraintLayout, linearLayout, group, group2, group3, group4, yYBaseUserHeadView, sVGAImageView, constraintLayout2, imageView, shapeTextView3, shapeTextView4, shapeTextView5, shapeTextView6, imageView2, linearLayout2, linearLayout3, linearLayout4, linearLayout5, lyricsBorShowingView, lyricsBorSinglisView, lyricsBorSingSingerView, sVGAImageView2, imageView3, textView, shapeTextView7, textView2, shapeTextView8, shapeTextView9, textView3, shapeTextView10, yYMemberRobView, yYMemberRobView2, yYMemberRobView3, yYMemberRobView4, yYMemberRobView5, yYMemberRobView6, yYMemberRobView7, yYMemberRobView8);
                                                                                                                                                                        }
                                                                                                                                                                        str = "user8";
                                                                                                                                                                    } else {
                                                                                                                                                                        str = "user7";
                                                                                                                                                                    }
                                                                                                                                                                } else {
                                                                                                                                                                    str = "user6";
                                                                                                                                                                }
                                                                                                                                                            } else {
                                                                                                                                                                str = "user5";
                                                                                                                                                            }
                                                                                                                                                        } else {
                                                                                                                                                            str = "user4";
                                                                                                                                                        }
                                                                                                                                                    } else {
                                                                                                                                                        str = "user3";
                                                                                                                                                    }
                                                                                                                                                } else {
                                                                                                                                                    str = "user2";
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                str = "user1";
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            str = "tvWantMusic";
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        str = "tvUsName";
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    str = "tvStopMusic";
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                str = "tvSingSingerTime";
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            str = "tvShowMusicName";
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        str = "tvFollow";
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    str = "tvBegin";
                                                                                                                }
                                                                                                            } else {
                                                                                                                str = Constant.MAP_KEY_TOP;
                                                                                                            }
                                                                                                        } else {
                                                                                                            str = "svga";
                                                                                                        }
                                                                                                    } else {
                                                                                                        str = "lrcViewSingSingger";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "lrcViewSingLis";
                                                                                                }
                                                                                            } else {
                                                                                                str = "lrcViewShowing";
                                                                                            }
                                                                                        } else {
                                                                                            str = "llSing";
                                                                                        }
                                                                                    } else {
                                                                                        str = "llLrcStart";
                                                                                    }
                                                                                } else {
                                                                                    str = "llLisLightAndGift";
                                                                                }
                                                                            } else {
                                                                                str = "llAudienceView";
                                                                            }
                                                                        } else {
                                                                            str = "ivSendGift";
                                                                        }
                                                                    } else {
                                                                        str = "ivLrcStart4";
                                                                    }
                                                                } else {
                                                                    str = "ivLrcStart3";
                                                                }
                                                            } else {
                                                                str = "ivLrcStart2";
                                                            }
                                                        } else {
                                                            str = "ivLrcStart1";
                                                        }
                                                    } else {
                                                        str = "ivBegin";
                                                    }
                                                } else {
                                                    str = "itemRobRoot";
                                                }
                                            } else {
                                                str = "headUserAni";
                                            }
                                        } else {
                                            str = "headUser";
                                        }
                                    } else {
                                        str = "grpSingSinger";
                                    }
                                } else {
                                    str = "grpSingLis";
                                }
                            } else {
                                str = "groupSingUser";
                            }
                        } else {
                            str = "groBegin";
                        }
                    } else {
                        str = "conShowing";
                    }
                } else {
                    str = "con";
                }
            } else {
                str = "btnSingSinggerTiaoying";
            }
        } else {
            str = "btnSingSinggerSwitch";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.P;
    }
}
