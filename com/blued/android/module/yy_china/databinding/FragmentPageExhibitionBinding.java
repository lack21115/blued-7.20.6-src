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
    public final ImageView a;
    public final ImageView b;
    public final ImageView c;
    public final LinearLayout d;
    public final SmartRefreshLayout e;
    public final RecyclerView f;
    public final TextView g;
    private final ConstraintLayout h;

    private FragmentPageExhibitionBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, SmartRefreshLayout smartRefreshLayout, RecyclerView recyclerView, TextView textView) {
        this.h = constraintLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = imageView3;
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
                        SmartRefreshLayout findViewById = view.findViewById(R.id.refresh_layout);
                        if (findViewById != null) {
                            RecyclerView findViewById2 = view.findViewById(R.id.rv_receive_cars);
                            if (findViewById2 != null) {
                                TextView textView = (TextView) view.findViewById(R.id.tv_somebody_exhibition);
                                if (textView != null) {
                                    return new FragmentPageExhibitionBinding((ConstraintLayout) view, imageView, imageView2, imageView3, linearLayout, findViewById, findViewById2, textView);
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

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.h;
    }
}
