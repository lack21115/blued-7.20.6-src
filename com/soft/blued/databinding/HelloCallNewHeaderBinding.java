package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/HelloCallNewHeaderBinding.class */
public final class HelloCallNewHeaderBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f29061a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f29062c;
    public final RecyclerView d;
    public final LinearLayout e;
    public final TextView f;
    public final TextView g;
    public final ShapeTextView h;
    public final ShapeTextView i;
    private final LinearLayout j;

    private HelloCallNewHeaderBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, LinearLayout linearLayout3, RecyclerView recyclerView, LinearLayout linearLayout4, TextView textView, TextView textView2, ShapeTextView shapeTextView, ShapeTextView shapeTextView2) {
        this.j = linearLayout;
        this.f29061a = linearLayout2;
        this.b = imageView;
        this.f29062c = linearLayout3;
        this.d = recyclerView;
        this.e = linearLayout4;
        this.f = textView;
        this.g = textView2;
        this.h = shapeTextView;
        this.i = shapeTextView2;
    }

    public static HelloCallNewHeaderBinding a(View view) {
        String str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.btn_filter);
        if (linearLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_filter);
            if (imageView != null) {
                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.layout_filter);
                if (linearLayout2 != null) {
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recommend_recycler_view);
                    if (recyclerView != null) {
                        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.recommend_view);
                        if (linearLayout3 != null) {
                            TextView textView = (TextView) view.findViewById(R.id.tv_filter);
                            if (textView != null) {
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_recommend_no_data);
                                if (textView2 != null) {
                                    ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_sort_left);
                                    if (shapeTextView != null) {
                                        ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_sort_right);
                                        if (shapeTextView2 != null) {
                                            return new HelloCallNewHeaderBinding((LinearLayout) view, linearLayout, imageView, linearLayout2, recyclerView, linearLayout3, textView, textView2, shapeTextView, shapeTextView2);
                                        }
                                        str = "tvSortRight";
                                    } else {
                                        str = "tvSortLeft";
                                    }
                                } else {
                                    str = "tvRecommendNoData";
                                }
                            } else {
                                str = "tvFilter";
                            }
                        } else {
                            str = "recommendView";
                        }
                    } else {
                        str = "recommendRecyclerView";
                    }
                } else {
                    str = "layoutFilter";
                }
            } else {
                str = "ivFilter";
            }
        } else {
            str = "btnFilter";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.j;
    }
}
