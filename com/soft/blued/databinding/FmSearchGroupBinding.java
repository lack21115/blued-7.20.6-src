package com.soft.blued.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.view.SearchView;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FmSearchGroupBinding.class */
public final class FmSearchGroupBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final NoDataAndLoadFailView f28763a;
    public final RecyclerView b;

    /* renamed from: c  reason: collision with root package name */
    public final SearchView f28764c;
    private final LinearLayout d;

    private FmSearchGroupBinding(LinearLayout linearLayout, NoDataAndLoadFailView noDataAndLoadFailView, RecyclerView recyclerView, SearchView searchView) {
        this.d = linearLayout;
        this.f28763a = noDataAndLoadFailView;
        this.b = recyclerView;
        this.f28764c = searchView;
    }

    public static FmSearchGroupBinding a(View view) {
        String str;
        NoDataAndLoadFailView noDataAndLoadFailView = (NoDataAndLoadFailView) view.findViewById(2131368721);
        if (noDataAndLoadFailView != null) {
            RecyclerView recyclerView = (RecyclerView) view.findViewById(2131369093);
            if (recyclerView != null) {
                SearchView searchView = (SearchView) view.findViewById(2131369680);
                if (searchView != null) {
                    return new FmSearchGroupBinding((LinearLayout) view, noDataAndLoadFailView, recyclerView, searchView);
                }
                str = "searchView";
            } else {
                str = "recycleView";
            }
        } else {
            str = "noDataView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.d;
    }
}
