package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentPageExhibitionBinding.class */
public final class FragmentPageExhibitionBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f16481a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f16482c;
    public final LinearLayout d;
    public final SmartRefreshLayout e;
    public final RecyclerView f;
    public final TextView g;
    private final ConstraintLayout h;

    private FragmentPageExhibitionBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, SmartRefreshLayout smartRefreshLayout, RecyclerView recyclerView, TextView textView) {
        this.h = constraintLayout;
        this.f16481a = imageView;
        this.b = imageView2;
        this.f16482c = imageView3;
        this.d = linearLayout;
        this.e = smartRefreshLayout;
        this.f = recyclerView;
        this.g = textView;
    }

    public static FragmentPageExhibitionBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.img_background);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.img_line_left);
            if (imageView2 != null) {
                ImageView imageView3 = (ImageView) view.findViewById(R.id.img_line_right);
                if (imageView3 != null) {
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_empty_view);
                    if (linearLayout != null) {
                        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refresh_layout);
                        if (smartRefreshLayout != null) {
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_receive_cars);
                            if (recyclerView != null) {
                                TextView textView = (TextView) view.findViewById(R.id.tv_somebody_exhibition);
                                if (textView != null) {
                                    return new FragmentPageExhibitionBinding((ConstraintLayout) view, imageView, imageView2, imageView3, linearLayout, smartRefreshLayout, recyclerView, textView);
                                }
                                str = "tvSomebodyExhibition";
                            } else {
                                str = "rvReceiveCars";
                            }
                        } else {
                            str = "refreshLayout";
                        }
                    } else {
                        str = "llEmptyView";
                    }
                } else {
                    str = "imgLineRight";
                }
            } else {
                str = "imgLineLeft";
            }
        } else {
            str = "imgBackground";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.h;
    }
}
