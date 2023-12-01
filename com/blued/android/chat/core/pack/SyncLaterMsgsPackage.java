package com.blued.android.chat.core.pack;

import com.blued.android.chat.utils.BytesUtils;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/SyncLaterMsgsPackage.class */
public class SyncLaterMsgsPackage extends SyncBasePackage {
    private final long sessionId;
    private final short sessionType;

    public SyncLaterMsgsPackage(short s, long j, long j2) {
        super((short) 4, j2);
        this.sessionType = s;
        this.sessionId = j;
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    protected BytesData msgDataToByte() {
        BytesData bytesData = new BytesData(10);
        BytesUtils.numberTo1Byte(bytesData.data, 0, this.syncType);
        BytesUtils.numberTo4Bytes(bytesData.data, 1, this.localId);
        BytesUtils.numberTo1Byte(bytesData.data, 5, this.sessionType);
        BytesUtils.numberTo4Bytes(bytesData.data, 6, this.sessionId);
        return bytesData;
    }

    @Override // com.blued.android.chat.core.pack.SyncBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[sessionType:" + ((int) this.sessionType) + ", sessionId:" + this.sessionId + "]";
    }
}
