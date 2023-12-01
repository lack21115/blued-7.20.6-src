package com.soft.blued.ui.msg.model;

import android.provider.Contacts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/GroupStatusInfo.class */
public final class GroupStatusInfo {
    private String group_id;
    private int online;

    public GroupStatusInfo(String str, int i) {
        Intrinsics.e(str, Contacts.GroupMembership.GROUP_ID);
        this.group_id = str;
        this.online = i;
    }

    public static /* synthetic */ GroupStatusInfo copy$default(GroupStatusInfo groupStatusInfo, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = groupStatusInfo.group_id;
        }
        if ((i2 & 2) != 0) {
            i = groupStatusInfo.online;
        }
        return groupStatusInfo.copy(str, i);
    }

    public final String component1() {
        return this.group_id;
    }

    public final int component2() {
        return this.online;
    }

    public final GroupStatusInfo copy(String str, int i) {
        Intrinsics.e(str, Contacts.GroupMembership.GROUP_ID);
        return new GroupStatusInfo(str, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GroupStatusInfo) {
            GroupStatusInfo groupStatusInfo = (GroupStatusInfo) obj;
            return Intrinsics.a(this.group_id, groupStatusInfo.group_id) && this.online == groupStatusInfo.online;
        }
        return false;
    }

    public final String getGroup_id() {
        return this.group_id;
    }

    public final int getOnline() {
        return this.online;
    }

    public int hashCode() {
        return (this.group_id.hashCode() * 31) + this.online;
    }

    public final void setGroup_id(String str) {
        Intrinsics.e(str, "<set-?>");
        this.group_id = str;
    }

    public final void setOnline(int i) {
        this.online = i;
    }

    public String toString() {
        return "GroupStatusInfo(group_id=" + this.group_id + ", online=" + this.online + ')';
    }
}
