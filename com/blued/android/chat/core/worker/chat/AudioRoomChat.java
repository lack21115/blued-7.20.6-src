package com.blued.android.chat.core.worker.chat;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.pack.BasePackage;
import com.blued.android.chat.core.pack.PushMsgPackage;
import com.blued.android.chat.core.pack.SendAckPackage;
import com.blued.android.chat.core.pack.SendMsgPackage;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.worker.BaseWorker;
import com.blued.android.chat.core.worker.Connector;
import com.blued.android.chat.core.worker.PackSendHelper;
import com.blued.android.chat.data.AudioRoomChatData;
import com.blued.android.chat.listener.AudioRoomChatInfoListener;
import com.blued.android.chat.listener.ChatTipsListener;
import com.blued.android.chat.listener.ConnectListener;
import com.blued.android.chat.listener.MsgPreProcesser;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.utils.ChatHelper;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/chat/AudioRoomChat.class */
public class AudioRoomChat extends BaseWorker implements ConnectListener {
    private static final String TAG = "Chat_AudioChat";
    Chat chat;
    Connector connector;
    PackSendHelper packSendHelper;
    SendMsgPackage sendPackage;
    private Object sessionLock = new Object();
    private final ArrayList<AudioRoomChatInfoListener> audioChatInfoListeners = new ArrayList<>();

    public AudioRoomChat(Connector connector, Chat chat) {
        if (ChatManager.debug) {
            Log.v(TAG, "AudioRoomChat() create");
        }
        this.chat = chat;
        this.connector = connector;
        this.packSendHelper = connector.getPackageSendHelper();
        chat.audioRoomChat = this;
        this.connector.registerConnectListener(this);
    }

    private void notifyAcceptInviteAnchor(AudioRoomChatData audioRoomChatData) {
        Log.v(TAG, "notifyRefuseInviteAnchor(), audioRoomChatData:" + audioRoomChatData.toString());
        synchronized (this.audioChatInfoListeners) {
            Iterator<AudioRoomChatInfoListener> it = this.audioChatInfoListeners.iterator();
            while (it.hasNext()) {
                it.next().onAcceptInviteAnchor(audioRoomChatData);
            }
        }
    }

    private void notifyApplyAnchor(AudioRoomChatData audioRoomChatData) {
        Log.v(TAG, "notifyApplyAnchor(), audioRoomChatData:" + audioRoomChatData.toString());
        synchronized (this.audioChatInfoListeners) {
            Iterator<AudioRoomChatInfoListener> it = this.audioChatInfoListeners.iterator();
            while (it.hasNext()) {
                it.next().onApplyAnchor(audioRoomChatData);
            }
        }
    }

    private void notifyChangeSeatSuccess(AudioRoomChatData audioRoomChatData) {
        Log.v(TAG, "notifyChangeSeatSuccess(), msgData:" + audioRoomChatData.toString());
        synchronized (this.audioChatInfoListeners) {
            Iterator<AudioRoomChatInfoListener> it = this.audioChatInfoListeners.iterator();
            while (it.hasNext()) {
                it.next().onChangeSeatSuccess(audioRoomChatData);
            }
        }
    }

    private void notifyCloseRoom(AudioRoomChatData audioRoomChatData) {
        Log.v(TAG, "notifyCloseRoom(), audioRoomChatData:" + audioRoomChatData.toString());
        synchronized (this.audioChatInfoListeners) {
            Iterator<AudioRoomChatInfoListener> it = this.audioChatInfoListeners.iterator();
            while (it.hasNext()) {
                it.next().onCloseRoom(audioRoomChatData);
            }
        }
    }

    private void notifyInviteAnchor(AudioRoomChatData audioRoomChatData) {
        Log.v(TAG, "notifyInviteAnchor(), audioRoomChatData:" + audioRoomChatData.toString());
        synchronized (this.audioChatInfoListeners) {
            Iterator<AudioRoomChatInfoListener> it = this.audioChatInfoListeners.iterator();
            while (it.hasNext()) {
                it.next().onInviteAnchor(audioRoomChatData);
            }
        }
    }

    private void notifyKickedOut(ChattingModel chattingModel) {
        Log.v(TAG, "notifyKickedOut(), msgData:" + chattingModel.toString());
        synchronized (this.audioChatInfoListeners) {
            Iterator<AudioRoomChatInfoListener> it = this.audioChatInfoListeners.iterator();
            while (it.hasNext()) {
                it.next().onKickedOut(chattingModel);
            }
        }
    }

    private void notifyMemebersDecrease(AudioRoomChatData audioRoomChatData) {
        Log.v(TAG, "notifyAudioMemebersDecrease(), audioRoomChatData:" + audioRoomChatData.toString());
        synchronized (this.audioChatInfoListeners) {
            Iterator<AudioRoomChatInfoListener> it = this.audioChatInfoListeners.iterator();
            while (it.hasNext()) {
                it.next().onMemebersDecrease(audioRoomChatData);
            }
        }
    }

    private void notifyMemebersIncrease(AudioRoomChatData audioRoomChatData) {
        Log.v(TAG, "notifyAudioMemebersIncrease(), audioRoomChatData:" + audioRoomChatData.toString());
        synchronized (this.audioChatInfoListeners) {
            Iterator<AudioRoomChatInfoListener> it = this.audioChatInfoListeners.iterator();
            while (it.hasNext()) {
                it.next().onMemebersIncrease(audioRoomChatData);
            }
        }
    }

    private void notifyModifyRoomTitle(AudioRoomChatData audioRoomChatData) {
        Log.v(TAG, "notifyModifyRoomTitle(), msgData:" + audioRoomChatData.toString());
        synchronized (this.audioChatInfoListeners) {
            Iterator<AudioRoomChatInfoListener> it = this.audioChatInfoListeners.iterator();
            while (it.hasNext()) {
                it.next().onModifyRoomTitle(audioRoomChatData);
            }
        }
    }

    private void notifyNewMsg(ChattingModel chattingModel) {
        Log.v(TAG, "notifyNewMsg(), chattingModel:" + chattingModel.toString());
        synchronized (this.audioChatInfoListeners) {
            Iterator<AudioRoomChatInfoListener> it = this.audioChatInfoListeners.iterator();
            while (it.hasNext()) {
                it.next().onRecvNewMsg(chattingModel);
            }
        }
    }

    private void notifyOffAnchor(AudioRoomChatData audioRoomChatData) {
        Log.v(TAG, "notifyOffAnchor(), audioRoomChatData:" + audioRoomChatData.toString());
        synchronized (this.audioChatInfoListeners) {
            Iterator<AudioRoomChatInfoListener> it = this.audioChatInfoListeners.iterator();
            while (it.hasNext()) {
                it.next().onOffAnchor(audioRoomChatData);
            }
        }
    }

    private void notifyOnAnchor(AudioRoomChatData audioRoomChatData) {
        Log.v(TAG, "notifyOnAnchor(), audioRoomChatData:" + audioRoomChatData.toString());
        synchronized (this.audioChatInfoListeners) {
            Iterator<AudioRoomChatInfoListener> it = this.audioChatInfoListeners.iterator();
            while (it.hasNext()) {
                it.next().onOnAnchor(audioRoomChatData);
            }
        }
    }

    private void notifyRefuseAnchor(AudioRoomChatData audioRoomChatData) {
        Log.v(TAG, "notifyRefuseAnchor(), audioRoomChatData:" + audioRoomChatData.toString());
        synchronized (this.audioChatInfoListeners) {
            Iterator<AudioRoomChatInfoListener> it = this.audioChatInfoListeners.iterator();
            while (it.hasNext()) {
                it.next().onRefuseAnchor(audioRoomChatData);
            }
        }
    }

    private void notifyRefuseInviteAnchor(AudioRoomChatData audioRoomChatData) {
        Log.v(TAG, "notifyRefuseInviteAnchor(), audioRoomChatData:" + audioRoomChatData.toString());
        synchronized (this.audioChatInfoListeners) {
            Iterator<AudioRoomChatInfoListener> it = this.audioChatInfoListeners.iterator();
            while (it.hasNext()) {
                it.next().onRefuseInviteAnchor(audioRoomChatData);
            }
        }
    }

    private void notifySeatDecrease(AudioRoomChatData audioRoomChatData) {
        Log.v(TAG, "notifySeatDecrease(), audioRoomChatData:" + audioRoomChatData.toString());
        synchronized (this.audioChatInfoListeners) {
            Iterator<AudioRoomChatInfoListener> it = this.audioChatInfoListeners.iterator();
            while (it.hasNext()) {
                it.next().onSeatDecrease(audioRoomChatData);
            }
        }
    }

    private void notifySeatIncrease(AudioRoomChatData audioRoomChatData) {
        Log.v(TAG, "notifySeatIncrease(), audioRoomChatData:" + audioRoomChatData.toString());
        synchronized (this.audioChatInfoListeners) {
            Iterator<AudioRoomChatInfoListener> it = this.audioChatInfoListeners.iterator();
            while (it.hasNext()) {
                it.next().onSeatIncrease(audioRoomChatData);
            }
        }
    }

    private void notifySeatOccupancyNotice(AudioRoomChatData audioRoomChatData) {
        Log.v(TAG, "notifyChangeSeatSuccess(), msgData:" + audioRoomChatData.toString());
        synchronized (this.audioChatInfoListeners) {
            Iterator<AudioRoomChatInfoListener> it = this.audioChatInfoListeners.iterator();
            while (it.hasNext()) {
                it.next().onSeatOccupancyNotice(audioRoomChatData);
            }
        }
    }

    private void notifyUpdateRoomNotice(AudioRoomChatData audioRoomChatData) {
        Log.v(TAG, "notifyRoomNotice(), msgData:" + audioRoomChatData.toString());
        synchronized (this.audioChatInfoListeners) {
            Iterator<AudioRoomChatInfoListener> it = this.audioChatInfoListeners.iterator();
            while (it.hasNext()) {
                it.next().onUpdateRoomNotice(audioRoomChatData);
            }
        }
    }

    @Override // com.blued.android.chat.core.worker.BaseWorker
    public String getWorkerName() {
        return "AudioRoomChat";
    }

    @Override // com.blued.android.chat.listener.ConnectListener
    public void onConnected() {
    }

    @Override // com.blued.android.chat.listener.ConnectListener
    public void onConnecting() {
    }

    @Override // com.blued.android.chat.listener.ConnectListener
    public void onDisconnected() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void recvPushMsgPackage(PushMsgPackage pushMsgPackage) {
        ChattingModel msgData = PushMsgPackage.toMsgData(pushMsgPackage);
        if (msgData != null) {
            if (msgData.msgType == 1) {
                notifyNewMsg(msgData);
            } else if (msgData.msgType == 162) {
                notifyKickedOut(msgData);
            } else if (msgData.msgMapExtra != null) {
                AudioRoomChatData audioRoomChatData = new AudioRoomChatData();
                audioRoomChatData.session_id = msgData.sessionId;
                audioRoomChatData.session_type = msgData.sessionType;
                audioRoomChatData.msg_type = msgData.msgType;
                audioRoomChatData.parseExtraData(msgData.msgMapExtra);
                if (audioRoomChatData.room_data == null || audioRoomChatData.room_data.room_members == null) {
                    return;
                }
                short s = msgData.msgType;
                if (s == 222) {
                    notifyModifyRoomTitle(audioRoomChatData);
                    return;
                }
                if (s != 265 && s != 247 && s != 248) {
                    switch (s) {
                        case 158:
                            notifyMemebersIncrease(audioRoomChatData);
                            return;
                        case 159:
                            notifyMemebersDecrease(audioRoomChatData);
                            return;
                        case 160:
                            notifySeatDecrease(audioRoomChatData);
                            return;
                        case 161:
                            notifySeatIncrease(audioRoomChatData);
                            return;
                        default:
                            switch (s) {
                                case 195:
                                    notifyApplyAnchor(audioRoomChatData);
                                    return;
                                case 196:
                                    notifyOffAnchor(audioRoomChatData);
                                    notifyNewMsg(msgData);
                                    return;
                                case 197:
                                    notifyOnAnchor(audioRoomChatData);
                                    notifyNewMsg(msgData);
                                    return;
                                case 198:
                                    notifyRefuseAnchor(audioRoomChatData);
                                    notifyNewMsg(msgData);
                                    return;
                                case 199:
                                    notifyCloseRoom(audioRoomChatData);
                                    return;
                                default:
                                    switch (s) {
                                        case 224:
                                            notifyInviteAnchor(audioRoomChatData);
                                            return;
                                        case 225:
                                            notifyRefuseInviteAnchor(audioRoomChatData);
                                            notifyNewMsg(msgData);
                                            return;
                                        case 226:
                                            notifyAcceptInviteAnchor(audioRoomChatData);
                                            return;
                                        default:
                                            switch (s) {
                                                case 228:
                                                    notifyChangeSeatSuccess(audioRoomChatData);
                                                    return;
                                                case 229:
                                                    notifySeatOccupancyNotice(audioRoomChatData);
                                                    return;
                                                case 230:
                                                    notifyUpdateRoomNotice(audioRoomChatData);
                                                    return;
                                                default:
                                                    switch (s) {
                                                        case 259:
                                                        case 260:
                                                        case 261:
                                                            break;
                                                        default:
                                                            switch (s) {
                                                                case 276:
                                                                case 277:
                                                                case 278:
                                                                    break;
                                                                default:
                                                                    return;
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
                }
                notifyNewMsg(msgData);
            }
        }
    }

    protected void recvSendAckPackage(SendAckPackage sendAckPackage) {
        ChatTipsListener tipsListener;
        if (sendAckPackage.result == 0 || (tipsListener = ChatManager.getInstance().getTipsListener()) == null) {
            return;
        }
        tipsListener.onSendMsgFailed(this.sendPackage.sessionType, this.sendPackage.sessionId, this.sendPackage.msgType, sendAckPackage.msgId, sendAckPackage.localId, sendAckPackage.result);
    }

    public void registerAudioRoomChatListener(AudioRoomChatInfoListener audioRoomChatInfoListener) {
        if (ChatManager.debug) {
            Log.v(TAG, "registerLiveChatListener(), audioChatInfoListener:" + audioRoomChatInfoListener.hashCode());
        }
        synchronized (this.audioChatInfoListeners) {
            if (!this.audioChatInfoListeners.contains(audioRoomChatInfoListener)) {
                this.audioChatInfoListeners.add(audioRoomChatInfoListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendMsg(ChattingModel chattingModel, MsgPreProcesser msgPreProcesser) {
        if (ChatManager.debug) {
            Log.v(TAG, "sendMsg()");
        }
        chattingModel.msgStateCode = (short) 1;
        chattingModel.msgId = 0L;
        chattingModel.msgPreviousId = 0L;
        chattingModel.msgLocalId = ChatHelper.getLocalId();
        chattingModel.msgTimestamp = System.currentTimeMillis();
        synchronized (this.sessionLock) {
            notifyNewMsg(chattingModel);
        }
        SendMsgPackage sendMsgPackageFromChattingModel = ChatHelper.getSendMsgPackageFromChattingModel(chattingModel);
        this.sendPackage = sendMsgPackageFromChattingModel;
        this.packSendHelper.sendPackage(sendMsgPackageFromChattingModel, new PackSendHelper.PackCallback() { // from class: com.blued.android.chat.core.worker.chat.AudioRoomChat.1
            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onAckTimeout(BasePackage basePackage) {
                if (basePackage instanceof SendMsgPackage) {
                    AudioRoomChat.this.sendMsgErrorPackage((SendMsgPackage) basePackage);
                }
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onReceiveAck(BasePackage basePackage, BasePackage basePackage2) {
                if (basePackage2 instanceof SendAckPackage) {
                    AudioRoomChat.this.recvSendAckPackage((SendAckPackage) basePackage2);
                }
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFailed(BasePackage basePackage) {
                if (basePackage instanceof SendMsgPackage) {
                    AudioRoomChat.this.sendMsgErrorPackage((SendMsgPackage) basePackage);
                }
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendFinish(BasePackage basePackage) {
            }

            @Override // com.blued.android.chat.core.worker.PackSendHelper.PackCallback
            public void onSendTimeout(BasePackage basePackage) {
                if (basePackage instanceof SendMsgPackage) {
                    AudioRoomChat.this.sendMsgErrorPackage((SendMsgPackage) basePackage);
                }
            }
        });
    }

    protected void sendMsgErrorPackage(SendMsgPackage sendMsgPackage) {
        ChatTipsListener tipsListener = ChatManager.getInstance().getTipsListener();
        if (tipsListener != null) {
            tipsListener.onSendMsgFailed(sendMsgPackage.sessionType, sendMsgPackage.sessionId, sendMsgPackage.msgContent);
        }
    }

    public void unregisterAudioRoomChatListener(AudioRoomChatInfoListener audioRoomChatInfoListener) {
        if (ChatManager.debug) {
            Log.v(TAG, "unregisterLiveChatListener(),  audioChatInfoListener:" + audioRoomChatInfoListener.hashCode());
        }
        synchronized (this.audioChatInfoListeners) {
            if (this.audioChatInfoListeners.contains(audioRoomChatInfoListener)) {
                this.audioChatInfoListeners.remove(audioRoomChatInfoListener);
            }
        }
    }
}
