package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;
import com.cdo.oaps.ad.OapsKey;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyHomeMineBinding.class */
public final class FragmentYyHomeMineBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f16504a;
    public final FrameLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final View f16505c;
    public final ImageView d;
    public final ImageView e;
    public final LinearLayout f;
    public final LinearLayout g;
    public final LinearLayout h;
    public final SmartRefreshLayout i;
    public final RelativeLayout j;
    public final RelativeLayout k;
    public final RecyclerView l;
    public final RecyclerView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    private final FrameLayout r;

    private FragmentYyHomeMineBinding(FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, View view, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, SmartRefreshLayout smartRefreshLayout, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.r = frameLayout;
        this.f16504a = frameLayout2;
        this.b = frameLayout3;
        this.f16505c = view;
        this.d = imageView;
        this.e = imageView2;
        this.f = linearLayout;
        this.g = linearLayout2;
        this.h = linearLayout3;
        this.i = smartRefreshLayout;
        this.j = relativeLayout;
        this.k = relativeLayout2;
        this.l = recyclerView;
        this.m = recyclerView2;
        this.n = textView;
        this.o = textView2;
        this.p = textView3;
        this.q = textView4;
    }

    public static FragmentYyHomeMineBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_follow_layout);
        if (frameLayout != null) {
            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.fl_history_layout);
            if (frameLayout2 != null) {
                View findViewById = view.findViewById(R.id.history_line);
                if (findViewById != null) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_follow_arrow);
                    if (imageView != null) {
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_history_arrow);
                        if (imageView2 != null) {
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_data_list);
                            if (linearLayout != null) {
                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_follow_flexible);
                                if (linearLayout2 != null) {
                                    LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.ll_history_flexible);
                                    if (linearLayout3 != null) {
                                        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.ref);
                                        if (smartRefreshLayout != null) {
                                            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_follow);
                                            if (relativeLayout != null) {
                                                RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.rl_history);
                                                if (relativeLayout2 != null) {
                                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_follow_list);
                                                    if (recyclerView != null) {
                                                        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.rv_history_list);
                                                        if (recyclerView2 != null) {
                                                            TextView textView = (TextView) view.findViewById(R.id.tv_follow_empty);
                                                            if (textView != null) {
                                                                TextView textView2 = (TextView) view.findViewById(R.id.tv_follow_flexible);
                                                                if (textView2 != null) {
                                                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_history_empty);
                                                                    if (textView3 != null) {
                                                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_history_flexible);
                                                                        if (textView4 != null) {
                                                                            return new FragmentYyHomeMineBinding((FrameLayout) view, frameLayout, frameLayout2, findViewById, imageView, imageView2, linearLayout, linearLayout2, linearLayout3, smartRefreshLayout, relativeLayout, relativeLayout2, recyclerView, recyclerView2, textView, textView2, textView3, textView4);
                                                                        }
                                                                        str = "tvHistoryFlexible";
                                                                    } else {
                                                                        str = "tvHistoryEmpty";
                                                                    }
                                                                } else {
                                                                    str = "tvFollowFlexible";
                                                                }
                                                            } else {
                                                                str = "tvFollowEmpty";
                                                            }
                                                        } else {
                                                            str = "rvHistoryList";
                                                        }
                                                    } else {
                                                        str = "rvFollowList";
                                                    }
                                                } else {
                                                    str = "rlHistory";
                                                }
                                            } else {
                                                str = "rlFollow";
                                            }
                                        } else {
                                            str = OapsKey.KEY_REF;
                                        }
                                    } else {
                                        str = "llHistoryFlexible";
                                    }
                                } else {
                                    str = "llFollowFlexible";
                                }
                            } else {
                                str = "llDataList";
                            }
                        } else {
                            str = "ivHistoryArrow";
                        }
                    } else {
                        str = "ivFollowArrow";
                    }
                } else {
                    str = "historyLine";
                }
            } else {
                str = "flHistoryLayout";
            }
        } else {
            str = "flFollowLayout";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.r;
    }
}
