package com.blued.android.chat.core.pack;

import com.blued.android.chat.utils.BytesUtils;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/PingPackage.class */
public class PingPackage extends BasePackage {
    public int freqMs;

    public PingPackage() {
        this.freqMs = 0;
        this.type = (short) 2;
    }

    public PingPackage(short s) {
        this.freqMs = 0;
        this.type = (short) 2;
        this.ack = true;
        this.freqMs = s;
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    protected BytesData msgDataToByte() {
        if (this.freqMs > 0) {
            BytesData bytesData = new BytesData(2);
            BytesUtils.numberTo2Bytes(bytesData.data, 0, this.freqMs);
            return bytesData;
        }
        return null;
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    protected void parseMsgData(byte[] bArr, int i, int i2) {
        this.freqMs = BytesUtils.bytesTo2Number(bArr, i);
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[freqMs:" + this.freqMs + ", ack:" + this.ack + "]";
    }
}
