package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.FlowLayout;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.view.SearchView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FmSearchGlobalBinding.class */
public final class FmSearchGlobalBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final FlowLayout f28761a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f28762c;
    public final NoDataAndLoadFailView d;
    public final RecyclerView e;
    public final SearchView f;
    public final TextView g;
    private final ConstraintLayout h;

    private FmSearchGlobalBinding(ConstraintLayout constraintLayout, FlowLayout flowLayout, ImageView imageView, LinearLayout linearLayout, NoDataAndLoadFailView noDataAndLoadFailView, RecyclerView recyclerView, SearchView searchView, TextView textView) {
        this.h = constraintLayout;
        this.f28761a = flowLayout;
        this.b = imageView;
        this.f28762c = linearLayout;
        this.d = noDataAndLoadFailView;
        this.e = recyclerView;
        this.f = searchView;
        this.g = textView;
    }

    public static FmSearchGlobalBinding a(View view) {
        String str;
        FlowLayout flowLayout = (FlowLayout) view.findViewById(2131363977);
        if (flowLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(2131365254);
            if (imageView != null) {
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_search_recent);
                if (linearLayout != null) {
                    NoDataAndLoadFailView noDataAndLoadFailView = (NoDataAndLoadFailView) view.findViewById(2131368727);
                    if (noDataAndLoadFailView != null) {
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(2131369093);
                        if (recyclerView != null) {
                            SearchView searchView = (SearchView) view.findViewById(2131369680);
                            if (searchView != null) {
                                TextView textView = (TextView) view.findViewById(2131372754);
                                if (textView != null) {
                                    return new FmSearchGlobalBinding((ConstraintLayout) view, flowLayout, imageView, linearLayout, noDataAndLoadFailView, recyclerView, searchView, textView);
                                }
                                str = "tvTitle";
                            } else {
                                str = "searchView";
                            }
                        } else {
                            str = "recycleView";
                        }
                    } else {
                        str = "noDataView";
                    }
                } else {
                    str = "llSearchRecent";
                }
            } else {
                str = "ivDelete";
            }
        } else {
            str = "flowLayout";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.h;
    }
}
