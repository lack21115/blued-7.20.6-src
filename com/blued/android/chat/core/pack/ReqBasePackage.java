package com.blued.android.chat.core.pack;

import com.blued.android.chat.utils.BytesUtils;
import com.blued.android.chat.utils.MsgPackHelper;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqBasePackage.class */
public class ReqBasePackage extends BasePackage {
    public final short reqType;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/ReqBasePackage$REQ_TYPE.class */
    public interface REQ_TYPE {
        public static final short REQ_APPLY_JOINLIVE = 11;
        public static final short REQ_CLOSE_LIVECHAT = 4;
        public static final short REQ_CLOSE_VIDEOCHAT = 14;
        public static final short REQ_CREATE_LIVECHAT = 3;
        public static final short REQ_CREATE_VIDEOCHAT = 13;
        public static final short REQ_DESTROY_MSG = 2;
        public static final short REQ_ENTER_LIVECHAT = 6;
        public static final short REQ_FLASHVIDEO_APPLY_EXTRA_TIME = 37;
        public static final short REQ_FLASHVIDEO_APPLY_FRIEND = 36;
        public static final short REQ_FLASHVIDEO_CANCEL_MATCH = 19;
        public static final short REQ_FLASHVIDEO_CLOSE = 20;
        public static final short REQ_FLASHVIDEO_EMOJI = 40;
        public static final short REQ_FLASHVIDEO_MATCH_AGREE = 38;
        public static final short REQ_FLASHVIDEO_SAY_HI = 39;
        public static final short REQ_FLASHVIDEO_START_MATCH = 18;
        public static final short REQ_GET_LIVECHAT_INFO = 8;
        public static final short REQ_LEAVE_LIVECHAT = 7;
        public static final short REQ_LIVECHAT_STATUS_CHANGE = 35;
        public static final short REQ_LIVEJOIN_END_NOTIFY = 32;
        public static final short REQ_LIVEJOIN_START_NOTIFY = 31;
        public static final short REQ_RECOVER_LIVECHAT = 9;
        public static final short REQ_REPORT_VIDEOCHAT = 50;
        public static final short REQ_SESSION = 1;
        public static final short REQ_START_JOINLIVE = 10;
        public static final short REQ_STOP_TALK = 5;
        public static final short REQ_UNKNOWN = -1;
        public static final short REQ_UPDATE_CALL_TIME = 15;
        public static final short REQ_VIDEOCHAT_GET_LEFT_TIME = 17;
        public static final short REQ_VIDEOCHAT_SWITCH_TO_AUDIO = 16;
        public static final short REQ_WAWAJICONTROLLER_CHECK_PLAY = 29;
        public static final short REQ_WAWAJICONTROLLER_INIT = 21;
        public static final short REQ_WAWAJICONTROLLER_READY = 22;
        public static final short REQ_WAWAJICONTROLLER_UPLOAD_RESULT = 28;
        public static final short REQ_WAWAJI_CANCEL_QUEUEUP = 27;
        public static final short REQ_WAWAJI_ENTER = 23;
        public static final short REQ_WAWAJI_GETINFO = 25;
        public static final short REQ_WAWAJI_LEAVE = 24;
        public static final short REQ_WAWAJI_QUEUEUP = 26;
        public static final short REQ_WAWAJI_RECOVER = 30;
        public static final short REQ_WAWAJI_START_RECEIVE_GAME_RESULT = 33;
        public static final short REQ_WAWAJI_STOP_RECEIVE_GAME_RESULT = 34;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ReqBasePackage(short s, long j) {
        this.type = (short) 7;
        this.needAck = true;
        this.reqType = s;
        this.localId = j;
    }

    public static String reqTypeToString(int i) {
        if (i != -1) {
            if (i != 50) {
                switch (i) {
                    case 1:
                        return "拉取session信息";
                    case 2:
                        return "约后及焚消息请求服务器销毁消息";
                    case 3:
                        return "创建直播间";
                    case 4:
                        return "关闭直播间";
                    case 5:
                        return "把某人禁言";
                    case 6:
                        return "加入直播间";
                    case 7:
                        return "离开直播间";
                    case 8:
                        return "拉取直播间信息";
                    case 9:
                        return "恢复直播间信息(当im断开重连后, 如果直播间还在则需要发送恢复req)";
                    case 10:
                        return "开启连麦";
                    case 11:
                        return "申请加入连麦";
                    default:
                        switch (i) {
                            case 13:
                                return "开启视频对话";
                            case 14:
                                return "结束视频对话";
                            case 15:
                                return "更新通话时间";
                            case 16:
                                return "切换视频聊天到语音通话";
                            case 17:
                                return "获取用户剩余时间";
                            case 18:
                                return "开始闪聊匹配";
                            case 19:
                                return "取消闪聊匹配";
                            case 20:
                                return "结束闪聊";
                            case 21:
                                return "初始化娃娃机";
                            case 22:
                                return "娃娃机准备完成通知";
                            case 23:
                                return "进入娃娃机";
                            case 24:
                                return "离开娃娃机";
                            case 25:
                                return "获取娃娃机信息";
                            case 26:
                                return "娃娃机排队";
                            case 27:
                                return "取消娃娃机排队";
                            case 28:
                                return "上传娃娃机结果";
                            case 29:
                                return "查询娃娃机当前是否处于play状态";
                            case 30:
                                return "恢复娃娃机直播间状态";
                            case 31:
                                return "开始连麦通知";
                            case 32:
                                return "结束连麦通知";
                            case 33:
                                return "开始接收娃娃机游戏结果";
                            case 34:
                                return "停止接收娃娃机游戏结果";
                            case 35:
                                return "直播状态变化（暂停或恢复直播）";
                            case 36:
                                return "国际版闪聊申请加好友";
                            case 37:
                                return "国际版闪聊申请加时";
                            case 38:
                            case 39:
                                return "国际版闪聊，匹配确认";
                            case 40:
                                return "发送表情请求";
                            default:
                                return "未知Req类型:" + i;
                        }
                }
            }
            return "1v1视频通话埋点上报";
        }
        return "未知Req类型";
    }

    protected Map<String, Object> getReqInfo() {
        return null;
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    protected BytesData msgDataToByte() {
        Map<String, Object> reqInfo = getReqInfo();
        byte[] packMap = reqInfo != null ? MsgPackHelper.packMap(reqInfo) : null;
        int length = packMap == null ? 0 : packMap.length;
        BytesData bytesData = new BytesData(length + 5);
        BytesUtils.numberTo1Byte(bytesData.data, 0, this.reqType);
        BytesUtils.numberTo4Bytes(bytesData.data, 1, this.localId);
        if (length > 0) {
            BytesUtils.copy(packMap, 0, bytesData.data, 5, length);
        }
        return bytesData;
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[reqType:" + ((int) this.reqType) + ", localId:" + this.localId + "]";
    }
}
