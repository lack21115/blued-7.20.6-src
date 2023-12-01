package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.module.common.view.SlopeLoadingView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.view.LineProgressView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/FragmentGoodsWallBinding.class */
public final class FragmentGoodsWallBinding implements ViewBinding {
    public final ShapeConstraintLayout a;
    public final ShapeConstraintLayout b;
    public final Group c;
    public final Group d;
    public final Group e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final SlopeLoadingView j;
    public final RecyclerView k;
    public final RecyclerView l;
    public final TextView m;
    public final TextView n;
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
    public final LineProgressView y;
    private final RelativeLayout z;

    private FragmentGoodsWallBinding(RelativeLayout relativeLayout, ShapeConstraintLayout shapeConstraintLayout, ShapeConstraintLayout shapeConstraintLayout2, Group group, Group group2, Group group3, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, SlopeLoadingView slopeLoadingView, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, LineProgressView lineProgressView) {
        this.z = relativeLayout;
        this.a = shapeConstraintLayout;
        this.b = shapeConstraintLayout2;
        this.c = group;
        this.d = group2;
        this.e = group3;
        this.f = imageView;
        this.g = imageView2;
        this.h = imageView3;
        this.i = imageView4;
        this.j = slopeLoadingView;
        this.k = recyclerView;
        this.l = recyclerView2;
        this.m = textView;
        this.n = textView2;
        this.o = textView3;
        this.p = textView4;
        this.q = textView5;
        this.r = textView6;
        this.s = textView7;
        this.t = textView8;
        this.u = textView9;
        this.v = textView10;
        this.w = textView11;
        this.x = textView12;
        this.y = lineProgressView;
    }

    public static FragmentGoodsWallBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_goods_wall, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static FragmentGoodsWallBinding a(View view) {
        String str;
        ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.cl_host_info);
        if (shapeConstraintLayout != null) {
            ShapeConstraintLayout shapeConstraintLayout2 = (ShapeConstraintLayout) view.findViewById(R.id.cl_task);
            if (shapeConstraintLayout2 != null) {
                Group findViewById = view.findViewById(R.id.group_aglow);
                if (findViewById != null) {
                    Group findViewById2 = view.findViewById(R.id.group_not_aglow);
                    if (findViewById2 != null) {
                        Group findViewById3 = view.findViewById(R.id.group_progress);
                        if (findViewById3 != null) {
                            ImageView imageView = (ImageView) view.findViewById(R.id.iv_avatar);
                            if (imageView != null) {
                                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_avatar_frame);
                                if (imageView2 != null) {
                                    ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_check_task);
                                    if (imageView3 != null) {
                                        ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_info);
                                        if (imageView4 != null) {
                                            SlopeLoadingView slopeLoadingView = (SlopeLoadingView) view.findViewById(R.id.loading);
                                            if (slopeLoadingView != null) {
                                                RecyclerView findViewById4 = view.findViewById(R.id.rv_aglow);
                                                if (findViewById4 != null) {
                                                    RecyclerView findViewById5 = view.findViewById(R.id.rv_not_aglow);
                                                    if (findViewById5 != null) {
                                                        TextView textView = (TextView) view.findViewById(R.id.tv_aglow_count);
                                                        if (textView != null) {
                                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_aglow_title);
                                                            if (textView2 != null) {
                                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_check_task);
                                                                if (textView3 != null) {
                                                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_desc);
                                                                    if (textView4 != null) {
                                                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_name);
                                                                        if (textView5 != null) {
                                                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_name_suffix);
                                                                            if (textView6 != null) {
                                                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_not_aglow_count);
                                                                                if (textView7 != null) {
                                                                                    TextView textView8 = (TextView) view.findViewById(R.id.tv_not_aglow_title);
                                                                                    if (textView8 != null) {
                                                                                        TextView textView9 = (TextView) view.findViewById(R.id.tv_progress);
                                                                                        if (textView9 != null) {
                                                                                            TextView textView10 = (TextView) view.findViewById(R.id.tv_task_all_finish);
                                                                                            if (textView10 != null) {
                                                                                                TextView textView11 = (TextView) view.findViewById(R.id.tv_task_title);
                                                                                                if (textView11 != null) {
                                                                                                    TextView textView12 = (TextView) view.findViewById(R.id.tv_update_time);
                                                                                                    if (textView12 != null) {
                                                                                                        LineProgressView lineProgressView = (LineProgressView) view.findViewById(R.id.view_progress);
                                                                                                        if (lineProgressView != null) {
                                                                                                            return new FragmentGoodsWallBinding((RelativeLayout) view, shapeConstraintLayout, shapeConstraintLayout2, findViewById, findViewById2, findViewById3, imageView, imageView2, imageView3, imageView4, slopeLoadingView, findViewById4, findViewById5, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, lineProgressView);
                                                                                                        }
                                                                                                        str = "viewProgress";
                                                                                                    } else {
                                                                                                        str = "tvUpdateTime";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "tvTaskTitle";
                                                                                                }
                                                                                            } else {
                                                                                                str = "tvTaskAllFinish";
                                                                                            }
                                                                                        } else {
                                                                                            str = "tvProgress";
                                                                                        }
                                                                                    } else {
                                                                                        str = "tvNotAglowTitle";
                                                                                    }
                                                                                } else {
                                                                                    str = "tvNotAglowCount";
                                                                                }
                                                                            } else {
                                                                                str = "tvNameSuffix";
                                                                            }
                                                                        } else {
                                                                            str = "tvName";
                                                                        }
                                                                    } else {
                                                                        str = "tvDesc";
                                                                    }
                                                                } else {
                                                                    str = "tvCheckTask";
                                                                }
                                                            } else {
                                                                str = "tvAglowTitle";
                                                            }
                                                        } else {
                                                            str = "tvAglowCount";
                                                        }
                                                    } else {
                                                        str = "rvNotAglow";
                                                    }
                                                } else {
                                                    str = "rvAglow";
                                                }
                                            } else {
                                                str = "loading";
                                            }
                                        } else {
                                            str = "ivInfo";
                                        }
                                    } else {
                                        str = "ivCheckTask";
                                    }
                                } else {
                                    str = "ivAvatarFrame";
                                }
                            } else {
                                str = "ivAvatar";
                            }
                        } else {
                            str = "groupProgress";
                        }
                    } else {
                        str = "groupNotAglow";
                    }
                } else {
                    str = "groupAglow";
                }
            } else {
                str = "clTask";
            }
        } else {
            str = "clHostInfo";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.z;
    }
}
