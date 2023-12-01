package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYFansLevelView;
import com.google.android.material.imageview.ShapeableImageView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogFansClubAudienceViewBinding.class */
public final class DialogFansClubAudienceViewBinding implements ViewBinding {
    public final ProgressBar a;
    public final View b;
    public final ShapeableImageView c;
    public final ShapeableImageView d;
    public final ImageView e;
    public final ConstraintLayout f;
    public final YYFansLevelView g;
    public final YYFansLevelView h;
    public final LinearLayout i;
    public final SmartRefreshLayout j;
    public final ConstraintLayout k;
    public final ConstraintLayout l;
    public final ConstraintLayout m;
    public final RecyclerView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    private final ConstraintLayout y;

    private DialogFansClubAudienceViewBinding(ConstraintLayout constraintLayout, ProgressBar progressBar, View view, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, ImageView imageView, ConstraintLayout constraintLayout2, YYFansLevelView yYFansLevelView, YYFansLevelView yYFansLevelView2, LinearLayout linearLayout, SmartRefreshLayout smartRefreshLayout, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10) {
        this.y = constraintLayout;
        this.a = progressBar;
        this.b = view;
        this.c = shapeableImageView;
        this.d = shapeableImageView2;
        this.e = imageView;
        this.f = constraintLayout2;
        this.g = yYFansLevelView;
        this.h = yYFansLevelView2;
        this.i = linearLayout;
        this.j = smartRefreshLayout;
        this.k = constraintLayout3;
        this.l = constraintLayout4;
        this.m = constraintLayout5;
        this.n = recyclerView;
        this.o = textView;
        this.p = textView2;
        this.q = textView3;
        this.r = textView4;
        this.s = textView5;
        this.t = textView6;
        this.u = textView7;
        this.v = textView8;
        this.w = textView9;
        this.x = textView10;
    }

    public static DialogFansClubAudienceViewBinding a(View view) {
        String str;
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.bar_profit);
        if (progressBar != null) {
            View findViewById = view.findViewById(R.id.cover_view);
            if (findViewById != null) {
                ShapeableImageView findViewById2 = view.findViewById(R.id.img_host_avatar);
                if (findViewById2 != null) {
                    ShapeableImageView findViewById3 = view.findViewById(R.id.img_my_avatar);
                    if (findViewById3 != null) {
                        ImageView imageView = (ImageView) view.findViewById(R.id.img_q_a);
                        if (imageView != null) {
                            ConstraintLayout findViewById4 = view.findViewById(R.id.ll_author_view);
                            if (findViewById4 != null) {
                                YYFansLevelView yYFansLevelView = (YYFansLevelView) view.findViewById(R.id.ll_fans_level);
                                if (yYFansLevelView != null) {
                                    YYFansLevelView yYFansLevelView2 = (YYFansLevelView) view.findViewById(R.id.ll_level);
                                    if (yYFansLevelView2 != null) {
                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_rank_info);
                                        if (linearLayout != null) {
                                            SmartRefreshLayout findViewById5 = view.findViewById(R.id.ll_refresh_view);
                                            if (findViewById5 != null) {
                                                ConstraintLayout findViewById6 = view.findViewById(R.id.ll_top_rank);
                                                if (findViewById6 != null) {
                                                    ConstraintLayout findViewById7 = view.findViewById(R.id.root_cover_view);
                                                    if (findViewById7 != null) {
                                                        ConstraintLayout findViewById8 = view.findViewById(R.id.root_view);
                                                        if (findViewById8 != null) {
                                                            RecyclerView findViewById9 = view.findViewById(R.id.rv_fans_list);
                                                            if (findViewById9 != null) {
                                                                TextView textView = (TextView) view.findViewById(R.id.tv_author_name);
                                                                if (textView != null) {
                                                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_consumption);
                                                                    if (textView2 != null) {
                                                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_current_profit);
                                                                        if (textView3 != null) {
                                                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_fans_amount);
                                                                            if (textView4 != null) {
                                                                                TextView textView5 = (TextView) view.findViewById(R.id.tv_fans_describe);
                                                                                if (textView5 != null) {
                                                                                    TextView textView6 = (TextView) view.findViewById(R.id.tv_member_count);
                                                                                    if (textView6 != null) {
                                                                                        TextView textView7 = (TextView) view.findViewById(R.id.tv_number);
                                                                                        if (textView7 != null) {
                                                                                            TextView textView8 = (TextView) view.findViewById(R.id.tv_rank_title);
                                                                                            if (textView8 != null) {
                                                                                                TextView textView9 = (TextView) view.findViewById(R.id.tv_total_profit);
                                                                                                if (textView9 != null) {
                                                                                                    TextView textView10 = (TextView) view.findViewById(R.id.tv_user_name);
                                                                                                    if (textView10 != null) {
                                                                                                        return new DialogFansClubAudienceViewBinding((ConstraintLayout) view, progressBar, findViewById, findViewById2, findViewById3, imageView, findViewById4, yYFansLevelView, yYFansLevelView2, linearLayout, findViewById5, findViewById6, findViewById7, findViewById8, findViewById9, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10);
                                                                                                    }
                                                                                                    str = "tvUserName";
                                                                                                } else {
                                                                                                    str = "tvTotalProfit";
                                                                                                }
                                                                                            } else {
                                                                                                str = "tvRankTitle";
                                                                                            }
                                                                                        } else {
                                                                                            str = "tvNumber";
                                                                                        }
                                                                                    } else {
                                                                                        str = "tvMemberCount";
                                                                                    }
                                                                                } else {
                                                                                    str = "tvFansDescribe";
                                                                                }
                                                                            } else {
                                                                                str = "tvFansAmount";
                                                                            }
                                                                        } else {
                                                                            str = "tvCurrentProfit";
                                                                        }
                                                                    } else {
                                                                        str = "tvConsumption";
                                                                    }
                                                                } else {
                                                                    str = "tvAuthorName";
                                                                }
                                                            } else {
                                                                str = "rvFansList";
                                                            }
                                                        } else {
                                                            str = "rootView";
                                                        }
                                                    } else {
                                                        str = "rootCoverView";
                                                    }
                                                } else {
                                                    str = "llTopRank";
                                                }
                                            } else {
                                                str = "llRefreshView";
                                            }
                                        } else {
                                            str = "llRankInfo";
                                        }
                                    } else {
                                        str = "llLevel";
                                    }
                                } else {
                                    str = "llFansLevel";
                                }
                            } else {
                                str = "llAuthorView";
                            }
                        } else {
                            str = "imgQA";
                        }
                    } else {
                        str = "imgMyAvatar";
                    }
                } else {
                    str = "imgHostAvatar";
                }
            } else {
                str = "coverView";
            }
        } else {
            str = "barProfit";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.y;
    }
}
