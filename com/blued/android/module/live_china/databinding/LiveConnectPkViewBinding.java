package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.view.LiveConnectPKUserItemView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveConnectPkViewBinding.class */
public final class LiveConnectPkViewBinding implements ViewBinding {
    public final ShapeTextView a;
    public final ShapeFrameLayout b;
    public final CardView c;
    public final ImageView d;
    public final ImageView e;
    public final LinearLayout f;
    public final LinearLayout g;
    public final ProgressBar h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final LiveConnectPKUserItemView m;
    public final LiveConnectPKUserItemView n;
    public final LiveConnectPKUserItemView o;
    public final LiveConnectPKUserItemView p;
    public final View q;
    public final ShapeTextView r;
    public final ShapeTextView s;
    public final View t;
    private final FrameLayout u;

    private LiveConnectPkViewBinding(FrameLayout frameLayout, ShapeTextView shapeTextView, ShapeFrameLayout shapeFrameLayout, CardView cardView, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, ProgressBar progressBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, LiveConnectPKUserItemView liveConnectPKUserItemView, LiveConnectPKUserItemView liveConnectPKUserItemView2, LiveConnectPKUserItemView liveConnectPKUserItemView3, LiveConnectPKUserItemView liveConnectPKUserItemView4, View view, ShapeTextView shapeTextView2, ShapeTextView shapeTextView3, View view2) {
        this.u = frameLayout;
        this.a = shapeTextView;
        this.b = shapeFrameLayout;
        this.c = cardView;
        this.d = imageView;
        this.e = imageView2;
        this.f = linearLayout;
        this.g = linearLayout2;
        this.h = progressBar;
        this.i = textView;
        this.j = textView2;
        this.k = textView3;
        this.l = textView4;
        this.m = liveConnectPKUserItemView;
        this.n = liveConnectPKUserItemView2;
        this.o = liveConnectPKUserItemView3;
        this.p = liveConnectPKUserItemView4;
        this.q = view;
        this.r = shapeTextView2;
        this.s = shapeTextView3;
        this.t = view2;
    }

    public static LiveConnectPkViewBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.bt_start_pk);
        if (shapeTextView != null) {
            ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) view.findViewById(R.id.content_layout);
            if (shapeFrameLayout != null) {
                CardView findViewById = view.findViewById(R.id.cv_tab_root);
                if (findViewById != null) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_pk);
                    if (imageView != null) {
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_pk_cloak);
                        if (imageView2 != null) {
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_user_list);
                            if (linearLayout != null) {
                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_user_list_bg);
                                if (linearLayout2 != null) {
                                    ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.loading);
                                    if (progressBar != null) {
                                        TextView textView = (TextView) view.findViewById(R.id.tv_start_tips);
                                        if (textView != null) {
                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_tab_each);
                                            if (textView2 != null) {
                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_tab_group);
                                                if (textView3 != null) {
                                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_title_pk_ing);
                                                    if (textView4 != null) {
                                                        LiveConnectPKUserItemView liveConnectPKUserItemView = (LiveConnectPKUserItemView) view.findViewById(R.id.user_1);
                                                        if (liveConnectPKUserItemView != null) {
                                                            LiveConnectPKUserItemView liveConnectPKUserItemView2 = (LiveConnectPKUserItemView) view.findViewById(R.id.user_2);
                                                            if (liveConnectPKUserItemView2 != null) {
                                                                LiveConnectPKUserItemView liveConnectPKUserItemView3 = (LiveConnectPKUserItemView) view.findViewById(R.id.user_3);
                                                                if (liveConnectPKUserItemView3 != null) {
                                                                    LiveConnectPKUserItemView liveConnectPKUserItemView4 = (LiveConnectPKUserItemView) view.findViewById(R.id.user_4);
                                                                    if (liveConnectPKUserItemView4 != null) {
                                                                        View findViewById2 = view.findViewById(R.id.view_carry);
                                                                        if (findViewById2 != null) {
                                                                            ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.view_cursor);
                                                                            if (shapeTextView2 != null) {
                                                                                ShapeTextView shapeTextView3 = (ShapeTextView) view.findViewById(R.id.view_dot);
                                                                                if (shapeTextView3 != null) {
                                                                                    View findViewById3 = view.findViewById(R.id.view_pk_icon_left);
                                                                                    if (findViewById3 != null) {
                                                                                        return new LiveConnectPkViewBinding((FrameLayout) view, shapeTextView, shapeFrameLayout, findViewById, imageView, imageView2, linearLayout, linearLayout2, progressBar, textView, textView2, textView3, textView4, liveConnectPKUserItemView, liveConnectPKUserItemView2, liveConnectPKUserItemView3, liveConnectPKUserItemView4, findViewById2, shapeTextView2, shapeTextView3, findViewById3);
                                                                                    }
                                                                                    str = "viewPkIconLeft";
                                                                                } else {
                                                                                    str = "viewDot";
                                                                                }
                                                                            } else {
                                                                                str = "viewCursor";
                                                                            }
                                                                        } else {
                                                                            str = "viewCarry";
                                                                        }
                                                                    } else {
                                                                        str = "user4";
                                                                    }
                                                                } else {
                                                                    str = "user3";
                                                                }
                                                            } else {
                                                                str = "user2";
                                                            }
                                                        } else {
                                                            str = "user1";
                                                        }
                                                    } else {
                                                        str = "tvTitlePkIng";
                                                    }
                                                } else {
                                                    str = "tvTabGroup";
                                                }
                                            } else {
                                                str = "tvTabEach";
                                            }
                                        } else {
                                            str = "tvStartTips";
                                        }
                                    } else {
                                        str = "loading";
                                    }
                                } else {
                                    str = "llUserListBg";
                                }
                            } else {
                                str = "llUserList";
                            }
                        } else {
                            str = "ivPkCloak";
                        }
                    } else {
                        str = "ivPk";
                    }
                } else {
                    str = "cvTabRoot";
                }
            } else {
                str = "contentLayout";
            }
        } else {
            str = "btStartPk";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.u;
    }
}
