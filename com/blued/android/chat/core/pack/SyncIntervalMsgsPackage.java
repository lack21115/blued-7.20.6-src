package com.blued.android.chat.core.pack;

import com.blued.android.chat.utils.BytesUtils;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/SyncIntervalMsgsPackage.class */
public class SyncIntervalMsgsPackage extends SyncBasePackage {
    private long endMsgId;
    private long sessionId;
    private short sessionType;
    private long startMsgId;

    public SyncIntervalMsgsPackage(short s, long j, long j2, long j3, long j4) {
        super((short) 3, j4);
        this.sessionType = s;
        this.sessionId = j;
        this.startMsgId = j2;
        this.endMsgId = j3;
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    protected BytesData msgDataToByte() {
        BytesData bytesData = new BytesData(26);
        BytesUtils.numberTo1Byte(bytesData.data, 0, this.syncType);
        BytesUtils.numberTo4Bytes(bytesData.data, 1, this.localId);
        BytesUtils.numberTo1Byte(bytesData.data, 5, this.sessionType);
        BytesUtils.numberTo4Bytes(bytesData.data, 6, this.sessionId);
        BytesUtils.numberTo8Bytes(bytesData.data, 10, this.startMsgId);
        BytesUtils.numberTo8Bytes(bytesData.data, 18, this.endMsgId);
        return bytesData;
    }

    @Override // com.blued.android.chat.core.pack.SyncBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[sessionType:" + ((int) this.sessionType) + ", sessionId:" + this.sessionId + ", startMsgId:" + this.startMsgId + ", endMsgId:" + this.endMsgId + "]";
    }
}
