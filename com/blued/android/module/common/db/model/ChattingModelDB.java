package com.blued.android.module.common.db.model;

import android.text.TextUtils;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.core.AppInfo;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Map;

@DatabaseTable(tableName = "ChattingModel")
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/db/model/ChattingModelDB.class */
public class ChattingModelDB {
    @DatabaseField
    public int app;
    @DatabaseField(columnName = "id", generatedId = true)
    public int dbId;
    @DatabaseField(columnName = ReqAckPackage.REQ_RESPONSE_KEY.AVATAR)
    public String fromAvatar;
    @DatabaseField(columnName = "distance")
    public String fromDistance;
    @DatabaseField
    public int fromHideVipLook;
    @DatabaseField
    public long fromId;
    @DatabaseField(columnName = "nickName")
    public String fromNickName;
    @DatabaseField(columnName = "online", defaultValue = "1")
    public int fromOnline;
    @DatabaseField(columnName = "vBadge")
    public int fromVBadge;
    @DatabaseField
    public int fromVipAnnual;
    @DatabaseField
    public int fromVipExpLvl;
    @DatabaseField
    public int fromVipGrade;
    @DatabaseField
    public int identifyYellow;
    @DatabaseField
    public int isMatchMsg;
    @DatabaseField(index = true)
    public long loadName;
    @DatabaseField
    public String msgContent;
    @DatabaseField
    private String msgExtra;
    @DatabaseField(index = true)
    public long msgId;
    @DatabaseField
    public boolean msgIsDelete;
    @DatabaseField(index = true)
    public long msgLocalId;
    public Map<String, Object> msgMapExtra;
    @DatabaseField(columnName = "previousMsgId")
    public long msgPreviousId;
    @DatabaseField(index = true)
    public short msgStateCode;
    @DatabaseField
    public String msgTextTranslateContent;
    @DatabaseField
    public int msgTextTranslateIsShow;
    @DatabaseField
    public int msgTextTranslateStatus;
    @DatabaseField
    public long msgTimestamp;
    @DatabaseField
    public short msgType;
    @DatabaseField
    public String msgVideoCoverUrlLocal;
    @DatabaseField
    public String promptType;
    @DatabaseField(index = true)
    public long sessionId;
    @DatabaseField
    public short sessionType;
    @DatabaseField
    public long toId;

    public String getMsgExtra() {
        if (TextUtils.isEmpty(this.msgExtra) && this.msgMapExtra != null) {
            this.msgExtra = AppInfo.f().toJson(this.msgMapExtra);
        }
        return this.msgExtra;
    }

    public boolean isFromSelf() {
        return ChatManager.userInfo.uid == this.fromId;
    }

    public void setMsgExtra(String str) {
        this.msgExtra = str;
    }

    public String toString() {
        return "[sessionId=" + this.sessionId + ", toId=" + this.toId + ", fromId=" + this.fromId + ", isMatchMsg=" + this.isMatchMsg + ", msgExtra=" + this.msgExtra + "]";
    }
}
