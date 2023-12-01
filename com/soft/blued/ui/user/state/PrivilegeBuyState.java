package com.soft.blued.ui.user.state;

import com.blued.android.module.common.base.mvi.UiState;
import com.soft.blued.ui.user.model.CheckUserPrivilegePermission;
import com.soft.blued.ui.user.model.PrivilegeBuyOptionForJsonParse;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/PrivilegeBuyState.class */
public final class PrivilegeBuyState implements UiState {
    private final PrivilegeBuyOptionForJsonParse goodsListData;
    private final CheckUserPrivilegePermission userPrivilegePermission;

    public PrivilegeBuyState() {
        this(null, null, 3, null);
    }

    public PrivilegeBuyState(PrivilegeBuyOptionForJsonParse privilegeBuyOptionForJsonParse, CheckUserPrivilegePermission checkUserPrivilegePermission) {
        this.goodsListData = privilegeBuyOptionForJsonParse;
        this.userPrivilegePermission = checkUserPrivilegePermission;
    }

    public /* synthetic */ PrivilegeBuyState(PrivilegeBuyOptionForJsonParse privilegeBuyOptionForJsonParse, CheckUserPrivilegePermission checkUserPrivilegePermission, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : privilegeBuyOptionForJsonParse, (i & 2) != 0 ? null : checkUserPrivilegePermission);
    }

    public static /* synthetic */ PrivilegeBuyState copy$default(PrivilegeBuyState privilegeBuyState, PrivilegeBuyOptionForJsonParse privilegeBuyOptionForJsonParse, CheckUserPrivilegePermission checkUserPrivilegePermission, int i, Object obj) {
        if ((i & 1) != 0) {
            privilegeBuyOptionForJsonParse = privilegeBuyState.goodsListData;
        }
        if ((i & 2) != 0) {
            checkUserPrivilegePermission = privilegeBuyState.userPrivilegePermission;
        }
        return privilegeBuyState.copy(privilegeBuyOptionForJsonParse, checkUserPrivilegePermission);
    }

    public final PrivilegeBuyOptionForJsonParse component1() {
        return this.goodsListData;
    }

    public final CheckUserPrivilegePermission component2() {
        return this.userPrivilegePermission;
    }

    public final PrivilegeBuyState copy(PrivilegeBuyOptionForJsonParse privilegeBuyOptionForJsonParse, CheckUserPrivilegePermission checkUserPrivilegePermission) {
        return new PrivilegeBuyState(privilegeBuyOptionForJsonParse, checkUserPrivilegePermission);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PrivilegeBuyState) {
            PrivilegeBuyState privilegeBuyState = (PrivilegeBuyState) obj;
            return Intrinsics.a(this.goodsListData, privilegeBuyState.goodsListData) && Intrinsics.a(this.userPrivilegePermission, privilegeBuyState.userPrivilegePermission);
        }
        return false;
    }

    public final PrivilegeBuyOptionForJsonParse getGoodsListData() {
        return this.goodsListData;
    }

    public final CheckUserPrivilegePermission getUserPrivilegePermission() {
        return this.userPrivilegePermission;
    }

    public int hashCode() {
        PrivilegeBuyOptionForJsonParse privilegeBuyOptionForJsonParse = this.goodsListData;
        int i = 0;
        int hashCode = privilegeBuyOptionForJsonParse == null ? 0 : privilegeBuyOptionForJsonParse.hashCode();
        CheckUserPrivilegePermission checkUserPrivilegePermission = this.userPrivilegePermission;
        if (checkUserPrivilegePermission != null) {
            i = checkUserPrivilegePermission.hashCode();
        }
        return (hashCode * 31) + i;
    }

    public String toString() {
        return "PrivilegeBuyState(goodsListData=" + this.goodsListData + ", userPrivilegePermission=" + this.userPrivilegePermission + ')';
    }
}
