package com.blued.android.chat.core.pack;

import android.media.MediaFormat;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.utils.BytesUtils;
import com.blued.android.chat.utils.MsgPackHelper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/SendMsgPackage.class */
public class SendMsgPackage extends BasePackage {
    public final long fromId;
    public final String fromName;
    public final String msgAt;
    public final String msgContent;
    public final String msgExtra;
    public MsgHeader msgHeader;
    public final long msgLocalTime;
    public final short msgType;
    public final long sessionId;
    public final short sessionType;

    public SendMsgPackage(short s, long j, long j2, long j3, short s2, String str, String str2, String str3, long j4, String str4) {
        this.type = (short) 3;
        this.needAck = true;
        MsgHeader msgHeader = new MsgHeader();
        this.msgHeader = msgHeader;
        msgHeader.isSendByUser = true;
        this.sessionType = s;
        this.sessionId = j;
        this.localId = j2;
        this.msgLocalTime = j3;
        this.msgType = s2;
        this.msgContent = str;
        this.msgAt = str2;
        this.msgExtra = str3;
        this.fromId = j4;
        this.fromName = str4;
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    protected BytesData msgDataToByte() {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("type", Short.valueOf(this.msgType));
        arrayMap.put("from", Long.valueOf(this.fromId));
        if (!TextUtils.isEmpty(this.fromName)) {
            ArrayMap arrayMap2 = new ArrayMap();
            arrayMap2.put("name", this.fromName);
            arrayMap.put(MediaFormat.KEY_PROFILE, arrayMap2);
        }
        arrayMap.put("contents", this.msgContent);
        if (!TextUtils.isEmpty(this.msgAt)) {
            arrayMap.put("at", this.msgAt);
        }
        if (!TextUtils.isEmpty(this.msgExtra)) {
            arrayMap.put("extra", (Map) new Gson().fromJson(this.msgExtra, new TypeToken<Map<String, Object>>() { // from class: com.blued.android.chat.core.pack.SendMsgPackage.1
            }.getType()));
            if (ChatManager.debug) {
                for (Object obj : arrayMap.keySet()) {
                    Log.d("extra", "key: " + obj + " value: " + arrayMap.get(obj) + " type: " + arrayMap.get(obj).getClass().getSimpleName());
                }
            }
        }
        byte[] packMap = MsgPackHelper.packMap(arrayMap);
        BytesData bytesData = new BytesData((short) (packMap.length + 10));
        bytesData.data[0] = this.msgHeader.toByte();
        BytesUtils.numberTo1Byte(bytesData.data, 1, this.sessionType);
        BytesUtils.numberTo4Bytes(bytesData.data, 2, this.sessionId);
        BytesUtils.numberTo4Bytes(bytesData.data, 6, this.localId);
        BytesUtils.copy(packMap, 0, bytesData.data, 10, packMap.length);
        int length = packMap.length;
        return bytesData;
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[msgHeader:" + ((int) this.msgHeader.toByte()) + ", sessionType:" + ((int) this.sessionType) + ", sessionId:" + this.sessionId + ", localId:" + this.localId + ", msgType:" + ((int) this.msgType) + ", fromId:" + this.fromId + ", fromName:" + this.fromName + ", msgContent:" + this.msgContent + ", msgAt:" + this.msgAt + "]";
    }
}
