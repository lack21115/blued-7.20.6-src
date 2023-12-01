package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SlopeLoadingView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/DialogLiveVipBinding.class */
public final class DialogLiveVipBinding implements ViewBinding {
    public final ShapeTextView A;
    public final TextView B;
    public final TextView C;
    public final TextView D;
    public final TextView E;
    public final View F;
    public final View G;
    public final View H;
    public final View I;
    public final View J;
    public final View K;
    public final ViewPager L;
    private final ConstraintLayout M;

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f11828a;
    public final ConstraintLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeConstraintLayout f11829c;
    public final LinearLayout d;
    public final ImageView e;
    public final ImageView f;
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
    public final SlopeLoadingView q;
    public final NestedScrollView r;
    public final RecyclerView s;
    public final ShapeTextView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public final TextView y;
    public final TextView z;

    private DialogLiveVipBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ShapeConstraintLayout shapeConstraintLayout, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, ImageView imageView12, SlopeLoadingView slopeLoadingView, NestedScrollView nestedScrollView, RecyclerView recyclerView, ShapeTextView shapeTextView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, ShapeTextView shapeTextView2, TextView textView7, TextView textView8, TextView textView9, TextView textView10, View view, View view2, View view3, View view4, View view5, View view6, ViewPager viewPager) {
        this.M = constraintLayout;
        this.f11828a = constraintLayout2;
        this.b = constraintLayout3;
        this.f11829c = shapeConstraintLayout;
        this.d = linearLayout;
        this.e = imageView;
        this.f = imageView2;
        this.g = imageView3;
        this.h = imageView4;
        this.i = imageView5;
        this.j = imageView6;
        this.k = imageView7;
        this.l = imageView8;
        this.m = imageView9;
        this.n = imageView10;
        this.o = imageView11;
        this.p = imageView12;
        this.q = slopeLoadingView;
        this.r = nestedScrollView;
        this.s = recyclerView;
        this.t = shapeTextView;
        this.u = textView;
        this.v = textView2;
        this.w = textView3;
        this.x = textView4;
        this.y = textView5;
        this.z = textView6;
        this.A = shapeTextView2;
        this.B = textView7;
        this.C = textView8;
        this.D = textView9;
        this.E = textView10;
        this.F = view;
        this.G = view2;
        this.H = view3;
        this.I = view4;
        this.J = view5;
        this.K = view6;
        this.L = viewPager;
    }

    public static DialogLiveVipBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogLiveVipBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_live_vip, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogLiveVipBinding a(View view) {
        String str;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_content);
        if (constraintLayout != null) {
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_info_title_root);
            if (constraintLayout2 != null) {
                ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.cl_privilege_info);
                if (shapeConstraintLayout != null) {
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.cl_shell);
                    if (linearLayout != null) {
                        ImageView imageView = (ImageView) view.findViewById(R.id.iv_arc);
                        if (imageView != null) {
                            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_avatar);
                            if (imageView2 != null) {
                                ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_avatar_frame);
                                if (imageView3 != null) {
                                    ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_back);
                                    if (imageView4 != null) {
                                        ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_bg);
                                        if (imageView5 != null) {
                                            ImageView imageView6 = (ImageView) view.findViewById(R.id.iv_info);
                                            if (imageView6 != null) {
                                                ImageView imageView7 = (ImageView) view.findViewById(R.id.iv_level_1_dot);
                                                if (imageView7 != null) {
                                                    ImageView imageView8 = (ImageView) view.findViewById(R.id.iv_level_2_dot);
                                                    if (imageView8 != null) {
                                                        ImageView imageView9 = (ImageView) view.findViewById(R.id.iv_level_3_dot);
                                                        if (imageView9 != null) {
                                                            ImageView imageView10 = (ImageView) view.findViewById(R.id.iv_level_4_dot);
                                                            if (imageView10 != null) {
                                                                ImageView imageView11 = (ImageView) view.findViewById(R.id.iv_level_5_dot);
                                                                if (imageView11 != null) {
                                                                    ImageView imageView12 = (ImageView) view.findViewById(R.id.iv_privilege);
                                                                    if (imageView12 != null) {
                                                                        SlopeLoadingView slopeLoadingView = (SlopeLoadingView) view.findViewById(R.id.loading);
                                                                        if (slopeLoadingView != null) {
                                                                            NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.nsv_content);
                                                                            if (nestedScrollView != null) {
                                                                                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
                                                                                if (recyclerView != null) {
                                                                                    ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_current_level);
                                                                                    if (shapeTextView != null) {
                                                                                        TextView textView = (TextView) view.findViewById(R.id.tv_level_1);
                                                                                        if (textView != null) {
                                                                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_level_2);
                                                                                            if (textView2 != null) {
                                                                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_level_3);
                                                                                                if (textView3 != null) {
                                                                                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_level_4);
                                                                                                    if (textView4 != null) {
                                                                                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_level_5);
                                                                                                        if (textView5 != null) {
                                                                                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_nickname);
                                                                                                            if (textView6 != null) {
                                                                                                                ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_privilege_btn);
                                                                                                                if (shapeTextView2 != null) {
                                                                                                                    TextView textView7 = (TextView) view.findViewById(R.id.tv_privilege_desc);
                                                                                                                    if (textView7 != null) {
                                                                                                                        TextView textView8 = (TextView) view.findViewById(R.id.tv_privilege_title);
                                                                                                                        if (textView8 != null) {
                                                                                                                            TextView textView9 = (TextView) view.findViewById(R.id.tv_privileges_title);
                                                                                                                            if (textView9 != null) {
                                                                                                                                TextView textView10 = (TextView) view.findViewById(R.id.tv_title);
                                                                                                                                if (textView10 != null) {
                                                                                                                                    View findViewById = view.findViewById(R.id.view_dot_1);
                                                                                                                                    if (findViewById != null) {
                                                                                                                                        View findViewById2 = view.findViewById(R.id.view_dot_2);
                                                                                                                                        if (findViewById2 != null) {
                                                                                                                                            View findViewById3 = view.findViewById(R.id.view_dot_3);
                                                                                                                                            if (findViewById3 != null) {
                                                                                                                                                View findViewById4 = view.findViewById(R.id.view_dot_4);
                                                                                                                                                if (findViewById4 != null) {
                                                                                                                                                    View findViewById5 = view.findViewById(R.id.view_dot_5);
                                                                                                                                                    if (findViewById5 != null) {
                                                                                                                                                        View findViewById6 = view.findViewById(R.id.view_status_bar);
                                                                                                                                                        if (findViewById6 != null) {
                                                                                                                                                            ViewPager viewPager = (ViewPager) view.findViewById(R.id.vp_level_card);
                                                                                                                                                            if (viewPager != null) {
                                                                                                                                                                return new DialogLiveVipBinding((ConstraintLayout) view, constraintLayout, constraintLayout2, shapeConstraintLayout, linearLayout, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, imageView12, slopeLoadingView, nestedScrollView, recyclerView, shapeTextView, textView, textView2, textView3, textView4, textView5, textView6, shapeTextView2, textView7, textView8, textView9, textView10, findViewById, findViewById2, findViewById3, findViewById4, findViewById5, findViewById6, viewPager);
                                                                                                                                                            }
                                                                                                                                                            str = "vpLevelCard";
                                                                                                                                                        } else {
                                                                                                                                                            str = "viewStatusBar";
                                                                                                                                                        }
                                                                                                                                                    } else {
                                                                                                                                                        str = "viewDot5";
                                                                                                                                                    }
                                                                                                                                                } else {
                                                                                                                                                    str = "viewDot4";
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                str = "viewDot3";
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            str = "viewDot2";
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        str = "viewDot1";
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    str = "tvTitle";
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                str = "tvPrivilegesTitle";
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            str = "tvPrivilegeTitle";
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        str = "tvPrivilegeDesc";
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    str = "tvPrivilegeBtn";
                                                                                                                }
                                                                                                            } else {
                                                                                                                str = "tvNickname";
                                                                                                            }
                                                                                                        } else {
                                                                                                            str = "tvLevel5";
                                                                                                        }
                                                                                                    } else {
                                                                                                        str = "tvLevel4";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "tvLevel3";
                                                                                                }
                                                                                            } else {
                                                                                                str = "tvLevel2";
                                                                                            }
                                                                                        } else {
                                                                                            str = "tvLevel1";
                                                                                        }
                                                                                    } else {
                                                                                        str = "tvCurrentLevel";
                                                                                    }
                                                                                } else {
                                                                                    str = "rvList";
                                                                                }
                                                                            } else {
                                                                                str = "nsvContent";
                                                                            }
                                                                        } else {
                                                                            str = "loading";
                                                                        }
                                                                    } else {
                                                                        str = "ivPrivilege";
                                                                    }
                                                                } else {
                                                                    str = "ivLevel5Dot";
                                                                }
                                                            } else {
                                                                str = "ivLevel4Dot";
                                                            }
                                                        } else {
                                                            str = "ivLevel3Dot";
                                                        }
                                                    } else {
                                                        str = "ivLevel2Dot";
                                                    }
                                                } else {
                                                    str = "ivLevel1Dot";
                                                }
                                            } else {
                                                str = "ivInfo";
                                            }
                                        } else {
                                            str = "ivBg";
                                        }
                                    } else {
                                        str = "ivBack";
                                    }
                                } else {
                                    str = "ivAvatarFrame";
                                }
                            } else {
                                str = "ivAvatar";
                            }
                        } else {
                            str = "ivArc";
                        }
                    } else {
                        str = "clShell";
                    }
                } else {
                    str = "clPrivilegeInfo";
                }
            } else {
                str = "clInfoTitleRoot";
            }
        } else {
            str = "clContent";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.M;
    }
}
