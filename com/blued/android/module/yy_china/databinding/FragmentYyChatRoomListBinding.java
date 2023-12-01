package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYHomeTabView;
import com.blued.android.module.yy_china.view.ban.BGABanner;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyChatRoomListBinding.class */
public final class FragmentYyChatRoomListBinding implements ViewBinding {
    public final AppBarLayout a;
    public final BGABanner b;
    public final CoordinatorLayout c;
    public final FrameLayout d;
    public final LinearLayout e;
    public final NoDataAndLoadFailView f;
    public final SmartRefreshLayout g;
    public final RelativeLayout h;
    public final ViewPager i;
    public final ShapeLinearLayout j;
    public final YYHomeTabView k;
    public final TextView l;
    public final ShapeTextView m;
    public final TextView n;
    private final ConstraintLayout o;

    private FragmentYyChatRoomListBinding(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, BGABanner bGABanner, CoordinatorLayout coordinatorLayout, FrameLayout frameLayout, LinearLayout linearLayout, NoDataAndLoadFailView noDataAndLoadFailView, SmartRefreshLayout smartRefreshLayout, RelativeLayout relativeLayout, ViewPager viewPager, ShapeLinearLayout shapeLinearLayout, YYHomeTabView yYHomeTabView, TextView textView, ShapeTextView shapeTextView, TextView textView2) {
        this.o = constraintLayout;
        this.a = appBarLayout;
        this.b = bGABanner;
        this.c = coordinatorLayout;
        this.d = frameLayout;
        this.e = linearLayout;
        this.f = noDataAndLoadFailView;
        this.g = smartRefreshLayout;
        this.h = relativeLayout;
        this.i = viewPager;
        this.j = shapeLinearLayout;
        this.k = yYHomeTabView;
        this.l = textView;
        this.m = shapeTextView;
        this.n = textView2;
    }

    public static FragmentYyChatRoomListBinding a(View view) {
        String str;
        AppBarLayout findViewById = view.findViewById(R.id.appbar);
        if (findViewById != null) {
            BGABanner bGABanner = (BGABanner) view.findViewById(R.id.banner);
            if (bGABanner != null) {
                CoordinatorLayout findViewById2 = view.findViewById(R.id.coordinator);
                if (findViewById2 != null) {
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_code_of_condut_layout);
                    if (frameLayout != null) {
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_red_envelope);
                        if (linearLayout != null) {
                            NoDataAndLoadFailView noDataAndLoadFailView = (NoDataAndLoadFailView) view.findViewById(R.id.no_data_view);
                            if (noDataAndLoadFailView != null) {
                                SmartRefreshLayout findViewById3 = view.findViewById(R.id.refresh_layout);
                                if (findViewById3 != null) {
                                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl);
                                    if (relativeLayout != null) {
                                        ViewPager findViewById4 = view.findViewById(R.id.room_view_pager);
                                        if (findViewById4 != null) {
                                            ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.shall_home_bottoms);
                                            if (shapeLinearLayout != null) {
                                                YYHomeTabView yYHomeTabView = (YYHomeTabView) view.findViewById(R.id.tablayout);
                                                if (yYHomeTabView != null) {
                                                    TextView textView = (TextView) view.findViewById(R.id.tv_create_room_bottom);
                                                    if (textView != null) {
                                                        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_match_room);
                                                        if (shapeTextView != null) {
                                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_match_room_bottom);
                                                            if (textView2 != null) {
                                                                return new FragmentYyChatRoomListBinding((ConstraintLayout) view, findViewById, bGABanner, findViewById2, frameLayout, linearLayout, noDataAndLoadFailView, findViewById3, relativeLayout, findViewById4, shapeLinearLayout, yYHomeTabView, textView, shapeTextView, textView2);
                                                            }
                                                            str = "tvMatchRoomBottom";
                                                        } else {
                                                            str = "tvMatchRoom";
                                                        }
                                                    } else {
                                                        str = "tvCreateRoomBottom";
                                                    }
                                                } else {
                                                    str = "tablayout";
                                                }
                                            } else {
                                                str = "shallHomeBottoms";
                                            }
                                        } else {
                                            str = "roomViewPager";
                                        }
                                    } else {
                                        str = "rl";
                                    }
                                } else {
                                    str = "refreshLayout";
                                }
                            } else {
                                str = "noDataView";
                            }
                        } else {
                            str = "llRedEnvelope";
                        }
                    } else {
                        str = "flCodeOfCondutLayout";
                    }
                } else {
                    str = "coordinator";
                }
            } else {
                str = "banner";
            }
        } else {
            str = "appbar";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.o;
    }
}
