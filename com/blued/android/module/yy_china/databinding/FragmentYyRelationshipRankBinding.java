package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyRelationshipRankBinding.class */
public final class FragmentYyRelationshipRankBinding implements ViewBinding {
    public final SquareImageView a;
    public final LinearLayout b;
    public final RecyclerView c;
    public final SmartRefreshLayout d;
    public final TextView e;
    public final TextView f;
    private final ConstraintLayout g;

    private FragmentYyRelationshipRankBinding(ConstraintLayout constraintLayout, SquareImageView squareImageView, LinearLayout linearLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, TextView textView, TextView textView2) {
        this.g = constraintLayout;
        this.a = squareImageView;
        this.b = linearLayout;
        this.c = recyclerView;
        this.d = smartRefreshLayout;
        this.e = textView;
        this.f = textView2;
    }

    public static FragmentYyRelationshipRankBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv_null);
        if (squareImageView != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.noDataView);
            if (linearLayout != null) {
                RecyclerView findViewById = view.findViewById(R.id.recycler_view);
                if (findViewById != null) {
                    SmartRefreshLayout findViewById2 = view.findViewById(R.id.refresh_layout);
                    if (findViewById2 != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_null_1);
                        if (textView != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_null_2);
                            if (textView2 != null) {
                                return new FragmentYyRelationshipRankBinding((ConstraintLayout) view, squareImageView, linearLayout, findViewById, findViewById2, textView, textView2);
                            }
                            str = "tvNull2";
                        } else {
                            str = "tvNull1";
                        }
                    } else {
                        str = "refreshLayout";
                    }
                } else {
                    str = "recyclerView";
                }
            } else {
                str = "noDataView";
            }
        } else {
            str = "ivNull";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.g;
    }
}
