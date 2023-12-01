package com.blued.android.chat.core.worker.chat;

import android.util.Pair;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.pack.PushMsgPackage;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.listener.ChatTipsListener;
import com.blued.android.chat.model.ChattingModel;
import java.util.ArrayList;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/chat/RoomChat.class */
public class RoomChat {
    private static final String TAG = "Chat_RoomChat";
    Chat chat;
    private long singleRoomId;

    public RoomChat(Chat chat) {
        if (ChatManager.debug) {
            Log.v(TAG, "LiveChat() create");
        }
        this.chat = chat;
        chat.roomChat = this;
    }

    private boolean handleRoomPushMessage(PushMsgPackage pushMsgPackage) {
        if (pushMsgPackage.msgType == 110 || pushMsgPackage.msgType == 111 || pushMsgPackage.msgType == 112) {
            ChattingModel msgData = PushMsgPackage.toMsgData(pushMsgPackage);
            ChatTipsListener tipsListener = ChatManager.getInstance().getTipsListener();
            if (tipsListener != null) {
                tipsListener.onRecvNewMsg(null, msgData);
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean isRoomMessage(PushMsgPackage pushMsgPackage) {
        return pushMsgPackage != null && pushMsgPackage.sessionType == 7 && pushMsgPackage.sessionId == this.singleRoomId;
    }

    private void removeRoomSessionAndMessage(long j) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair((short) 7, Long.valueOf(j)));
        this.chat.deleteSessions(arrayList, true);
    }

    private void setupRoomSession(long j) {
        this.chat.insertEmptySession((short) 7, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean handleRoomMessage(PushMsgPackage pushMsgPackage) {
        if (ChatManager.debug) {
            Log.v(TAG, "handleRoomMessage() pushMsgPackage:" + pushMsgPackage);
        }
        if (isRoomMessage(pushMsgPackage)) {
            return handleRoomPushMessage(pushMsgPackage);
        } else if (ChatManager.debug) {
            Log.v(TAG, "it is not current room message, drop it.");
            return true;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setupRoomId(long j) {
        if (ChatManager.debug) {
            Log.v(TAG, "setupRoomId() roomId:" + j);
        }
        this.singleRoomId = j;
    }

    public void switchRoomId(long j) {
        if (ChatManager.debug) {
            Log.v(TAG, "switchRoomId(), currentRoomId:" + this.singleRoomId + ", newRoodId:" + j);
        }
        long j2 = this.singleRoomId;
        if (j2 == j) {
            return;
        }
        this.singleRoomId = j;
        removeRoomSessionAndMessage(j2);
        if (j > 0) {
            setupRoomSession(j);
        }
    }
}
