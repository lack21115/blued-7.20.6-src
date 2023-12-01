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

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyMyRelationshipBinding.class */
public final class FragmentYyMyRelationshipBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final SquareImageView f16529a;
    public final LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f16530c;
    public final SmartRefreshLayout d;
    public final TextView e;
    public final TextView f;
    private final ConstraintLayout g;

    private FragmentYyMyRelationshipBinding(ConstraintLayout constraintLayout, SquareImageView squareImageView, LinearLayout linearLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, TextView textView, TextView textView2) {
        this.g = constraintLayout;
        this.f16529a = squareImageView;
        this.b = linearLayout;
        this.f16530c = recyclerView;
        this.d = smartRefreshLayout;
        this.e = textView;
        this.f = textView2;
    }

    public static FragmentYyMyRelationshipBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv_null);
        if (squareImageView != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.noDataView);
            if (linearLayout != null) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
                if (recyclerView != null) {
                    SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refresh_layout);
                    if (smartRefreshLayout != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_null_1);
                        if (textView != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_null_2);
                            if (textView2 != null) {
                                return new FragmentYyMyRelationshipBinding((ConstraintLayout) view, squareImageView, linearLayout, recyclerView, smartRefreshLayout, textView, textView2);
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

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.g;
    }
}
