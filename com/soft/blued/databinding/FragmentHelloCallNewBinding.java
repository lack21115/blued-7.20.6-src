package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.community.view.FloatFooterView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FragmentHelloCallNewBinding.class */
public final class FragmentHelloCallNewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f28849a;
    public final FloatFooterView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f28850c;
    public final LinearLayout d;
    public final ConstraintLayout e;
    public final PullToRefreshRecyclerView f;
    public final CommonTopTitleNoTrans g;
    public final TextView h;
    public final ShapeTextView i;
    public final ShapeTextView j;
    private final ConstraintLayout k;

    private FragmentHelloCallNewBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, FloatFooterView floatFooterView, ImageView imageView, LinearLayout linearLayout2, ConstraintLayout constraintLayout2, PullToRefreshRecyclerView pullToRefreshRecyclerView, CommonTopTitleNoTrans commonTopTitleNoTrans, TextView textView, ShapeTextView shapeTextView, ShapeTextView shapeTextView2) {
        this.k = constraintLayout;
        this.f28849a = linearLayout;
        this.b = floatFooterView;
        this.f28850c = imageView;
        this.d = linearLayout2;
        this.e = constraintLayout2;
        this.f = pullToRefreshRecyclerView;
        this.g = commonTopTitleNoTrans;
        this.h = textView;
        this.i = shapeTextView;
        this.j = shapeTextView2;
    }

    public static FragmentHelloCallNewBinding a(View view) {
        String str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.btn_filter);
        if (linearLayout != null) {
            FloatFooterView floatFooterView = (FloatFooterView) view.findViewById(R.id.ffv_bottom);
            if (floatFooterView != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_filter);
                if (imageView != null) {
                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.layout_scroll_top_filter);
                    if (linearLayout2 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.linearLayout2);
                        if (constraintLayout != null) {
                            PullToRefreshRecyclerView pullToRefreshRecyclerView = (PullToRefreshRecyclerView) view.findViewById(2131366898);
                            if (pullToRefreshRecyclerView != null) {
                                CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(2131370749);
                                if (commonTopTitleNoTrans != null) {
                                    TextView textView = (TextView) view.findViewById(R.id.tv_filter);
                                    if (textView != null) {
                                        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_sort_left);
                                        if (shapeTextView != null) {
                                            ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_sort_right);
                                            if (shapeTextView2 != null) {
                                                return new FragmentHelloCallNewBinding((ConstraintLayout) view, linearLayout, floatFooterView, imageView, linearLayout2, constraintLayout, pullToRefreshRecyclerView, commonTopTitleNoTrans, textView, shapeTextView, shapeTextView2);
                                            }
                                            str = "tvSortRight";
                                        } else {
                                            str = "tvSortLeft";
                                        }
                                    } else {
                                        str = "tvFilter";
                                    }
                                } else {
                                    str = "topTitle";
                                }
                            } else {
                                str = "listView";
                            }
                        } else {
                            str = "linearLayout2";
                        }
                    } else {
                        str = "layoutScrollTopFilter";
                    }
                } else {
                    str = "ivFilter";
                }
            } else {
                str = "ffvBottom";
            }
        } else {
            str = "btnFilter";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.k;
    }
}
