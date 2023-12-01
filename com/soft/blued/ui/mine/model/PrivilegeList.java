package com.soft.blued.ui.mine.model;

import com.soft.blued.ui.user.model.VIPCenterForJsonParse;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/model/PrivilegeList.class */
public final class PrivilegeList {
    private final List<VIPCenterForJsonParse._privilege_list> current;
    private final List<VIPCenterForJsonParse._privilege_list> next;

    /* JADX WARN: Multi-variable type inference failed */
    public PrivilegeList(List<? extends VIPCenterForJsonParse._privilege_list> current, List<? extends VIPCenterForJsonParse._privilege_list> next) {
        Intrinsics.e(current, "current");
        Intrinsics.e(next, "next");
        this.current = current;
        this.next = next;
    }

    public static /* synthetic */ PrivilegeList copy$default(PrivilegeList privilegeList, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = privilegeList.current;
        }
        if ((i & 2) != 0) {
            list2 = privilegeList.next;
        }
        return privilegeList.copy(list, list2);
    }

    public final List<VIPCenterForJsonParse._privilege_list> component1() {
        return this.current;
    }

    public final List<VIPCenterForJsonParse._privilege_list> component2() {
        return this.next;
    }

    public final PrivilegeList copy(List<? extends VIPCenterForJsonParse._privilege_list> current, List<? extends VIPCenterForJsonParse._privilege_list> next) {
        Intrinsics.e(current, "current");
        Intrinsics.e(next, "next");
        return new PrivilegeList(current, next);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PrivilegeList) {
            PrivilegeList privilegeList = (PrivilegeList) obj;
            return Intrinsics.a(this.current, privilegeList.current) && Intrinsics.a(this.next, privilegeList.next);
        }
        return false;
    }

    public final List<VIPCenterForJsonParse._privilege_list> getCurrent() {
        return this.current;
    }

    public final List<VIPCenterForJsonParse._privilege_list> getNext() {
        return this.next;
    }

    public int hashCode() {
        return (this.current.hashCode() * 31) + this.next.hashCode();
    }

    public String toString() {
        return "PrivilegeList(current=" + this.current + ", next=" + this.next + ')';
    }
}
