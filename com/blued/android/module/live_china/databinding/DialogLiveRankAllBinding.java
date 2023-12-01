package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.CustomViewPager;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.rank.LiveRankToolBarView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/DialogLiveRankAllBinding.class */
public final class DialogLiveRankAllBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RelativeLayout f11813a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final LiveRankToolBarView f11814c;
    public final CustomViewPager d;
    public final LinearLayout e;
    public final RelativeLayout f;
    public final LiveRankBarTitleBinding g;
    public final View h;
    private final RelativeLayout i;

    private DialogLiveRankAllBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ImageView imageView, LiveRankToolBarView liveRankToolBarView, CustomViewPager customViewPager, LinearLayout linearLayout, RelativeLayout relativeLayout3, LiveRankBarTitleBinding liveRankBarTitleBinding, View view) {
        this.i = relativeLayout;
        this.f11813a = relativeLayout2;
        this.b = imageView;
        this.f11814c = liveRankToolBarView;
        this.d = customViewPager;
        this.e = linearLayout;
        this.f = relativeLayout3;
        this.g = liveRankBarTitleBinding;
        this.h = view;
    }

    public static DialogLiveRankAllBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogLiveRankAllBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_live_rank_all, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogLiveRankAllBinding a(View view) {
        String str;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.cv_tabbar_root);
        if (relativeLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_flash_bg);
            if (imageView != null) {
                LiveRankToolBarView liveRankToolBarView = (LiveRankToolBarView) view.findViewById(R.id.live_rank_tool_bar);
                if (liveRankToolBarView != null) {
                    CustomViewPager customViewPager = (CustomViewPager) view.findViewById(R.id.live_rank_viewpager);
                    if (customViewPager != null) {
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_loading);
                        if (linearLayout != null) {
                            RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.root_rank);
                            if (relativeLayout2 != null) {
                                View findViewById = view.findViewById(R.id.title_bar);
                                if (findViewById != null) {
                                    LiveRankBarTitleBinding a2 = LiveRankBarTitleBinding.a(findViewById);
                                    View findViewById2 = view.findViewById(R.id.view_status_bar);
                                    if (findViewById2 != null) {
                                        return new DialogLiveRankAllBinding((RelativeLayout) view, relativeLayout, imageView, liveRankToolBarView, customViewPager, linearLayout, relativeLayout2, a2, findViewById2);
                                    }
                                    str = "viewStatusBar";
                                } else {
                                    str = "titleBar";
                                }
                            } else {
                                str = "rootRank";
                            }
                        } else {
                            str = "llLoading";
                        }
                    } else {
                        str = "liveRankViewpager";
                    }
                } else {
                    str = "liveRankToolBar";
                }
            } else {
                str = "ivFlashBg";
            }
        } else {
            str = "cvTabbarRoot";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.i;
    }
}
