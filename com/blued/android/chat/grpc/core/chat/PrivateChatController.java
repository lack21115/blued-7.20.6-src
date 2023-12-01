package com.blued.android.chat.grpc.core.chat;

import android.util.Log;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.db.DBOper;
import com.blued.android.chat.grpc.core.BaseWorker;
import com.blued.android.chat.grpc.core.data.SessionHeader;
import com.blued.android.chat.grpc.core.link.Connector;
import com.blued.android.chat.grpc.listener.ChatTipsListener;
import com.blued.android.chat.grpc.listener.MsgConsumer;
import com.blued.android.chat.grpc.listener.MsgContentListener;
import com.blued.android.chat.grpc.listener.ReceiveMsgListener;
import com.blued.android.chat.grpc.utils.ChatLog;
import com.blued.android.chat.grpc.utils.MsgConverter;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.module.im.IM;
import com.blued.android.module.im.biz.privatechat.OnPrivateChatResponseListener;
import com.blued.im.private_chat.PrivateChatOuterClass;
import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/grpc/core/chat/PrivateChatController.class */
public class PrivateChatController extends BaseWorker implements MsgConsumer {
    private static final String TAG = PrivateChatController.class.getSimpleName();
    private ChatTipsListener chatTipsListener;
    private Connector connector;
    private DBOper dbOperImpl;
    private final HashMap<String, HashSet<MsgContentListener>> msgListenerMap = new HashMap<>();

    public PrivateChatController(Connector connector) {
        if (connector == null) {
            throw new RuntimeException(" connector is null");
        }
        this.connector = connector;
    }

    @Override // com.blued.android.chat.grpc.listener.MsgConsumer
    public boolean consumeMsg(Any any) {
        if (any.is(PrivateChatOuterClass.Receive.class)) {
            try {
                PrivateChatOuterClass.Receive unpack = any.unpack(PrivateChatOuterClass.Receive.class);
                if (unpack != null) {
                    ChatManager.getInstance().onReceiveMsgFromGRPC(MsgConverter.convertReceiveMsg(unpack), unpack.getIsRead(), unpack.getIsDeleted());
                    return true;
                }
                return true;
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
                return true;
            }
        }
        return false;
    }

    @Override // com.blued.android.chat.grpc.core.BaseWorker
    public void onStart() {
        super.onStart();
        this.connector.registerMsgConsumer(this);
    }

    @Override // com.blued.android.chat.grpc.core.BaseWorker
    public void onStop() {
        super.onStop();
        this.connector.unregisterMsgConsumer(this);
    }

    public void registerChatTipsListener(ChatTipsListener chatTipsListener) {
        this.chatTipsListener = chatTipsListener;
        Connector connector = this.connector;
        if (connector != null) {
            connector.registerConnectListener(chatTipsListener);
        }
    }

    public void registerMsgContentListener(short s, long j, MsgContentListener msgContentListener) {
        ChatLog.d(TAG, "registerMsgContentListener");
        synchronized (this.msgListenerMap) {
            String sessionKey = SessionHeader.getSessionKey(s, j);
            HashSet<MsgContentListener> hashSet = this.msgListenerMap.get(sessionKey);
            HashSet<MsgContentListener> hashSet2 = hashSet;
            if (hashSet == null) {
                hashSet2 = new HashSet<>();
                this.msgListenerMap.put(sessionKey, hashSet2);
            }
            hashSet2.add(msgContentListener);
        }
    }

    public void sendMsg(final ChattingModel chattingModel) {
        final ChattingModel chattingModel2 = new ChattingModel(chattingModel);
        if (chattingModel2.isMatchMsg == 1 && chattingModel2.sessionId < 0) {
            chattingModel2.sessionId = -chattingModel2.sessionId;
        }
        OnPrivateChatResponseListener onPrivateChatResponseListener = new OnPrivateChatResponseListener() { // from class: com.blued.android.chat.grpc.core.chat.PrivateChatController.1
            @Override // com.blued.android.module.im.biz.privatechat.OnPrivateChatResponseListener
            public void onFailure(int i, int i2, Exception exc) {
                String str = PrivateChatController.TAG;
                Log.e(str, "grpc error: " + i2 + " || exception : " + exc);
                ChatManager chatManager = ChatManager.getInstance();
                int convertErrorCode = MsgConverter.convertErrorCode(i2);
                ChattingModel chattingModel3 = chattingModel2;
                chatManager.notifySendStateForGRPC(convertErrorCode, chattingModel3, chattingModel3.sessionType, chattingModel.sessionId, chattingModel2.msgType, chattingModel2.msgId, (long) i, chattingModel2.msgTimestamp, "");
            }

            @Override // com.blued.android.module.im.biz.privatechat.OnPrivateChatResponseListener
            public void onSuccess(int i, long j, long j2, String str) {
                ChatManager chatManager = ChatManager.getInstance();
                ChattingModel chattingModel3 = chattingModel2;
                chatManager.notifySendStateForGRPC(0, chattingModel3, chattingModel3.sessionType, chattingModel2.sessionId, chattingModel2.msgType, j, i, j2, str);
            }
        };
        if (chattingModel2.sessionType == 3) {
            IM.b(chattingModel.msgType, (int) chattingModel.msgLocalId, (int) chattingModel.toId, (int) chattingModel.fromId, MsgConverter.convertGRPCMsgBody(chattingModel2), onPrivateChatResponseListener);
        } else {
            IM.a(chattingModel.msgType, (int) chattingModel.msgLocalId, (int) chattingModel.toId, (int) chattingModel.fromId, MsgConverter.convertGRPCMsgBody(chattingModel2), onPrivateChatResponseListener);
        }
    }

    public void setDbOperImpl(DBOper dBOper) {
        if (dBOper == null) {
            throw new RuntimeException(" dbOperImpl is null");
        }
        this.dbOperImpl = dBOper;
    }

    public void unregisterMsgContentListener(short s, long j, ReceiveMsgListener receiveMsgListener) {
        ChatLog.d(TAG, "unRegisterMsgContentListener");
        synchronized (this.msgListenerMap) {
            HashSet<MsgContentListener> hashSet = this.msgListenerMap.get(SessionHeader.getSessionKey(s, j));
            if (hashSet != null) {
                hashSet.remove(receiveMsgListener);
            }
        }
    }
}
