package com.blued.android.chat.core.worker.chat;

import com.blued.android.chat.WawajiControllerHelper;
import com.blued.android.chat.core.pack.BasePackage;
import com.blued.android.chat.core.pack.PushMsgPackage;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.chat.core.pack.ReqWawajiControllerCheckPlayPackage;
import com.blued.android.chat.core.pack.ReqWawajiControllerInitPackage;
import com.blued.android.chat.core.pack.ReqWawajiControllerReadyPackage;
import com.blued.android.chat.core.pack.ReqWawajiControllerUploadResultPackage;
import com.blued.android.chat.core.worker.Connector;
import com.blued.android.chat.core.worker.PackSendHelper;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.chat.utils.MsgPackHelper;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/chat/WawajiControllerChat.class */
public class WawajiControllerChat {
    private final Chat chat;
    private final Connector connector;
    private IWawajiControllerCallback wawajiControllerCallback;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/chat/WawajiControllerChat$IWawajiControllerCallback.class */
    public interface IWawajiControllerCallback {
        void onControllerUpdate(long j, String str);

        void onInitControllerFailed(String str);

        void onInitControllerSuccess(long j, String str, String str2, String str3);

        void onPlayCheckFailed(String str);

        void onPlayCheckSuccess();

        void onPlayConfig(long j, String str, WawajiControllerHelper.WawajiControllerConfig wawajiControllerConfig);

        void onReadyControllerFailed(String str);

        void onReadyControllerSuccess();

        void onUploadGameResultFailed(WawajiControllerHelper.WawajiGameResult wawajiGameResult, String str);

        void onUploadGameResultSuccess(WawajiControllerHelper.WawajiGameResult wawajiGameResult);
    }

    public WawajiControllerChat(Connector connector, Chat chat) {
        this.connector = connector;
        this.chat = chat;
        chat.wawajiControllerChat = this;
    }

    public static boolean handleMessage(int i) {
        return i == 76 || i == 77;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initControllerFailed(String str) {
        IWawajiControllerCallback iWawajiControllerCallback = this.wawajiControllerCallback;
        if (iWawajiControllerCallback != null) {
            iWawajiControllerCallback.onInitControllerFailed(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initControllerSuccess(long j, String str, String str2, String str3) {
        IWawajiControllerCallback iWawajiControllerCallback = this.wawajiControllerCallback;
        if (iWawajiControllerCallback != null) {
            iWawajiControllerCallback.onInitControllerSuccess(j, str, str2, str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playCheckFailed(String str) {
        IWawajiControllerCallback iWawajiControllerCallback = this.wawajiControllerCallback;
        if (iWawajiControllerCallback != null) {
            iWawajiControllerCallback.onPlayCheckFailed(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playCheckSuccess() {
        IWawajiControllerCallback iWawajiControllerCallback = this.wawajiControllerCallback;
        if (iWawajiControllerCallback != null) {
            iWawajiControllerCallback.onPlayCheckSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readyControllerFailed(String str) {
        IWawajiControllerCallback iWawajiControllerCallback = this.wawajiControllerCallback;
        if (iWawajiControllerCallback != null) {
            iWawajiControllerCallback.onReadyControllerFailed(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readyControllerSuccess() {
        IWawajiControllerCallback iWawajiControllerCallback = this.wawajiControllerCallback;
        if (iWawajiControllerCallback != null) {
            iWawajiControllerCallback.onReadyControllerSuccess();
        }
    }

    private void recvControllerUpdateMsg(PushMsgPackage pushMsgPackage) {
        if (pushMsgPackage.msgMapExtra != null) {
            long longValue = MsgPackHelper.getLongValue(pushMsgPackage.msgMapExtra, "version_code");
            String stringValue = MsgPackHelper.getStringValue(pushMsgPackage.msgMapExtra, "url");
            IWawajiControllerCallback iWawajiControllerCallback = this.wawajiControllerCallback;
            if (iWawajiControllerCallback != null) {
                iWawajiControllerCallback.onControllerUpdate(longValue, stringValue);
            }
        }
    }

    private void recvPlayConfigMsg(PushMsgPackage pushMsgPackage) {
        if (pushMsgPackage.msgMapExtra != null) {
            long longValue = MsgPackHelper.getLongValue(pushMsgPackage.msgMapExtra, "uid");
            String stringValue = MsgPackHelper.getStringValue(pushMsgPackage.msgMapExtra, "order_id");
            WawajiControllerHelper.WawajiControllerConfig parseData = WawajiControllerHelper.WawajiControllerConfig.parseData(MsgPackHelper.getMapValue(pushMsgPackage.msgMapExtra, "config"));
            IWawajiControllerCallback iWawajiControllerCallback = this.wawajiControllerCallback;
            if (iWawajiControllerCallback != null) {
                iWawajiControllerCallback.onPlayConfig(longValue, stringValue, parseData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadGameResultFailed(WawajiControllerHelper.WawajiGameResult wawajiGameResult, String str) {
        IWawajiControllerCallback iWawajiControllerCallback = this.wawajiControllerCallback;
        if (iWawajiControllerCallback != null) {
            iWawajiControllerCallback.onUploadGameResultFailed(wawajiGameResult, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadGameResultSuccess(WawajiControllerHelper.WawajiGameResult wawajiGameResult) {
        IWawajiControllerCallback iWawajiControllerCallback = this.wawajiControllerCallback;
        if (iWawajiControllerCallback != null) {
            iWawajiControllerCallback.onUploadGameResultSuccess(wawajiGameResult);
        }
    }

    public void attach(IWawajiControllerCallback iWawajiControllerCallback) {
        this.wawajiControllerCallback = iWawajiControllerCallback;
    }

    public void checkPlayingState(long j) {
        this.connector.getPackageSendHelper().sendPackage(new ReqWawajiControllerCheckPlayPackage(j, ChatHelper.getLocalId()), new PackSendHelper.PackCallback() { // from class: com.blued.android.chat.core.worker.chat.WawajiControllerChat.4
            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onAckTimeout(BasePackage basePackage) {
                WawajiControllerChat.this.playCheckFailed("ack timeout");
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onReceiveAck(BasePackage basePackage, BasePackage basePackage2) {
                if (basePackage2 instanceof ReqAckPackage) {
                    ReqAckPackage reqAckPackage = (ReqAckPackage) basePackage2;
                    if (reqAckPackage.error == 0) {
                        WawajiControllerChat.this.playCheckSuccess();
                        return;
                    }
                    WawajiControllerChat wawajiControllerChat = WawajiControllerChat.this;
                    wawajiControllerChat.playCheckFailed("ack errorCode:" + reqAckPackage.error);
                }
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFailed(BasePackage basePackage) {
                WawajiControllerChat.this.playCheckFailed("send failed");
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFinish(BasePackage basePackage) {
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendTimeout(BasePackage basePackage) {
                WawajiControllerChat.this.playCheckFailed("send timeout");
            }
        });
    }

    public void detach(IWawajiControllerCallback iWawajiControllerCallback) {
        if (this.wawajiControllerCallback == iWawajiControllerCallback) {
            this.wawajiControllerCallback = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean handlePushMessage(PushMsgPackage pushMsgPackage) {
        if (pushMsgPackage.msgType == 76) {
            recvPlayConfigMsg(pushMsgPackage);
            return true;
        } else if (pushMsgPackage.msgType == 77) {
            recvControllerUpdateMsg(pushMsgPackage);
            return true;
        } else {
            return false;
        }
    }

    public void initController() {
        this.connector.getPackageSendHelper().sendPackage(new ReqWawajiControllerInitPackage(ChatHelper.getLocalId()), new PackSendHelper.PackCallback() { // from class: com.blued.android.chat.core.worker.chat.WawajiControllerChat.2
            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onAckTimeout(BasePackage basePackage) {
                WawajiControllerChat.this.initControllerFailed("init ack timeout");
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onReceiveAck(BasePackage basePackage, BasePackage basePackage2) {
                if (basePackage2 instanceof ReqAckPackage) {
                    ReqAckPackage reqAckPackage = (ReqAckPackage) basePackage2;
                    if (reqAckPackage.error == 0) {
                        WawajiControllerChat.this.initControllerSuccess(MsgPackHelper.getLongValue(reqAckPackage.reqResponse, ReqAckPackage.REQ_RESPONSE_KEY.SESSION_ID), MsgPackHelper.getStringValue(reqAckPackage.reqResponse, "room_id"), MsgPackHelper.getStringValue(reqAckPackage.reqResponse, "stream_id1"), MsgPackHelper.getStringValue(reqAckPackage.reqResponse, "stream_id2"));
                        return;
                    }
                    WawajiControllerChat wawajiControllerChat = WawajiControllerChat.this;
                    wawajiControllerChat.initControllerFailed("ack errorCode:" + reqAckPackage.error);
                }
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFailed(BasePackage basePackage) {
                WawajiControllerChat.this.initControllerFailed("init send failed");
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFinish(BasePackage basePackage) {
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendTimeout(BasePackage basePackage) {
                WawajiControllerChat.this.initControllerFailed("init send timeout");
            }
        });
    }

    public void readyController(long j) {
        this.connector.getPackageSendHelper().sendPackage(new ReqWawajiControllerReadyPackage(j, ChatHelper.getLocalId()), new PackSendHelper.PackCallback() { // from class: com.blued.android.chat.core.worker.chat.WawajiControllerChat.3
            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onAckTimeout(BasePackage basePackage) {
                WawajiControllerChat.this.readyControllerFailed("ack timeout");
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onReceiveAck(BasePackage basePackage, BasePackage basePackage2) {
                if (basePackage2 instanceof ReqAckPackage) {
                    ReqAckPackage reqAckPackage = (ReqAckPackage) basePackage2;
                    if (reqAckPackage.error == 0) {
                        WawajiControllerChat.this.readyControllerSuccess();
                        return;
                    }
                    WawajiControllerChat wawajiControllerChat = WawajiControllerChat.this;
                    wawajiControllerChat.readyControllerFailed("ack errorCode:" + reqAckPackage.error);
                }
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFailed(BasePackage basePackage) {
                WawajiControllerChat.this.readyControllerFailed("send failed");
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFinish(BasePackage basePackage) {
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendTimeout(BasePackage basePackage) {
                WawajiControllerChat.this.readyControllerFailed("send timeout");
            }
        });
    }

    public void uploadGameResult(final WawajiControllerHelper.WawajiGameResult wawajiGameResult) {
        this.connector.getPackageSendHelper().sendPackage(new ReqWawajiControllerUploadResultPackage(wawajiGameResult.sessionId, wawajiGameResult.playerUid, wawajiGameResult.orderId, wawajiGameResult.result, ChatHelper.getLocalId()), new PackSendHelper.PackCallback() { // from class: com.blued.android.chat.core.worker.chat.WawajiControllerChat.1
            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onAckTimeout(BasePackage basePackage) {
                WawajiControllerChat.this.uploadGameResultFailed(wawajiGameResult, "ack timeout");
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onReceiveAck(BasePackage basePackage, BasePackage basePackage2) {
                if (basePackage2 instanceof ReqAckPackage) {
                    ReqAckPackage reqAckPackage = (ReqAckPackage) basePackage2;
                    if (reqAckPackage.error == 0) {
                        WawajiControllerChat.this.uploadGameResultSuccess(wawajiGameResult);
                        return;
                    }
                    WawajiControllerChat wawajiControllerChat = WawajiControllerChat.this;
                    WawajiControllerHelper.WawajiGameResult wawajiGameResult2 = wawajiGameResult;
                    wawajiControllerChat.uploadGameResultFailed(wawajiGameResult2, "ack errorCode:" + reqAckPackage.error);
                }
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFailed(BasePackage basePackage) {
                WawajiControllerChat.this.uploadGameResultFailed(wawajiGameResult, "send failed");
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFinish(BasePackage basePackage) {
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendTimeout(BasePackage basePackage) {
                WawajiControllerChat.this.uploadGameResultFailed(wawajiGameResult, "send timeout");
            }
        });
    }
}
