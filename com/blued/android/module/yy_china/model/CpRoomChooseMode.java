package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/CpRoomChooseMode.class */
public final class CpRoomChooseMode {
    private String contName;
    private String contRealName;
    private final YYGiftModel gift_info;
    private String uid;

    public CpRoomChooseMode(YYGiftModel gift_info, String uid, String contName, String contRealName) {
        Intrinsics.e(gift_info, "gift_info");
        Intrinsics.e(uid, "uid");
        Intrinsics.e(contName, "contName");
        Intrinsics.e(contRealName, "contRealName");
        this.gift_info = gift_info;
        this.uid = uid;
        this.contName = contName;
        this.contRealName = contRealName;
    }

    public static /* synthetic */ CpRoomChooseMode copy$default(CpRoomChooseMode cpRoomChooseMode, YYGiftModel yYGiftModel, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            yYGiftModel = cpRoomChooseMode.gift_info;
        }
        if ((i & 2) != 0) {
            str = cpRoomChooseMode.uid;
        }
        if ((i & 4) != 0) {
            str2 = cpRoomChooseMode.contName;
        }
        if ((i & 8) != 0) {
            str3 = cpRoomChooseMode.contRealName;
        }
        return cpRoomChooseMode.copy(yYGiftModel, str, str2, str3);
    }

    public final YYGiftModel component1() {
        return this.gift_info;
    }

    public final String component2() {
        return this.uid;
    }

    public final String component3() {
        return this.contName;
    }

    public final String component4() {
        return this.contRealName;
    }

    public final CpRoomChooseMode copy(YYGiftModel gift_info, String uid, String contName, String contRealName) {
        Intrinsics.e(gift_info, "gift_info");
        Intrinsics.e(uid, "uid");
        Intrinsics.e(contName, "contName");
        Intrinsics.e(contRealName, "contRealName");
        return new CpRoomChooseMode(gift_info, uid, contName, contRealName);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CpRoomChooseMode) {
            CpRoomChooseMode cpRoomChooseMode = (CpRoomChooseMode) obj;
            return Intrinsics.a(this.gift_info, cpRoomChooseMode.gift_info) && Intrinsics.a((Object) this.uid, (Object) cpRoomChooseMode.uid) && Intrinsics.a((Object) this.contName, (Object) cpRoomChooseMode.contName) && Intrinsics.a((Object) this.contRealName, (Object) cpRoomChooseMode.contRealName);
        }
        return false;
    }

    public final String getContName() {
        return this.contName;
    }

    public final String getContRealName() {
        return this.contRealName;
    }

    public final YYGiftModel getGift_info() {
        return this.gift_info;
    }

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        return (((((this.gift_info.hashCode() * 31) + this.uid.hashCode()) * 31) + this.contName.hashCode()) * 31) + this.contRealName.hashCode();
    }

    public final void setContName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.contName = str;
    }

    public final void setContRealName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.contRealName = str;
    }

    public final void setUid(String str) {
        Intrinsics.e(str, "<set-?>");
        this.uid = str;
    }

    public String toString() {
        return "CpRoomChooseMode(gift_info=" + this.gift_info + ", uid=" + this.uid + ", contName=" + this.contName + ", contRealName=" + this.contRealName + ')';
    }
}
