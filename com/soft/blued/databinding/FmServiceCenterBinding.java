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
    public final RelativeLayout f28767a;
    public final NoDataAndLoadFailView b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f28768c;
    public final CommonTopTitleNoTrans d;
    public final TextView e;
    private final ConstraintLayout f;

    private FmServiceCenterBinding(ConstraintLayout constraintLayout, RelativeLayout relativeLayout, NoDataAndLoadFailView noDataAndLoadFailView, RecyclerView recyclerView, CommonTopTitleNoTrans commonTopTitleNoTrans, TextView textView) {
        this.f = constraintLayout;
        this.f28767a = relativeLayout;
        this.b = noDataAndLoadFailView;
        this.f28768c = recyclerView;
        this.d = commonTopTitleNoTrans;
        this.e = textView;
    }

    public static FmServiceCenterBinding a(View view) {
        String str;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.bottomView);
        if (relativeLayout != null) {
            NoDataAndLoadFailView noDataAndLoadFailView = (NoDataAndLoadFailView) view.findViewById(2131368721);
            if (noDataAndLoadFailView != null) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(2131369093);
                if (recyclerView != null) {
                    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(2131370694);
                    if (commonTopTitleNoTrans != null) {
                        TextView textView = (TextView) view.findViewById(2131371675);
                        if (textView != null) {
                            return new FmServiceCenterBinding((ConstraintLayout) view, relativeLayout, noDataAndLoadFailView, recyclerView, commonTopTitleNoTrans, textView);
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
