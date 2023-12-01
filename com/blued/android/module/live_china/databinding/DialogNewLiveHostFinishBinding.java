package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SlopeLoadingView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/DialogNewLiveHostFinishBinding.class */
public final class DialogNewLiveHostFinishBinding implements ViewBinding {
    public final TextView A;
    public final TextView B;
    public final TextView C;
    public final TextView D;
    public final TextView E;
    public final TextView F;
    public final TextView G;
    public final TextView H;
    public final TextView I;
    public final TextView J;
    public final TextView K;
    public final View L;
    public final View M;
    public final View N;
    public final View O;
    public final View P;
    public final View Q;
    private final ConstraintLayout R;
    public final ShapeConstraintLayout a;
    public final ShapeConstraintLayout b;
    public final ShapeConstraintLayout c;
    public final ShapeConstraintLayout d;
    public final ShapeConstraintLayout e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final SlopeLoadingView k;
    public final NestedScrollView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final ShapeTextView p;
    public final TextView q;
    public final TextView r;
    public final ShapeTextView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public final TextView y;
    public final TextView z;

    private DialogNewLiveHostFinishBinding(ConstraintLayout constraintLayout, ShapeConstraintLayout shapeConstraintLayout, ShapeConstraintLayout shapeConstraintLayout2, ShapeConstraintLayout shapeConstraintLayout3, ShapeConstraintLayout shapeConstraintLayout4, ShapeConstraintLayout shapeConstraintLayout5, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, SlopeLoadingView slopeLoadingView, NestedScrollView nestedScrollView, TextView textView, TextView textView2, TextView textView3, ShapeTextView shapeTextView, TextView textView4, TextView textView5, ShapeTextView shapeTextView2, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22, TextView textView23, View view, View view2, View view3, View view4, View view5, View view6) {
        this.R = constraintLayout;
        this.a = shapeConstraintLayout;
        this.b = shapeConstraintLayout2;
        this.c = shapeConstraintLayout3;
        this.d = shapeConstraintLayout4;
        this.e = shapeConstraintLayout5;
        this.f = imageView;
        this.g = imageView2;
        this.h = imageView3;
        this.i = imageView4;
        this.j = imageView5;
        this.k = slopeLoadingView;
        this.l = nestedScrollView;
        this.m = textView;
        this.n = textView2;
        this.o = textView3;
        this.p = shapeTextView;
        this.q = textView4;
        this.r = textView5;
        this.s = shapeTextView2;
        this.t = textView6;
        this.u = textView7;
        this.v = textView8;
        this.w = textView9;
        this.x = textView10;
        this.y = textView11;
        this.z = textView12;
        this.A = textView13;
        this.B = textView14;
        this.C = textView15;
        this.D = textView16;
        this.E = textView17;
        this.F = textView18;
        this.G = textView19;
        this.H = textView20;
        this.I = textView21;
        this.J = textView22;
        this.K = textView23;
        this.L = view;
        this.M = view2;
        this.N = view3;
        this.O = view4;
        this.P = view5;
        this.Q = view6;
    }

    public static DialogNewLiveHostFinishBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogNewLiveHostFinishBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_new_live_host_finish, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogNewLiveHostFinishBinding a(View view) {
        String str;
        ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.cl_college);
        if (shapeConstraintLayout != null) {
            ShapeConstraintLayout shapeConstraintLayout2 = (ShapeConstraintLayout) view.findViewById(R.id.cl_info_centre);
            if (shapeConstraintLayout2 != null) {
                ShapeConstraintLayout shapeConstraintLayout3 = (ShapeConstraintLayout) view.findViewById(R.id.cl_info_head);
                if (shapeConstraintLayout3 != null) {
                    ShapeConstraintLayout shapeConstraintLayout4 = (ShapeConstraintLayout) view.findViewById(R.id.cl_more_data);
                    if (shapeConstraintLayout4 != null) {
                        ShapeConstraintLayout shapeConstraintLayout5 = (ShapeConstraintLayout) view.findViewById(R.id.cl_report);
                        if (shapeConstraintLayout5 != null) {
                            ImageView imageView = (ImageView) view.findViewById(R.id.iv_avatar);
                            if (imageView != null) {
                                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_college);
                                if (imageView2 != null) {
                                    ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_more_data_arrow);
                                    if (imageView3 != null) {
                                        ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_report_arrow);
                                        if (imageView4 != null) {
                                            ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_shade);
                                            if (imageView5 != null) {
                                                SlopeLoadingView slopeLoadingView = (SlopeLoadingView) view.findViewById(R.id.loading);
                                                if (slopeLoadingView != null) {
                                                    NestedScrollView findViewById = view.findViewById(R.id.nsv_content);
                                                    if (findViewById != null) {
                                                        TextView textView = (TextView) view.findViewById(R.id.tv_add_follow);
                                                        if (textView != null) {
                                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_add_follow_num);
                                                            if (textView2 != null) {
                                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_college_desc);
                                                                if (textView3 != null) {
                                                                    ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_college_join);
                                                                    if (shapeTextView != null) {
                                                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_comment_number);
                                                                        if (textView4 != null) {
                                                                            TextView textView5 = (TextView) view.findViewById(R.id.tv_comment_number_num);
                                                                            if (textView5 != null) {
                                                                                ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_confirm);
                                                                                if (shapeTextView2 != null) {
                                                                                    TextView textView6 = (TextView) view.findViewById(R.id.tv_count_minute);
                                                                                    if (textView6 != null) {
                                                                                        TextView textView7 = (TextView) view.findViewById(R.id.tv_duration);
                                                                                        if (textView7 != null) {
                                                                                            TextView textView8 = (TextView) view.findViewById(R.id.tv_duration_num);
                                                                                            if (textView8 != null) {
                                                                                                TextView textView9 = (TextView) view.findViewById(R.id.tv_fans_add_number);
                                                                                                if (textView9 != null) {
                                                                                                    TextView textView10 = (TextView) view.findViewById(R.id.tv_fans_add_number_num);
                                                                                                    if (textView10 != null) {
                                                                                                        TextView textView11 = (TextView) view.findViewById(R.id.tv_gifts_number_people);
                                                                                                        if (textView11 != null) {
                                                                                                            TextView textView12 = (TextView) view.findViewById(R.id.tv_gifts_number_people_num);
                                                                                                            if (textView12 != null) {
                                                                                                                TextView textView13 = (TextView) view.findViewById(R.id.tv_like_number);
                                                                                                                if (textView13 != null) {
                                                                                                                    TextView textView14 = (TextView) view.findViewById(R.id.tv_like_number_num);
                                                                                                                    if (textView14 != null) {
                                                                                                                        TextView textView15 = (TextView) view.findViewById(R.id.tv_minute);
                                                                                                                        if (textView15 != null) {
                                                                                                                            TextView textView16 = (TextView) view.findViewById(R.id.tv_minute_suffix);
                                                                                                                            if (textView16 != null) {
                                                                                                                                TextView textView17 = (TextView) view.findViewById(R.id.tv_more_data);
                                                                                                                                if (textView17 != null) {
                                                                                                                                    TextView textView18 = (TextView) view.findViewById(R.id.tv_reap_bean);
                                                                                                                                    if (textView18 != null) {
                                                                                                                                        TextView textView19 = (TextView) view.findViewById(R.id.tv_reap_bean_num);
                                                                                                                                        if (textView19 != null) {
                                                                                                                                            TextView textView20 = (TextView) view.findViewById(R.id.tv_report);
                                                                                                                                            if (textView20 != null) {
                                                                                                                                                TextView textView21 = (TextView) view.findViewById(R.id.tv_title);
                                                                                                                                                if (textView21 != null) {
                                                                                                                                                    TextView textView22 = (TextView) view.findViewById(R.id.tv_viewer_count);
                                                                                                                                                    if (textView22 != null) {
                                                                                                                                                        TextView textView23 = (TextView) view.findViewById(R.id.tv_viewer_count_num);
                                                                                                                                                        if (textView23 != null) {
                                                                                                                                                            View findViewById2 = view.findViewById(R.id.view_separator_info_head);
                                                                                                                                                            if (findViewById2 != null) {
                                                                                                                                                                View findViewById3 = view.findViewById(R.id.view_separator_left_bottom);
                                                                                                                                                                if (findViewById3 != null) {
                                                                                                                                                                    View findViewById4 = view.findViewById(R.id.view_separator_left_top);
                                                                                                                                                                    if (findViewById4 != null) {
                                                                                                                                                                        View findViewById5 = view.findViewById(R.id.view_separator_right_bottom);
                                                                                                                                                                        if (findViewById5 != null) {
                                                                                                                                                                            View findViewById6 = view.findViewById(R.id.view_separator_right_top);
                                                                                                                                                                            if (findViewById6 != null) {
                                                                                                                                                                                View findViewById7 = view.findViewById(R.id.view_status_bar);
                                                                                                                                                                                if (findViewById7 != null) {
                                                                                                                                                                                    return new DialogNewLiveHostFinishBinding((ConstraintLayout) view, shapeConstraintLayout, shapeConstraintLayout2, shapeConstraintLayout3, shapeConstraintLayout4, shapeConstraintLayout5, imageView, imageView2, imageView3, imageView4, imageView5, slopeLoadingView, findViewById, textView, textView2, textView3, shapeTextView, textView4, textView5, shapeTextView2, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22, textView23, findViewById2, findViewById3, findViewById4, findViewById5, findViewById6, findViewById7);
                                                                                                                                                                                }
                                                                                                                                                                                str = "viewStatusBar";
                                                                                                                                                                            } else {
                                                                                                                                                                                str = "viewSeparatorRightTop";
                                                                                                                                                                            }
                                                                                                                                                                        } else {
                                                                                                                                                                            str = "viewSeparatorRightBottom";
                                                                                                                                                                        }
                                                                                                                                                                    } else {
                                                                                                                                                                        str = "viewSeparatorLeftTop";
                                                                                                                                                                    }
                                                                                                                                                                } else {
                                                                                                                                                                    str = "viewSeparatorLeftBottom";
                                                                                                                                                                }
                                                                                                                                                            } else {
                                                                                                                                                                str = "viewSeparatorInfoHead";
                                                                                                                                                            }
                                                                                                                                                        } else {
                                                                                                                                                            str = "tvViewerCountNum";
                                                                                                                                                        }
                                                                                                                                                    } else {
                                                                                                                                                        str = "tvViewerCount";
                                                                                                                                                    }
                                                                                                                                                } else {
                                                                                                                                                    str = "tvTitle";
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                str = "tvReport";
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            str = "tvReapBeanNum";
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        str = "tvReapBean";
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    str = "tvMoreData";
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                str = "tvMinuteSuffix";
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            str = "tvMinute";
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        str = "tvLikeNumberNum";
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    str = "tvLikeNumber";
                                                                                                                }
                                                                                                            } else {
                                                                                                                str = "tvGiftsNumberPeopleNum";
                                                                                                            }
                                                                                                        } else {
                                                                                                            str = "tvGiftsNumberPeople";
                                                                                                        }
                                                                                                    } else {
                                                                                                        str = "tvFansAddNumberNum";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "tvFansAddNumber";
                                                                                                }
                                                                                            } else {
                                                                                                str = "tvDurationNum";
                                                                                            }
                                                                                        } else {
                                                                                            str = "tvDuration";
                                                                                        }
                                                                                    } else {
                                                                                        str = "tvCountMinute";
                                                                                    }
                                                                                } else {
                                                                                    str = "tvConfirm";
                                                                                }
                                                                            } else {
                                                                                str = "tvCommentNumberNum";
                                                                            }
                                                                        } else {
                                                                            str = "tvCommentNumber";
                                                                        }
                                                                    } else {
                                                                        str = "tvCollegeJoin";
                                                                    }
                                                                } else {
                                                                    str = "tvCollegeDesc";
                                                                }
                                                            } else {
                                                                str = "tvAddFollowNum";
                                                            }
                                                        } else {
                                                            str = "tvAddFollow";
                                                        }
                                                    } else {
                                                        str = "nsvContent";
                                                    }
                                                } else {
                                                    str = "loading";
                                                }
                                            } else {
                                                str = "ivShade";
                                            }
                                        } else {
                                            str = "ivReportArrow";
                                        }
                                    } else {
                                        str = "ivMoreDataArrow";
                                    }
                                } else {
                                    str = "ivCollege";
                                }
                            } else {
                                str = "ivAvatar";
                            }
                        } else {
                            str = "clReport";
                        }
                    } else {
                        str = "clMoreData";
                    }
                } else {
                    str = "clInfoHead";
                }
            } else {
                str = "clInfoCentre";
            }
        } else {
            str = "clCollege";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.R;
    }
}
