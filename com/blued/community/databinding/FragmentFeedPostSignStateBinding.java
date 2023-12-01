package com.blued.community.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.HoleRelativeLayout;
import com.blued.community.R;
import com.blued.community.view.PhotoGridView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/FragmentFeedPostSignStateBinding.class */
public final class FragmentFeedPostSignStateBinding implements ViewBinding {
    public final AppBarLayout a;
    public final CollapsingToolbarLayout b;
    public final TextView c;
    public final PhotoGridView d;
    public final LinearLayout e;
    public final ImageView f;
    public final LinearLayout g;
    public final LinearLayout h;
    public final HoleRelativeLayout i;
    public final ImageView j;
    public final NestedScrollView k;
    private final CoordinatorLayout l;

    private FragmentFeedPostSignStateBinding(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, CollapsingToolbarLayout collapsingToolbarLayout, TextView textView, PhotoGridView photoGridView, LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, LinearLayout linearLayout3, HoleRelativeLayout holeRelativeLayout, ImageView imageView2, NestedScrollView nestedScrollView) {
        this.l = coordinatorLayout;
        this.a = appBarLayout;
        this.b = collapsingToolbarLayout;
        this.c = textView;
        this.d = photoGridView;
        this.e = linearLayout;
        this.f = imageView;
        this.g = linearLayout2;
        this.h = linearLayout3;
        this.i = holeRelativeLayout;
        this.j = imageView2;
        this.k = nestedScrollView;
    }

    public static FragmentFeedPostSignStateBinding a(View view) {
        String str;
        AppBarLayout findViewById = view.findViewById(R.id.appbar);
        if (findViewById != null) {
            CollapsingToolbarLayout findViewById2 = view.findViewById(R.id.ctl_test_bar);
            if (findViewById2 != null) {
                TextView textView = (TextView) view.findViewById(R.id.feed_bubble_state_guide_confirm);
                if (textView != null) {
                    PhotoGridView findViewById3 = view.findViewById(R.id.feed_post_sign_state_gv);
                    if (findViewById3 != null) {
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.feed_post_tips_layout);
                        if (linearLayout != null) {
                            ImageView imageView = (ImageView) view.findViewById(R.id.feed_post_title_close);
                            if (imageView != null) {
                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.feed_post_title_content);
                                if (linearLayout2 != null) {
                                    LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.guide_content);
                                    if (linearLayout3 != null) {
                                        HoleRelativeLayout holeRelativeLayout = (HoleRelativeLayout) view.findViewById(R.id.guide_layout);
                                        if (holeRelativeLayout != null) {
                                            ImageView imageView2 = (ImageView) view.findViewById(R.id.guide_triangle);
                                            if (imageView2 != null) {
                                                NestedScrollView findViewById4 = view.findViewById(R.id.nestedScrollView);
                                                if (findViewById4 != null) {
                                                    return new FragmentFeedPostSignStateBinding((CoordinatorLayout) view, findViewById, findViewById2, textView, findViewById3, linearLayout, imageView, linearLayout2, linearLayout3, holeRelativeLayout, imageView2, findViewById4);
                                                }
                                                str = "nestedScrollView";
                                            } else {
                                                str = "guideTriangle";
                                            }
                                        } else {
                                            str = "guideLayout";
                                        }
                                    } else {
                                        str = "guideContent";
                                    }
                                } else {
                                    str = "feedPostTitleContent";
                                }
                            } else {
                                str = "feedPostTitleClose";
                            }
                        } else {
                            str = "feedPostTipsLayout";
                        }
                    } else {
                        str = "feedPostSignStateGv";
                    }
                } else {
                    str = "feedBubbleStateGuideConfirm";
                }
            } else {
                str = "ctlTestBar";
            }
        } else {
            str = "appbar";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public CoordinatorLayout getRoot() {
        return this.l;
    }
}
