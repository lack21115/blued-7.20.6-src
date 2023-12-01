package com.blued.android.chat.core.worker.chat;

import android.media.MediaFormat;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.FlashVideoHelper;
import com.blued.android.chat.core.pack.BasePackage;
import com.blued.android.chat.core.pack.PushMsgPackage;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.chat.core.pack.ReqCancelFlashVideoMatchPackage;
import com.blued.android.chat.core.pack.ReqCloseFlashVideoPackage;
import com.blued.android.chat.core.pack.ReqFlashVideoApplyExtraTimePackage;
import com.blued.android.chat.core.pack.ReqFlashVideoApplyFriend;
import com.blued.android.chat.core.pack.ReqFlashVideoEmoji;
import com.blued.android.chat.core.pack.ReqFlashVideoMatchAgreePackage;
import com.blued.android.chat.core.pack.ReqFlashVideoSayHi;
import com.blued.android.chat.core.pack.ReqStartFlashVideoMatchPackage;
import com.blued.android.chat.core.pack.SendAckPackage;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.worker.Connector;
import com.blued.android.chat.core.worker.PackSendHelper;
import com.blued.android.chat.data.RelationProfileData;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.FlashVideoGiftModel;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.chat.utils.MsgPackHelper;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import java.util.List;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/chat/FlashVideo.class */
public class FlashVideo {
    private static final String TAG = "Chat_FlashVideo";
    private final Chat chat;
    private final Connector connector;
    private IFlashVideoCallback flashVideoCallback;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/chat/FlashVideo$IFlashVideoCallback.class */
    public interface IFlashVideoCallback {
        void onApplyFriends(String str);

        void onApplyFriends(Map map);

        void onApplyFriendsAgree(String str);

        void onChatClose(String str, int i, String str2);

        void onMatchAck(String str, List<String> list);

        void onMatchFailed(FlashVideoHelper.MatchFailed matchFailed, String str, int i);

        void onMatched(String str, RelationProfileData relationProfileData, int i, int i2, String str2, String str3, String str4, int i3);

        void onReceiveApplyExtraTime(String str, int i);

        void onReceiveEmoji(String str, String str2);

        void onReceiveGift(FlashVideoGiftModel flashVideoGiftModel);

        void onReceiveMatchAgree(String str);

        void onReceiveText(long j, ChattingModel chattingModel);

        void onSayHi(String str);

        void onSendTextMsgFail(long j, String str);

        void onSendTextMsgSuccess(long j);
    }

    public FlashVideo(Connector connector, Chat chat) {
        this.connector = connector;
        this.chat = chat;
        chat.flashVideo = this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reqFlashVideoFriendApply(ReqAckPackage reqAckPackage) {
        if (reqAckPackage != null && reqAckPackage.result == 0 && reqAckPackage.error == 0) {
            Map mapValue = MsgPackHelper.getMapValue(reqAckPackage.reqResponse, "extra");
            IFlashVideoCallback iFlashVideoCallback = this.flashVideoCallback;
            if (iFlashVideoCallback == null || mapValue == null) {
                return;
            }
            iFlashVideoCallback.onApplyFriends(mapValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMsgFail(long j, String str) {
        IFlashVideoCallback iFlashVideoCallback = this.flashVideoCallback;
        if (iFlashVideoCallback != null) {
            iFlashVideoCallback.onSendTextMsgFail(j, str);
        }
    }

    public void applyExtraTime(long j, String str) {
        this.connector.getPackageSendHelper().sendPackage(new ReqFlashVideoApplyExtraTimePackage(j, str, ChatHelper.getLocalId()), null);
    }

    public void applyFriend(long j, String str) {
        this.connector.getPackageSendHelper().sendPackage(new ReqFlashVideoApplyFriend(j, str, ChatHelper.getLocalId()), new PackSendHelper.PackCallback() { // from class: com.blued.android.chat.core.worker.chat.FlashVideo.2
            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onAckTimeout(BasePackage basePackage) {
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onReceiveAck(BasePackage basePackage, BasePackage basePackage2) {
                if (basePackage2 instanceof ReqAckPackage) {
                    FlashVideo.this.reqFlashVideoFriendApply((ReqAckPackage) basePackage2);
                }
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFailed(BasePackage basePackage) {
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFinish(BasePackage basePackage) {
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendTimeout(BasePackage basePackage) {
            }
        });
    }

    public void attach(IFlashVideoCallback iFlashVideoCallback) {
        this.flashVideoCallback = iFlashVideoCallback;
    }

    public void cancelMatch() {
        this.connector.getPackageSendHelper().sendPackage(new ReqCancelFlashVideoMatchPackage(ChatHelper.getLocalId()), null);
    }

    public void closeFlashVideo(long j, String str, int i) {
        this.connector.getPackageSendHelper().sendPackage(new ReqCloseFlashVideoPackage(j, str, i, ChatHelper.getLocalId()), null);
    }

    public void detach(IFlashVideoCallback iFlashVideoCallback) {
        if (this.flashVideoCallback == iFlashVideoCallback) {
            this.flashVideoCallback = null;
        }
    }

    public void matchAgree(long j, String str) {
        this.connector.getPackageSendHelper().sendPackage(new ReqFlashVideoMatchAgreePackage(j, str, ChatHelper.getLocalId()), null);
    }

    public void receiveFlashVideoApplyExtraTime(PushMsgPackage pushMsgPackage) {
        String stringValue = MsgPackHelper.getStringValue(pushMsgPackage.msgMapExtra, TTLiveConstants.ROOMID_KEY);
        int intValue = MsgPackHelper.getIntValue(pushMsgPackage.msgMapExtra, "add_time");
        IFlashVideoCallback iFlashVideoCallback = this.flashVideoCallback;
        if (iFlashVideoCallback != null) {
            iFlashVideoCallback.onReceiveApplyExtraTime(stringValue, intValue);
        }
    }

    public void receiveFlashVideoClosePush(PushMsgPackage pushMsgPackage) {
        if (pushMsgPackage.msgMapExtra != null) {
            String stringValue = MsgPackHelper.getStringValue(pushMsgPackage.msgMapExtra, TTLiveConstants.ROOMID_KEY);
            int intValue = MsgPackHelper.getIntValue(pushMsgPackage.msgMapExtra, "reason");
            String stringValue2 = MsgPackHelper.getStringValue(pushMsgPackage.msgMapExtra, "msg");
            IFlashVideoCallback iFlashVideoCallback = this.flashVideoCallback;
            if (iFlashVideoCallback != null) {
                iFlashVideoCallback.onChatClose(stringValue, intValue, stringValue2);
            }
        }
    }

    public void receiveFlashVideoEmoji(PushMsgPackage pushMsgPackage) {
        String stringValue = MsgPackHelper.getStringValue(pushMsgPackage.msgMapExtra, TTLiveConstants.ROOMID_KEY);
        String stringValue2 = MsgPackHelper.getStringValue(pushMsgPackage.msgMapExtra, "emoji_tag");
        IFlashVideoCallback iFlashVideoCallback = this.flashVideoCallback;
        if (iFlashVideoCallback != null) {
            iFlashVideoCallback.onReceiveEmoji(stringValue, stringValue2);
        }
    }

    public void receiveFlashVideoFriendApply(PushMsgPackage pushMsgPackage) {
        String stringValue = MsgPackHelper.getStringValue(pushMsgPackage.msgMapExtra, TTLiveConstants.ROOMID_KEY);
        IFlashVideoCallback iFlashVideoCallback = this.flashVideoCallback;
        if (iFlashVideoCallback != null) {
            iFlashVideoCallback.onApplyFriends(stringValue);
        }
    }

    public void receiveFlashVideoFriendApplyAgree(PushMsgPackage pushMsgPackage) {
        String stringValue = MsgPackHelper.getStringValue(pushMsgPackage.msgMapExtra, TTLiveConstants.ROOMID_KEY);
        IFlashVideoCallback iFlashVideoCallback = this.flashVideoCallback;
        if (iFlashVideoCallback != null) {
            iFlashVideoCallback.onApplyFriendsAgree(stringValue);
        }
    }

    public void receiveFlashVideoGift(PushMsgPackage pushMsgPackage) {
        FlashVideoGiftModel parseData = FlashVideoGiftModel.parseData(pushMsgPackage.msgMapExtra);
        IFlashVideoCallback iFlashVideoCallback = this.flashVideoCallback;
        if (iFlashVideoCallback != null) {
            iFlashVideoCallback.onReceiveGift(parseData);
        }
    }

    public void receiveFlashVideoMatchAgree(PushMsgPackage pushMsgPackage) {
        String stringValue = MsgPackHelper.getStringValue(pushMsgPackage.msgMapExtra, TTLiveConstants.ROOMID_KEY);
        IFlashVideoCallback iFlashVideoCallback = this.flashVideoCallback;
        if (iFlashVideoCallback != null) {
            iFlashVideoCallback.onReceiveMatchAgree(stringValue);
        }
    }

    public void receiveFlashVideoSayHi(PushMsgPackage pushMsgPackage) {
        String stringValue = MsgPackHelper.getStringValue(pushMsgPackage.msgMapExtra, TTLiveConstants.ROOMID_KEY);
        IFlashVideoCallback iFlashVideoCallback = this.flashVideoCallback;
        if (iFlashVideoCallback != null) {
            iFlashVideoCallback.onSayHi(stringValue);
        }
    }

    public void receiveMatchedPush(PushMsgPackage pushMsgPackage) {
        if (pushMsgPackage.msgMapExtra != null) {
            RelationProfileData relationProfileData = null;
            Map<String, Object> mapValue = MsgPackHelper.getMapValue(pushMsgPackage.msgMapExtra, MediaFormat.KEY_PROFILE);
            if (mapValue != null) {
                relationProfileData = new RelationProfileData();
                relationProfileData.parseMsgPackData(mapValue);
            }
            int intValue = MsgPackHelper.getIntValue(pushMsgPackage.msgMapExtra, "other_like");
            String stringValue = MsgPackHelper.getStringValue(pushMsgPackage.msgMapExtra, TTLiveConstants.ROOMID_KEY);
            int intValue2 = MsgPackHelper.getIntValue(pushMsgPackage.msgMapExtra, "max_time");
            String stringValue2 = MsgPackHelper.getStringValue(pushMsgPackage.msgMapExtra, "chat_tips");
            String stringValue3 = MsgPackHelper.getStringValue(pushMsgPackage.msgMapExtra, "stream_id");
            String stringValue4 = MsgPackHelper.getStringValue(pushMsgPackage.msgMapExtra, "rtmp_url");
            int intValue3 = MsgPackHelper.getIntValue(pushMsgPackage.msgMapExtra, ReqAckPackage.REQ_RESPONSE_KEY.FLASH_REMAIN_NUM);
            IFlashVideoCallback iFlashVideoCallback = this.flashVideoCallback;
            if (iFlashVideoCallback != null) {
                iFlashVideoCallback.onMatched(stringValue, relationProfileData, intValue, intValue2, stringValue2, stringValue3, stringValue4, intValue3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void recvPushMsgPackage(PushMsgPackage pushMsgPackage) {
        IFlashVideoCallback iFlashVideoCallback;
        ChattingModel msgData = PushMsgPackage.toMsgData(pushMsgPackage);
        Log.e(TAG, "收到消息recvPushMsgPackage  = " + pushMsgPackage.toString());
        if (msgData == null || msgData.msgType != 1 || (iFlashVideoCallback = this.flashVideoCallback) == null) {
            return;
        }
        iFlashVideoCallback.onReceiveText(pushMsgPackage.sessionId, msgData);
    }

    public void sayHi(long j, String str) {
        this.connector.getPackageSendHelper().sendPackage(new ReqFlashVideoSayHi(j, str, ChatHelper.getLocalId()), null);
    }

    public void sendEmoji(long j, String str, String str2) {
        this.connector.getPackageSendHelper().sendPackage(new ReqFlashVideoEmoji(j, str, ChatHelper.getLocalId(), str2), null);
    }

    public void sendMsg(final long j, ChattingModel chattingModel) {
        if (ChatManager.debug) {
            Log.v(TAG, "sendMsg() " + chattingModel.toString());
        }
        chattingModel.msgStateCode = (short) 1;
        chattingModel.msgId = 0L;
        chattingModel.msgPreviousId = 0L;
        chattingModel.msgLocalId = ChatHelper.getLocalId();
        chattingModel.msgTimestamp = System.currentTimeMillis();
        final String str = chattingModel.msgContent;
        IFlashVideoCallback iFlashVideoCallback = this.flashVideoCallback;
        if (iFlashVideoCallback != null) {
            iFlashVideoCallback.onReceiveText(j, chattingModel);
        }
        this.connector.getPackageSendHelper().sendPackage(ChatHelper.getSendMsgPackageFromChattingModel(chattingModel), new PackSendHelper.PackCallback() { // from class: com.blued.android.chat.core.worker.chat.FlashVideo.3
            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onAckTimeout(BasePackage basePackage) {
                if (ChatManager.debug) {
                    Log.e(FlashVideo.TAG, "消息Ack等待超时");
                }
                FlashVideo.this.sendMsgFail(j, str);
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onReceiveAck(BasePackage basePackage, BasePackage basePackage2) {
                if (basePackage2 instanceof SendAckPackage) {
                    if (((SendAckPackage) basePackage2).result != 0) {
                        FlashVideo.this.sendMsgFail(j, str);
                    } else if (FlashVideo.this.flashVideoCallback != null) {
                        FlashVideo.this.flashVideoCallback.onSendTextMsgSuccess(j);
                    }
                }
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFailed(BasePackage basePackage) {
                if (ChatManager.debug) {
                    Log.e(FlashVideo.TAG, "消息发送失败");
                }
                FlashVideo.this.sendMsgFail(j, str);
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFinish(BasePackage basePackage) {
                if (FlashVideo.this.flashVideoCallback != null) {
                    FlashVideo.this.flashVideoCallback.onSendTextMsgSuccess(j);
                }
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendTimeout(BasePackage basePackage) {
                if (ChatManager.debug) {
                    Log.e(FlashVideo.TAG, "消息发送超时");
                }
                FlashVideo.this.sendMsgFail(j, str);
            }
        });
    }

    public void startMatch() {
        this.connector.getPackageSendHelper().sendPackage(new ReqStartFlashVideoMatchPackage(ChatHelper.getLocalId()), new PackSendHelper.PackCallback() { // from class: com.blued.android.chat.core.worker.chat.FlashVideo.1
            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onAckTimeout(BasePackage basePackage) {
                if (ChatManager.debug) {
                    Log.e(FlashVideo.TAG, "匹配Ack等待超时");
                }
                if (FlashVideo.this.flashVideoCallback != null) {
                    FlashVideo.this.flashVideoCallback.onMatchFailed(FlashVideoHelper.MatchFailed.NETWORK, null, 0);
                }
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onReceiveAck(BasePackage basePackage, BasePackage basePackage2) {
                if (basePackage2 instanceof ReqAckPackage) {
                    ReqAckPackage reqAckPackage = (ReqAckPackage) basePackage2;
                    String str = reqAckPackage.errorContent;
                    int intValue = MsgPackHelper.getIntValue(reqAckPackage.reqResponse, ReqAckPackage.REQ_RESPONSE_KEY.FLASH_REMAIN_NUM);
                    if (reqAckPackage.error == 0) {
                        String stringValue = MsgPackHelper.getStringValue(reqAckPackage.reqResponse, "contents");
                        List<String> listValue = MsgPackHelper.getListValue(reqAckPackage.reqResponse, "tips");
                        if (FlashVideo.this.flashVideoCallback != null) {
                            FlashVideo.this.flashVideoCallback.onMatchAck(stringValue, listValue);
                        }
                    } else if (reqAckPackage.error == 13) {
                        if (FlashVideo.this.flashVideoCallback != null) {
                            FlashVideo.this.flashVideoCallback.onMatchFailed(FlashVideoHelper.MatchFailed.FUNCTION_LOCK, str, intValue);
                        }
                    } else if (reqAckPackage.error == 14) {
                        if (FlashVideo.this.flashVideoCallback != null) {
                            FlashVideo.this.flashVideoCallback.onMatchFailed(FlashVideoHelper.MatchFailed.FUNCTION_LOCK, str, intValue);
                        }
                    } else if (FlashVideo.this.flashVideoCallback != null) {
                        FlashVideo.this.flashVideoCallback.onMatchFailed(FlashVideoHelper.MatchFailed.UNKNOWN, str, intValue);
                    }
                }
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFailed(BasePackage basePackage) {
                if (ChatManager.debug) {
                    Log.e(FlashVideo.TAG, "匹配包发送失败");
                }
                if (FlashVideo.this.flashVideoCallback != null) {
                    FlashVideo.this.flashVideoCallback.onMatchFailed(FlashVideoHelper.MatchFailed.NETWORK, null, 0);
                }
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFinish(BasePackage basePackage) {
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendTimeout(BasePackage basePackage) {
                if (ChatManager.debug) {
                    Log.e(FlashVideo.TAG, "匹配包发送超时");
                }
                if (FlashVideo.this.flashVideoCallback != null) {
                    FlashVideo.this.flashVideoCallback.onMatchFailed(FlashVideoHelper.MatchFailed.NETWORK, null, 0);
                }
            }
        });
    }
}
