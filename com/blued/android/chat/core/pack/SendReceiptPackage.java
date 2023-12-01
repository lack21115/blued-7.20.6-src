package com.blued.android.chat.core.pack;

import com.blued.android.chat.utils.BytesUtils;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/SendReceiptPackage.class */
public class SendReceiptPackage extends BasePackage {
    public MsgHeader msgHeader;
    public long msgId;
    public long sessionId;
    public short sessionType;

    @Override // com.blued.android.chat.core.pack.BasePackage
    protected BytesData msgDataToByte() {
        BytesData bytesData = new BytesData(14);
        bytesData.data[0] = this.msgHeader.toByte();
        BytesUtils.numberTo1Byte(bytesData.data, 1, this.sessionType);
        BytesUtils.numberTo4Bytes(bytesData.data, 2, this.sessionId);
        BytesUtils.numberTo8Bytes(bytesData.data, 6, this.msgId);
        return bytesData;
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[msgHeader:" + this.msgHeader + ", sessionType:" + ((int) this.sessionType) + ", sessionId:" + this.sessionId + ", msgId:" + this.msgId + "]";
    }
}
