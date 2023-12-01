package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.view.LiveGiftAndMedalCardView;
import com.blued.android.module.live_china.view.LiveUserCardModuleView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LayoutUsercardDialogBinding.class */
public final class LayoutUsercardDialogBinding implements ViewBinding {
    public final RelativeLayout A;
    public final TextView B;
    public final ShapeTextView C;
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
    public final ShapeTextView R;
    public final TextView S;
    public final FrameLayout T;
    private final FrameLayout U;

    /* renamed from: a  reason: collision with root package name */
    public final CardView f12115a;
    public final FrameLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f12116c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final ImageView k;
    public final ImageView l;
    public final ImageView m;
    public final LiveGiftAndMedalCardView n;
    public final ImageView o;
    public final ImageView p;
    public final LinearLayout q;
    public final LinearLayout r;
    public final LinearLayout s;
    public final LinearLayout t;
    public final LinearLayout u;
    public final LinearLayout v;
    public final LinearLayout w;
    public final LinearLayout x;
    public final LiveUserCardModuleView y;
    public final RelativeLayout z;

    private LayoutUsercardDialogBinding(FrameLayout frameLayout, CardView cardView, FrameLayout frameLayout2, FrameLayout frameLayout3, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, LiveGiftAndMedalCardView liveGiftAndMedalCardView, ImageView imageView11, ImageView imageView12, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, LiveUserCardModuleView liveUserCardModuleView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, ShapeTextView shapeTextView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, ShapeTextView shapeTextView2, TextView textView16, FrameLayout frameLayout4) {
        this.U = frameLayout;
        this.f12115a = cardView;
        this.b = frameLayout2;
        this.f12116c = frameLayout3;
        this.d = imageView;
        this.e = imageView2;
        this.f = imageView3;
        this.g = imageView4;
        this.h = imageView5;
        this.i = imageView6;
        this.j = imageView7;
        this.k = imageView8;
        this.l = imageView9;
        this.m = imageView10;
        this.n = liveGiftAndMedalCardView;
        this.o = imageView11;
        this.p = imageView12;
        this.q = linearLayout;
        this.r = linearLayout2;
        this.s = linearLayout3;
        this.t = linearLayout4;
        this.u = linearLayout5;
        this.v = linearLayout6;
        this.w = linearLayout7;
        this.x = linearLayout8;
        this.y = liveUserCardModuleView;
        this.z = relativeLayout;
        this.A = relativeLayout2;
        this.B = textView;
        this.C = shapeTextView;
        this.D = textView2;
        this.E = textView3;
        this.F = textView4;
        this.G = textView5;
        this.H = textView6;
        this.I = textView7;
        this.J = textView8;
        this.K = textView9;
        this.L = textView10;
        this.M = textView11;
        this.N = textView12;
        this.O = textView13;
        this.P = textView14;
        this.Q = textView15;
        this.R = shapeTextView2;
        this.S = textView16;
        this.T = frameLayout4;
    }

    public static LayoutUsercardDialogBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static LayoutUsercardDialogBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_usercard_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LayoutUsercardDialogBinding a(View view) {
        String str;
        CardView cardView = (CardView) view.findViewById(R.id.cv_background_root);
        if (cardView != null) {
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_avatar);
            if (frameLayout != null) {
                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.fl_rank_top_one);
                if (frameLayout2 != null) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.header_view);
                    if (imageView != null) {
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.img_chat_badge_icon);
                        if (imageView2 != null) {
                            ImageView imageView3 = (ImageView) view.findViewById(R.id.img_manager_icon);
                            if (imageView3 != null) {
                                ImageView imageView4 = (ImageView) view.findViewById(R.id.img_ribbon);
                                if (imageView4 != null) {
                                    ImageView imageView5 = (ImageView) view.findViewById(R.id.img_verify);
                                    if (imageView5 != null) {
                                        ImageView imageView6 = (ImageView) view.findViewById(R.id.iv_avatar_decorate);
                                        if (imageView6 != null) {
                                            ImageView imageView7 = (ImageView) view.findViewById(R.id.iv_background);
                                            if (imageView7 != null) {
                                                ImageView imageView8 = (ImageView) view.findViewById(R.id.iv_rank_avatar_one);
                                                if (imageView8 != null) {
                                                    ImageView imageView9 = (ImageView) view.findViewById(R.id.iv_streamer);
                                                    if (imageView9 != null) {
                                                        ImageView imageView10 = (ImageView) view.findViewById(R.id.iv_to_live);
                                                        if (imageView10 != null) {
                                                            LiveGiftAndMedalCardView liveGiftAndMedalCardView = (LiveGiftAndMedalCardView) view.findViewById(R.id.live_gift_medal_card_view);
                                                            if (liveGiftAndMedalCardView != null) {
                                                                ImageView imageView11 = (ImageView) view.findViewById(R.id.live_user_avatar_decorate);
                                                                if (imageView11 != null) {
                                                                    ImageView imageView12 = (ImageView) view.findViewById(R.id.live_user_card_avatar_decorate);
                                                                    if (imageView12 != null) {
                                                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_attention);
                                                                        if (linearLayout != null) {
                                                                            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_bottom_button);
                                                                            if (linearLayout2 != null) {
                                                                                LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.ll_connect);
                                                                                if (linearLayout3 != null) {
                                                                                    LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.ll_manage);
                                                                                    if (linearLayout4 != null) {
                                                                                        LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.ll_reply);
                                                                                        if (linearLayout5 != null) {
                                                                                            LinearLayout linearLayout6 = (LinearLayout) view.findViewById(R.id.ll_right);
                                                                                            if (linearLayout6 != null) {
                                                                                                LinearLayout linearLayout7 = (LinearLayout) view.findViewById(R.id.ll_userinfo);
                                                                                                if (linearLayout7 != null) {
                                                                                                    LinearLayout linearLayout8 = (LinearLayout) view.findViewById(R.id.ll_view_profile);
                                                                                                    if (linearLayout8 != null) {
                                                                                                        LiveUserCardModuleView liveUserCardModuleView = (LiveUserCardModuleView) view.findViewById(R.id.module_view);
                                                                                                        if (liveUserCardModuleView != null) {
                                                                                                            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_card_info);
                                                                                                            if (relativeLayout != null) {
                                                                                                                RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.rl_userinfo);
                                                                                                                if (relativeLayout2 != null) {
                                                                                                                    TextView textView = (TextView) view.findViewById(R.id.tv_attention);
                                                                                                                    if (textView != null) {
                                                                                                                        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_avatar_gold_border);
                                                                                                                        if (shapeTextView != null) {
                                                                                                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_block);
                                                                                                                            if (textView2 != null) {
                                                                                                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_connect);
                                                                                                                                if (textView3 != null) {
                                                                                                                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_cut_attention);
                                                                                                                                    if (textView4 != null) {
                                                                                                                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_cut_bottom);
                                                                                                                                        if (textView5 != null) {
                                                                                                                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_cut_chat);
                                                                                                                                            if (textView6 != null) {
                                                                                                                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_cut_connect);
                                                                                                                                                if (textView7 != null) {
                                                                                                                                                    TextView textView8 = (TextView) view.findViewById(R.id.tv_cut_silence);
                                                                                                                                                    if (textView8 != null) {
                                                                                                                                                        TextView textView9 = (TextView) view.findViewById(R.id.tv_distance);
                                                                                                                                                        if (textView9 != null) {
                                                                                                                                                            TextView textView10 = (TextView) view.findViewById(R.id.tv_kick);
                                                                                                                                                            if (textView10 != null) {
                                                                                                                                                                TextView textView11 = (TextView) view.findViewById(R.id.tv_line);
                                                                                                                                                                if (textView11 != null) {
                                                                                                                                                                    TextView textView12 = (TextView) view.findViewById(R.id.tv_manage);
                                                                                                                                                                    if (textView12 != null) {
                                                                                                                                                                        TextView textView13 = (TextView) view.findViewById(R.id.tv_name);
                                                                                                                                                                        if (textView13 != null) {
                                                                                                                                                                            TextView textView14 = (TextView) view.findViewById(R.id.tv_report);
                                                                                                                                                                            if (textView14 != null) {
                                                                                                                                                                                TextView textView15 = (TextView) view.findViewById(R.id.tv_silence);
                                                                                                                                                                                if (textView15 != null) {
                                                                                                                                                                                    ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_user_card_behalf_status);
                                                                                                                                                                                    if (shapeTextView2 != null) {
                                                                                                                                                                                        TextView textView16 = (TextView) view.findViewById(R.id.tv_userinfo_line1);
                                                                                                                                                                                        if (textView16 != null) {
                                                                                                                                                                                            FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.view_over30_ribbon);
                                                                                                                                                                                            if (frameLayout3 != null) {
                                                                                                                                                                                                return new LayoutUsercardDialogBinding((FrameLayout) view, cardView, frameLayout, frameLayout2, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, liveGiftAndMedalCardView, imageView11, imageView12, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, liveUserCardModuleView, relativeLayout, relativeLayout2, textView, shapeTextView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, shapeTextView2, textView16, frameLayout3);
                                                                                                                                                                                            }
                                                                                                                                                                                            str = "viewOver30Ribbon";
                                                                                                                                                                                        } else {
                                                                                                                                                                                            str = "tvUserinfoLine1";
                                                                                                                                                                                        }
                                                                                                                                                                                    } else {
                                                                                                                                                                                        str = "tvUserCardBehalfStatus";
                                                                                                                                                                                    }
                                                                                                                                                                                } else {
                                                                                                                                                                                    str = "tvSilence";
                                                                                                                                                                                }
                                                                                                                                                                            } else {
                                                                                                                                                                                str = "tvReport";
                                                                                                                                                                            }
                                                                                                                                                                        } else {
                                                                                                                                                                            str = "tvName";
                                                                                                                                                                        }
                                                                                                                                                                    } else {
                                                                                                                                                                        str = "tvManage";
                                                                                                                                                                    }
                                                                                                                                                                } else {
                                                                                                                                                                    str = "tvLine";
                                                                                                                                                                }
                                                                                                                                                            } else {
                                                                                                                                                                str = "tvKick";
                                                                                                                                                            }
                                                                                                                                                        } else {
                                                                                                                                                            str = "tvDistance";
                                                                                                                                                        }
                                                                                                                                                    } else {
                                                                                                                                                        str = "tvCutSilence";
                                                                                                                                                    }
                                                                                                                                                } else {
                                                                                                                                                    str = "tvCutConnect";
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                str = "tvCutChat";
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            str = "tvCutBottom";
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        str = "tvCutAttention";
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    str = "tvConnect";
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                str = "tvBlock";
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            str = "tvAvatarGoldBorder";
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        str = "tvAttention";
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    str = "rlUserinfo";
                                                                                                                }
                                                                                                            } else {
                                                                                                                str = "rlCardInfo";
                                                                                                            }
                                                                                                        } else {
                                                                                                            str = "moduleView";
                                                                                                        }
                                                                                                    } else {
                                                                                                        str = "llViewProfile";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "llUserinfo";
                                                                                                }
                                                                                            } else {
                                                                                                str = "llRight";
                                                                                            }
                                                                                        } else {
                                                                                            str = "llReply";
                                                                                        }
                                                                                    } else {
                                                                                        str = "llManage";
                                                                                    }
                                                                                } else {
                                                                                    str = "llConnect";
                                                                                }
                                                                            } else {
                                                                                str = "llBottomButton";
                                                                            }
                                                                        } else {
                                                                            str = "llAttention";
                                                                        }
                                                                    } else {
                                                                        str = "liveUserCardAvatarDecorate";
                                                                    }
                                                                } else {
                                                                    str = "liveUserAvatarDecorate";
                                                                }
                                                            } else {
                                                                str = "liveGiftMedalCardView";
                                                            }
                                                        } else {
                                                            str = "ivToLive";
                                                        }
                                                    } else {
                                                        str = "ivStreamer";
                                                    }
                                                } else {
                                                    str = "ivRankAvatarOne";
                                                }
                                            } else {
                                                str = "ivBackground";
                                            }
                                        } else {
                                            str = "ivAvatarDecorate";
                                        }
                                    } else {
                                        str = "imgVerify";
                                    }
                                } else {
                                    str = "imgRibbon";
                                }
                            } else {
                                str = "imgManagerIcon";
                            }
                        } else {
                            str = "imgChatBadgeIcon";
                        }
                    } else {
                        str = "headerView";
                    }
                } else {
                    str = "flRankTopOne";
                }
            } else {
                str = "flAvatar";
            }
        } else {
            str = "cvBackgroundRoot";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.U;
    }
}
