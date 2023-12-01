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
    public final FlowLayout f15071a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f15072c;
    public final NoDataAndLoadFailView d;
    public final RecyclerView e;
    public final SearchView f;
    public final TextView g;
    private final ConstraintLayout h;

    private FmSearchGlobalBinding(ConstraintLayout constraintLayout, FlowLayout flowLayout, ImageView imageView, LinearLayout linearLayout, NoDataAndLoadFailView noDataAndLoadFailView, RecyclerView recyclerView, SearchView searchView, TextView textView) {
        this.h = constraintLayout;
        this.f15071a = flowLayout;
        this.b = imageView;
        this.f15072c = linearLayout;
        this.d = noDataAndLoadFailView;
        this.e = recyclerView;
        this.f = searchView;
        this.g = textView;
    }

    public static FmSearchGlobalBinding a(View view) {
        String str;
        FlowLayout findViewById = view.findViewById(2131363977);
        if (findViewById != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_delete);
            if (imageView != null) {
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_search_recent);
                if (linearLayout != null) {
                    NoDataAndLoadFailView findViewById2 = view.findViewById(R.id.no_data_view);
                    if (findViewById2 != null) {
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
                        if (recyclerView != null) {
                            SearchView findViewById3 = view.findViewById(R.id.search_view);
                            if (findViewById3 != null) {
                                TextView textView = (TextView) view.findViewById(2131372754);
                                if (textView != null) {
                                    return new FmSearchGlobalBinding((ConstraintLayout) view, findViewById, imageView, linearLayout, findViewById2, recyclerView, findViewById3, textView);
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
