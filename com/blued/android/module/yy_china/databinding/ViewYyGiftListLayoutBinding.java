package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.DoubleHitSendGiftView;
import com.blued.android.module.yy_china.view.YYAdInGiftListView;
import com.blued.android.module.yy_china.view.YYGiftTabView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYyGiftListLayoutBinding.class */
public final class ViewYyGiftListLayoutBinding implements ViewBinding {
    public final TextView A;
    public final ShapeTextView B;
    public final TextView C;
    public final TextView D;
    public final TextView E;
    public final TextView F;
    public final ShapeTextView G;
    public final ShapeTextView H;
    public final ShapeTextView I;
    public final TextView J;
    public final ShapeTextView K;
    public final TextView L;
    public final ImageView M;
    public final ImageView N;
    public final FrameLayout O;
    public final ListView P;
    public final ImageView Q;
    public final ShapeLinearLayout R;
    private final ConstraintLayout S;

    /* renamed from: a  reason: collision with root package name */
    public final YYGiftTabView f16913a;
    public final ViewPager b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeConstraintLayout f16914c;
    public final Group d;
    public final Group e;
    public final ImageView f;
    public final ImageView g;
    public final LinearLayout h;
    public final ImageView i;
    public final SquareImageView j;
    public final ImageView k;
    public final SquareImageView l;
    public final ImageView m;
    public final View n;
    public final YYAdInGiftListView o;
    public final LinearLayout p;
    public final ShapeLinearLayout q;
    public final ShapeTextView r;
    public final LinearLayout s;
    public final ProgressBar t;
    public final RecyclerView u;
    public final ShapeLinearLayout v;
    public final TextView w;
    public final DoubleHitSendGiftView x;
    public final TextView y;
    public final TextView z;

    private ViewYyGiftListLayoutBinding(ConstraintLayout constraintLayout, YYGiftTabView yYGiftTabView, ViewPager viewPager, ShapeConstraintLayout shapeConstraintLayout, Group group, Group group2, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, ImageView imageView3, SquareImageView squareImageView, ImageView imageView4, SquareImageView squareImageView2, ImageView imageView5, View view, YYAdInGiftListView yYAdInGiftListView, LinearLayout linearLayout2, ShapeLinearLayout shapeLinearLayout, ShapeTextView shapeTextView, LinearLayout linearLayout3, ProgressBar progressBar, RecyclerView recyclerView, ShapeLinearLayout shapeLinearLayout2, TextView textView, DoubleHitSendGiftView doubleHitSendGiftView, TextView textView2, TextView textView3, TextView textView4, ShapeTextView shapeTextView2, TextView textView5, TextView textView6, TextView textView7, TextView textView8, ShapeTextView shapeTextView3, ShapeTextView shapeTextView4, ShapeTextView shapeTextView5, TextView textView9, ShapeTextView shapeTextView6, TextView textView10, ImageView imageView6, ImageView imageView7, FrameLayout frameLayout, ListView listView, ImageView imageView8, ShapeLinearLayout shapeLinearLayout3) {
        this.S = constraintLayout;
        this.f16913a = yYGiftTabView;
        this.b = viewPager;
        this.f16914c = shapeConstraintLayout;
        this.d = group;
        this.e = group2;
        this.f = imageView;
        this.g = imageView2;
        this.h = linearLayout;
        this.i = imageView3;
        this.j = squareImageView;
        this.k = imageView4;
        this.l = squareImageView2;
        this.m = imageView5;
        this.n = view;
        this.o = yYAdInGiftListView;
        this.p = linearLayout2;
        this.q = shapeLinearLayout;
        this.r = shapeTextView;
        this.s = linearLayout3;
        this.t = progressBar;
        this.u = recyclerView;
        this.v = shapeLinearLayout2;
        this.w = textView;
        this.x = doubleHitSendGiftView;
        this.y = textView2;
        this.z = textView3;
        this.A = textView4;
        this.B = shapeTextView2;
        this.C = textView5;
        this.D = textView6;
        this.E = textView7;
        this.F = textView8;
        this.G = shapeTextView3;
        this.H = shapeTextView4;
        this.I = shapeTextView5;
        this.J = textView9;
        this.K = shapeTextView6;
        this.L = textView10;
        this.M = imageView6;
        this.N = imageView7;
        this.O = frameLayout;
        this.P = listView;
        this.Q = imageView8;
        this.R = shapeLinearLayout3;
    }

    public static ViewYyGiftListLayoutBinding a(View view) {
        String str;
        YYGiftTabView yYGiftTabView = (YYGiftTabView) view.findViewById(R.id.base_gift_toolbar_view);
        if (yYGiftTabView != null) {
            ViewPager viewPager = (ViewPager) view.findViewById(R.id.base_view_pager_id);
            if (viewPager != null) {
                ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.con_host_users);
                if (shapeConstraintLayout != null) {
                    Group group = (Group) view.findViewById(R.id.grp_week_star);
                    if (group != null) {
                        Group group2 = (Group) view.findViewById(R.id.grp_week_star_new);
                        if (group2 != null) {
                            ImageView imageView = (ImageView) view.findViewById(R.id.iv_bg_new_star);
                            if (imageView != null) {
                                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_bg_star);
                                if (imageView2 != null) {
                                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.iv_more_leve);
                                    if (linearLayout != null) {
                                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_select_num);
                                        if (imageView3 != null) {
                                            SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv_week_star_new_user);
                                            if (squareImageView != null) {
                                                ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_week_star_new_user_live);
                                                if (imageView4 != null) {
                                                    SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.iv_week_star_user);
                                                    if (squareImageView2 != null) {
                                                        ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_week_star_user_live);
                                                        if (imageView5 != null) {
                                                            View findViewById = view.findViewById(R.id.live_gift_blank_view);
                                                            if (findViewById != null) {
                                                                YYAdInGiftListView yYAdInGiftListView = (YYAdInGiftListView) view.findViewById(R.id.ll_ad_view);
                                                                if (yYAdInGiftListView != null) {
                                                                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_gift_content);
                                                                    if (linearLayout2 != null) {
                                                                        ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.ll_gift_count);
                                                                        if (shapeLinearLayout != null) {
                                                                            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.ll_send);
                                                                            if (shapeTextView != null) {
                                                                                LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.ll_tab_layout);
                                                                                if (linearLayout3 != null) {
                                                                                    ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.pro_lv);
                                                                                    if (progressBar != null) {
                                                                                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcv_user);
                                                                                        if (recyclerView != null) {
                                                                                            ShapeLinearLayout shapeLinearLayout2 = (ShapeLinearLayout) view.findViewById(R.id.shape_send);
                                                                                            if (shapeLinearLayout2 != null) {
                                                                                                TextView textView = (TextView) view.findViewById(R.id.tv_backpack);
                                                                                                if (textView != null) {
                                                                                                    DoubleHitSendGiftView doubleHitSendGiftView = (DoubleHitSendGiftView) view.findViewById(R.id.tv_click_doublehit);
                                                                                                    if (doubleHitSendGiftView != null) {
                                                                                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_last_up_live);
                                                                                                        if (textView2 != null) {
                                                                                                            TextView textView3 = (TextView) view.findViewById(R.id.tv_lv_1);
                                                                                                            if (textView3 != null) {
                                                                                                                TextView textView4 = (TextView) view.findViewById(R.id.tv_lv_2);
                                                                                                                if (textView4 != null) {
                                                                                                                    ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_new_star);
                                                                                                                    if (shapeTextView2 != null) {
                                                                                                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_no_give);
                                                                                                                        if (textView5 != null) {
                                                                                                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_price);
                                                                                                                            if (textView6 != null) {
                                                                                                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_recharge);
                                                                                                                                if (textView7 != null) {
                                                                                                                                    TextView textView8 = (TextView) view.findViewById(R.id.tv_select_num);
                                                                                                                                    if (textView8 != null) {
                                                                                                                                        ShapeTextView shapeTextView3 = (ShapeTextView) view.findViewById(R.id.tv_select_user);
                                                                                                                                        if (shapeTextView3 != null) {
                                                                                                                                            ShapeTextView shapeTextView4 = (ShapeTextView) view.findViewById(R.id.tv_star);
                                                                                                                                            if (shapeTextView4 != null) {
                                                                                                                                                ShapeTextView shapeTextView5 = (ShapeTextView) view.findViewById(R.id.tv_week_star_bg);
                                                                                                                                                if (shapeTextView5 != null) {
                                                                                                                                                    TextView textView9 = (TextView) view.findViewById(R.id.tv_week_star_name_user);
                                                                                                                                                    if (textView9 != null) {
                                                                                                                                                        ShapeTextView shapeTextView6 = (ShapeTextView) view.findViewById(R.id.tv_week_star_new_bg);
                                                                                                                                                        if (shapeTextView6 != null) {
                                                                                                                                                            TextView textView10 = (TextView) view.findViewById(R.id.tv_week_star_new_name_user);
                                                                                                                                                            if (textView10 != null) {
                                                                                                                                                                ImageView imageView6 = (ImageView) view.findViewById(R.id.tv_week_star_new_title);
                                                                                                                                                                if (imageView6 != null) {
                                                                                                                                                                    ImageView imageView7 = (ImageView) view.findViewById(R.id.tv_week_star_title);
                                                                                                                                                                    if (imageView7 != null) {
                                                                                                                                                                        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.yy_gift_number_select_layout);
                                                                                                                                                                        if (frameLayout != null) {
                                                                                                                                                                            ListView listView = (ListView) view.findViewById(R.id.yy_gift_number_select_list);
                                                                                                                                                                            if (listView != null) {
                                                                                                                                                                                ImageView imageView8 = (ImageView) view.findViewById(R.id.yy_top_up_first);
                                                                                                                                                                                if (imageView8 != null) {
                                                                                                                                                                                    ShapeLinearLayout shapeLinearLayout3 = (ShapeLinearLayout) view.findViewById(R.id.yy_top_up_view);
                                                                                                                                                                                    if (shapeLinearLayout3 != null) {
                                                                                                                                                                                        return new ViewYyGiftListLayoutBinding((ConstraintLayout) view, yYGiftTabView, viewPager, shapeConstraintLayout, group, group2, imageView, imageView2, linearLayout, imageView3, squareImageView, imageView4, squareImageView2, imageView5, findViewById, yYAdInGiftListView, linearLayout2, shapeLinearLayout, shapeTextView, linearLayout3, progressBar, recyclerView, shapeLinearLayout2, textView, doubleHitSendGiftView, textView2, textView3, textView4, shapeTextView2, textView5, textView6, textView7, textView8, shapeTextView3, shapeTextView4, shapeTextView5, textView9, shapeTextView6, textView10, imageView6, imageView7, frameLayout, listView, imageView8, shapeLinearLayout3);
                                                                                                                                                                                    }
                                                                                                                                                                                    str = "yyTopUpView";
                                                                                                                                                                                } else {
                                                                                                                                                                                    str = "yyTopUpFirst";
                                                                                                                                                                                }
                                                                                                                                                                            } else {
                                                                                                                                                                                str = "yyGiftNumberSelectList";
                                                                                                                                                                            }
                                                                                                                                                                        } else {
                                                                                                                                                                            str = "yyGiftNumberSelectLayout";
                                                                                                                                                                        }
                                                                                                                                                                    } else {
                                                                                                                                                                        str = "tvWeekStarTitle";
                                                                                                                                                                    }
                                                                                                                                                                } else {
                                                                                                                                                                    str = "tvWeekStarNewTitle";
                                                                                                                                                                }
                                                                                                                                                            } else {
                                                                                                                                                                str = "tvWeekStarNewNameUser";
                                                                                                                                                            }
                                                                                                                                                        } else {
                                                                                                                                                            str = "tvWeekStarNewBg";
                                                                                                                                                        }
                                                                                                                                                    } else {
                                                                                                                                                        str = "tvWeekStarNameUser";
                                                                                                                                                    }
                                                                                                                                                } else {
                                                                                                                                                    str = "tvWeekStarBg";
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                str = "tvStar";
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            str = "tvSelectUser";
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        str = "tvSelectNum";
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    str = "tvRecharge";
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                str = "tvPrice";
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            str = "tvNoGive";
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        str = "tvNewStar";
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    str = "tvLv2";
                                                                                                                }
                                                                                                            } else {
                                                                                                                str = "tvLv1";
                                                                                                            }
                                                                                                        } else {
                                                                                                            str = "tvLastUpLive";
                                                                                                        }
                                                                                                    } else {
                                                                                                        str = "tvClickDoublehit";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "tvBackpack";
                                                                                                }
                                                                                            } else {
                                                                                                str = "shapeSend";
                                                                                            }
                                                                                        } else {
                                                                                            str = "rcvUser";
                                                                                        }
                                                                                    } else {
                                                                                        str = "proLv";
                                                                                    }
                                                                                } else {
                                                                                    str = "llTabLayout";
                                                                                }
                                                                            } else {
                                                                                str = "llSend";
                                                                            }
                                                                        } else {
                                                                            str = "llGiftCount";
                                                                        }
                                                                    } else {
                                                                        str = "llGiftContent";
                                                                    }
                                                                } else {
                                                                    str = "llAdView";
                                                                }
                                                            } else {
                                                                str = "liveGiftBlankView";
                                                            }
                                                        } else {
                                                            str = "ivWeekStarUserLive";
                                                        }
                                                    } else {
                                                        str = "ivWeekStarUser";
                                                    }
                                                } else {
                                                    str = "ivWeekStarNewUserLive";
                                                }
                                            } else {
                                                str = "ivWeekStarNewUser";
                                            }
                                        } else {
                                            str = "ivSelectNum";
                                        }
                                    } else {
                                        str = "ivMoreLeve";
                                    }
                                } else {
                                    str = "ivBgStar";
                                }
                            } else {
                                str = "ivBgNewStar";
                            }
                        } else {
                            str = "grpWeekStarNew";
                        }
                    } else {
                        str = "grpWeekStar";
                    }
                } else {
                    str = "conHostUsers";
                }
            } else {
                str = "baseViewPagerId";
            }
        } else {
            str = "baseGiftToolbarView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.S;
    }
}
