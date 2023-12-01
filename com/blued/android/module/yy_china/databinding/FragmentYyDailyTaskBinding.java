package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.YYTaskRewardDialog;
import com.blued.android.module.yy_china.view.DailyPrizeView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyDailyTaskBinding.class */
public final class FragmentYyDailyTaskBinding implements ViewBinding {
    public final ShapeTextView a;
    public final ShapeTextView b;
    public final ShapeTextView c;
    public final ShapeTextView d;
    public final View e;
    public final ProgressBar f;
    public final TextView g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final DailyPrizeView k;
    public final DailyPrizeView l;
    public final DailyPrizeView m;
    public final DailyPrizeView n;
    public final ShapeConstraintLayout o;
    public final ConstraintLayout p;
    public final RecyclerView q;
    public final TextView r;
    public final YYTaskRewardDialog s;
    private final ConstraintLayout t;

    private FragmentYyDailyTaskBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, ShapeTextView shapeTextView3, ShapeTextView shapeTextView4, View view, ProgressBar progressBar, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3, DailyPrizeView dailyPrizeView, DailyPrizeView dailyPrizeView2, DailyPrizeView dailyPrizeView3, DailyPrizeView dailyPrizeView4, ShapeConstraintLayout shapeConstraintLayout, ConstraintLayout constraintLayout2, RecyclerView recyclerView, TextView textView2, YYTaskRewardDialog yYTaskRewardDialog) {
        this.t = constraintLayout;
        this.a = shapeTextView;
        this.b = shapeTextView2;
        this.c = shapeTextView3;
        this.d = shapeTextView4;
        this.e = view;
        this.f = progressBar;
        this.g = textView;
        this.h = imageView;
        this.i = imageView2;
        this.j = imageView3;
        this.k = dailyPrizeView;
        this.l = dailyPrizeView2;
        this.m = dailyPrizeView3;
        this.n = dailyPrizeView4;
        this.o = shapeConstraintLayout;
        this.p = constraintLayout2;
        this.q = recyclerView;
        this.r = textView2;
        this.s = yYTaskRewardDialog;
    }

    public static FragmentYyDailyTaskBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_get_four);
        if (shapeTextView != null) {
            ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.btn_get_one);
            if (shapeTextView2 != null) {
                ShapeTextView shapeTextView3 = (ShapeTextView) view.findViewById(R.id.btn_get_three);
                if (shapeTextView3 != null) {
                    ShapeTextView shapeTextView4 = (ShapeTextView) view.findViewById(R.id.btn_get_two);
                    if (shapeTextView4 != null) {
                        View findViewById = view.findViewById(R.id.cover_view);
                        if (findViewById != null) {
                            ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.daily_bar);
                            if (progressBar != null) {
                                TextView textView = (TextView) view.findViewById(R.id.dialog_title);
                                if (textView != null) {
                                    ImageView imageView = (ImageView) view.findViewById(R.id.img_background);
                                    if (imageView != null) {
                                        ImageView imageView2 = (ImageView) view.findViewById(R.id.img_question);
                                        if (imageView2 != null) {
                                            ImageView imageView3 = (ImageView) view.findViewById(R.id.img_title);
                                            if (imageView3 != null) {
                                                DailyPrizeView dailyPrizeView = (DailyPrizeView) view.findViewById(R.id.prize_four);
                                                if (dailyPrizeView != null) {
                                                    DailyPrizeView dailyPrizeView2 = (DailyPrizeView) view.findViewById(R.id.prize_one);
                                                    if (dailyPrizeView2 != null) {
                                                        DailyPrizeView dailyPrizeView3 = (DailyPrizeView) view.findViewById(R.id.prize_three);
                                                        if (dailyPrizeView3 != null) {
                                                            DailyPrizeView dailyPrizeView4 = (DailyPrizeView) view.findViewById(R.id.prize_two);
                                                            if (dailyPrizeView4 != null) {
                                                                ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.root_float_view);
                                                                if (shapeConstraintLayout != null) {
                                                                    ConstraintLayout findViewById2 = view.findViewById(R.id.root_view);
                                                                    if (findViewById2 != null) {
                                                                        RecyclerView findViewById3 = view.findViewById(R.id.rv_daily_list);
                                                                        if (findViewById3 != null) {
                                                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_today_process);
                                                                            if (textView2 != null) {
                                                                                YYTaskRewardDialog yYTaskRewardDialog = (YYTaskRewardDialog) view.findViewById(R.id.yyTaskReward);
                                                                                if (yYTaskRewardDialog != null) {
                                                                                    return new FragmentYyDailyTaskBinding((ConstraintLayout) view, shapeTextView, shapeTextView2, shapeTextView3, shapeTextView4, findViewById, progressBar, textView, imageView, imageView2, imageView3, dailyPrizeView, dailyPrizeView2, dailyPrizeView3, dailyPrizeView4, shapeConstraintLayout, findViewById2, findViewById3, textView2, yYTaskRewardDialog);
                                                                                }
                                                                                str = "yyTaskReward";
                                                                            } else {
                                                                                str = "tvTodayProcess";
                                                                            }
                                                                        } else {
                                                                            str = "rvDailyList";
                                                                        }
                                                                    } else {
                                                                        str = "rootView";
                                                                    }
                                                                } else {
                                                                    str = "rootFloatView";
                                                                }
                                                            } else {
                                                                str = "prizeTwo";
                                                            }
                                                        } else {
                                                            str = "prizeThree";
                                                        }
                                                    } else {
                                                        str = "prizeOne";
                                                    }
                                                } else {
                                                    str = "prizeFour";
                                                }
                                            } else {
                                                str = "imgTitle";
                                            }
                                        } else {
                                            str = "imgQuestion";
                                        }
                                    } else {
                                        str = "imgBackground";
                                    }
                                } else {
                                    str = "dialogTitle";
                                }
                            } else {
                                str = "dailyBar";
                            }
                        } else {
                            str = "coverView";
                        }
                    } else {
                        str = "btnGetTwo";
                    }
                } else {
                    str = "btnGetThree";
                }
            } else {
                str = "btnGetOne";
            }
        } else {
            str = "btnGetFour";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.t;
    }
}
