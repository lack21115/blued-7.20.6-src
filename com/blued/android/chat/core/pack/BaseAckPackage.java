package com.blued.android.chat.core.pack;

import android.text.TextUtils;
import com.amap.api.services.core.AMapException;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/BaseAckPackage.class */
public class BaseAckPackage extends BasePackage {
    public short result = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public String _resultToString() {
        short s = this.result;
        return s != -2 ? s != -1 ? s != 0 ? s != 1 ? s != 2 ? s != 255 ? "" : "服务器内部错误" : "协议错误" : "协议版本不支持" : "success" : "本地未知错误" : "本地发送超时";
    }

    public String ackResultToString() {
        String _resultToString = _resultToString();
        String str = _resultToString;
        if (TextUtils.isEmpty(_resultToString)) {
            str = AMapException.AMAP_CLIENT_UNKNOWN_ERROR;
        }
        return "[" + ((int) this.result) + ", " + str + "]";
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + ackResultToString();
    }
}
