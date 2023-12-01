package com.soft.blued.ui.search;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.base.mvi.BaseListAction;
import com.blued.android.module.common.base.mvi.BaseListFragment;
import com.blued.android.module.common.base.mvi.MVIBaseFragment;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.das.guy.GuyProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.ui.search.adapter.SearchGlobalAdapter;
import com.soft.blued.ui.search.model.SearchGlobalInfo;
import com.soft.blued.ui.search.vm.SearchGlobalMoreVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/SearchGlobalMoreFragment.class */
public final class SearchGlobalMoreFragment extends BaseListFragment<SearchGlobalMoreVM, SearchGlobalInfo> {
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private TextView[] f19454c;

    public SearchGlobalMoreFragment() {
        super((int) R.layout.fragment_search_global_more);
        this.b = 2;
        TextView[] textViewArr = new TextView[3];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                this.f19454c = textViewArr;
                return;
            } else {
                textViewArr[i2] = null;
                i = i2 + 1;
            }
        }
    }

    private final String D() {
        int i = this.b;
        String string = i != 1 ? i != 2 ? i != 3 ? "" : getString(R.string.friend_global_search_more_group) : getString(R.string.friend_global_search_more_user) : getString(R.string.friend_global_search_more_chat);
        Intrinsics.c(string, "when(dataType) {\n       …\n        else -> \"\"\n    }");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SearchGlobalMoreFragment searchGlobalMoreFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(searchGlobalMoreFragment, "this$0");
        EventTrackGuy.a(GuyProtos.Event.SEARCH_ALL_SECOND_RESULT_PAGE_SHOW, GuyProtos.SortType.COMPLEX_SORT);
        ((SearchGlobalAdapter) searchGlobalMoreFragment.f()).a(GuyProtos.SortType.COMPLEX_SORT);
        searchGlobalMoreFragment.y().b(0);
        a(searchGlobalMoreFragment, false, 1, null);
    }

    static /* synthetic */ void a(SearchGlobalMoreFragment searchGlobalMoreFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        searchGlobalMoreFragment.a(z);
    }

    private final void a(boolean z) {
        TextView[] textViewArr = this.f19454c;
        int length = textViewArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            TextView textView = textViewArr[i2];
            if (textView != null) {
                if (i2 == y().c()) {
                    textView.setTextSize(2, 17.0f);
                    textView.setTextColor(BluedSkinUtils.a(AppInfo.d(), 2131102254));
                } else {
                    textView.setTextSize(2, 15.0f);
                    textView.setTextColor(BluedSkinUtils.a(AppInfo.d(), 2131102263));
                }
            }
            i = i2 + 1;
        }
        if (z) {
            BluedStructureExtKt.a((MVIBaseFragment) this, BaseListAction.RefreshData.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SearchGlobalMoreFragment searchGlobalMoreFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(searchGlobalMoreFragment, "this$0");
        EventTrackGuy.a(GuyProtos.Event.SEARCH_ALL_SECOND_RESULT_PAGE_SHOW, GuyProtos.SortType.DISTANCE_SORT);
        ((SearchGlobalAdapter) searchGlobalMoreFragment.f()).a(GuyProtos.SortType.DISTANCE_SORT);
        searchGlobalMoreFragment.y().b(1);
        a(searchGlobalMoreFragment, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(SearchGlobalMoreFragment searchGlobalMoreFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(searchGlobalMoreFragment, "this$0");
        EventTrackGuy.a(GuyProtos.Event.SEARCH_ALL_SECOND_RESULT_PAGE_SHOW, GuyProtos.SortType.ONLINE_TIME_SORT);
        ((SearchGlobalAdapter) searchGlobalMoreFragment.f()).a(GuyProtos.SortType.ONLINE_TIME_SORT);
        searchGlobalMoreFragment.y().b(2);
        a(searchGlobalMoreFragment, false, 1, null);
    }

    /* renamed from: C */
    public SearchGlobalAdapter i() {
        IRequestHost fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        return new SearchGlobalAdapter(fragmentActive);
    }

    public void m() {
        int i;
        String string;
        super.m();
        this.b = A();
        Bundle arguments = getArguments();
        String str = "";
        if (arguments != null && (string = arguments.getString("search_keywords", "")) != null) {
            str = string;
        }
        y().a(this.b);
        y().a(str);
        y().b(0);
        ((SearchGlobalAdapter) f()).a(str);
        ((SearchGlobalAdapter) f()).a(1);
        CommonTopTitleNoTrans b = b();
        if (b != null) {
            b.setCenterText(D());
        }
        LinearLayout linearLayout = (LinearLayout) requireView().findViewById(R.id.ll_sort_tabs);
        if (this.b == 2) {
            this.f19454c[0] = (TextView) requireView().findViewById(R.id.tv_sort_by_default);
            this.f19454c[1] = (TextView) requireView().findViewById(R.id.tv_sort_by_nearby);
            this.f19454c[2] = (TextView) requireView().findViewById(R.id.tv_sort_by_online);
            TextView textView = this.f19454c[0];
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.search.-$$Lambda$SearchGlobalMoreFragment$O78hF468zLg95RhXbAUMGfw6o6o
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SearchGlobalMoreFragment.a(SearchGlobalMoreFragment.this, view);
                    }
                });
            }
            TextView textView2 = this.f19454c[1];
            if (textView2 != null) {
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.search.-$$Lambda$SearchGlobalMoreFragment$fQXzt-M2dkEU1fhvglnAI83XuZk
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SearchGlobalMoreFragment.b(SearchGlobalMoreFragment.this, view);
                    }
                });
            }
            TextView textView3 = this.f19454c[2];
            if (textView3 != null) {
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.search.-$$Lambda$SearchGlobalMoreFragment$YMC3rQEc10-6rU2GDNY7VY6TsSQ
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SearchGlobalMoreFragment.c(SearchGlobalMoreFragment.this, view);
                    }
                });
            }
            i = 0;
        } else {
            i = 8;
        }
        linearLayout.setVisibility(i);
        EventTrackGuy.a(GuyProtos.Event.SEARCH_ALL_SECOND_RESULT_PAGE_SHOW, GuyProtos.SortType.COMPLEX_SORT);
        a(false);
    }
}
