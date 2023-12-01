package com.blued.android.chat.core.pack;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/PushBasePackage.class */
public class PushBasePackage extends BasePackage {
    public MsgHeader msgHeader;
    public PushMsgPackage pushMsgPackage;
    public PushReadedPackage pushReadedPackage;

    protected PushBasePackage() {
    }

    public static PushBasePackage getDefaultInstance() {
        PushBasePackage pushBasePackage = new PushBasePackage();
        pushBasePackage.msgHeader = new MsgHeader();
        PushMsgPackage pushMsgPackage = new PushMsgPackage();
        pushMsgPackage.pushBasePackage = pushBasePackage;
        pushBasePackage.pushMsgPackage = pushMsgPackage;
        return pushBasePackage;
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    protected void parseMsgData(byte[] bArr, int i, int i2) {
        MsgHeader msgHeader = new MsgHeader(bArr[i]);
        this.msgHeader = msgHeader;
        int i3 = i + 1;
        if (msgHeader.isReceiptFlag) {
            PushReadedPackage pushReadedPackage = new PushReadedPackage();
            this.pushReadedPackage = pushReadedPackage;
            pushReadedPackage.pushBasePackage = this;
            this.pushReadedPackage.parseSubPackageData(bArr, i3, i2);
            return;
        }
        PushMsgPackage pushMsgPackage = new PushMsgPackage();
        this.pushMsgPackage = pushMsgPackage;
        pushMsgPackage.pushBasePackage = this;
        this.pushMsgPackage.parseSubPackageData(bArr, i3, i2);
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[msgHeader:" + this.msgHeader + ", pushReadedPackage:" + this.pushReadedPackage + ", _pushMsgPackage:" + this.pushMsgPackage + "]";
    }
}
