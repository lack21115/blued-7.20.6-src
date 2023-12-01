package com.soft.blued.ui.search.state;

import com.blued.android.module.common.base.mvi.UiState;
import com.soft.blued.ui.search.model.SearchGlobalInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/state/SearchGlobalState.class */
public final class SearchGlobalState implements UiState {
    private final List<SearchGlobalInfo> data;
    private final List<String> recentList;

    public SearchGlobalState() {
        this(null, null, 3, null);
    }

    public SearchGlobalState(List<SearchGlobalInfo> list, List<String> list2) {
        this.data = list;
        this.recentList = list2;
    }

    public /* synthetic */ SearchGlobalState(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2);
    }

    public static /* synthetic */ SearchGlobalState copy$default(SearchGlobalState searchGlobalState, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = searchGlobalState.data;
        }
        if ((i & 2) != 0) {
            list2 = searchGlobalState.recentList;
        }
        return searchGlobalState.copy(list, list2);
    }

    public final List<SearchGlobalInfo> component1() {
        return this.data;
    }

    public final List<String> component2() {
        return this.recentList;
    }

    public final SearchGlobalState copy(List<SearchGlobalInfo> list, List<String> list2) {
        return new SearchGlobalState(list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SearchGlobalState) {
            SearchGlobalState searchGlobalState = (SearchGlobalState) obj;
            return Intrinsics.a(this.data, searchGlobalState.data) && Intrinsics.a(this.recentList, searchGlobalState.recentList);
        }
        return false;
    }

    public final List<SearchGlobalInfo> getData() {
        return this.data;
    }

    public final List<String> getRecentList() {
        return this.recentList;
    }

    public int hashCode() {
        List<SearchGlobalInfo> list = this.data;
        int i = 0;
        int hashCode = list == null ? 0 : list.hashCode();
        List<String> list2 = this.recentList;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return (hashCode * 31) + i;
    }

    public String toString() {
        return "SearchGlobalState(data=" + this.data + ", recentList=" + this.recentList + ')';
    }
}
