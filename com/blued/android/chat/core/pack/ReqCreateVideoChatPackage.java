package com.blued.android.chat.core.pack;

import androidx.collection.ArrayMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqCreateVideoChatPackage.class */
public class ReqCreateVideoChatPackage extends ReqBasePackage {
    public final int chatSdkType;
    public final int consumeBeans;
    public final long invitedUid;
    public final String roomId;
    public final int roomType;

    public ReqCreateVideoChatPackage(long j, String str, int i, long j2, int i2, int i3) {
        super((short) 13, j2);
        this.invitedUid = j;
        this.roomId = str;
        this.roomType = i;
        this.chatSdkType = i2;
        this.consumeBeans = i3;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage
    protected Map<String, Object> getReqInfo() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("invited_uid", Long.valueOf(this.invitedUid));
        arrayMap.put("room_id", this.roomId);
        arrayMap.put("room_type", Integer.valueOf(this.roomType));
        arrayMap.put("chat_sdk_type", Integer.valueOf(this.chatSdkType));
        arrayMap.put("consume_beans", Integer.valueOf(this.consumeBeans));
        return arrayMap;
    }

    @Override // com.blued.android.chat.core.pack.ReqBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[invitedUid:" + this.invitedUid + ", roomId:" + this.roomId + ", roomType:" + this.roomType + ", chatSdkType:" + this.chatSdkType + ", consumeBeans:" + this.consumeBeans + "]";
    }
}
