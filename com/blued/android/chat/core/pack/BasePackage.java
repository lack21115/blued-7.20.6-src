package com.blued.android.chat.core.pack;

import android.util.SparseArray;
import com.android.internal.util.cm.QSConstants;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.utils.BytesUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/BasePackage.class */
public class BasePackage {
    public static final int CURRENT_VERSION = 3;
    public static final int MAX_HEADER_LENGTH = 6;
    public static final int MIN_HEADER_LENGTH = 1;
    public static final int PACKAGE_TIMEOUT_MAX_MS = 60000;
    public static final int PACKAGE_TIMEOUT_MS = 30000;
    private static final String TAG = "Chat_BasePackage";
    static SparseArray<Class<? extends BasePackage>> packageRecvAckMap;
    static SparseArray<Class<? extends BasePackage>> packageRecvMap;
    public short version;
    public short type = -1;
    public boolean hasPayLoads = false;
    public boolean sync = false;
    public boolean ack = false;
    public boolean needAck = false;
    public int msgBodyLength = 0;
    public long localId = 0;
    public long sendTime = 0;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/BasePackage$PackException.class */
    public static class PackException extends Exception {
        public PackException() {
            super("unknown packexception");
        }

        public PackException(String str) {
            super(str);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/BasePackage$TYPE.class */
    public interface TYPE {
        public static final int CONNECT = 1;
        public static final int DELETE = 6;
        public static final int DISCONNECT = 14;
        public static final int PING = 2;
        public static final int PUSH = 4;
        public static final int RECONNECT = 13;
        public static final int REQ = 7;
        public static final int SEND = 3;
        public static final int SYNC = 5;
        public static final int UNKNOWN = -1;
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/BasePackage$UnsupportedVersionException.class */
    public static class UnsupportedVersionException extends PackException {
        public UnsupportedVersionException(short s) {
            super("UnsupportedVersionException, unsupportedVersion:" + ((int) s));
        }
    }

    static {
        SparseArray<Class<? extends BasePackage>> sparseArray = new SparseArray<>();
        packageRecvMap = sparseArray;
        sparseArray.put(2, PingPackage.class);
        packageRecvMap.put(4, PushBasePackage.class);
        packageRecvMap.put(13, BasePackage.class);
        packageRecvMap.put(14, DisconnectPackage.class);
        SparseArray<Class<? extends BasePackage>> sparseArray2 = new SparseArray<>();
        packageRecvAckMap = sparseArray2;
        sparseArray2.put(1, ConnAckPackage.class);
        packageRecvAckMap.put(3, SendAckPackage.class);
        packageRecvAckMap.put(5, SyncAckPackage.class);
        packageRecvAckMap.put(7, ReqAckPackage.class);
        packageRecvAckMap.put(6, DeleteAckPackage.class);
        packageRecvAckMap.put(2, PingPackage.class);
        packageRecvAckMap.put(14, BasePackage.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BasePackage() {
        this.version = (short) 0;
        this.version = (short) 3;
    }

    public static BasePackage createEmptyHeader() {
        return new BasePackage();
    }

    private static Class<? extends BasePackage> getRecvPackTypeClass(BasePackage basePackage) {
        return basePackage.ack ? packageRecvAckMap.get(basePackage.type) : packageRecvMap.get(basePackage.type);
    }

    public static BasePackage parseMsgBody(BasePackage basePackage, byte[] bArr, int i, int i2) {
        Class<? extends BasePackage> recvPackTypeClass = getRecvPackTypeClass(basePackage);
        if (recvPackTypeClass == null) {
            if (ChatManager.debug) {
                Log.e(TAG, "can't get packClass for header:" + basePackage);
                return null;
            }
            return null;
        }
        try {
            BasePackage newInstance = recvPackTypeClass.newInstance();
            newInstance.copyHeader(basePackage);
            if (bArr != null) {
                newInstance.parseMsgData(bArr, i, i2);
            }
            return newInstance;
        } catch (Exception e) {
            e.printStackTrace();
            if (ChatManager.debug) {
                Log.e(TAG, "parse pack exception", e);
                return null;
            }
            return null;
        }
    }

    public static BasePackage parseToPack(byte[] bArr, int i, int i2) throws PackException {
        BasePackage basePackage = new BasePackage();
        return (!basePackage.hasPayLoads || basePackage.msgBodyLength <= 0) ? basePackage : parseMsgBody(basePackage, bArr, i + basePackage.parseHeader(bArr, i, i2), i2);
    }

    public static String typeToString(BasePackage basePackage) {
        short s = basePackage.type;
        if (s != 13) {
            if (s != 14) {
                switch (s) {
                    case 1:
                        return "connect";
                    case 2:
                        return "ping";
                    case 3:
                        return "send";
                    case 4:
                        return "push";
                    case 5:
                        if (basePackage instanceof SyncBasePackage) {
                            short syncType = ((SyncBasePackage) basePackage).getSyncType();
                            return syncType != 1 ? syncType != 2 ? syncType != 3 ? syncType != 4 ? QSConstants.TILE_SYNC : "sync_later" : "sync_range" : "sync_new" : "sync_all";
                        }
                        return QSConstants.TILE_SYNC;
                    case 6:
                        return "delete";
                    case 7:
                        return HiAnalyticsConstant.Direction.REQUEST;
                    default:
                        return "unknown(" + ((int) basePackage.type) + ")";
                }
            }
            return "disconnect";
        }
        return "reconnect";
    }

    public void copyHeader(BasePackage basePackage) {
        this.type = basePackage.type;
        this.hasPayLoads = basePackage.hasPayLoads;
        this.sync = basePackage.sync;
        this.ack = basePackage.ack;
        this.needAck = basePackage.needAck;
        this.version = basePackage.version;
        this.msgBodyLength = basePackage.msgBodyLength;
    }

    public final int getPackLength() {
        if (this.hasPayLoads) {
            return this.msgBodyLength + 6;
        }
        return 1;
    }

    protected BytesData msgDataToByte() {
        return null;
    }

    public void parseFixHeader(byte b) {
        this.type = (short) ((b & 255) >> 4);
        this.hasPayLoads = (b & 8) > 0;
        this.sync = (b & 4) > 0;
        this.ack = (b & 2) > 0;
        boolean z = false;
        if ((b & 1) > 0) {
            z = true;
        }
        this.needAck = z;
    }

    public int parseHeader(byte[] bArr, int i, int i2) throws PackException {
        parseFixHeader(bArr[i]);
        int i3 = i + 1;
        int i4 = i3;
        if (this.hasPayLoads) {
            i4 = i3 + parsePayLoadsHeader(bArr, i3);
        }
        return i4 - i;
    }

    protected void parseMsgData(byte[] bArr, int i, int i2) throws PackException {
    }

    public int parsePayLoadsHeader(byte[] bArr, int i) throws UnsupportedVersionException {
        this.version = BytesUtils.byteTo1Number(bArr, i);
        int i2 = i + 1;
        this.msgBodyLength = (int) BytesUtils.bytesTo4Number(bArr, i2);
        if (this.version == 3) {
            return (i2 + 4) - i;
        }
        throw new UnsupportedVersionException(this.version);
    }

    public BytesData toBype() {
        BytesData msgDataToByte = msgDataToByte();
        int i = msgDataToByte == null ? 0 : msgDataToByte.length;
        BytesData bytesData = new BytesData((short) (i > 0 ? i + 6 : 1));
        bytesData.data[0] = (byte) (this.type << 4);
        if (this.sync) {
            bytesData.data[0] = (byte) (bytesData.data[0] | 4);
        }
        if (this.ack) {
            bytesData.data[0] = (byte) (bytesData.data[0] | 2);
        }
        if (this.needAck) {
            bytesData.data[0] = (byte) (bytesData.data[0] | 1);
        }
        if (i > 0) {
            bytesData.data[0] = (byte) (bytesData.data[0] | 8);
            BytesUtils.numberTo1Byte(bytesData.data, 1, this.version);
            BytesUtils.numberTo4Bytes(bytesData.data, 2, i);
            BytesUtils.copy(msgDataToByte.data, 0, bytesData.data, 6, msgDataToByte.length);
            int i2 = msgDataToByte.length;
        }
        return bytesData;
    }

    public String toString() {
        return "[type:" + typeToString(this) + ", ack:" + this.ack + ", needAck:" + this.needAck + "]";
    }
}
