package com.soft.blued.ui.msg_group.state;

import com.blued.android.module.common.base.mvi.UiState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/state/GroupClassifyState.class */
public final class GroupClassifyState implements UiState {
    private Boolean succeed;

    public GroupClassifyState() {
        this(null, 1, null);
    }

    public GroupClassifyState(Boolean bool) {
        this.succeed = bool;
    }

    public /* synthetic */ GroupClassifyState(Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool);
    }

    public static /* synthetic */ GroupClassifyState copy$default(GroupClassifyState groupClassifyState, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = groupClassifyState.succeed;
        }
        return groupClassifyState.copy(bool);
    }

    public final Boolean component1() {
        return this.succeed;
    }

    public final GroupClassifyState copy(Boolean bool) {
        return new GroupClassifyState(bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GroupClassifyState) && Intrinsics.a(this.succeed, ((GroupClassifyState) obj).succeed);
    }

    public final Boolean getSucceed() {
        return this.succeed;
    }

    public int hashCode() {
        Boolean bool = this.succeed;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    public final void setSucceed(Boolean bool) {
        this.succeed = bool;
    }

    public String toString() {
        return "GroupClassifyState(succeed=" + this.succeed + ')';
    }
}
