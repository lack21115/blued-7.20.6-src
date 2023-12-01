package com.blued.android.chat.core.worker.chat;

import android.text.TextUtils;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.VideoChatHelper;
import com.blued.android.chat.core.pack.BasePackage;
import com.blued.android.chat.core.pack.PushMsgPackage;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.worker.Connector;
import com.blued.android.chat.core.worker.PackSendHelper;
import com.blued.android.chat.listener.ChatTipsListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.VideoChatMsgContentModel;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.module.im.IM;
import com.blued.android.module.im.biz.Common;
import com.blued.android.module.im.grpc.GrpcUnaryCall;
import com.blued.im.private_chat.Chat1V1;
import com.blued.im.private_chat.CodeOuterClass;
import com.blued.im.private_chat.ReqTypeOuterClass;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.protobuf.GeneratedMessageV3;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/chat/VideoChat.class */
public class VideoChat {
    private static final String TAG = "Chat_VideoChat";
    private final Chat chat;
    private final Connector connector;
    private IVideoChatCallback videoChatCallback;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/chat/VideoChat$IVideoChatCallback.class */
    public interface IVideoChatCallback {
        long getCallUid();

        String getRoomId();

        int getRoomType();

        void onCallFailed(VideoChatHelper.CallFailed callFailed, String str, int i);

        void onCallSuccess(int i, int i2, boolean z, String str, int i3);

        void onClose(int i);

        void onGetLeftTime(int i, int i2);

        void onGetLeftTimeFail();

        void onReceiveCallingMsg(long j);

        void onReceiveText(long j, ChattingModel chattingModel);

        void onSwitchToAudio();
    }

    public VideoChat(Connector connector, Chat chat) {
        this.connector = connector;
        this.chat = chat;
        chat.videoChat = this;
    }

    private void getLeftTimeAndCount(long j, int i) {
        try {
            sendGrpcRequest(ReqTypeOuterClass.ReqType.ReqGetCallTime, Chat1V1.Chat1v1ReqBody.newBuilder().setInvitedUid((int) j).setConsumeBeans(i).build(), new GrpcUnaryCall.OnFinishListener() { // from class: com.blued.android.chat.core.worker.chat.VideoChat.2
                @Override // com.blued.android.module.im.grpc.GrpcUnaryCall.OnFinishListener
                public void onFinish(GeneratedMessageV3 generatedMessageV3) {
                    if (generatedMessageV3 != null) {
                        VideoChat.this.processGetLeftTimeResponse((Chat1V1.Chat1v1Response) generatedMessageV3);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void notifyBusyCalling(long j) {
        ChatTipsListener tipsListener = ChatManager.getInstance().getTipsListener();
        if (tipsListener != null) {
            tipsListener.onBusyCalling(j);
        }
    }

    private void notifyTipsCalling(long j, int i) {
        ChatTipsListener tipsListener = ChatManager.getInstance().getTipsListener();
        if (tipsListener != null) {
            tipsListener.onVideoCalling(j, i);
        }
    }

    private void notifyTipsCallingCancel(long j, int i) {
        ChatTipsListener tipsListener = ChatManager.getInstance().getTipsListener();
        if (tipsListener != null) {
            tipsListener.onVideoCallingCancel(j, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processCreateVideoChatResponse(Chat1V1.Chat1v1Response chat1v1Response) {
        if (chat1v1Response == null) {
            return;
        }
        Chat1V1.Chat1v1AckBody body = chat1v1Response.getBody();
        if (chat1v1Response.getCode() == CodeOuterClass.Code.PRIVATE_SUCCESS && body.getError() == 0) {
            int ownTime = (int) body.getOwnTime();
            int remainingCallCount = (int) body.getRemainingCallCount();
            boolean switchSdk = body.getSwitchSdk();
            String userSig = body.getUserSig();
            int appId = body.getAppId();
            IVideoChatCallback iVideoChatCallback = this.videoChatCallback;
            if (iVideoChatCallback != null) {
                iVideoChatCallback.onCallSuccess(ownTime, remainingCallCount, switchSdk, userSig, appId);
            }
        } else if (this.videoChatCallback != null) {
            String errorContents = body.getErrorContents();
            int error = body.getError();
            switch (error) {
                case 15:
                    this.videoChatCallback.onCallFailed(VideoChatHelper.CallFailed.APP_NOT_SUPPORT, errorContents, error);
                    return;
                case 16:
                    this.videoChatCallback.onCallFailed(VideoChatHelper.CallFailed.APP_NOT_ONLINE, errorContents, error);
                    return;
                case 17:
                    this.videoChatCallback.onCallFailed(VideoChatHelper.CallFailed.APP_NOT_RECEIVE, errorContents, error);
                    return;
                default:
                    this.videoChatCallback.onCallFailed(VideoChatHelper.CallFailed.SERVER_LIMIT, errorContents, error);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processGetLeftTimeResponse(Chat1V1.Chat1v1Response chat1v1Response) {
        if (chat1v1Response == null) {
            return;
        }
        Chat1V1.Chat1v1AckBody body = chat1v1Response.getBody();
        if (chat1v1Response.getCode() != CodeOuterClass.Code.PRIVATE_SUCCESS || body.getError() != 0) {
            IVideoChatCallback iVideoChatCallback = this.videoChatCallback;
            if (iVideoChatCallback != null) {
                iVideoChatCallback.onGetLeftTimeFail();
                return;
            }
            return;
        }
        int ownTime = (int) body.getOwnTime();
        int remainingCallCount = (int) body.getRemainingCallCount();
        IVideoChatCallback iVideoChatCallback2 = this.videoChatCallback;
        if (iVideoChatCallback2 != null) {
            iVideoChatCallback2.onGetLeftTime(ownTime, remainingCallCount);
        }
    }

    public void answer(long j, String str, int i, int i2) {
        notifyTipsCallingCancel(j, i);
        getLeftTimeAndCount(j, i2);
    }

    public void attach(IVideoChatCallback iVideoChatCallback) {
        this.videoChatCallback = iVideoChatCallback;
        long callUid = iVideoChatCallback.getCallUid();
        if (callUid != ChatManager.getInstance().getUid()) {
            notifyTipsCallingCancel(callUid, iVideoChatCallback.getRoomType());
        }
    }

    public void call(long j, String str, int i, int i2, int i3) {
        try {
            sendGrpcRequest(ReqTypeOuterClass.ReqType.ReqMakeCall, Chat1V1.Chat1v1ReqBody.newBuilder().setInvitedUid((int) j).setRoomId(str).setRoomType(i).setChatSdkType(i2).setConsumeBeans(i3).build(), new GrpcUnaryCall.OnFinishListener() { // from class: com.blued.android.chat.core.worker.chat.VideoChat.1
                @Override // com.blued.android.module.im.grpc.GrpcUnaryCall.OnFinishListener
                public void onFinish(GeneratedMessageV3 generatedMessageV3) {
                    if (generatedMessageV3 != null) {
                        VideoChat.this.processCreateVideoChatResponse((Chat1V1.Chat1v1Response) generatedMessageV3);
                    } else if (VideoChat.this.videoChatCallback != null) {
                        VideoChat.this.videoChatCallback.onCallFailed(VideoChatHelper.CallFailed.NETWORK, null, -1);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close(String str, int i, long j) {
        try {
            sendGrpcRequest(ReqTypeOuterClass.ReqType.ReqStopCall, Chat1V1.Chat1v1ReqBody.newBuilder().setRoomId(str).setTotalTime(j).setReason(i).build(), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        IVideoChatCallback iVideoChatCallback = this.videoChatCallback;
        if (iVideoChatCallback != null) {
            long callUid = iVideoChatCallback.getCallUid();
            if (callUid != ChatManager.getInstance().getUid()) {
                notifyTipsCallingCancel(callUid, this.videoChatCallback.getRoomType());
            }
        }
    }

    public void detach(IVideoChatCallback iVideoChatCallback) {
        if (this.videoChatCallback == iVideoChatCallback) {
            this.videoChatCallback = null;
        }
    }

    public void getLeftTimeAndCount() {
        getLeftTimeAndCount(0L, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean recvPushCallMessageAndNotifyOrNot(ChattingModel chattingModel) {
        VideoChatMsgContentModel videoChatMsgContentModel;
        if (ChatManager.debug) {
            Log.v(TAG, "recvPushCallMessage(), pushMessage:" + chattingModel);
        }
        String str = null;
        try {
            videoChatMsgContentModel = (VideoChatMsgContentModel) new Gson().fromJson(chattingModel.msgContent, new TypeToken<VideoChatMsgContentModel>() { // from class: com.blued.android.chat.core.worker.chat.VideoChat.4
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            videoChatMsgContentModel = null;
        }
        int i = videoChatMsgContentModel != null ? videoChatMsgContentModel.room_type : 0;
        String str2 = videoChatMsgContentModel != null ? videoChatMsgContentModel.room_id : null;
        IVideoChatCallback iVideoChatCallback = this.videoChatCallback;
        if (iVideoChatCallback != null) {
            str = iVideoChatCallback.getRoomId();
        }
        Log.v(TAG, "currentRoomId:" + str + ", pushRoomId:" + str2);
        if (chattingModel.msgType == 52) {
            if (chattingModel.fromId != ChatManager.getInstance().getUid()) {
                if (str != null && !TextUtils.equals(str2, str)) {
                    if (ChatManager.debug) {
                        Log.v(TAG, "calling busy, current roomId:" + this.videoChatCallback.getRoomId() + ", new roomId:" + str2);
                    }
                    close(str2, 6, 0L);
                    notifyBusyCalling(chattingModel.fromId);
                    return false;
                }
                notifyTipsCalling(chattingModel.fromId, i);
            }
            IVideoChatCallback iVideoChatCallback2 = this.videoChatCallback;
            if (iVideoChatCallback2 != null) {
                iVideoChatCallback2.onReceiveCallingMsg(chattingModel.fromId);
                return true;
            }
            return true;
        } else if (chattingModel.msgType != 53) {
            if (chattingModel.msgType == 54 && this.videoChatCallback != null && TextUtils.equals(str2, str)) {
                this.videoChatCallback.onSwitchToAudio();
                return false;
            }
            return false;
        } else if (str == null || TextUtils.equals(str, str2)) {
            if (chattingModel.fromId != ChatManager.getInstance().getUid()) {
                notifyTipsCallingCancel(chattingModel.fromId, i);
            }
            IVideoChatCallback iVideoChatCallback3 = this.videoChatCallback;
            if (iVideoChatCallback3 != null) {
                if (videoChatMsgContentModel != null) {
                    iVideoChatCallback3.onClose(videoChatMsgContentModel.close_type);
                    return false;
                }
                iVideoChatCallback3.onClose(0);
                return false;
            }
            return false;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void recvPushMsgPackage(PushMsgPackage pushMsgPackage) {
        IVideoChatCallback iVideoChatCallback;
        ChattingModel msgData = PushMsgPackage.toMsgData(pushMsgPackage);
        Log.e(TAG, "收到消息recvPushMsgPackage  = " + pushMsgPackage.toString());
        if (msgData == null || msgData.msgType != 232 || (iVideoChatCallback = this.videoChatCallback) == null) {
            return;
        }
        iVideoChatCallback.onReceiveText(pushMsgPackage.sessionId, msgData);
    }

    public void report(String str) {
        try {
            sendGrpcRequest(ReqTypeOuterClass.ReqType.ReqStartStreaming, Chat1V1.Chat1v1ReqBody.newBuilder().setStreamId(str).build(), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendGrpcRequest(ReqTypeOuterClass.ReqType reqType, Chat1V1.Chat1v1ReqBody chat1v1ReqBody, GrpcUnaryCall.OnFinishListener onFinishListener) {
        try {
            IM.a(Chat1V1.Chat1v1Request.newBuilder().setCommon(Common.a().b()).setReqType(reqType).setLocalId((int) ChatHelper.getLocalId()).setCorrelationId(String.valueOf(ChatManager.userInfo.uid)).setBody(chat1v1ReqBody).build(), onFinishListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(long j, ChattingModel chattingModel) {
        if (ChatManager.debug) {
            Log.v(TAG, "sendMsg() " + chattingModel.toString());
        }
        chattingModel.msgStateCode = (short) 1;
        chattingModel.msgId = 0L;
        chattingModel.msgPreviousId = 0L;
        chattingModel.msgLocalId = ChatHelper.getLocalId();
        chattingModel.msgTimestamp = System.currentTimeMillis();
        String str = chattingModel.msgContent;
        IVideoChatCallback iVideoChatCallback = this.videoChatCallback;
        if (iVideoChatCallback != null) {
            iVideoChatCallback.onReceiveText(j, chattingModel);
        }
        this.connector.getPackageSendHelper().sendPackage(ChatHelper.getSendMsgPackageFromChattingModel(chattingModel), new PackSendHelper.PackCallback() { // from class: com.blued.android.chat.core.worker.chat.VideoChat.5
            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onAckTimeout(BasePackage basePackage) {
                if (ChatManager.debug) {
                    Log.e(VideoChat.TAG, "消息Ack等待超时");
                }
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onReceiveAck(BasePackage basePackage, BasePackage basePackage2) {
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFailed(BasePackage basePackage) {
                if (ChatManager.debug) {
                    Log.e(VideoChat.TAG, "消息发送失败");
                }
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFinish(BasePackage basePackage) {
                if (ChatManager.debug) {
                    Log.e(VideoChat.TAG, "消息发送完成");
                }
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendTimeout(BasePackage basePackage) {
                if (ChatManager.debug) {
                    Log.e(VideoChat.TAG, "消息发送超时");
                }
            }
        });
    }

    public void switchToAudio(String str) {
        try {
            sendGrpcRequest(ReqTypeOuterClass.ReqType.ReqChangeCallType, Chat1V1.Chat1v1ReqBody.newBuilder().setRoomId(str).build(), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCallMessage(long j, long j2, int i, int i2) {
        ChattingModel findMessage = this.chat.findMessage((short) 2, j, j2, 0L, null);
        if (findMessage == null || findMessage.msgType != 52) {
            return;
        }
        findMessage.msgType = (short) 53;
        VideoChatMsgContentModel videoChatMsgContentModel = null;
        Gson gson = new Gson();
        try {
            videoChatMsgContentModel = (VideoChatMsgContentModel) gson.fromJson(findMessage.msgContent, new TypeToken<VideoChatMsgContentModel>() { // from class: com.blued.android.chat.core.worker.chat.VideoChat.3
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (videoChatMsgContentModel != null) {
            videoChatMsgContentModel.close_type = i;
            videoChatMsgContentModel.total_time = i2;
            findMessage.msgContent = gson.toJson(videoChatMsgContentModel);
            this.chat.updateMsgData(findMessage);
        }
    }

    public void updateCallTimeToServer(String str, int i) {
        try {
            sendGrpcRequest(ReqTypeOuterClass.ReqType.ReqUpdateCall, Chat1V1.Chat1v1ReqBody.newBuilder().setRoomId(str).setTotalTime(i).build(), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
