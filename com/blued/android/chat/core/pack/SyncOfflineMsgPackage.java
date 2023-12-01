package com.blued.android.chat.core.pack;

import com.blued.android.chat.utils.BytesUtils;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/SyncOfflineMsgPackage.class */
public class SyncOfflineMsgPackage extends SyncBasePackage {
    private final long multiSyncLocalId;

    public SyncOfflineMsgPackage(long j, long j2) {
        super((short) 2, j);
        this.multiSyncLocalId = j2;
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    protected BytesData msgDataToByte() {
        BytesData bytesData = new BytesData(9);
        BytesUtils.numberTo1Byte(bytesData.data, 0, this.syncType);
        BytesUtils.numberTo4Bytes(bytesData.data, 1, this.localId);
        BytesUtils.numberTo4Bytes(bytesData.data, 5, this.multiSyncLocalId);
        return bytesData;
    }

    @Override // com.blued.android.chat.core.pack.SyncBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[SyncNew, multiSyncLocalId: " + this.multiSyncLocalId + "]";
    }
}
