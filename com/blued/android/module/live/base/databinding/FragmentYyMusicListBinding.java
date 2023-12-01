package com.blued.android.module.live.base.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live.base.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/databinding/FragmentYyMusicListBinding.class */
public final class FragmentYyMusicListBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final YyMusicListNoDataBinding f11380a;
    public final YyMusicSearchNoDataBinding b;

    /* renamed from: c  reason: collision with root package name */
    public final YyMusicListLoadErrorBinding f11381c;
    public final ProgressBar d;
    public final RecyclerView e;
    public final SmartRefreshLayout f;
    private final FrameLayout g;

    private FragmentYyMusicListBinding(FrameLayout frameLayout, YyMusicListNoDataBinding yyMusicListNoDataBinding, YyMusicSearchNoDataBinding yyMusicSearchNoDataBinding, YyMusicListLoadErrorBinding yyMusicListLoadErrorBinding, ProgressBar progressBar, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        this.g = frameLayout;
        this.f11380a = yyMusicListNoDataBinding;
        this.b = yyMusicSearchNoDataBinding;
        this.f11381c = yyMusicListLoadErrorBinding;
        this.d = progressBar;
        this.e = recyclerView;
        this.f = smartRefreshLayout;
    }

    public static FragmentYyMusicListBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.ll_nodata);
        if (findViewById != null) {
            YyMusicListNoDataBinding a2 = YyMusicListNoDataBinding.a(findViewById);
            View findViewById2 = view.findViewById(R.id.ll_search_no_data);
            if (findViewById2 != null) {
                YyMusicSearchNoDataBinding a3 = YyMusicSearchNoDataBinding.a(findViewById2);
                View findViewById3 = view.findViewById(R.id.ll_sheet_error);
                if (findViewById3 != null) {
                    YyMusicListLoadErrorBinding a4 = YyMusicListLoadErrorBinding.a(findViewById3);
                    ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.loading_view);
                    if (progressBar != null) {
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_music);
                        if (recyclerView != null) {
                            SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.smart_members);
                            if (smartRefreshLayout != null) {
                                return new FragmentYyMusicListBinding((FrameLayout) view, a2, a3, a4, progressBar, recyclerView, smartRefreshLayout);
                            }
                            str = "smartMembers";
                        } else {
                            str = "rvMusic";
                        }
                    } else {
                        str = "loadingView";
                    }
                } else {
                    str = "llSheetError";
                }
            } else {
                str = "llSearchNoData";
            }
        } else {
            str = "llNodata";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.g;
    }
}
