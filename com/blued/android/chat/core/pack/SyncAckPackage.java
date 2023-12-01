package com.blued.android.chat.core.pack;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.pack.BasePackage;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.data.PackageAckResult;
import com.blued.android.chat.utils.BytesUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/SyncAckPackage.class */
public class SyncAckPackage extends BaseAckPackage {
    private static final String TAG = "Chat_SyncAckPackage";
    public boolean hasMore = false;
    public long syncLocalId = 0;
    public List<PushMsgPackage> syncMsgList;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/SyncAckPackage$SYNC_RESULT.class */
    public interface SYNC_RESULT extends PackageAckResult {
        public static final int SYNC_FORBIDDEN = 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.chat.core.pack.BaseAckPackage
    public String _resultToString() {
        return this.result != 3 ? "" : " 不允许同步该会话（比如已不在群里）";
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    protected void parseMsgData(byte[] bArr, int i, int i2) throws BasePackage.PackException {
        this.result = BytesUtils.byteTo1Number(bArr, i);
        int i3 = i + 1;
        this.localId = BytesUtils.bytesTo4Number(bArr, i3);
        int i4 = i3 + 4;
        this.hasMore = (bArr[i4] & 1) > 0;
        int i5 = i4 + 1;
        this.syncLocalId = BytesUtils.bytesTo4Number(bArr, i5);
        int i6 = i5 + 4;
        if (this.result == 0) {
            this.syncMsgList = new ArrayList();
            while (i6 - i < this.msgBodyLength) {
                BasePackage parseToPack = BasePackage.parseToPack(bArr, i6, i2);
                if (parseToPack == null) {
                    if (ChatManager.debug) {
                        Log.e(TAG, "消息列表中出现了未知包无法解析");
                        return;
                    }
                    return;
                }
                int packLength = i6 + parseToPack.getPackLength();
                if (parseToPack instanceof PushBasePackage) {
                    PushBasePackage pushBasePackage = (PushBasePackage) parseToPack;
                    if (pushBasePackage.pushMsgPackage != null) {
                        this.syncMsgList.add(pushBasePackage.pushMsgPackage);
                        i6 = packLength;
                    }
                }
                i6 = packLength;
                if (ChatManager.debug) {
                    Log.e(TAG, "why this pack in the msg list, pack:" + parseToPack);
                    i6 = packLength;
                }
            }
        }
    }

    @Override // com.blued.android.chat.core.pack.BaseAckPackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[result:");
        sb.append((int) this.result);
        sb.append(", hasMore:");
        sb.append(this.hasMore);
        sb.append(", syncLocalId:");
        sb.append(this.syncLocalId);
        sb.append(", _msgList size:");
        List<PushMsgPackage> list = this.syncMsgList;
        sb.append(list == null ? 0 : list.size());
        sb.append("]");
        String sb2 = sb.toString();
        String str = sb2;
        if (ChatManager.debug) {
            str = sb2;
            if (this.syncMsgList != null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("[");
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.syncMsgList.size()) {
                        break;
                    }
                    stringBuffer.append(i2);
                    stringBuffer.append("-->");
                    stringBuffer.append(this.syncMsgList.get(i2).pushBasePackage);
                    stringBuffer.append(", ");
                    i = i2 + 1;
                }
                stringBuffer.append("]");
                str = sb2 + stringBuffer.toString();
            }
        }
        return str;
    }
}
