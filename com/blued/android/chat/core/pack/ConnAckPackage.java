package com.blued.android.chat.core.pack;

import com.blued.android.chat.utils.BytesUtils;
import com.blued.android.chat.utils.MsgPackHelper;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ConnAckPackage.class */
public class ConnAckPackage extends BasePackage {
    public int code = 0;
    public String reason;

    protected ConnAckPackage() {
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    protected void parseMsgData(byte[] bArr, int i, int i2) {
        this.code = BytesUtils.byteTo1Number(bArr, i);
        int i3 = i + 1;
        if (i2 > i3) {
            Map<String, Object> unpackMap = MsgPackHelper.unpackMap(bArr, i3, i2);
            if (unpackMap != null) {
                this.reason = MsgPackHelper.getStringValue(unpackMap, "error_msg", "");
            } else {
                this.reason = "";
            }
        }
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[code:" + this.code + ", reason:" + this.reason + "]";
    }
}
