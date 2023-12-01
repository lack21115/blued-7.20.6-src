package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SlopeLoadingView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/DialogLiveGoodsWallBrandAwardBinding.class */
public final class DialogLiveGoodsWallBrandAwardBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ConstraintLayout b;
    public final Group c;
    public final ImageView d;
    public final SlopeLoadingView e;
    public final RecyclerView f;
    public final TextView g;
    public final TextView h;
    public final ShapeTextView i;
    public final ShapeTextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final View q;
    public final View r;
    private final ConstraintLayout s;

    private DialogLiveGoodsWallBrandAwardBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, Group group, ImageView imageView, SlopeLoadingView slopeLoadingView, RecyclerView recyclerView, TextView textView, TextView textView2, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, View view, View view2) {
        this.s = constraintLayout;
        this.a = constraintLayout2;
        this.b = constraintLayout3;
        this.c = group;
        this.d = imageView;
        this.e = slopeLoadingView;
        this.f = recyclerView;
        this.g = textView;
        this.h = textView2;
        this.i = shapeTextView;
        this.j = shapeTextView2;
        this.k = textView3;
        this.l = textView4;
        this.m = textView5;
        this.n = textView6;
        this.o = textView7;
        this.p = textView8;
        this.q = view;
        this.r = view2;
    }

    public static DialogLiveGoodsWallBrandAwardBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogLiveGoodsWallBrandAwardBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_live_goods_wall_brand_award, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogLiveGoodsWallBrandAwardBinding a(View view) {
        String str;
        ConstraintLayout findViewById = view.findViewById(R.id.cl_task_1);
        if (findViewById != null) {
            ConstraintLayout findViewById2 = view.findViewById(R.id.cl_task_2);
            if (findViewById2 != null) {
                Group findViewById3 = view.findViewById(R.id.group_list);
                if (findViewById3 != null) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
                    if (imageView != null) {
                        SlopeLoadingView slopeLoadingView = (SlopeLoadingView) view.findViewById(R.id.loading);
                        if (slopeLoadingView != null) {
                            RecyclerView findViewById4 = view.findViewById(R.id.rv_list);
                            if (findViewById4 != null) {
                                TextView textView = (TextView) view.findViewById(R.id.tv_brand_count);
                                if (textView != null) {
                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_get_brand_count);
                                    if (textView2 != null) {
                                        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_list_head_content);
                                        if (shapeTextView != null) {
                                            ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_list_head_time);
                                            if (shapeTextView2 != null) {
                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_list_title);
                                                if (textView3 != null) {
                                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_no_data);
                                                    if (textView4 != null) {
                                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_task1_desc);
                                                        if (textView5 != null) {
                                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_task1_title);
                                                            if (textView6 != null) {
                                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_task2_title);
                                                                if (textView7 != null) {
                                                                    TextView textView8 = (TextView) view.findViewById(R.id.tv_title);
                                                                    if (textView8 != null) {
                                                                        View findViewById5 = view.findViewById(R.id.view_line);
                                                                        if (findViewById5 != null) {
                                                                            View findViewById6 = view.findViewById(R.id.view_top_bg);
                                                                            if (findViewById6 != null) {
                                                                                return new DialogLiveGoodsWallBrandAwardBinding((ConstraintLayout) view, findViewById, findViewById2, findViewById3, imageView, slopeLoadingView, findViewById4, textView, textView2, shapeTextView, shapeTextView2, textView3, textView4, textView5, textView6, textView7, textView8, findViewById5, findViewById6);
                                                                            }
                                                                            str = "viewTopBg";
                                                                        } else {
                                                                            str = "viewLine";
                                                                        }
                                                                    } else {
                                                                        str = "tvTitle";
                                                                    }
                                                                } else {
                                                                    str = "tvTask2Title";
                                                                }
                                                            } else {
                                                                str = "tvTask1Title";
                                                            }
                                                        } else {
                                                            str = "tvTask1Desc";
                                                        }
                                                    } else {
                                                        str = "tvNoData";
                                                    }
                                                } else {
                                                    str = "tvListTitle";
                                                }
                                            } else {
                                                str = "tvListHeadTime";
                                            }
                                        } else {
                                            str = "tvListHeadContent";
                                        }
                                    } else {
                                        str = "tvGetBrandCount";
                                    }
                                } else {
                                    str = "tvBrandCount";
                                }
                            } else {
                                str = "rvList";
                            }
                        } else {
                            str = "loading";
                        }
                    } else {
                        str = "ivClose";
                    }
                } else {
                    str = "groupList";
                }
            } else {
                str = "clTask2";
            }
        } else {
            str = "clTask1";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.s;
    }
}
