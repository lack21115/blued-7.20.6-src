package com.blued.android.chat.core.pack;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/MsgHeader.class */
public class MsgHeader {
    public boolean isDeleted;
    public boolean isNeedReceiptFlag;
    public boolean isOrder;
    public boolean isReaded;
    public boolean isReceiptFlag;
    public boolean isSendByUser;

    public MsgHeader() {
        this.isOrder = false;
        this.isDeleted = false;
        this.isSendByUser = false;
        this.isReaded = false;
        this.isReceiptFlag = false;
        this.isNeedReceiptFlag = false;
    }

    public MsgHeader(byte b) {
        this.isOrder = (b & 32) > 0;
        this.isDeleted = (b & 16) > 0;
        this.isSendByUser = (b & 8) > 0;
        this.isReaded = (b & 4) > 0;
        this.isReceiptFlag = (b & 2) > 0;
        this.isNeedReceiptFlag = (b & 1) > 0;
    }

    public byte toByte() {
        byte b = this.isOrder ? (byte) 32 : (byte) 0;
        byte b2 = b;
        if (this.isDeleted) {
            b2 = (byte) (b | 16);
        }
        byte b3 = b2;
        if (this.isSendByUser) {
            b3 = (byte) (b2 | 8);
        }
        byte b4 = b3;
        if (this.isReaded) {
            b4 = (byte) (b3 | 4);
        }
        byte b5 = b4;
        if (this.isReceiptFlag) {
            b5 = (byte) (b4 | 2);
        }
        byte b6 = b5;
        if (this.isNeedReceiptFlag) {
            b6 = (byte) (b5 | 1);
        }
        return b6;
    }

    public String toString() {
        return "[isOrder:" + this.isOrder + ", isDeleted:" + this.isDeleted + ", isSendByUser:" + this.isSendByUser + ", isReaded:" + this.isReaded + ", isReceiptFlag:" + this.isReceiptFlag + ", isNeedReceiptFlag:" + this.isNeedReceiptFlag + "]";
    }
}
