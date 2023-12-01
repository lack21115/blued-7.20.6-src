package com.blued.android.module.yy_china.model;

import $r8;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/ClientSendMessageInfoDataModel.class */
public final class ClientSendMessageInfoDataModel {
    private final String roomId;
    private final String roomType;
    private final long time;

    public ClientSendMessageInfoDataModel(String roomId, String roomType, long j) {
        Intrinsics.e(roomId, "roomId");
        Intrinsics.e(roomType, "roomType");
        this.roomId = roomId;
        this.roomType = roomType;
        this.time = j;
    }

    public static /* synthetic */ ClientSendMessageInfoDataModel copy$default(ClientSendMessageInfoDataModel clientSendMessageInfoDataModel, String str, String str2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = clientSendMessageInfoDataModel.roomId;
        }
        if ((i & 2) != 0) {
            str2 = clientSendMessageInfoDataModel.roomType;
        }
        if ((i & 4) != 0) {
            j = clientSendMessageInfoDataModel.time;
        }
        return clientSendMessageInfoDataModel.copy(str, str2, j);
    }

    public final String component1() {
        return this.roomId;
    }

    public final String component2() {
        return this.roomType;
    }

    public final long component3() {
        return this.time;
    }

    public final ClientSendMessageInfoDataModel copy(String roomId, String roomType, long j) {
        Intrinsics.e(roomId, "roomId");
        Intrinsics.e(roomType, "roomType");
        return new ClientSendMessageInfoDataModel(roomId, roomType, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ClientSendMessageInfoDataModel) {
            ClientSendMessageInfoDataModel clientSendMessageInfoDataModel = (ClientSendMessageInfoDataModel) obj;
            return Intrinsics.a((Object) this.roomId, (Object) clientSendMessageInfoDataModel.roomId) && Intrinsics.a((Object) this.roomType, (Object) clientSendMessageInfoDataModel.roomType) && this.time == clientSendMessageInfoDataModel.time;
        }
        return false;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getRoomType() {
        return this.roomType;
    }

    public final long getTime() {
        return this.time;
    }

    public int hashCode() {
        return (((this.roomId.hashCode() * 31) + this.roomType.hashCode()) * 31) + $r8.backportedMethods.utility.Long.1.hashCode.hashCode(this.time);
    }

    public String toString() {
        return "ClientSendMessageInfoDataModel(roomId=" + this.roomId + ", roomType=" + this.roomType + ", time=" + this.time + ')';
    }
}
