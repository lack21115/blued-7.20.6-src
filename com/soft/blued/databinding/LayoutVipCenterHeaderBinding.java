package com.soft.blued.databinding;

import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.soft.blued.R;
import com.soft.blued.ui.user.views.VipGradeProgress;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/LayoutVipCenterHeaderBinding.class */
public final class LayoutVipCenterHeaderBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f29434a;
    public final ItemVipCenterBannerBinding b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f29435c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final VipGradeProgress g;
    public final ShapeLinearLayout h;
    public final RecyclerView i;
    public final HorizontalScrollView j;
    public final TextView k;
    public final TextView l;
    public final LinearLayout m;
    private final LinearLayout n;

    private LayoutVipCenterHeaderBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ItemVipCenterBannerBinding itemVipCenterBannerBinding, LinearLayout linearLayout3, ImageView imageView, ImageView imageView2, ImageView imageView3, VipGradeProgress vipGradeProgress, ShapeLinearLayout shapeLinearLayout, RecyclerView recyclerView, HorizontalScrollView horizontalScrollView, TextView textView, TextView textView2, LinearLayout linearLayout4) {
        this.n = linearLayout;
        this.f29434a = linearLayout2;
        this.b = itemVipCenterBannerBinding;
        this.f29435c = linearLayout3;
        this.d = imageView;
        this.e = imageView2;
        this.f = imageView3;
        this.g = vipGradeProgress;
        this.h = shapeLinearLayout;
        this.i = recyclerView;
        this.j = horizontalScrollView;
        this.k = textView;
        this.l = textView2;
        this.m = linearLayout4;
    }

    public static LayoutVipCenterHeaderBinding a(View view) {
        String str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.banner_root_view);
        if (linearLayout != null) {
            View findViewById = view.findViewById(R.id.banner_view);
            if (findViewById != null) {
                ItemVipCenterBannerBinding a2 = ItemVipCenterBannerBinding.a(findViewById);
                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(2131364224);
                if (linearLayout2 != null) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_header_bg);
                    if (imageView != null) {
                        ImageView imageView2 = (ImageView) view.findViewById(2131366006);
                        if (imageView2 != null) {
                            ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_vip_gradle);
                            if (imageView3 != null) {
                                VipGradeProgress vipGradeProgress = (VipGradeProgress) view.findViewById(2131368972);
                                if (vipGradeProgress != null) {
                                    ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.recycler_parent_view);
                                    if (shapeLinearLayout != null) {
                                        RecyclerView recyclerView = (RecyclerView) view.findViewById(2131369105);
                                        if (recyclerView != null) {
                                            HorizontalScrollView horizontalScrollView = (HorizontalScrollView) view.findViewById(2131369645);
                                            if (horizontalScrollView != null) {
                                                TextView textView = (TextView) view.findViewById(2131372879);
                                                if (textView != null) {
                                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_vip_state);
                                                    if (textView2 != null) {
                                                        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.user_info_view);
                                                        if (linearLayout3 != null) {
                                                            return new LayoutVipCenterHeaderBinding((LinearLayout) view, linearLayout, a2, linearLayout2, imageView, imageView2, imageView3, vipGradeProgress, shapeLinearLayout, recyclerView, horizontalScrollView, textView, textView2, linearLayout3);
                                                        }
                                                        str = "userInfoView";
                                                    } else {
                                                        str = "tvVipState";
                                                    }
                                                } else {
                                                    str = "tvUserName";
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
                        str = "ivHeaderBg";
                    }
                } else {
                    str = "header";
                }
            } else {
                str = "bannerView";
            }
        } else {
            str = "bannerRootView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.n;
    }
}
