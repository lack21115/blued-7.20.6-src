package com.soft.blued.ui.search.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.das.guy.GuyProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.ui.search.adapter.SearchShortcutAdapter;
import com.soft.blued.ui.search.model.SearchGlobalInfo;
import com.soft.blued.ui.search.utils.SearchGlobalUtil;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/view/SearchGlobalShortcutHeader.class */
public final class SearchGlobalShortcutHeader extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private IRequestHost f19485a;
    private SearchShortcutAdapter b;

    /* renamed from: c  reason: collision with root package name */
    private String f19486c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SearchGlobalShortcutHeader(Context context) {
        this(context, null, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SearchGlobalShortcutHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchGlobalShortcutHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SearchGlobalShortcutHeader searchGlobalShortcutHeader, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(searchGlobalShortcutHeader, "this$0");
        Object item = baseQuickAdapter.getItem(i);
        if (item == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.soft.blued.ui.search.model.SearchGlobalInfo.SearchShortcutModel");
        }
        SearchGlobalInfo.SearchShortcutModel searchShortcutModel = (SearchGlobalInfo.SearchShortcutModel) item;
        String str = searchGlobalShortcutHeader.f19486c;
        if (str != null) {
            SearchGlobalUtil.f19484a.b(str);
        }
        EventTrackGuy.c(GuyProtos.Event.SEARCH_ALL_FIRST_RESULT_QUICK_CLICK, searchGlobalShortcutHeader.f19486c, searchShortcutModel.getName());
        WebViewShowInfoFragment.show(searchGlobalShortcutHeader.getContext(), searchShortcutModel.getTarget_url());
    }

    public final void a() {
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(getContext()).inflate(R.layout.layout_search_global_header, this).findViewById(R.id.rv_search_global_shortcut);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        SearchShortcutAdapter searchShortcutAdapter = new SearchShortcutAdapter(this.f19485a);
        this.b = searchShortcutAdapter;
        Intrinsics.a(searchShortcutAdapter);
        searchShortcutAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.search.view.-$$Lambda$SearchGlobalShortcutHeader$b7OTeJyLdf5Y3JENWSviDEil1cw
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SearchGlobalShortcutHeader.a(SearchGlobalShortcutHeader.this, baseQuickAdapter, view, i);
            }
        });
        recyclerView.setAdapter(this.b);
    }

    public final void a(List<SearchGlobalInfo.SearchShortcutModel> list, String str) {
        Intrinsics.e(list, "list");
        this.f19486c = str;
        for (SearchGlobalInfo.SearchShortcutModel searchShortcutModel : list) {
            EventTrackGuy.c(GuyProtos.Event.SEARCH_ALL_FIRST_RESULT_QUICK_SHOW, str, searchShortcutModel.getName());
        }
        SearchShortcutAdapter searchShortcutAdapter = this.b;
        if (searchShortcutAdapter == null) {
            return;
        }
        searchShortcutAdapter.setNewData(list);
    }

    public final IRequestHost getRequestHost() {
        return this.f19485a;
    }

    public final void setRequestHost(IRequestHost iRequestHost) {
        this.f19485a = iRequestHost;
    }
}
