package com.blued.android.chat.core.worker.chat;

import com.alipay.sdk.util.l;
import com.android.internal.util.cm.SpamFilter;
import com.blued.android.chat.core.pack.BasePackage;
import com.blued.android.chat.core.pack.PushMsgPackage;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.chat.core.pack.ReqEmptyBodyPackage;
import com.blued.android.chat.core.pack.ReqWawajiCancelQueueUpPackage;
import com.blued.android.chat.core.pack.ReqWawajiEnterPackage;
import com.blued.android.chat.core.pack.ReqWawajiGetInfoPackage;
import com.blued.android.chat.core.pack.ReqWawajiLeavePackage;
import com.blued.android.chat.core.pack.ReqWawajiQueueUpPackage;
import com.blued.android.chat.core.pack.ReqWawajiRecoverPackage;
import com.blued.android.chat.core.worker.Connector;
import com.blued.android.chat.core.worker.PackSendHelper;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.chat.listener.ConnectListener;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.chat.utils.MsgPackHelper;
import java.util.List;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/chat/WawajiChat.class */
public class WawajiChat implements ConnectListener {
    private final Chat chat;
    private final Connector connector;
    private IWawajiChatCallback wawajiChatCallback;
    private IWawajiResultCallback wawajiResultCallback;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/chat/WawajiChat$IWawajiChatCallback.class */
    public interface IWawajiChatCallback {
        void onCancelQueueUpFailed(long j, String str);

        void onCancelQueueUpSuccess(long j);

        void onEnterRoomFailed(long j, String str);

        void onEnterRoomSuccess(long j, int i, int i2, int i3, int i4, int i5, int i6, String str, String str2, String str3, Map<String, Object> map);

        void onGameResultUpdate(long j, int i, ProfileData profileData, String str, String str2, String str3, String str4, int i2, Map<String, Object> map);

        void onGetInfoFailed(long j, String str);

        void onGetInfoSuccess(long j);

        void onIMConnected();

        void onLeaveRoomFailed(long j, String str);

        void onLeaveRoomSuccess(long j);

        void onPlayerUpdate(long j, ProfileData profileData);

        void onQueueCountUpdate(long j, int i);

        void onQueueRankUpdate(long j, int i);

        void onQueueUpFailed(long j, String str);

        void onQueueUpSuccess(long j, int i);

        void onViewIn(long j, ProfileData profileData, int i);

        void onViewOut(long j, ProfileData profileData, int i);

        void onViewerUpdate(long j, int i, List<ProfileData> list);
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/chat/WawajiChat$IWawajiResultCallback.class */
    public interface IWawajiResultCallback {
        void onGameResultReceive(long j, int i, ProfileData profileData, String str, String str2, String str3);
    }

    public WawajiChat(Connector connector, Chat chat) {
        this.connector = connector;
        this.chat = chat;
        chat.wawajiChat = this;
        this.connector.registerConnectListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCancelQueueUpFailed(long j, String str) {
        IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
        if (iWawajiChatCallback != null) {
            iWawajiChatCallback.onCancelQueueUpFailed(j, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCancelQueueUpSuccess(long j) {
        IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
        if (iWawajiChatCallback != null) {
            iWawajiChatCallback.onCancelQueueUpSuccess(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyEnterRoomFailed(long j, String str) {
        IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
        if (iWawajiChatCallback != null) {
            iWawajiChatCallback.onEnterRoomFailed(j, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyEnterRoomSuccess(long j, int i, int i2, int i3, int i4, int i5, int i6, String str, String str2, String str3, Map<String, Object> map) {
        IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
        if (iWawajiChatCallback != null) {
            iWawajiChatCallback.onEnterRoomSuccess(j, i, i2, i3, i4, i5, i6, str, str2, str3, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyGetRoomInfoFailed(long j, String str) {
        IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
        if (iWawajiChatCallback != null) {
            iWawajiChatCallback.onGetInfoFailed(j, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyGetRoomInfoSuccess(long j) {
        IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
        if (iWawajiChatCallback != null) {
            iWawajiChatCallback.onGetInfoSuccess(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyLeaveRoomFailed(long j, String str) {
        IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
        if (iWawajiChatCallback != null) {
            iWawajiChatCallback.onLeaveRoomFailed(j, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyLeaveRoomSuccess(long j) {
        IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
        if (iWawajiChatCallback != null) {
            iWawajiChatCallback.onLeaveRoomSuccess(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyQueueUpFailed(long j, String str) {
        IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
        if (iWawajiChatCallback != null) {
            iWawajiChatCallback.onQueueUpFailed(j, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyQueueUpSuccess(long j, int i) {
        IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
        if (iWawajiChatCallback != null) {
            iWawajiChatCallback.onQueueUpSuccess(j, i);
        }
    }

    private void notifyViewerIn(long j, ProfileData profileData, int i) {
        IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
        if (iWawajiChatCallback != null) {
            iWawajiChatCallback.onViewIn(j, profileData, i);
        }
    }

    private void notifyViewerOut(long j, ProfileData profileData, int i) {
        IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
        if (iWawajiChatCallback != null) {
            iWawajiChatCallback.onViewOut(j, profileData, i);
        }
    }

    private void recvGameResultUpdateMessage(PushMsgPackage pushMsgPackage) {
        int intValue = MsgPackHelper.getIntValue(pushMsgPackage.msgMapExtra, l.c);
        ProfileData parseProfile = ProfileData.parseProfile(pushMsgPackage.msgMapExtra, "player");
        String stringValue = MsgPackHelper.getStringValue(pushMsgPackage.msgMapExtra, "tips_player");
        String stringValue2 = MsgPackHelper.getStringValue(pushMsgPackage.msgMapExtra, "tips_viewer");
        String stringValue3 = MsgPackHelper.getStringValue(pushMsgPackage.msgMapExtra, "wawa_image");
        String stringValue4 = MsgPackHelper.getStringValue(pushMsgPackage.msgMapExtra, "wawa_name");
        int intValue2 = MsgPackHelper.getIntValue(pushMsgPackage.msgMapExtra, "gift_bonus");
        IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
        if (iWawajiChatCallback != null) {
            iWawajiChatCallback.onGameResultUpdate(pushMsgPackage.sessionId, intValue, parseProfile, stringValue, stringValue2, stringValue3, stringValue4, intValue2, pushMsgPackage.msgMapExtra);
        }
        IWawajiResultCallback iWawajiResultCallback = this.wawajiResultCallback;
        if (iWawajiResultCallback != null) {
            iWawajiResultCallback.onGameResultReceive(pushMsgPackage.sessionId, intValue, parseProfile, stringValue2, stringValue3, stringValue4);
        }
    }

    private void recvPlayQueueCountUpdateMessage(PushMsgPackage pushMsgPackage) {
        int intValue = MsgPackHelper.getIntValue(pushMsgPackage.msgMapExtra, SpamFilter.SpamContract.NotificationTable.COUNT);
        IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
        if (iWawajiChatCallback != null) {
            iWawajiChatCallback.onQueueCountUpdate(pushMsgPackage.sessionId, intValue);
        }
    }

    private void recvPlayQueueRankUpdateMessage(PushMsgPackage pushMsgPackage) {
        int intValue = MsgPackHelper.getIntValue(pushMsgPackage.msgMapExtra, ReqAckPackage.REQ_RESPONSE_KEY.RANK, -1);
        IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
        if (iWawajiChatCallback != null) {
            iWawajiChatCallback.onQueueRankUpdate(pushMsgPackage.sessionId, intValue);
        }
    }

    private void recvPlayingUpdateMessage(PushMsgPackage pushMsgPackage) {
        ProfileData parseProfile = ProfileData.parseProfile(pushMsgPackage.msgMapExtra, "player");
        IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
        if (iWawajiChatCallback != null) {
            iWawajiChatCallback.onPlayerUpdate(pushMsgPackage.sessionId, parseProfile);
        }
    }

    private void recvViewerUpdateMessage(PushMsgPackage pushMsgPackage) {
        int intValue = MsgPackHelper.getIntValue(pushMsgPackage.msgMapExtra, SpamFilter.SpamContract.NotificationTable.COUNT);
        List<ProfileData> parseProfileList = ProfileData.parseProfileList(MsgPackHelper.getListValue(pushMsgPackage.msgMapExtra, "members"));
        IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
        if (iWawajiChatCallback != null) {
            iWawajiChatCallback.onViewerUpdate(pushMsgPackage.sessionId, intValue, parseProfileList);
        }
    }

    public void attach(IWawajiChatCallback iWawajiChatCallback) {
        this.wawajiChatCallback = iWawajiChatCallback;
    }

    public void attachResultCallback(IWawajiResultCallback iWawajiResultCallback) {
        this.wawajiResultCallback = iWawajiResultCallback;
    }

    public void cancelQueueUp(final long j) {
        this.connector.getPackageSendHelper().sendPackage(new ReqWawajiCancelQueueUpPackage(j, ChatHelper.getLocalId()), new PackSendHelper.PackCallback() { // from class: com.blued.android.chat.core.worker.chat.WawajiChat.4
            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onAckTimeout(BasePackage basePackage) {
                WawajiChat.this.notifyCancelQueueUpFailed(j, "请求回应等待超时");
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onReceiveAck(BasePackage basePackage, BasePackage basePackage2) {
                if (basePackage2 instanceof ReqAckPackage) {
                    ReqAckPackage reqAckPackage = (ReqAckPackage) basePackage2;
                    if (reqAckPackage.error == 0) {
                        WawajiChat.this.notifyCancelQueueUpSuccess(j);
                        return;
                    }
                    WawajiChat wawajiChat = WawajiChat.this;
                    long j2 = j;
                    wawajiChat.notifyCancelQueueUpFailed(j2, "请求失败, errorCode:" + reqAckPackage.error);
                }
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFailed(BasePackage basePackage) {
                WawajiChat.this.notifyCancelQueueUpFailed(j, "请求发送失败");
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFinish(BasePackage basePackage) {
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendTimeout(BasePackage basePackage) {
                WawajiChat.this.notifyCancelQueueUpFailed(j, "请求发送超时");
            }
        });
    }

    public void detach(IWawajiChatCallback iWawajiChatCallback) {
        if (this.wawajiChatCallback == iWawajiChatCallback) {
            this.wawajiChatCallback = null;
        }
    }

    public void detachResultCallback(IWawajiResultCallback iWawajiResultCallback) {
        if (this.wawajiResultCallback == iWawajiResultCallback) {
            this.wawajiResultCallback = null;
        }
    }

    public void enterRoom(final long j) {
        this.connector.getPackageSendHelper().sendPackage(new ReqWawajiEnterPackage(j, ChatHelper.getLocalId()), new PackSendHelper.PackCallback() { // from class: com.blued.android.chat.core.worker.chat.WawajiChat.1
            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onAckTimeout(BasePackage basePackage) {
                WawajiChat.this.notifyEnterRoomFailed(j, "请求发送回应等待超时");
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onReceiveAck(BasePackage basePackage, BasePackage basePackage2) {
                if (basePackage2 instanceof ReqAckPackage) {
                    ReqAckPackage reqAckPackage = (ReqAckPackage) basePackage2;
                    if (reqAckPackage.error != 0) {
                        WawajiChat wawajiChat = WawajiChat.this;
                        long j2 = j;
                        wawajiChat.notifyEnterRoomFailed(j2, "ack错误, 错误码:" + reqAckPackage.error);
                        return;
                    }
                    WawajiChat.this.notifyEnterRoomSuccess(j, MsgPackHelper.getIntValue(reqAckPackage.reqResponse, "price_android"), MsgPackHelper.getIntValue(reqAckPackage.reqResponse, "goods_id_android"), MsgPackHelper.getIntValue(reqAckPackage.reqResponse, "lifetime"), MsgPackHelper.getIntValue(reqAckPackage.reqResponse, ReqAckPackage.REQ_RESPONSE_KEY.RANK, -1), MsgPackHelper.getIntValue(reqAckPackage.reqResponse, "queue_count"), MsgPackHelper.getIntValue(reqAckPackage.reqResponse, "beans_android"), MsgPackHelper.getStringValue(reqAckPackage.reqResponse, "room_id"), MsgPackHelper.getStringValue(reqAckPackage.reqResponse, "stream_id_1"), MsgPackHelper.getStringValue(reqAckPackage.reqResponse, "stream_id_2"), MsgPackHelper.getMapValue(reqAckPackage.reqResponse, "extra"));
                }
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFailed(BasePackage basePackage) {
                WawajiChat.this.notifyEnterRoomFailed(j, "请求发送失败");
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFinish(BasePackage basePackage) {
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendTimeout(BasePackage basePackage) {
                WawajiChat.this.notifyEnterRoomFailed(j, "请求发送超时");
            }
        });
    }

    public void getRoomInfo(final long j) {
        this.connector.getPackageSendHelper().sendPackage(new ReqWawajiGetInfoPackage(j, ChatHelper.getLocalId()), new PackSendHelper.PackCallback() { // from class: com.blued.android.chat.core.worker.chat.WawajiChat.5
            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onAckTimeout(BasePackage basePackage) {
                WawajiChat.this.notifyGetRoomInfoFailed(j, "请求回应等待超时");
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onReceiveAck(BasePackage basePackage, BasePackage basePackage2) {
                if (basePackage2 instanceof ReqAckPackage) {
                    ReqAckPackage reqAckPackage = (ReqAckPackage) basePackage2;
                    if (reqAckPackage.error == 0) {
                        WawajiChat.this.notifyGetRoomInfoSuccess(j);
                        return;
                    }
                    WawajiChat wawajiChat = WawajiChat.this;
                    long j2 = j;
                    wawajiChat.notifyGetRoomInfoFailed(j2, "请求失败, errorCode:" + reqAckPackage.error);
                }
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFailed(BasePackage basePackage) {
                WawajiChat.this.notifyGetRoomInfoFailed(j, "请求发送失败");
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFinish(BasePackage basePackage) {
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendTimeout(BasePackage basePackage) {
                WawajiChat.this.notifyGetRoomInfoFailed(j, "请求发送超时");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean handlePushMessage(PushMsgPackage pushMsgPackage) {
        if (pushMsgPackage.msgType == 84) {
            recvPlayQueueCountUpdateMessage(pushMsgPackage);
            return true;
        } else if (pushMsgPackage.msgType == 78) {
            recvPlayQueueRankUpdateMessage(pushMsgPackage);
            return true;
        } else if (pushMsgPackage.msgType == 79) {
            recvPlayingUpdateMessage(pushMsgPackage);
            return true;
        } else if (pushMsgPackage.msgType == 80) {
            recvViewerUpdateMessage(pushMsgPackage);
            return true;
        } else if (pushMsgPackage.msgType == 81) {
            recvGameResultUpdateMessage(pushMsgPackage);
            return true;
        } else if (pushMsgPackage.msgType == 82) {
            notifyViewerIn(pushMsgPackage.sessionId, ProfileData.parseProfile(pushMsgPackage.msgMapExtra, "viewer"), MsgPackHelper.getIntValue(pushMsgPackage.msgMapExtra, SpamFilter.SpamContract.NotificationTable.COUNT));
            return true;
        } else if (pushMsgPackage.msgType == 83) {
            notifyViewerOut(pushMsgPackage.sessionId, ProfileData.parseProfile(pushMsgPackage.msgMapExtra, "viewer"), MsgPackHelper.getIntValue(pushMsgPackage.msgMapExtra, SpamFilter.SpamContract.NotificationTable.COUNT));
            return true;
        } else {
            return false;
        }
    }

    public void leaveRoom(final long j) {
        this.connector.getPackageSendHelper().sendPackage(new ReqWawajiLeavePackage(j, ChatHelper.getLocalId()), new PackSendHelper.PackCallback() { // from class: com.blued.android.chat.core.worker.chat.WawajiChat.2
            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onAckTimeout(BasePackage basePackage) {
                WawajiChat.this.notifyLeaveRoomFailed(j, "请求回应等待超时");
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onReceiveAck(BasePackage basePackage, BasePackage basePackage2) {
                if (basePackage2 instanceof ReqAckPackage) {
                    ReqAckPackage reqAckPackage = (ReqAckPackage) basePackage2;
                    if (reqAckPackage.error == 0) {
                        WawajiChat.this.notifyLeaveRoomSuccess(j);
                        return;
                    }
                    WawajiChat wawajiChat = WawajiChat.this;
                    long j2 = j;
                    wawajiChat.notifyLeaveRoomFailed(j2, "请求失败, errorCode:" + reqAckPackage.error);
                }
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFailed(BasePackage basePackage) {
                WawajiChat.this.notifyLeaveRoomFailed(j, "请求发送失败");
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFinish(BasePackage basePackage) {
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendTimeout(BasePackage basePackage) {
                WawajiChat.this.notifyLeaveRoomFailed(j, "请求发送超时");
            }
        });
    }

    @Override // com.blued.android.chat.listener.ConnectListener
    public void onConnected() {
        IWawajiChatCallback iWawajiChatCallback = this.wawajiChatCallback;
        if (iWawajiChatCallback != null) {
            iWawajiChatCallback.onIMConnected();
        }
    }

    @Override // com.blued.android.chat.listener.ConnectListener
    public void onConnecting() {
    }

    @Override // com.blued.android.chat.listener.ConnectListener
    public void onDisconnected() {
    }

    public void queueUp(final long j) {
        this.connector.getPackageSendHelper().sendPackage(new ReqWawajiQueueUpPackage(j, ChatHelper.getLocalId()), new PackSendHelper.PackCallback() { // from class: com.blued.android.chat.core.worker.chat.WawajiChat.3
            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onAckTimeout(BasePackage basePackage) {
                WawajiChat.this.notifyQueueUpFailed(j, "请求回应接收超时");
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onReceiveAck(BasePackage basePackage, BasePackage basePackage2) {
                if (basePackage2 instanceof ReqAckPackage) {
                    ReqAckPackage reqAckPackage = (ReqAckPackage) basePackage2;
                    if (reqAckPackage.error == 0) {
                        WawajiChat.this.notifyQueueUpSuccess(j, MsgPackHelper.getIntValue(reqAckPackage.reqResponse, ReqAckPackage.REQ_RESPONSE_KEY.RANK, -1));
                        return;
                    }
                    WawajiChat wawajiChat = WawajiChat.this;
                    long j2 = j;
                    wawajiChat.notifyQueueUpFailed(j2, "ack错误, 错误码:" + reqAckPackage.error);
                }
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFailed(BasePackage basePackage) {
                WawajiChat.this.notifyQueueUpFailed(j, "请求发送失败");
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFinish(BasePackage basePackage) {
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendTimeout(BasePackage basePackage) {
                WawajiChat.this.notifyQueueUpFailed(j, "请求发送超时");
            }
        });
    }

    public void recover(long j) {
        this.connector.sendPackage(new ReqWawajiRecoverPackage(j, ChatHelper.getLocalId()));
    }

    public void startReceiveAllGameResult() {
        this.connector.sendPackage(new ReqEmptyBodyPackage((short) 33, ChatHelper.getLocalId()));
    }

    public void stopReceiveAllGameResult() {
        this.connector.sendPackage(new ReqEmptyBodyPackage((short) 34, ChatHelper.getLocalId()));
    }
}
