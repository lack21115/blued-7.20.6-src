package com.blued.android.chat.core.pack;

import com.blued.android.chat.utils.BytesUtils;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/DeleteRetractMessagePackage.class */
public class DeleteRetractMessagePackage extends DeleteBasePackage {
    private final DeleteHeader deleteHeader;
    public final short isMatchMsg;
    public final long messageId;
    public final long sessionId;
    public final short sessionType;

    public DeleteRetractMessagePackage(short s, long j, long j2, long j3, short s2) {
        super(j3);
        this.deleteHeader = new DeleteHeader((short) 4, true);
        this.sessionType = s;
        this.sessionId = j;
        this.messageId = j2;
        this.isMatchMsg = s2;
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    protected BytesData msgDataToByte() {
        BytesData bytesData = new BytesData(19);
        bytesData.data[0] = this.deleteHeader.toByte();
        BytesUtils.numberTo4Bytes(bytesData.data, 1, this.localId);
        BytesUtils.numberTo1Byte(bytesData.data, 5, this.sessionType);
        BytesUtils.numberTo4Bytes(bytesData.data, 6, this.sessionId);
        BytesUtils.numberTo8Bytes(bytesData.data, 10, this.messageId);
        BytesUtils.numberTo1Byte(bytesData.data, 18, this.isMatchMsg);
        return bytesData;
    }

    @Override // com.blued.android.chat.core.pack.DeleteBasePackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[DeleteMessage, sessionType:" + ((int) this.sessionType) + ", sessionId:" + this.sessionId + ", messageId:" + this.messageId + ", isMatchMsg:" + ((int) this.isMatchMsg) + ", deleteHeader:" + this.deleteHeader + "]";
    }
}
