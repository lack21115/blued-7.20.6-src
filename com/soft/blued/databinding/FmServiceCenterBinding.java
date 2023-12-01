package com.soft.blued.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FmServiceCenterBinding.class */
public final class FmServiceCenterBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RelativeLayout f15077a;
    public final NoDataAndLoadFailView b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f15078c;
    public final CommonTopTitleNoTrans d;
    public final TextView e;
    private final ConstraintLayout f;

    private FmServiceCenterBinding(ConstraintLayout constraintLayout, RelativeLayout relativeLayout, NoDataAndLoadFailView noDataAndLoadFailView, RecyclerView recyclerView, CommonTopTitleNoTrans commonTopTitleNoTrans, TextView textView) {
        this.f = constraintLayout;
        this.f15077a = relativeLayout;
        this.b = noDataAndLoadFailView;
        this.f15078c = recyclerView;
        this.d = commonTopTitleNoTrans;
        this.e = textView;
    }

    public static FmServiceCenterBinding a(View view) {
        String str;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.bottomView);
        if (relativeLayout != null) {
            NoDataAndLoadFailView findViewById = view.findViewById(2131368721);
            if (findViewById != null) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
                if (recyclerView != null) {
                    CommonTopTitleNoTrans findViewById2 = view.findViewById(2131370694);
                    if (findViewById2 != null) {
                        TextView textView = (TextView) view.findViewById(2131371675);
                        if (textView != null) {
                            return new FmServiceCenterBinding((ConstraintLayout) view, relativeLayout, findViewById, recyclerView, findViewById2, textView);
                        }
                        str = "tvHint";
                    } else {
                        str = "title";
                    }
                } else {
                    str = "recycleView";
                }
            } else {
                str = "noDataView";
            }
        } else {
            str = "bottomView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
