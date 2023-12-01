package com.blued.android.chat.core.pack;

import com.blued.android.chat.data.PackageAckResult;
import com.blued.android.chat.utils.BytesUtils;
import com.blued.android.chat.utils.MsgPackHelper;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/DisconnectPackage.class */
public class DisconnectPackage extends BasePackage {
    public short code;
    public String reason;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/DisconnectPackage$DISCONNECT_RESULT.class */
    public interface DISCONNECT_RESULT extends PackageAckResult {
        public static final int DUPLICATE_LOGIN = 4;
        public static final int FORBIDDEN = 3;
    }

    public DisconnectPackage() {
        this.type = (short) 14;
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    protected BytesData msgDataToByte() {
        return null;
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
        return super.toString() + "[code:" + ((int) this.code) + ", reason:" + this.reason + "]";
    }
}
