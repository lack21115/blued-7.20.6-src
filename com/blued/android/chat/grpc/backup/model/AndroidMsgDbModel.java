package com.blued.android.chat.grpc.backup.model;

import com.blued.android.chat.grpc.backup.annotation.DbTableName;
import com.blued.android.chat.model.ChattingModel;

@DbTableName(name = "ChattingModel")
/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/grpc/backup/model/AndroidMsgDbModel.class */
public class AndroidMsgDbModel {
    public int app;
    public String avatar;
    public String distance;
    public int fromHideVipLook;
    public long fromId;
    public int fromVipAnnual;
    public int fromVipExpLvl;
    public int fromVipGrade;
    public long loadName;
    public String msgContent;
    private String msgExtra;
    public long msgId;
    public boolean msgIsDelete;
    public long msgLocalId;
    public short msgStateCode;
    public String msgTextTranslateContent;
    public int msgTextTranslateIsShow;
    public int msgTextTranslateStatus;
    public long msgTimestamp;
    public short msgType;
    public String msgVideoCoverUrlLocal;
    public String nickName;
    public int online;
    public long previousMsgId;
    public long sessionId;
    public short sessionType;
    public long toId;
    public int vBadge;

    public ChattingModel convertChattingModel() {
        ChattingModel chattingModel = new ChattingModel();
        chattingModel.loadName = this.loadName;
        chattingModel.fromId = this.fromId;
        chattingModel.toId = this.toId;
        chattingModel.fromNickName = this.nickName;
        chattingModel.fromAvatar = this.avatar;
        chattingModel.fromDistance = this.distance;
        chattingModel.fromVBadge = this.vBadge;
        chattingModel.fromOnline = this.online;
        chattingModel.fromVipGrade = this.fromVipGrade;
        chattingModel.fromVipAnnual = this.fromVipAnnual;
        chattingModel.fromVipExpLvl = this.fromVipExpLvl;
        chattingModel.fromHideVipLook = this.fromHideVipLook;
        chattingModel.app = this.app;
        chattingModel.setMsgExtra(this.msgExtra);
        chattingModel.sessionId = this.sessionId;
        chattingModel.sessionType = this.sessionType;
        chattingModel.msgPreviousId = this.previousMsgId;
        chattingModel.msgIsDelete = this.msgIsDelete;
        chattingModel.msgContent = this.msgContent;
        chattingModel.msgTimestamp = this.msgTimestamp;
        chattingModel.msgLocalId = this.msgLocalId;
        chattingModel.msgId = this.msgId;
        chattingModel.msgType = this.msgType;
        chattingModel.msgStateCode = this.msgStateCode;
        chattingModel.msgVideoCoverUrlLocal = this.msgVideoCoverUrlLocal;
        chattingModel.msgTextTranslateIsShow = this.msgTextTranslateIsShow;
        chattingModel.msgTextTranslateContent = this.msgTextTranslateContent;
        chattingModel.msgTextTranslateStatus = this.msgTextTranslateStatus;
        return chattingModel;
    }
}
