package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYyWaittingListViewBinding.class */
public final class ViewYyWaittingListViewBinding implements ViewBinding {
    public final RecyclerView a;
    public final SmartRefreshLayout b;
    public final TextView c;
    public final TextView d;
    private final LinearLayout e;

    private ViewYyWaittingListViewBinding(LinearLayout linearLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, TextView textView, TextView textView2) {
        this.e = linearLayout;
        this.a = recyclerView;
        this.b = smartRefreshLayout;
        this.c = textView;
        this.d = textView2;
    }

    public static ViewYyWaittingListViewBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_yy_waitting_list_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewYyWaittingListViewBinding a(View view) {
        String str;
        RecyclerView findViewById = view.findViewById(R.id.recycler_view);
        if (findViewById != null) {
            SmartRefreshLayout findViewById2 = view.findViewById(R.id.refresh_view);
            if (findViewById2 != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_gift_info);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_title);
                    if (textView2 != null) {
                        return new ViewYyWaittingListViewBinding((LinearLayout) view, findViewById, findViewById2, textView, textView2);
                    }
                    str = "tvTitle";
                } else {
                    str = "tvGiftInfo";
                }
            } else {
                str = "refreshView";
            }
        } else {
            str = "recyclerView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.e;
    }
}
