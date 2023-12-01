package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/DoublePeopleNoticeImNode.class */
public final class DoublePeopleNoticeImNode {
    private final DoublePeopleNoticeInfoNode full_server_notification;
    private final String target_avatar;
    private final String uid_avatar;

    public DoublePeopleNoticeImNode(String uid_avatar, String target_avatar, DoublePeopleNoticeInfoNode full_server_notification) {
        Intrinsics.e(uid_avatar, "uid_avatar");
        Intrinsics.e(target_avatar, "target_avatar");
        Intrinsics.e(full_server_notification, "full_server_notification");
        this.uid_avatar = uid_avatar;
        this.target_avatar = target_avatar;
        this.full_server_notification = full_server_notification;
    }

    public static /* synthetic */ DoublePeopleNoticeImNode copy$default(DoublePeopleNoticeImNode doublePeopleNoticeImNode, String str, String str2, DoublePeopleNoticeInfoNode doublePeopleNoticeInfoNode, int i, Object obj) {
        if ((i & 1) != 0) {
            str = doublePeopleNoticeImNode.uid_avatar;
        }
        if ((i & 2) != 0) {
            str2 = doublePeopleNoticeImNode.target_avatar;
        }
        if ((i & 4) != 0) {
            doublePeopleNoticeInfoNode = doublePeopleNoticeImNode.full_server_notification;
        }
        return doublePeopleNoticeImNode.copy(str, str2, doublePeopleNoticeInfoNode);
    }

    public final String component1() {
        return this.uid_avatar;
    }

    public final String component2() {
        return this.target_avatar;
    }

    public final DoublePeopleNoticeInfoNode component3() {
        return this.full_server_notification;
    }

    public final DoublePeopleNoticeImNode copy(String uid_avatar, String target_avatar, DoublePeopleNoticeInfoNode full_server_notification) {
        Intrinsics.e(uid_avatar, "uid_avatar");
        Intrinsics.e(target_avatar, "target_avatar");
        Intrinsics.e(full_server_notification, "full_server_notification");
        return new DoublePeopleNoticeImNode(uid_avatar, target_avatar, full_server_notification);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DoublePeopleNoticeImNode) {
            DoublePeopleNoticeImNode doublePeopleNoticeImNode = (DoublePeopleNoticeImNode) obj;
            return Intrinsics.a((Object) this.uid_avatar, (Object) doublePeopleNoticeImNode.uid_avatar) && Intrinsics.a((Object) this.target_avatar, (Object) doublePeopleNoticeImNode.target_avatar) && Intrinsics.a(this.full_server_notification, doublePeopleNoticeImNode.full_server_notification);
        }
        return false;
    }

    public final DoublePeopleNoticeInfoNode getFull_server_notification() {
        return this.full_server_notification;
    }

    public final String getTarget_avatar() {
        return this.target_avatar;
    }

    public final String getUid_avatar() {
        return this.uid_avatar;
    }

    public int hashCode() {
        return (((this.uid_avatar.hashCode() * 31) + this.target_avatar.hashCode()) * 31) + this.full_server_notification.hashCode();
    }

    public String toString() {
        return "DoublePeopleNoticeImNode(uid_avatar=" + this.uid_avatar + ", target_avatar=" + this.target_avatar + ", full_server_notification=" + this.full_server_notification + ')';
    }
}
