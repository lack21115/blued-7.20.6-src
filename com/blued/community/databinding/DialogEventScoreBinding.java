package com.blued.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/DialogEventScoreBinding.class */
public final class DialogEventScoreBinding implements ViewBinding {
    public final TextView A;
    public final TextView B;
    private final FrameLayout C;
    public final ShapeTextView a;
    public final ShapeTextView b;
    public final CheckBox c;
    public final CheckBox d;
    public final CheckBox e;
    public final CheckBox f;
    public final CheckBox g;
    public final Flow h;
    public final ImageView i;
    public final ImageView j;
    public final ImageView k;
    public final ShapeConstraintLayout l;
    public final ShapeConstraintLayout m;
    public final LinearLayout n;
    public final LinearLayout o;
    public final LinearLayout p;
    public final LinearLayout q;
    public final LinearLayout r;
    public final LinearLayout s;
    public final FrameLayout t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public final TextView y;
    public final TextView z;

    private DialogEventScoreBinding(FrameLayout frameLayout, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, Flow flow, ImageView imageView, ImageView imageView2, ImageView imageView3, ShapeConstraintLayout shapeConstraintLayout, ShapeConstraintLayout shapeConstraintLayout2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, FrameLayout frameLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.C = frameLayout;
        this.a = shapeTextView;
        this.b = shapeTextView2;
        this.c = checkBox;
        this.d = checkBox2;
        this.e = checkBox3;
        this.f = checkBox4;
        this.g = checkBox5;
        this.h = flow;
        this.i = imageView;
        this.j = imageView2;
        this.k = imageView3;
        this.l = shapeConstraintLayout;
        this.m = shapeConstraintLayout2;
        this.n = linearLayout;
        this.o = linearLayout2;
        this.p = linearLayout3;
        this.q = linearLayout4;
        this.r = linearLayout5;
        this.s = linearLayout6;
        this.t = frameLayout2;
        this.u = textView;
        this.v = textView2;
        this.w = textView3;
        this.x = textView4;
        this.y = textView5;
        this.z = textView6;
        this.A = textView7;
        this.B = textView8;
    }

    public static DialogEventScoreBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogEventScoreBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_event_score, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogEventScoreBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_post_feed);
        if (shapeTextView != null) {
            ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.btn_post_score);
            if (shapeTextView2 != null) {
                CheckBox checkBox = (CheckBox) view.findViewById(R.id.cb_score_1);
                if (checkBox != null) {
                    CheckBox checkBox2 = (CheckBox) view.findViewById(R.id.cb_score_2);
                    if (checkBox2 != null) {
                        CheckBox checkBox3 = (CheckBox) view.findViewById(R.id.cb_score_3);
                        if (checkBox3 != null) {
                            CheckBox checkBox4 = (CheckBox) view.findViewById(R.id.cb_score_4);
                            if (checkBox4 != null) {
                                CheckBox checkBox5 = (CheckBox) view.findViewById(R.id.cb_score_5);
                                if (checkBox5 != null) {
                                    Flow findViewById = view.findViewById(R.id.flow_score);
                                    if (findViewById != null) {
                                        ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
                                        if (imageView != null) {
                                            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_done);
                                            if (imageView2 != null) {
                                                ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_feed_close);
                                                if (imageView3 != null) {
                                                    ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.lay_event_score);
                                                    if (shapeConstraintLayout != null) {
                                                        ShapeConstraintLayout shapeConstraintLayout2 = (ShapeConstraintLayout) view.findViewById(R.id.lay_feed_post);
                                                        if (shapeConstraintLayout2 != null) {
                                                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.lay_score_1);
                                                            if (linearLayout != null) {
                                                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.lay_score_2);
                                                                if (linearLayout2 != null) {
                                                                    LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.lay_score_3);
                                                                    if (linearLayout3 != null) {
                                                                        LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.lay_score_4);
                                                                        if (linearLayout4 != null) {
                                                                            LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.lay_score_5);
                                                                            if (linearLayout5 != null) {
                                                                                LinearLayout linearLayout6 = (LinearLayout) view.findViewById(R.id.ll_score);
                                                                                if (linearLayout6 != null) {
                                                                                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.rootLayout);
                                                                                    if (frameLayout != null) {
                                                                                        TextView textView = (TextView) view.findViewById(R.id.tv_score_1);
                                                                                        if (textView != null) {
                                                                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_score_2);
                                                                                            if (textView2 != null) {
                                                                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_score_3);
                                                                                                if (textView3 != null) {
                                                                                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_score_4);
                                                                                                    if (textView4 != null) {
                                                                                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_score_5);
                                                                                                        if (textView5 != null) {
                                                                                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_score_num);
                                                                                                            if (textView6 != null) {
                                                                                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_tips);
                                                                                                                if (textView7 != null) {
                                                                                                                    TextView textView8 = (TextView) view.findViewById(R.id.tv_title);
                                                                                                                    if (textView8 != null) {
                                                                                                                        return new DialogEventScoreBinding((FrameLayout) view, shapeTextView, shapeTextView2, checkBox, checkBox2, checkBox3, checkBox4, checkBox5, findViewById, imageView, imageView2, imageView3, shapeConstraintLayout, shapeConstraintLayout2, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, frameLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
                                                                                                                    }
                                                                                                                    str = "tvTitle";
                                                                                                                } else {
                                                                                                                    str = "tvTips";
                                                                                                                }
                                                                                                            } else {
                                                                                                                str = "tvScoreNum";
                                                                                                            }
                                                                                                        } else {
                                                                                                            str = "tvScore5";
                                                                                                        }
                                                                                                    } else {
                                                                                                        str = "tvScore4";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "tvScore3";
                                                                                                }
                                                                                            } else {
                                                                                                str = "tvScore2";
                                                                                            }
                                                                                        } else {
                                                                                            str = "tvScore1";
                                                                                        }
                                                                                    } else {
                                                                                        str = "rootLayout";
                                                                                    }
                                                                                } else {
                                                                                    str = "llScore";
                                                                                }
                                                                            } else {
                                                                                str = "layScore5";
                                                                            }
                                                                        } else {
                                                                            str = "layScore4";
                                                                        }
                                                                    } else {
                                                                        str = "layScore3";
                                                                    }
                                                                } else {
                                                                    str = "layScore2";
                                                                }
                                                            } else {
                                                                str = "layScore1";
                                                            }
                                                        } else {
                                                            str = "layFeedPost";
                                                        }
                                                    } else {
                                                        str = "layEventScore";
                                                    }
                                                } else {
                                                    str = "ivFeedClose";
                                                }
                                            } else {
                                                str = "ivDone";
                                            }
                                        } else {
                                            str = "ivClose";
                                        }
                                    } else {
                                        str = "flowScore";
                                    }
                                } else {
                                    str = "cbScore5";
                                }
                            } else {
                                str = "cbScore4";
                            }
                        } else {
                            str = "cbScore3";
                        }
                    } else {
                        str = "cbScore2";
                    }
                } else {
                    str = "cbScore1";
                }
            } else {
                str = "btnPostScore";
            }
        } else {
            str = "btnPostFeed";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.C;
    }
}
