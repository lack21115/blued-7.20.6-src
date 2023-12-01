package com.blued.android.chat.core.pack;

import android.text.TextUtils;
import com.blued.android.chat.data.PackageAckResult;
import com.blued.android.chat.utils.BytesUtils;
import com.blued.android.chat.utils.MsgPackHelper;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqAckPackage.class */
public class ReqAckPackage extends BaseAckPackage {
    public Map<String, Object> reqResponse;
    public int reqType = -1;
    public int error = 0;
    public String errorContent = null;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqAckPackage$REQ_ERROR.class */
    public interface REQ_ERROR {
        public static final int ERROR_BLOCKED_BY_PEER = 3;
        public static final int ERROR_BLOCK_PEER = 4;
        public static final int ERROR_DESCRIPTION_INVALID = 7;
        public static final int ERROR_FLASHVIDEO_FUNCTION_LOCK = 13;
        public static final int ERROR_FLASHVIDEO_USER_BLOCK = 14;
        public static final int ERROR_FORBIDDEN_LIVE = 2;
        public static final int ERROR_JOINLIVE_CLOSE = 8;
        public static final int ERROR_JOINLIVE_FAILED = 11;
        public static final int ERROR_JOINLIVE_FULL = 9;
        public static final int ERROR_JOINLIVE_INVITE_OVERDUE = 10;
        public static final int ERROR_LIVEROOM_CLOSE = 6;
        public static final int ERROR_LIVEROOM_FULL = 5;
        public static final int ERROR_LIVEROOM_KICKED_OUT = 18;
        public static final int ERROR_NO_AUTHORITY_LIVE = 1;
        public static final int ERROR_REQ_SESSIONINFO_INVALID_USER = 12;
        public static final int ERROR_VIDEOCHAT_APP_NOT_SUPPORT = 15;
        public static final int ERROR_VIDEOCHAT_NOT_ONLINE = 16;
        public static final int ERROR_VIDEOCHAT_NOT_RECEIVE_MSG = 17;
        public static final int NO_ERROR = 0;
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqAckPackage$REQ_RESPONSE_KEY.class */
    public interface REQ_RESPONSE_KEY {
        public static final String ANIMATION = "animation";
        public static final String AVATAR = "avatar";
        public static final String AVATAR_BADGE = "avatar_badge";
        public static final String AVATAR_PENDANT = "avatar_pendant";
        public static final String BADGES = "badges";
        public static final String BEANS = "beans";
        public static final String BEANS_COUNT = "beans_count";
        public static final String BEANS_CURRENT_COUNT = "beans_current_count";
        public static final String BEANS_MERCHANT_IDENTITY = "beans_merchant_identity";
        public static final String BG_COLOR = "bg_color";
        public static final String BLUED_BADGE_PIC = "blued_badge_pic";
        public static final String EFFECT_MP4 = "full_effects";
        public static final String EFFECT_MP4_TIME = "full_effects_time";
        public static final String ENTRANCE_EFFECTS = "effects";
        public static final String FLASH_REMAIN_NUM = "remain_num";
        public static final String ICON = "icon";
        public static final String IS_HIDE_VIP_LOOK = "is_hide_vip_look";
        public static final String IS_LOCK_MIC = "isLockMic";
        public static final String LIVE_INFO = "live_info";
        public static final String MEMBER_ROLE = "member_role";
        public static final String NAME = "name";
        public static final String NOTE = "note";
        public static final String O_FACE_STATUS = "o_face_status";
        public static final String O_IS_HIDE_VIP_LOOK = "o_is_hide_vip_look";
        public static final String O_VIP_EXP_LVL = "o_vip_exp_lvl";
        public static final String O_VIP_GRADE = "o_vip_grade";
        public static final String O_VIP_GROUP_TYPE = "vip_group_type";
        public static final String PUBLISH_URL = "publish_url";
        public static final String RANK = "rank";
        public static final String REQ_ERROR = "error";
        public static final String REQ_ERROR_CONTENTS = "error_contents";
        public static final String REQ_EXTRA = "extra";
        public static final String REQ_TYPE = "req_type";
        public static final String SEAT_NUM = "seat_num";
        public static final String SESSION_ID = "session_id";
        public static final String SESSION_TYPE = "session_type";
        public static final String TOP_CARD_COUNT = "top_card_count";
        public static final String TOP_CARD_URL = "top_card_url";
        public static final String VBADGE = "vbadge";
        public static final String VIP_ANNUAL = "vip_annual";
        public static final String VIP_EXP_LVL = "vip_exp_lvl";
        public static final String VIP_GRADE = "vip_grade";
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqAckPackage$REQ_RESULT.class */
    public interface REQ_RESULT extends PackageAckResult {
        public static final int FAILED_UNKNOWN_REQ = 3;
    }

    protected ReqAckPackage() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.chat.core.pack.BaseAckPackage
    public String _resultToString() {
        String str;
        String str2 = ReqBasePackage.reqTypeToString(this.reqType) + ", ";
        switch (this.error) {
            case 0:
                str = str2 + "success";
                break;
            case 1:
                str = str2 + "没有权限直播";
                break;
            case 2:
                str = str2 + "被禁止直播";
                break;
            case 3:
                str = str2 + "已被对方拉黑";
                break;
            case 4:
                str = str2 + "已把对方拉黑";
                break;
            case 5:
                str = str2 + "聊天室已满";
                break;
            case 6:
                str = str2 + "聊天室已关闭";
                break;
            case 7:
                str = str2 + "聊天室描述违规";
                break;
            case 8:
                str = str2 + "连麦失败, 连麦还未开启";
                break;
            case 9:
                str = str2 + "连麦失败, 连麦房间已满";
                break;
            case 10:
                str = str2 + "连麦失败, 连麦邀请已过期";
                break;
            case 11:
                str = str2 + "连麦失败(例如对方版本不支持连买等)";
                break;
            case 12:
                str = str2 + "获取个人信息失败, 用户被锁定或注销等";
                break;
            case 13:
                str = str2 + "未在活动时间";
                break;
            case 14:
                str = str2 + "用户禁止进行闪聊";
                break;
            case 15:
                str = str2 + "1v1视频对方app不支持(国际往国内视频不通)";
                break;
            case 16:
                str = str2 + "1v1视频对方不在线";
                break;
            case 17:
                str = str2 + "1v1视频对方没有回复消息";
                break;
            case 18:
                str = str2 + "观众自己被踢出直播间";
                break;
            default:
                str = str2 + "未知错误, " + this.error;
                break;
        }
        String str3 = str;
        if (!TextUtils.isEmpty(this.errorContent)) {
            str3 = str + ", errorContent:" + this.errorContent;
        }
        return str3;
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    protected void parseMsgData(byte[] bArr, int i, int i2) {
        this.result = BytesUtils.byteTo1Number(bArr, i);
        int i3 = i + 1;
        this.localId = BytesUtils.bytesTo4Number(bArr, i3);
        int i4 = i3 + 4;
        if (i2 > i4) {
            this.reqResponse = MsgPackHelper.unpackMap(bArr, i4, i2);
        }
        Map<String, Object> map = this.reqResponse;
        if (map != null) {
            this.reqType = MsgPackHelper.getIntValue(map, "req_type", -1);
            this.error = MsgPackHelper.getIntValue(this.reqResponse, "error");
            this.errorContent = MsgPackHelper.getStringValue(this.reqResponse, REQ_RESPONSE_KEY.REQ_ERROR_CONTENTS);
        }
    }

    @Override // com.blued.android.chat.core.pack.BaseAckPackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[result:" + ((int) this.result) + ", localId:" + this.localId + ", reqType:" + this.reqType + ", error:" + this.error + ", reqResponse:" + this.reqResponse + "]";
    }
}
