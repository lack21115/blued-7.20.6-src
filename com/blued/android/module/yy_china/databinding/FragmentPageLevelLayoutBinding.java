package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentPageLevelLayoutBinding.class */
public final class FragmentPageLevelLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f16483a;
    public final LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f16484c;
    public final LinearLayout d;
    public final LinearLayout e;
    public final RecyclerView f;
    public final SmartRefreshLayout g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    private final ConstraintLayout m;

    private FragmentPageLevelLayoutBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.m = constraintLayout;
        this.f16483a = constraintLayout2;
        this.b = linearLayout;
        this.f16484c = linearLayout2;
        this.d = linearLayout3;
        this.e = linearLayout4;
        this.f = recyclerView;
        this.g = smartRefreshLayout;
        this.h = textView;
        this.i = textView2;
        this.j = textView3;
        this.k = textView4;
        this.l = textView5;
    }

    public static FragmentPageLevelLayoutBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_page_level_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static FragmentPageLevelLayoutBinding a(View view) {
        String str;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.con_all);
        if (constraintLayout != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_pk);
            if (linearLayout != null) {
                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_score);
                if (linearLayout2 != null) {
                    LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.ll_win);
                    if (linearLayout3 != null) {
                        LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.ll_win_percent);
                        if (linearLayout4 != null) {
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcv);
                            if (recyclerView != null) {
                                SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refresh_layout);
                                if (smartRefreshLayout != null) {
                                    TextView textView = (TextView) view.findViewById(R.id.tv_level_title);
                                    if (textView != null) {
                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_percent);
                                        if (textView2 != null) {
                                            TextView textView3 = (TextView) view.findViewById(R.id.tv_score);
                                            if (textView3 != null) {
                                                TextView textView4 = (TextView) view.findViewById(R.id.tv_times);
                                                if (textView4 != null) {
                                                    TextView textView5 = (TextView) view.findViewById(R.id.tv_win_times);
                                                    if (textView5 != null) {
                                                        return new FragmentPageLevelLayoutBinding((ConstraintLayout) view, constraintLayout, linearLayout, linearLayout2, linearLayout3, linearLayout4, recyclerView, smartRefreshLayout, textView, textView2, textView3, textView4, textView5);
                                                    }
                                                    str = "tvWinTimes";
                                                } else {
                                                    str = "tvTimes";
                                                }
                                            } else {
                                                str = "tvScore";
                                            }
                                        } else {
                                            str = "tvPercent";
                                        }
                                    } else {
                                        str = "tvLevelTitle";
                                    }
                                } else {
                                    str = "refreshLayout";
                                }
                            } else {
                                str = "rcv";
                            }
                        } else {
                            str = "llWinPercent";
                        }
                    } else {
                        str = "llWin";
                    }
                } else {
                    str = "llScore";
                }
            } else {
                str = "llPk";
            }
        } else {
            str = "conAll";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.m;
    }
}
