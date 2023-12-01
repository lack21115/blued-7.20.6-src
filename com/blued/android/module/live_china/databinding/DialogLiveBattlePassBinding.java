package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.view.battlepass.BattlePassProgressLevelView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/DialogLiveBattlePassBinding.class */
public final class DialogLiveBattlePassBinding implements ViewBinding {
    public final ShapeTextView A;
    public final ShapeTextView B;
    public final LinearLayout C;
    public final FrameLayout D;
    public final BattlePassProgressLevelView E;
    public final RelativeLayout F;
    public final RelativeLayout G;
    public final RelativeLayout H;
    public final RecyclerView I;
    public final RecyclerView J;
    public final TextView K;
    public final TextView L;
    public final TextView M;
    public final TextView N;
    public final TextView O;
    public final TextView P;
    public final TextView Q;
    public final TextView R;
    public final View S;
    public final View T;
    private final FrameLayout U;
    public final ImageView a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final ShapeConstraintLayout f;
    public final CardView g;
    public final FrameLayout h;
    public final FrameLayout i;
    public final ShapeFrameLayout j;
    public final FrameLayout k;
    public final FrameLayout l;
    public final FrameLayout m;
    public final HorizontalScrollView n;
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
    public final ImageView y;
    public final ImageView z;

    private DialogLiveBattlePassBinding(FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ShapeConstraintLayout shapeConstraintLayout, CardView cardView, FrameLayout frameLayout2, FrameLayout frameLayout3, ShapeFrameLayout shapeFrameLayout, FrameLayout frameLayout4, FrameLayout frameLayout5, FrameLayout frameLayout6, HorizontalScrollView horizontalScrollView, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, ImageView imageView12, ImageView imageView13, ImageView imageView14, ImageView imageView15, ImageView imageView16, ImageView imageView17, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, LinearLayout linearLayout, FrameLayout frameLayout7, BattlePassProgressLevelView battlePassProgressLevelView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, View view, View view2) {
        this.U = frameLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = imageView4;
        this.e = imageView5;
        this.f = shapeConstraintLayout;
        this.g = cardView;
        this.h = frameLayout2;
        this.i = frameLayout3;
        this.j = shapeFrameLayout;
        this.k = frameLayout4;
        this.l = frameLayout5;
        this.m = frameLayout6;
        this.n = horizontalScrollView;
        this.o = imageView6;
        this.p = imageView7;
        this.q = imageView8;
        this.r = imageView9;
        this.s = imageView10;
        this.t = imageView11;
        this.u = imageView12;
        this.v = imageView13;
        this.w = imageView14;
        this.x = imageView15;
        this.y = imageView16;
        this.z = imageView17;
        this.A = shapeTextView;
        this.B = shapeTextView2;
        this.C = linearLayout;
        this.D = frameLayout7;
        this.E = battlePassProgressLevelView;
        this.F = relativeLayout;
        this.G = relativeLayout2;
        this.H = relativeLayout3;
        this.I = recyclerView;
        this.J = recyclerView2;
        this.K = textView;
        this.L = textView2;
        this.M = textView3;
        this.N = textView4;
        this.O = textView5;
        this.P = textView6;
        this.Q = textView7;
        this.R = textView8;
        this.S = view;
        this.T = view2;
    }

    public static DialogLiveBattlePassBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogLiveBattlePassBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_live_battle_pass, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogLiveBattlePassBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.btn_buy_battle_pass_pro);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.btn_get_all);
            if (imageView2 != null) {
                ImageView imageView3 = (ImageView) view.findViewById(R.id.btn_get_all_big);
                if (imageView3 != null) {
                    ImageView imageView4 = (ImageView) view.findViewById(R.id.btn_unlock);
                    if (imageView4 != null) {
                        ImageView imageView5 = (ImageView) view.findViewById(R.id.btn_unlock_all);
                        if (imageView5 != null) {
                            ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.cl_bonus_history_content);
                            if (shapeConstraintLayout != null) {
                                CardView findViewById = view.findViewById(R.id.cv_bonus_history_root);
                                if (findViewById != null) {
                                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_bonus_history_content);
                                    if (frameLayout != null) {
                                        FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.fl_bonus_history_empty);
                                        if (frameLayout2 != null) {
                                            ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) view.findViewById(R.id.fl_bonus_history_root);
                                            if (shapeFrameLayout != null) {
                                                FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.fl_rv_root);
                                                if (frameLayout3 != null) {
                                                    FrameLayout frameLayout4 = (FrameLayout) view.findViewById(R.id.fl_tab_day);
                                                    if (frameLayout4 != null) {
                                                        FrameLayout frameLayout5 = (FrameLayout) view.findViewById(R.id.fl_tab_weekly);
                                                        if (frameLayout5 != null) {
                                                            HorizontalScrollView horizontalScrollView = (HorizontalScrollView) view.findViewById(R.id.hv_score_progress_root);
                                                            if (horizontalScrollView != null) {
                                                                ImageView imageView6 = (ImageView) view.findViewById(R.id.iv_award_back);
                                                                if (imageView6 != null) {
                                                                    ImageView imageView7 = (ImageView) view.findViewById(R.id.iv_award_title);
                                                                    if (imageView7 != null) {
                                                                        ImageView imageView8 = (ImageView) view.findViewById(R.id.iv_award_title_pro);
                                                                        if (imageView8 != null) {
                                                                            ImageView imageView9 = (ImageView) view.findViewById(R.id.iv_bonus_history_empty_left);
                                                                            if (imageView9 != null) {
                                                                                ImageView imageView10 = (ImageView) view.findViewById(R.id.iv_bonus_history_empty_right);
                                                                                if (imageView10 != null) {
                                                                                    ImageView imageView11 = (ImageView) view.findViewById(R.id.iv_bonus_history_tag);
                                                                                    if (imageView11 != null) {
                                                                                        ImageView imageView12 = (ImageView) view.findViewById(R.id.iv_bonus_icon);
                                                                                        if (imageView12 != null) {
                                                                                            ImageView imageView13 = (ImageView) view.findViewById(R.id.iv_box);
                                                                                            if (imageView13 != null) {
                                                                                                ImageView imageView14 = (ImageView) view.findViewById(R.id.iv_box_title);
                                                                                                if (imageView14 != null) {
                                                                                                    ImageView imageView15 = (ImageView) view.findViewById(R.id.iv_info);
                                                                                                    if (imageView15 != null) {
                                                                                                        ImageView imageView16 = (ImageView) view.findViewById(R.id.iv_tab_day);
                                                                                                        if (imageView16 != null) {
                                                                                                            ImageView imageView17 = (ImageView) view.findViewById(R.id.iv_tab_weekly);
                                                                                                            if (imageView17 != null) {
                                                                                                                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.live_dot_day);
                                                                                                                if (shapeTextView != null) {
                                                                                                                    ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.live_dot_weekly);
                                                                                                                    if (shapeTextView2 != null) {
                                                                                                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_btn_root);
                                                                                                                        if (linearLayout != null) {
                                                                                                                            FrameLayout frameLayout6 = (FrameLayout) view.findViewById(R.id.loading);
                                                                                                                            if (frameLayout6 != null) {
                                                                                                                                BattlePassProgressLevelView battlePassProgressLevelView = (BattlePassProgressLevelView) view.findViewById(R.id.pv_score_progress);
                                                                                                                                if (battlePassProgressLevelView != null) {
                                                                                                                                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_award_root);
                                                                                                                                    if (relativeLayout != null) {
                                                                                                                                        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.rl_buy_battle_pass_pro);
                                                                                                                                        if (relativeLayout2 != null) {
                                                                                                                                            RelativeLayout relativeLayout3 = (RelativeLayout) view.findViewById(R.id.rl_task_root);
                                                                                                                                            if (relativeLayout3 != null) {
                                                                                                                                                RecyclerView findViewById2 = view.findViewById(R.id.rv_level_list);
                                                                                                                                                if (findViewById2 != null) {
                                                                                                                                                    RecyclerView findViewById3 = view.findViewById(R.id.rv_task_list);
                                                                                                                                                    if (findViewById3 != null) {
                                                                                                                                                        TextView textView = (TextView) view.findViewById(R.id.tv_bonus_content);
                                                                                                                                                        if (textView != null) {
                                                                                                                                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_bonus_count);
                                                                                                                                                            if (textView2 != null) {
                                                                                                                                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_bonus_history_tag);
                                                                                                                                                                if (textView3 != null) {
                                                                                                                                                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_my_exp);
                                                                                                                                                                    if (textView4 != null) {
                                                                                                                                                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_my_level);
                                                                                                                                                                        if (textView5 != null) {
                                                                                                                                                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_next_update_time);
                                                                                                                                                                            if (textView6 != null) {
                                                                                                                                                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_next_update_title);
                                                                                                                                                                                if (textView7 != null) {
                                                                                                                                                                                    TextView textView8 = (TextView) view.findViewById(R.id.tv_subtitle);
                                                                                                                                                                                    if (textView8 != null) {
                                                                                                                                                                                        View findViewById4 = view.findViewById(R.id.view_tab_day_back);
                                                                                                                                                                                        if (findViewById4 != null) {
                                                                                                                                                                                            View findViewById5 = view.findViewById(R.id.view_tab_weekly_back);
                                                                                                                                                                                            if (findViewById5 != null) {
                                                                                                                                                                                                return new DialogLiveBattlePassBinding((FrameLayout) view, imageView, imageView2, imageView3, imageView4, imageView5, shapeConstraintLayout, findViewById, frameLayout, frameLayout2, shapeFrameLayout, frameLayout3, frameLayout4, frameLayout5, horizontalScrollView, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, imageView12, imageView13, imageView14, imageView15, imageView16, imageView17, shapeTextView, shapeTextView2, linearLayout, frameLayout6, battlePassProgressLevelView, relativeLayout, relativeLayout2, relativeLayout3, findViewById2, findViewById3, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, findViewById4, findViewById5);
                                                                                                                                                                                            }
                                                                                                                                                                                            str = "viewTabWeeklyBack";
                                                                                                                                                                                        } else {
                                                                                                                                                                                            str = "viewTabDayBack";
                                                                                                                                                                                        }
                                                                                                                                                                                    } else {
                                                                                                                                                                                        str = "tvSubtitle";
                                                                                                                                                                                    }
                                                                                                                                                                                } else {
                                                                                                                                                                                    str = "tvNextUpdateTitle";
                                                                                                                                                                                }
                                                                                                                                                                            } else {
                                                                                                                                                                                str = "tvNextUpdateTime";
                                                                                                                                                                            }
                                                                                                                                                                        } else {
                                                                                                                                                                            str = "tvMyLevel";
                                                                                                                                                                        }
                                                                                                                                                                    } else {
                                                                                                                                                                        str = "tvMyExp";
                                                                                                                                                                    }
                                                                                                                                                                } else {
                                                                                                                                                                    str = "tvBonusHistoryTag";
                                                                                                                                                                }
                                                                                                                                                            } else {
                                                                                                                                                                str = "tvBonusCount";
                                                                                                                                                            }
                                                                                                                                                        } else {
                                                                                                                                                            str = "tvBonusContent";
                                                                                                                                                        }
                                                                                                                                                    } else {
                                                                                                                                                        str = "rvTaskList";
                                                                                                                                                    }
                                                                                                                                                } else {
                                                                                                                                                    str = "rvLevelList";
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                str = "rlTaskRoot";
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            str = "rlBuyBattlePassPro";
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        str = "rlAwardRoot";
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    str = "pvScoreProgress";
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                str = "loading";
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            str = "llBtnRoot";
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        str = "liveDotWeekly";
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    str = "liveDotDay";
                                                                                                                }
                                                                                                            } else {
                                                                                                                str = "ivTabWeekly";
                                                                                                            }
                                                                                                        } else {
                                                                                                            str = "ivTabDay";
                                                                                                        }
                                                                                                    } else {
                                                                                                        str = "ivInfo";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "ivBoxTitle";
                                                                                                }
                                                                                            } else {
                                                                                                str = "ivBox";
                                                                                            }
                                                                                        } else {
                                                                                            str = "ivBonusIcon";
                                                                                        }
                                                                                    } else {
                                                                                        str = "ivBonusHistoryTag";
                                                                                    }
                                                                                } else {
                                                                                    str = "ivBonusHistoryEmptyRight";
                                                                                }
                                                                            } else {
                                                                                str = "ivBonusHistoryEmptyLeft";
                                                                            }
                                                                        } else {
                                                                            str = "ivAwardTitlePro";
                                                                        }
                                                                    } else {
                                                                        str = "ivAwardTitle";
                                                                    }
                                                                } else {
                                                                    str = "ivAwardBack";
                                                                }
                                                            } else {
                                                                str = "hvScoreProgressRoot";
                                                            }
                                                        } else {
                                                            str = "flTabWeekly";
                                                        }
                                                    } else {
                                                        str = "flTabDay";
                                                    }
                                                } else {
                                                    str = "flRvRoot";
                                                }
                                            } else {
                                                str = "flBonusHistoryRoot";
                                            }
                                        } else {
                                            str = "flBonusHistoryEmpty";
                                        }
                                    } else {
                                        str = "flBonusHistoryContent";
                                    }
                                } else {
                                    str = "cvBonusHistoryRoot";
                                }
                            } else {
                                str = "clBonusHistoryContent";
                            }
                        } else {
                            str = "btnUnlockAll";
                        }
                    } else {
                        str = "btnUnlock";
                    }
                } else {
                    str = "btnGetAllBig";
                }
            } else {
                str = "btnGetAll";
            }
        } else {
            str = "btnBuyBattlePassPro";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.U;
    }
}
