package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SlopeLoadingView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/DialogLiveConstellationBinding.class */
public final class DialogLiveConstellationBinding implements ViewBinding {
    public final SlopeLoadingView A;
    public final NestedScrollView B;
    public final RecyclerView C;
    public final RecyclerView D;
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
    public final TextView S;
    public final TextView T;
    public final TextView U;
    public final TextView V;
    public final TextView W;
    public final TextView X;
    public final ShapeTextView Y;
    public final ShapeTextView Z;

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f11753a;
    public final View aa;
    public final View ab;
    public final View ac;
    private final ConstraintLayout ad;
    public final ConstraintLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeConstraintLayout f11754c;
    public final Group d;
    public final Group e;
    public final Group f;
    public final Group g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final ImageView k;
    public final ImageView l;
    public final ImageView m;
    public final ImageView n;
    public final ImageView o;
    public final ImageView p;
    public final ImageView q;
    public final ImageView r;
    public final ImageView s;
    public final ImageView t;
    public final ImageView u;
    public final ImageView v;
    public final ImageView w;
    public final ImageView x;
    public final ShapeLinearLayout y;
    public final LinearLayout z;

    private DialogLiveConstellationBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ShapeConstraintLayout shapeConstraintLayout, Group group, Group group2, Group group3, Group group4, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, ImageView imageView12, ImageView imageView13, ImageView imageView14, ImageView imageView15, ImageView imageView16, ImageView imageView17, ShapeLinearLayout shapeLinearLayout, LinearLayout linearLayout, SlopeLoadingView slopeLoadingView, NestedScrollView nestedScrollView, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, View view, View view2, View view3) {
        this.ad = constraintLayout;
        this.f11753a = constraintLayout2;
        this.b = constraintLayout3;
        this.f11754c = shapeConstraintLayout;
        this.d = group;
        this.e = group2;
        this.f = group3;
        this.g = group4;
        this.h = imageView;
        this.i = imageView2;
        this.j = imageView3;
        this.k = imageView4;
        this.l = imageView5;
        this.m = imageView6;
        this.n = imageView7;
        this.o = imageView8;
        this.p = imageView9;
        this.q = imageView10;
        this.r = imageView11;
        this.s = imageView12;
        this.t = imageView13;
        this.u = imageView14;
        this.v = imageView15;
        this.w = imageView16;
        this.x = imageView17;
        this.y = shapeLinearLayout;
        this.z = linearLayout;
        this.A = slopeLoadingView;
        this.B = nestedScrollView;
        this.C = recyclerView;
        this.D = recyclerView2;
        this.E = textView;
        this.F = textView2;
        this.G = textView3;
        this.H = textView4;
        this.I = textView5;
        this.J = textView6;
        this.K = textView7;
        this.L = textView8;
        this.M = textView9;
        this.N = textView10;
        this.O = textView11;
        this.P = textView12;
        this.Q = textView13;
        this.R = textView14;
        this.S = textView15;
        this.T = textView16;
        this.U = textView17;
        this.V = textView18;
        this.W = textView19;
        this.X = textView20;
        this.Y = shapeTextView;
        this.Z = shapeTextView2;
        this.aa = view;
        this.ab = view2;
        this.ac = view3;
    }

    public static DialogLiveConstellationBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogLiveConstellationBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_live_constellation, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogLiveConstellationBinding a(View view) {
        String str;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_avatar);
        if (constraintLayout != null) {
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_content);
            if (constraintLayout2 != null) {
                ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.cl_stage);
                if (shapeConstraintLayout != null) {
                    Group group = (Group) view.findViewById(R.id.group_current_anchor);
                    if (group != null) {
                        Group group2 = (Group) view.findViewById(R.id.group_empty);
                        if (group2 != null) {
                            Group group3 = (Group) view.findViewById(R.id.group_gift_num);
                            if (group3 != null) {
                                Group group4 = (Group) view.findViewById(R.id.group_table);
                                if (group4 != null) {
                                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_anchor_avatar);
                                    if (imageView != null) {
                                        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_anchor_avatar_frame);
                                        if (imageView2 != null) {
                                            ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_avatar_title);
                                            if (imageView3 != null) {
                                                ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_award);
                                                if (imageView4 != null) {
                                                    ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_bg);
                                                    if (imageView5 != null) {
                                                        ImageView imageView6 = (ImageView) view.findViewById(R.id.iv_bottom_mvp_avatar);
                                                        if (imageView6 != null) {
                                                            ImageView imageView7 = (ImageView) view.findViewById(R.id.iv_content_bg);
                                                            if (imageView7 != null) {
                                                                ImageView imageView8 = (ImageView) view.findViewById(R.id.iv_current_anchor_avatar);
                                                                if (imageView8 != null) {
                                                                    ImageView imageView9 = (ImageView) view.findViewById(R.id.iv_empty);
                                                                    if (imageView9 != null) {
                                                                        ImageView imageView10 = (ImageView) view.findViewById(R.id.iv_gift_num_bg);
                                                                        if (imageView10 != null) {
                                                                            ImageView imageView11 = (ImageView) view.findViewById(R.id.iv_honour);
                                                                            if (imageView11 != null) {
                                                                                ImageView imageView12 = (ImageView) view.findViewById(R.id.iv_info);
                                                                                if (imageView12 != null) {
                                                                                    ImageView imageView13 = (ImageView) view.findViewById(R.id.iv_mvp_avatar);
                                                                                    if (imageView13 != null) {
                                                                                        ImageView imageView14 = (ImageView) view.findViewById(R.id.iv_mvp_avatar_frame);
                                                                                        if (imageView14 != null) {
                                                                                            ImageView imageView15 = (ImageView) view.findViewById(R.id.iv_my_anchor_avatar);
                                                                                            if (imageView15 != null) {
                                                                                                ImageView imageView16 = (ImageView) view.findViewById(R.id.iv_onekey_summit);
                                                                                                if (imageView16 != null) {
                                                                                                    ImageView imageView17 = (ImageView) view.findViewById(R.id.iv_title);
                                                                                                    if (imageView17 != null) {
                                                                                                        ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.ll_my_info);
                                                                                                        if (shapeLinearLayout != null) {
                                                                                                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_table_head);
                                                                                                            if (linearLayout != null) {
                                                                                                                SlopeLoadingView slopeLoadingView = (SlopeLoadingView) view.findViewById(R.id.loading);
                                                                                                                if (slopeLoadingView != null) {
                                                                                                                    NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.nsv_content);
                                                                                                                    if (nestedScrollView != null) {
                                                                                                                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_tab_list);
                                                                                                                        if (recyclerView != null) {
                                                                                                                            RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.rv_user_list);
                                                                                                                            if (recyclerView2 != null) {
                                                                                                                                TextView textView = (TextView) view.findViewById(R.id.tv_anchor_nickname);
                                                                                                                                if (textView != null) {
                                                                                                                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_avatar_title);
                                                                                                                                    if (textView2 != null) {
                                                                                                                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_award);
                                                                                                                                        if (textView3 != null) {
                                                                                                                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_award_info);
                                                                                                                                            if (textView4 != null) {
                                                                                                                                                TextView textView5 = (TextView) view.findViewById(R.id.tv_bottom_mvp_crown);
                                                                                                                                                if (textView5 != null) {
                                                                                                                                                    TextView textView6 = (TextView) view.findViewById(R.id.tv_bottom_mvp_nickname);
                                                                                                                                                    if (textView6 != null) {
                                                                                                                                                        TextView textView7 = (TextView) view.findViewById(R.id.tv_constellation_value);
                                                                                                                                                        if (textView7 != null) {
                                                                                                                                                            TextView textView8 = (TextView) view.findViewById(R.id.tv_empty);
                                                                                                                                                            if (textView8 != null) {
                                                                                                                                                                TextView textView9 = (TextView) view.findViewById(R.id.tv_gift_info);
                                                                                                                                                                if (textView9 != null) {
                                                                                                                                                                    TextView textView10 = (TextView) view.findViewById(R.id.tv_gift_num_content);
                                                                                                                                                                    if (textView10 != null) {
                                                                                                                                                                        TextView textView11 = (TextView) view.findViewById(R.id.tv_gift_num_title);
                                                                                                                                                                        if (textView11 != null) {
                                                                                                                                                                            TextView textView12 = (TextView) view.findViewById(R.id.tv_mvp_nickname);
                                                                                                                                                                            if (textView12 != null) {
                                                                                                                                                                                TextView textView13 = (TextView) view.findViewById(R.id.tv_my_anchor_crown);
                                                                                                                                                                                if (textView13 != null) {
                                                                                                                                                                                    TextView textView14 = (TextView) view.findViewById(R.id.tv_my_anchor_nickname);
                                                                                                                                                                                    if (textView14 != null) {
                                                                                                                                                                                        TextView textView15 = (TextView) view.findViewById(R.id.tv_my_ranking);
                                                                                                                                                                                        if (textView15 != null) {
                                                                                                                                                                                            TextView textView16 = (TextView) view.findViewById(R.id.tv_stage_1);
                                                                                                                                                                                            if (textView16 != null) {
                                                                                                                                                                                                TextView textView17 = (TextView) view.findViewById(R.id.tv_stage_2);
                                                                                                                                                                                                if (textView17 != null) {
                                                                                                                                                                                                    TextView textView18 = (TextView) view.findViewById(R.id.tv_stage_3);
                                                                                                                                                                                                    if (textView18 != null) {
                                                                                                                                                                                                        TextView textView19 = (TextView) view.findViewById(R.id.tv_subtitle);
                                                                                                                                                                                                        if (textView19 != null) {
                                                                                                                                                                                                            TextView textView20 = (TextView) view.findViewById(R.id.tv_title);
                                                                                                                                                                                                            if (textView20 != null) {
                                                                                                                                                                                                                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.view_content_bg);
                                                                                                                                                                                                                if (shapeTextView != null) {
                                                                                                                                                                                                                    ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.view_cursor);
                                                                                                                                                                                                                    if (shapeTextView2 != null) {
                                                                                                                                                                                                                        View findViewById = view.findViewById(R.id.view_dot);
                                                                                                                                                                                                                        if (findViewById != null) {
                                                                                                                                                                                                                            View findViewById2 = view.findViewById(R.id.view_line_table_head_top);
                                                                                                                                                                                                                            if (findViewById2 != null) {
                                                                                                                                                                                                                                View findViewById3 = view.findViewById(R.id.view_space);
                                                                                                                                                                                                                                if (findViewById3 != null) {
                                                                                                                                                                                                                                    return new DialogLiveConstellationBinding((ConstraintLayout) view, constraintLayout, constraintLayout2, shapeConstraintLayout, group, group2, group3, group4, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, imageView12, imageView13, imageView14, imageView15, imageView16, imageView17, shapeLinearLayout, linearLayout, slopeLoadingView, nestedScrollView, recyclerView, recyclerView2, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, shapeTextView, shapeTextView2, findViewById, findViewById2, findViewById3);
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                str = "viewSpace";
                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                str = "viewLineTableHeadTop";
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                            str = "viewDot";
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                        str = "viewCursor";
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                    str = "viewContentBg";
                                                                                                                                                                                                                }
                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                str = "tvTitle";
                                                                                                                                                                                                            }
                                                                                                                                                                                                        } else {
                                                                                                                                                                                                            str = "tvSubtitle";
                                                                                                                                                                                                        }
                                                                                                                                                                                                    } else {
                                                                                                                                                                                                        str = "tvStage3";
                                                                                                                                                                                                    }
                                                                                                                                                                                                } else {
                                                                                                                                                                                                    str = "tvStage2";
                                                                                                                                                                                                }
                                                                                                                                                                                            } else {
                                                                                                                                                                                                str = "tvStage1";
                                                                                                                                                                                            }
                                                                                                                                                                                        } else {
                                                                                                                                                                                            str = "tvMyRanking";
                                                                                                                                                                                        }
                                                                                                                                                                                    } else {
                                                                                                                                                                                        str = "tvMyAnchorNickname";
                                                                                                                                                                                    }
                                                                                                                                                                                } else {
                                                                                                                                                                                    str = "tvMyAnchorCrown";
                                                                                                                                                                                }
                                                                                                                                                                            } else {
                                                                                                                                                                                str = "tvMvpNickname";
                                                                                                                                                                            }
                                                                                                                                                                        } else {
                                                                                                                                                                            str = "tvGiftNumTitle";
                                                                                                                                                                        }
                                                                                                                                                                    } else {
                                                                                                                                                                        str = "tvGiftNumContent";
                                                                                                                                                                    }
                                                                                                                                                                } else {
                                                                                                                                                                    str = "tvGiftInfo";
                                                                                                                                                                }
                                                                                                                                                            } else {
                                                                                                                                                                str = "tvEmpty";
                                                                                                                                                            }
                                                                                                                                                        } else {
                                                                                                                                                            str = "tvConstellationValue";
                                                                                                                                                        }
                                                                                                                                                    } else {
                                                                                                                                                        str = "tvBottomMvpNickname";
                                                                                                                                                    }
                                                                                                                                                } else {
                                                                                                                                                    str = "tvBottomMvpCrown";
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                str = "tvAwardInfo";
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            str = "tvAward";
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        str = "tvAvatarTitle";
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    str = "tvAnchorNickname";
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                str = "rvUserList";
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            str = "rvTabList";
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        str = "nsvContent";
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    str = "loading";
                                                                                                                }
                                                                                                            } else {
                                                                                                                str = "llTableHead";
                                                                                                            }
                                                                                                        } else {
                                                                                                            str = "llMyInfo";
                                                                                                        }
                                                                                                    } else {
                                                                                                        str = "ivTitle";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "ivOnekeySummit";
                                                                                                }
                                                                                            } else {
                                                                                                str = "ivMyAnchorAvatar";
                                                                                            }
                                                                                        } else {
                                                                                            str = "ivMvpAvatarFrame";
                                                                                        }
                                                                                    } else {
                                                                                        str = "ivMvpAvatar";
                                                                                    }
                                                                                } else {
                                                                                    str = "ivInfo";
                                                                                }
                                                                            } else {
                                                                                str = "ivHonour";
                                                                            }
                                                                        } else {
                                                                            str = "ivGiftNumBg";
                                                                        }
                                                                    } else {
                                                                        str = "ivEmpty";
                                                                    }
                                                                } else {
                                                                    str = "ivCurrentAnchorAvatar";
                                                                }
                                                            } else {
                                                                str = "ivContentBg";
                                                            }
                                                        } else {
                                                            str = "ivBottomMvpAvatar";
                                                        }
                                                    } else {
                                                        str = "ivBg";
                                                    }
                                                } else {
                                                    str = "ivAward";
                                                }
                                            } else {
                                                str = "ivAvatarTitle";
                                            }
                                        } else {
                                            str = "ivAnchorAvatarFrame";
                                        }
                                    } else {
                                        str = "ivAnchorAvatar";
                                    }
                                } else {
                                    str = "groupTable";
                                }
                            } else {
                                str = "groupGiftNum";
                            }
                        } else {
                            str = "groupEmpty";
                        }
                    } else {
                        str = "groupCurrentAnchor";
                    }
                } else {
                    str = "clStage";
                }
            } else {
                str = "clContent";
            }
        } else {
            str = "clAvatar";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.ad;
    }
}
