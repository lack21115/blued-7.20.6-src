package com.soft.blued.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.view.SearchView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FmSearchGroupBinding.class */
public final class FmSearchGroupBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final NoDataAndLoadFailView f15073a;
    public final RecyclerView b;

    /* renamed from: c  reason: collision with root package name */
    public final SearchView f15074c;
    private final LinearLayout d;

    private FmSearchGroupBinding(LinearLayout linearLayout, NoDataAndLoadFailView noDataAndLoadFailView, RecyclerView recyclerView, SearchView searchView) {
        this.d = linearLayout;
        this.f15073a = noDataAndLoadFailView;
        this.b = recyclerView;
        this.f15074c = searchView;
    }

    public static FmSearchGroupBinding a(View view) {
        String str;
        NoDataAndLoadFailView findViewById = view.findViewById(2131368721);
        if (findViewById != null) {
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
            if (recyclerView != null) {
                SearchView findViewById2 = view.findViewById(R.id.search_view);
                if (findViewById2 != null) {
                    return new FmSearchGroupBinding((LinearLayout) view, findViewById, recyclerView, findViewById2);
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
