package com.soft.blued.ui.find.state;

import com.blued.android.module.common.base.mvi.UiState;
import com.blued.android.module.common.user.model.UserTagAll;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/state/FilterState.class */
public final class FilterState implements UiState {
    private final UserTagAll filterData;

    public FilterState() {
        this(null, 1, null);
    }

    public FilterState(UserTagAll userTagAll) {
        this.filterData = userTagAll;
    }

    public /* synthetic */ FilterState(UserTagAll userTagAll, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : userTagAll);
    }

    public static /* synthetic */ FilterState copy$default(FilterState filterState, UserTagAll userTagAll, int i, Object obj) {
        if ((i & 1) != 0) {
            userTagAll = filterState.filterData;
        }
        return filterState.copy(userTagAll);
    }

    public final UserTagAll component1() {
        return this.filterData;
    }

    public final FilterState copy(UserTagAll userTagAll) {
        return new FilterState(userTagAll);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FilterState) && Intrinsics.a(this.filterData, ((FilterState) obj).filterData);
    }

    public final UserTagAll getFilterData() {
        return this.filterData;
    }

    public int hashCode() {
        UserTagAll userTagAll = this.filterData;
        if (userTagAll == null) {
            return 0;
        }
        return userTagAll.hashCode();
    }

    public String toString() {
        return "FilterState(filterData=" + this.filterData + ')';
    }
}
