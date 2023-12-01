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

    /* renamed from: a  reason: collision with root package name */
    public final AppBarLayout f16492a;
    public final BGABanner b;

    /* renamed from: c  reason: collision with root package name */
    public final CoordinatorLayout f16493c;
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
        this.f16492a = appBarLayout;
        this.b = bGABanner;
        this.f16493c = coordinatorLayout;
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
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.appbar);
        if (appBarLayout != null) {
            BGABanner bGABanner = (BGABanner) view.findViewById(R.id.banner);
            if (bGABanner != null) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.coordinator);
                if (coordinatorLayout != null) {
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_code_of_condut_layout);
                    if (frameLayout != null) {
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_red_envelope);
                        if (linearLayout != null) {
                            NoDataAndLoadFailView noDataAndLoadFailView = (NoDataAndLoadFailView) view.findViewById(R.id.no_data_view);
                            if (noDataAndLoadFailView != null) {
                                SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refresh_layout);
                                if (smartRefreshLayout != null) {
                                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl);
                                    if (relativeLayout != null) {
                                        ViewPager viewPager = (ViewPager) view.findViewById(R.id.room_view_pager);
                                        if (viewPager != null) {
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
                                                                return new FragmentYyChatRoomListBinding((ConstraintLayout) view, appBarLayout, bGABanner, coordinatorLayout, frameLayout, linearLayout, noDataAndLoadFailView, smartRefreshLayout, relativeLayout, viewPager, shapeLinearLayout, yYHomeTabView, textView, shapeTextView, textView2);
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

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.o;
    }
}
