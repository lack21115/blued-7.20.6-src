package com.soft.blued.ui.mine.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/model/VIPPrivilegeDataModel.class */
public final class VIPPrivilegeDataModel {
    private final PrivilegeList privilege_list;
    private final UsersInfo users_info;

    public VIPPrivilegeDataModel(PrivilegeList privilege_list, UsersInfo users_info) {
        Intrinsics.e(privilege_list, "privilege_list");
        Intrinsics.e(users_info, "users_info");
        this.privilege_list = privilege_list;
        this.users_info = users_info;
    }

    public static /* synthetic */ VIPPrivilegeDataModel copy$default(VIPPrivilegeDataModel vIPPrivilegeDataModel, PrivilegeList privilegeList, UsersInfo usersInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            privilegeList = vIPPrivilegeDataModel.privilege_list;
        }
        if ((i & 2) != 0) {
            usersInfo = vIPPrivilegeDataModel.users_info;
        }
        return vIPPrivilegeDataModel.copy(privilegeList, usersInfo);
    }

    public final PrivilegeList component1() {
        return this.privilege_list;
    }

    public final UsersInfo component2() {
        return this.users_info;
    }

    public final VIPPrivilegeDataModel copy(PrivilegeList privilege_list, UsersInfo users_info) {
        Intrinsics.e(privilege_list, "privilege_list");
        Intrinsics.e(users_info, "users_info");
        return new VIPPrivilegeDataModel(privilege_list, users_info);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VIPPrivilegeDataModel) {
            VIPPrivilegeDataModel vIPPrivilegeDataModel = (VIPPrivilegeDataModel) obj;
            return Intrinsics.a(this.privilege_list, vIPPrivilegeDataModel.privilege_list) && Intrinsics.a(this.users_info, vIPPrivilegeDataModel.users_info);
        }
        return false;
    }

    public final PrivilegeList getPrivilege_list() {
        return this.privilege_list;
    }

    public final UsersInfo getUsers_info() {
        return this.users_info;
    }

    public int hashCode() {
        return (this.privilege_list.hashCode() * 31) + this.users_info.hashCode();
    }

    public String toString() {
        return "VIPPrivilegeDataModel(privilege_list=" + this.privilege_list + ", users_info=" + this.users_info + ')';
    }
}
