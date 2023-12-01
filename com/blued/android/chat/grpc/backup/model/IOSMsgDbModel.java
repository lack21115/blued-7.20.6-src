package com.blued.android.chat.grpc.backup.model;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.grpc.PrivateChatManager;
import com.blued.android.chat.grpc.backup.annotation.DbTableName;
import com.blued.android.chat.grpc.utils.ChatLog;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.VideoChatMsgContentModel;
import com.blued.android.chat.utils.ChatHelper;

@DbTableName(name = "MessageTable")
/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/grpc/backup/model/IOSMsgDbModel.class */
public class IOSMsgDbModel {
    public int app;
    public String at;
    public short deleteState;
    public String distance;
    public long fromId;
    public String fromUserAvatar;
    public String fromUserName;
    public short is_hide_vip_look;
    public long lastMessageId;
    public String messageContent;
    public long messageId;
    public short messageType;
    public String msgExtra;
    public long msgLocalId;
    public short o_is_hide_vip_look;
    public short o_vip_grade;
    public int online;
    public int reason;
    public int roomType;
    public short sendState;
    public long sendTime;
    public long sessionId;
    public short sessionType;
    public int totalTime;
    public String translateInfo;
    public short vbadge;
    public short vip_annual;
    public short vip_exp_lvl;
    public short vip_grade;

    public ChattingModel covertToAndroidModel() {
        ChattingModel chattingModel = new ChattingModel();
        chattingModel.sessionType = this.sessionType;
        chattingModel.sessionId = this.sessionId;
        chattingModel.msgLocalId = this.msgLocalId;
        chattingModel.msgStateCode = ChatHelper.transformIosSendStateToAndroid(this.sendState);
        chattingModel.msgType = this.messageType;
        chattingModel.fromId = this.fromId;
        chattingModel.toId = chattingModel.loadName != this.fromId ? chattingModel.loadName : this.sessionId;
        chattingModel.msgContent = this.messageContent;
        chattingModel.fromNickName = this.fromUserName;
        chattingModel.fromAvatar = this.fromUserAvatar;
        chattingModel.msgId = this.messageId;
        chattingModel.msgPreviousId = this.lastMessageId;
        chattingModel.msgTimestamp = this.sendTime * 1000;
        chattingModel.msgIsDelete = this.deleteState == 2;
        chattingModel.fromDistance = this.distance;
        chattingModel.fromVipGrade = this.vip_grade;
        chattingModel.fromVipAnnual = this.vip_annual;
        chattingModel.fromVipExpLvl = this.vip_exp_lvl;
        chattingModel.fromHideVipLook = this.is_hide_vip_look;
        chattingModel.ofromHideVipLook = this.o_is_hide_vip_look;
        chattingModel.ofromVipGrade = this.o_vip_grade;
        chattingModel.msgTextTranslateContent = this.translateInfo;
        chattingModel.fromOnline = this.online;
        chattingModel.msgAt = this.at;
        short s = this.messageType;
        if (s == 53 || s == 52) {
            VideoChatMsgContentModel videoChatMsgContentModel = new VideoChatMsgContentModel();
            videoChatMsgContentModel.room_type = this.roomType;
            videoChatMsgContentModel.total_time = this.totalTime;
            chattingModel.setMsgExtra(PrivateChatManager.getInstance().getGson().toJson(videoChatMsgContentModel));
        } else {
            chattingModel.setMsgExtra(this.msgExtra);
        }
        if (this.messageType != 3 || this.fromId == this.sessionId) {
            short s2 = this.messageType;
            if ((s2 == 5 || s2 == 2 || s2 == 24) && this.fromId != this.sessionId) {
                try {
                    chattingModel.msgContent = this.messageContent.split("\\|\\|")[1];
                    return chattingModel;
                } catch (Throwable th) {
                    if (ChatManager.debug) {
                        ChatLog.e("MessageTable", "covert msgType: " + ((int) this.messageType) + " error : " + th.getMessage());
                    }
                }
            }
        } else {
            try {
                String[] split = this.messageContent.split("\\|\\|");
                String str = split[0].split(",,")[1];
                chattingModel.msgContent = split[1] + ",," + str;
                return chattingModel;
            } catch (Throwable th2) {
                if (ChatManager.debug) {
                    ChatLog.e("MessageTable", "covert msgType: " + ((int) this.messageType) + " error : " + th2.getMessage());
                    return chattingModel;
                }
            }
        }
        return chattingModel;
    }
}
