package com.blued.android.chat.grpc.utils;

import android.text.TextUtils;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.data.MsgType;
import com.blued.android.chat.model.ChattingModel;
import com.blued.im.private_chat.MsgBodyExtraOuterClass;
import com.blued.im.private_chat.MsgBodyOuterClass;
import com.blued.im.private_chat.PrivateChatOuterClass;
import com.blued.im.private_chat.PushBodyOuterClass;
import com.blued.im.private_chat.PushProfileOuterClass;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import java.nio.charset.StandardCharsets;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/grpc/utils/MsgConverter.class */
public class MsgConverter {
    private static final String TAG = MsgConverter.class.getSimpleName();

    public static int convertErrorCode(int i) {
        switch (i) {
            case -2:
                return -2;
            case -1:
            case 13:
            default:
                return i;
            case 0:
                return 0;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 7;
            case 7:
                return 9;
            case 8:
                return 10;
            case 9:
                return 11;
            case 10:
                return 13;
            case 11:
                return 16;
            case 12:
                return 18;
            case 14:
                return 19;
        }
    }

    public static Any convertGRPCMsgBody(ChattingModel chattingModel) {
        try {
            MsgBodyOuterClass.MsgBody.Builder newBuilder = MsgBodyOuterClass.MsgBody.newBuilder();
            if (TextUtils.isEmpty(chattingModel.msgContent)) {
                throw new RuntimeException("content is null");
            }
            newBuilder.setContents(chattingModel.msgContent);
            setMsgSource(chattingModel, newBuilder);
            setMsgExtraJson(chattingModel, newBuilder);
            return Any.pack(newBuilder.build());
        } catch (Throwable th) {
            String str = TAG;
            ChatLog.d(str, "convertGRPCMsgBody===" + th);
            return Any.newBuilder().build();
        }
    }

    public static ChattingModel convertReceiveMsg(PrivateChatOuterClass.Receive receive) {
        String str = TAG;
        ChatLog.d(str, "REC---->[ " + receive.toString() + " ]");
        ChattingModel chattingModel = new ChattingModel();
        if (receive.getSessionType() == 2) {
            chattingModel.loadName = receive.getTo();
        }
        chattingModel.sessionType = (short) receive.getSessionType();
        chattingModel.sessionId = receive.getPhoneSessionId();
        chattingModel.msgType = (short) receive.getMsgType().getNumber();
        chattingModel.msgId = receive.getMsgId();
        if (chattingModel.msgId > 0) {
            chattingModel.msgPreviousId = chattingModel.msgId - 1;
        }
        chattingModel.fromId = receive.getFrom();
        chattingModel.toId = receive.getTo();
        chattingModel.msgTimestamp = receive.getTimestamp() * 1000;
        try {
            if (!TextUtils.isEmpty(receive.getDistance())) {
                chattingModel.fromDistance = (Float.parseFloat(receive.getDistance()) / 1000.0f) + "";
            }
        } catch (Throwable th) {
        }
        chattingModel.status = receive.getSessionStatus();
        chattingModel.session_common_status = receive.getSessionCommonStatus();
        if (MsgType.getClassify(chattingModel.msgType) == 1) {
            chattingModel.msgStateCode = (short) 3;
        } else if (chattingModel.msgType == 216) {
            chattingModel.msgStateCode = (short) 4;
        } else if (chattingModel.fromId != ChatManager.userInfo.uid) {
            chattingModel.msgStateCode = (short) 4;
        } else if (receive.getIsRead()) {
            chattingModel.msgStateCode = (short) 3;
        } else {
            chattingModel.msgStateCode = (short) 2;
        }
        if (receive.hasBody()) {
            PushBodyOuterClass.PushBody body = receive.getBody();
            chattingModel.msgContent = body.getContents();
            convertToLocalExtraJson(body, chattingModel);
            if (body.hasProfile()) {
                fillProfile(body, chattingModel);
            }
        }
        return chattingModel;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:82:0x03c4 A[Catch: InvalidProtocolBufferException -> 0x0489, TRY_LEAVE, TryCatch #0 {InvalidProtocolBufferException -> 0x0489, blocks: (B:3:0x0003, B:4:0x0007, B:7:0x0188, B:9:0x0192, B:85:0x03d8, B:87:0x03ee, B:89:0x03f8, B:94:0x042d, B:96:0x0436, B:98:0x044b, B:90:0x040f, B:92:0x041b, B:10:0x01a0, B:12:0x01aa, B:13:0x01b8, B:15:0x01c2, B:16:0x01d0, B:18:0x01da, B:19:0x01e8, B:21:0x01f2, B:22:0x0200, B:24:0x020a, B:25:0x0218, B:27:0x0222, B:28:0x0230, B:30:0x023a, B:31:0x0248, B:33:0x0252, B:34:0x0260, B:36:0x026a, B:37:0x0278, B:39:0x0282, B:40:0x0290, B:42:0x029a, B:43:0x02a8, B:45:0x02b2, B:46:0x02c0, B:48:0x02ca, B:49:0x02d8, B:51:0x02e2, B:52:0x02f0, B:54:0x02fa, B:55:0x0308, B:57:0x0312, B:58:0x0320, B:60:0x032a, B:61:0x0338, B:63:0x0342, B:64:0x0350, B:66:0x035a, B:67:0x0368, B:69:0x0372, B:70:0x0380, B:72:0x0388, B:74:0x0392, B:76:0x039c, B:78:0x03ac, B:80:0x03bb, B:82:0x03c4, B:6:0x0181, B:83:0x03d2), top: B:104:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void convertToLocalExtra(com.blued.im.private_chat.PushBodyOuterClass.PushBody r5, com.blued.android.chat.model.ChattingModel r6) {
        /*
            Method dump skipped, instructions count: 1170
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.chat.grpc.utils.MsgConverter.convertToLocalExtra(com.blued.im.private_chat.PushBodyOuterClass$PushBody, com.blued.android.chat.model.ChattingModel):void");
    }

    private static void convertToLocalExtraJson(PushBodyOuterClass.PushBody pushBody, ChattingModel chattingModel) {
        String str;
        try {
            str = pushBody.getExtraJson().toString(StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
        }
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            if (pushBody.hasExtra()) {
                convertToLocalExtra(pushBody, chattingModel);
                return;
            }
            str2 = "{}";
        }
        setExtraJsonToCommonField(chattingModel, str2);
        ChatLog.d(TAG, "转换接收消息：type=" + ((int) chattingModel.msgType) + " extraJson: " + str2);
        chattingModel.setMsgExtra(str2);
    }

    private static void fillProfile(PushBodyOuterClass.PushBody pushBody, ChattingModel chattingModel) {
        PushProfileOuterClass.PushProfile profile = pushBody.getProfile();
        chattingModel.fromNickName = profile.getName();
        chattingModel.fromAvatar = profile.getAvatar();
        chattingModel.fromVBadge = profile.getVbadge();
        chattingModel.fromOnline = profile.getOnline();
        chattingModel.fromFriend = profile.getFriend();
        chattingModel.fromRichLevel = profile.getRichLevel();
        chattingModel.fromVipGrade = profile.getVipGrade();
        chattingModel.ofromVipGrade = profile.getOVipGrade();
        chattingModel.fromVipAnnual = profile.getVipAnnual();
        chattingModel.fromVipExpLvl = profile.getVipExpLvl();
        chattingModel.fromLiveManager = profile.getIsManager();
        chattingModel.fromHideVipLook = profile.getIsHideVipLook();
        chattingModel.ofromHideVipLook = profile.getOIsHideVipLook();
        chattingModel.oFromFaceStatus = profile.getOFaceStatus();
        chattingModel.avatarPendant = profile.getAvatarPendant();
        chattingModel.promptType = profile.getPromptType();
    }

    private static String setCommonFieldToExtraJson(ChattingModel chattingModel, String str) {
        try {
            JsonObject asJsonObject = JsonParser.parseString(str).getAsJsonObject();
            if (!asJsonObject.has("is_match_msg")) {
                asJsonObject.addProperty("is_match_msg", Integer.valueOf(chattingModel.isMatchMsg));
            }
            short s = chattingModel.msgType;
            if ((s == 1 || s == 3 || s == 105 || s == 168) && !TextUtils.isEmpty(chattingModel.msgAt)) {
                asJsonObject.add("at_uids", JsonParser.parseString(chattingModel.msgAt));
            }
            return asJsonObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    private static void setExtraJsonToCommonField(ChattingModel chattingModel, String str) {
        JsonElement jsonElement;
        try {
            JsonObject asJsonObject = JsonParser.parseString(str).getAsJsonObject();
            JsonElement jsonElement2 = asJsonObject.get("is_match_msg");
            if (jsonElement2 != null) {
                chattingModel.isMatchMsg = jsonElement2.getAsInt();
            }
            JsonElement jsonElement3 = asJsonObject.get("identify_yellow");
            if (jsonElement3 != null) {
                chattingModel.identifyYellow = jsonElement3.getAsBoolean() ? 1 : 0;
            }
            if (chattingModel.msgType == 1 && chattingModel.sessionType == 3 && (jsonElement = asJsonObject.get("at_uids")) != null) {
                chattingModel.msgAt = jsonElement.getAsString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x017a A[Catch: InvalidProtocolBufferException -> 0x02bd, TRY_ENTER, TRY_LEAVE, TryCatch #1 {InvalidProtocolBufferException -> 0x02bd, blocks: (B:8:0x0020, B:47:0x0107, B:49:0x011e, B:51:0x0135, B:53:0x014c, B:55:0x0163, B:57:0x017a, B:59:0x0191, B:45:0x00f0, B:61:0x01a8, B:63:0x01bf, B:65:0x01d6, B:67:0x01ed, B:69:0x0204, B:71:0x021b, B:73:0x0232, B:75:0x0249, B:77:0x0260, B:79:0x0277, B:81:0x028e, B:83:0x029d, B:85:0x02a9), top: B:107:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void setMsgExtra(com.blued.android.chat.model.ChattingModel r4, com.blued.im.private_chat.MsgBodyOuterClass.MsgBody.Builder r5) {
        /*
            Method dump skipped, instructions count: 841
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.chat.grpc.utils.MsgConverter.setMsgExtra(com.blued.android.chat.model.ChattingModel, com.blued.im.private_chat.MsgBodyOuterClass$MsgBody$Builder):void");
    }

    private static void setMsgExtraJson(ChattingModel chattingModel, MsgBodyOuterClass.MsgBody.Builder builder) {
        String msgExtra = chattingModel.getMsgExtra();
        String str = msgExtra;
        if (TextUtils.isEmpty(msgExtra)) {
            str = "{}";
        }
        builder.setExtraJson(ByteString.copyFrom(setCommonFieldToExtraJson(chattingModel, str), StandardCharsets.UTF_8));
    }

    public static void setMsgSource(ChattingModel chattingModel, MsgBodyOuterClass.MsgBody.Builder builder) {
        String msgExtra = chattingModel.getMsgExtra();
        if (TextUtils.isEmpty(msgExtra)) {
            return;
        }
        JsonObject asJsonObject = JsonParser.parseString(msgExtra).getAsJsonObject();
        if (asJsonObject.has("msgSource")) {
            JsonElement jsonElement = asJsonObject.get("msgSource");
            if (jsonElement.isJsonNull()) {
                return;
            }
            JsonObject asJsonObject2 = jsonElement.getAsJsonObject();
            int i = 0;
            JsonElement jsonElement2 = asJsonObject2.get("type");
            String str = "";
            if (!jsonElement2.isJsonNull()) {
                int asInt = jsonElement2.getAsInt();
                JsonElement jsonElement3 = asJsonObject2.get("content");
                i = asInt;
                str = "";
                if (!jsonElement3.isJsonNull()) {
                    str = jsonElement3.getAsString();
                    i = asInt;
                }
            }
            builder.setMsgSource(MsgBodyExtraOuterClass.MsgSource.newBuilder().setType(i).setContent(str).build());
        }
    }
}
