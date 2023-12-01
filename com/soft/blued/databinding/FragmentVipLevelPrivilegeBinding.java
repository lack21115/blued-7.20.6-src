package com.soft.blued.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.soft.blued.R;
import com.soft.blued.ui.user.views.VipGradeProgress;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FragmentVipLevelPrivilegeBinding.class */
public final class FragmentVipLevelPrivilegeBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f29025a;
    public final LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f29026c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final VipGradeProgress j;
    public final ShapeLinearLayout k;
    public final RecyclerView l;
    public final HorizontalScrollView m;
    public final CommonTopTitleNoTrans n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    public final TextView s;
    public final TextView t;
    private final FrameLayout u;

    private FragmentVipLevelPrivilegeBinding(FrameLayout frameLayout, FrameLayout frameLayout2, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, VipGradeProgress vipGradeProgress, ShapeLinearLayout shapeLinearLayout, RecyclerView recyclerView, HorizontalScrollView horizontalScrollView, CommonTopTitleNoTrans commonTopTitleNoTrans, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.u = frameLayout;
        this.f29025a = frameLayout2;
        this.b = linearLayout;
        this.f29026c = imageView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = imageView4;
        this.g = imageView5;
        this.h = imageView6;
        this.i = imageView7;
        this.j = vipGradeProgress;
        this.k = shapeLinearLayout;
        this.l = recyclerView;
        this.m = horizontalScrollView;
        this.n = commonTopTitleNoTrans;
        this.o = textView;
        this.p = textView2;
        this.q = textView3;
        this.r = textView4;
        this.s = textView5;
        this.t = textView6;
    }

    public static FragmentVipLevelPrivilegeBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.buy_btn);
        if (frameLayout != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(2131364224);
            if (linearLayout != null) {
                ImageView imageView = (ImageView) view.findViewById(2131365126);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_buy_btn);
                    if (imageView2 != null) {
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_grade);
                        if (imageView3 != null) {
                            ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_header_bg);
                            if (imageView4 != null) {
                                ImageView imageView5 = (ImageView) view.findViewById(2131365773);
                                if (imageView5 != null) {
                                    ImageView imageView6 = (ImageView) view.findViewById(2131366006);
                                    if (imageView6 != null) {
                                        ImageView imageView7 = (ImageView) view.findViewById(R.id.iv_vip_gradle);
                                        if (imageView7 != null) {
                                            VipGradeProgress vipGradeProgress = (VipGradeProgress) view.findViewById(2131368972);
                                            if (vipGradeProgress != null) {
                                                ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.recycler_parent_view);
                                                if (shapeLinearLayout != null) {
                                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(2131369105);
                                                    if (recyclerView != null) {
                                                        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) view.findViewById(2131369645);
                                                        if (horizontalScrollView != null) {
                                                            CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(2131370694);
                                                            if (commonTopTitleNoTrans != null) {
                                                                TextView textView = (TextView) view.findViewById(R.id.tv_buy_btn);
                                                                if (textView != null) {
                                                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_current_exp);
                                                                    if (textView2 != null) {
                                                                        TextView textView3 = (TextView) view.findViewById(2131372302);
                                                                        if (textView3 != null) {
                                                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_today_exp);
                                                                            if (textView4 != null) {
                                                                                TextView textView5 = (TextView) view.findViewById(R.id.tv_upgrade_need_exp);
                                                                                if (textView5 != null) {
                                                                                    TextView textView6 = (TextView) view.findViewById(2131372879);
                                                                                    if (textView6 != null) {
                                                                                        return new FragmentVipLevelPrivilegeBinding((FrameLayout) view, frameLayout, linearLayout, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, vipGradeProgress, shapeLinearLayout, recyclerView, horizontalScrollView, commonTopTitleNoTrans, textView, textView2, textView3, textView4, textView5, textView6);
                                                                                    }
                                                                                    str = "tvUserName";
                                                                                } else {
                                                                                    str = "tvUpgradeNeedExp";
                                                                                }
                                                                            } else {
                                                                                str = "tvTodayExp";
                                                                            }
                                                                        } else {
                                                                            str = "tvPrivilegeTitle";
                                                                        }
                                                                    } else {
                                                                        str = "tvCurrentExp";
                                                                    }
                                                                } else {
                                                                    str = "tvBuyBtn";
                                                                }
                                                            } else {
                                                                str = "title";
                                                            }
                                                        } else {
                                                            str = "scrollView";
                                                        }
                                                    } else {
                                                        str = "recyclerView";
                                                    }
                                                } else {
                                                    str = "recyclerParentView";
                                                }
                                            } else {
                                                str = "progress";
                                            }
                                        } else {
                                            str = "ivVipGradle";
                                        }
                                    } else {
                                        str = "ivUserAvatar";
                                    }
                                } else {
                                    str = "ivQuestion";
                                }
                            } else {
                                str = "ivHeaderBg";
                            }
                        } else {
                            str = "ivGrade";
                        }
                    } else {
                        str = "ivBuyBtn";
                    }
                } else {
                    str = "ivBg";
                }
            } else {
                str = "header";
            }
        } else {
            str = "buyBtn";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.u;
    }
}
