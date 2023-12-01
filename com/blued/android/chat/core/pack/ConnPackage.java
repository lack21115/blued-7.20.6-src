package com.blued.android.chat.core.pack;

import android.util.Base64;
import com.blued.android.chat.data.PackageAckResult;
import com.blued.android.chat.utils.BytesUtils;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ConnPackage.class */
public class ConnPackage extends BasePackage {
    private static final String TAG = "Chat_ConnPackage";
    public final String token;
    public final long uid;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ConnPackage$CONN_RESULT.class */
    public interface CONN_RESULT extends PackageAckResult {
        public static final int AUTH_FAILED = 5;
        public static final int CONNECT_DUPLICATE = 6;
        public static final int CONNECT_REJECT = 4;
        public static final int SERVICE_UNAVAIABLE = 3;
    }

    public ConnPackage(long j, String str) {
        this.type = (short) 1;
        this.needAck = true;
        this.uid = j;
        this.token = str;
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    protected BytesData msgDataToByte() {
        byte[] decode = Base64.decode(this.token, 2);
        BytesData bytesData = new BytesData(decode.length + 4);
        BytesUtils.numberTo4Bytes(bytesData.data, 0, this.uid);
        BytesUtils.copy(decode, 0, bytesData.data, 4, decode.length);
        return bytesData;
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[uid:" + this.uid + ", token:" + this.token + "]";
    }
}
