package com.blued.android.chat;

import android.os.Handler;
import android.util.Log;
import com.blued.android.chat.core.worker.chat.VideoChat;
import com.blued.android.chat.model.ChattingModel;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/VideoChatHelper.class */
public class VideoChatHelper implements VideoChat.IVideoChatCallback {
    private static final String TAG = "Chat_VideoChatHelper";
    private CallInfoListener callInfoListener;
    private CallListener callListener;
    private CallMsgListener callMsgListener;
    private Handler callbackHandler;
    private long callingMsgId;
    public final int chatSdkType;
    public final long communicateUid;
    private int consumeBeans;
    private boolean destroyed = false;
    public final ROLE role;
    public final String roomId;
    public final int roomType;
    final VideoChat videoChatImpl;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/VideoChatHelper$CallFailed.class */
    public enum CallFailed {
        SERVER_LIMIT,
        APP_NOT_SUPPORT,
        APP_NOT_ONLINE,
        APP_NOT_RECEIVE,
        NETWORK,
        UNKNOWN
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/VideoChatHelper$CallInfoListener.class */
    public interface CallInfoListener {
        void onCallClose(int i);

        void onCallLeftTime(int i, int i2);

        void onCallLeftTimeFail();

        void onSwitchToAudio();
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/VideoChatHelper$CallListener.class */
    public interface CallListener {
        void onCallFailed(CallFailed callFailed, String str, int i);

        void onCallSuccess(int i, int i2, boolean z, String str, int i3);
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/VideoChatHelper$CallMsgListener.class */
    public interface CallMsgListener {
        void onReceiveText(ChattingModel chattingModel);
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/VideoChatHelper$CloseType.class */
    public interface CloseType {
        public static final int BUSY_BY_RECEIVER = 6;
        public static final int CANCEL_BY_CALLER = 3;
        public static final int HANGUP_BY_CALLER = 1;
        public static final int HANGUP_BY_RECEIVER = 2;
        public static final int REJECT_BY_RECEIVER = 4;
        public static final int TIMEOUT_BY_CALLER = 5;
        public static final int TIMEOUT_BY_RECEIVER = 7;
        public static final int UNKNOWN = 0;
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/VideoChatHelper$ROLE.class */
    public enum ROLE {
        CALLER,
        RECEIVER
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/VideoChatHelper$RoomType.class */
    public interface RoomType {
        public static final int AUDIO = 1;
        public static final int VIDEO = 2;
    }

    public VideoChatHelper(ROLE role, long j, String str, int i, int i2, CallInfoListener callInfoListener, CallMsgListener callMsgListener) {
        if (ChatManager.debug) {
            Log.v(TAG, "VideoChatHelper(), selfRole:" + role + ", communicateUid:" + j + ", roomId:" + str);
        }
        this.role = role;
        this.communicateUid = j;
        this.roomId = str;
        this.roomType = i;
        this.chatSdkType = i2;
        this.callInfoListener = callInfoListener;
        this.callMsgListener = callMsgListener;
        this.videoChatImpl = ChatManager.getInstance().registerVideoChatHelper(this);
    }

    private void notifyCallFailed(final CallFailed callFailed, final String str, final int i) {
        if (ChatManager.debug) {
            Log.v(TAG, "notifyCallFailed(), failed:" + callFailed + ", failedReason:" + str);
        }
        CallListener callListener = this.callListener;
        if (callListener != null) {
            Handler handler = this.callbackHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.blued.android.chat.VideoChatHelper.3
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoChatHelper.this.callListener.onCallFailed(callFailed, str, i);
                    }
                });
            } else {
                callListener.onCallFailed(callFailed, str, i);
            }
        }
    }

    private void notifyCallLeftTime(final int i, final int i2) {
        if (ChatManager.debug) {
            Log.v(TAG, "notifyCallLeftTime(), leftTimeSec:" + i);
        }
        CallInfoListener callInfoListener = this.callInfoListener;
        if (callInfoListener != null) {
            Handler handler = this.callbackHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.blued.android.chat.VideoChatHelper.6
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoChatHelper.this.callInfoListener.onCallLeftTime(i, i2);
                    }
                });
            } else {
                callInfoListener.onCallLeftTime(i, i2);
            }
        }
    }

    private void notifyCallLeftTimeFail() {
        CallInfoListener callInfoListener = this.callInfoListener;
        if (callInfoListener != null) {
            Handler handler = this.callbackHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.blued.android.chat.VideoChatHelper.7
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoChatHelper.this.callInfoListener.onCallLeftTimeFail();
                    }
                });
            } else {
                callInfoListener.onCallLeftTimeFail();
            }
        }
    }

    private void notifyCallSuccess(final int i, final int i2, final boolean z, final String str, final int i3) {
        if (ChatManager.debug) {
            Log.v(TAG, "notifyCallSuccess(), leftTimeMin:" + i);
        }
        CallListener callListener = this.callListener;
        if (callListener != null) {
            Handler handler = this.callbackHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.blued.android.chat.VideoChatHelper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoChatHelper.this.callListener.onCallSuccess(i, i2, z, str, i3);
                    }
                });
            } else {
                callListener.onCallSuccess(i, i2, z, str, i3);
            }
        }
        CallInfoListener callInfoListener = this.callInfoListener;
        if (callInfoListener != null) {
            Handler handler2 = this.callbackHandler;
            if (handler2 != null) {
                handler2.post(new Runnable() { // from class: com.blued.android.chat.VideoChatHelper.2
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoChatHelper.this.callInfoListener.onCallLeftTime(i, i2);
                    }
                });
            } else {
                callInfoListener.onCallLeftTime(i, i2);
            }
        }
    }

    private void notifyClose(final int i) {
        if (ChatManager.debug) {
            Log.v(TAG, "notifyClose(), closeType:" + i);
        }
        CallInfoListener callInfoListener = this.callInfoListener;
        if (callInfoListener != null) {
            Handler handler = this.callbackHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.blued.android.chat.VideoChatHelper.5
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoChatHelper.this.callInfoListener.onCallClose(i);
                    }
                });
            } else {
                callInfoListener.onCallClose(i);
            }
        }
        destroy();
    }

    private void notifySwitchToAudio() {
        if (ChatManager.debug) {
            Log.v(TAG, "notifySwitchToAudio()");
        }
        CallInfoListener callInfoListener = this.callInfoListener;
        if (callInfoListener != null) {
            Handler handler = this.callbackHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.blued.android.chat.VideoChatHelper.4
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoChatHelper.this.callInfoListener.onSwitchToAudio();
                    }
                });
            } else {
                callInfoListener.onSwitchToAudio();
            }
        }
    }

    private void updateCallMsg(int i, int i2) {
        if (ChatManager.debug) {
            Log.v(TAG, "updateCallMsg(), closeType:" + i + ", callTimeSec:" + i2);
        }
        long j = this.callingMsgId;
        if (j > 0) {
            this.videoChatImpl.updateCallMessage(this.communicateUid, j, i, i2);
        }
    }

    public void answer() {
        if (ChatManager.debug) {
            Log.v(TAG, "answer()");
        }
        if (this.destroyed) {
            return;
        }
        this.videoChatImpl.answer(this.communicateUid, this.roomId, this.roomType, this.consumeBeans);
    }

    public void call(CallListener callListener) {
        if (ChatManager.debug) {
            Log.v(TAG, "call()");
        }
        if (this.destroyed) {
            return;
        }
        this.callListener = callListener;
        this.videoChatImpl.call(this.communicateUid, this.roomId, this.roomType, this.chatSdkType, this.consumeBeans);
    }

    public void cancel(boolean z) {
        if (ChatManager.debug) {
            Log.v(TAG, "cancel(), timeout:" + z);
        }
        if (this.destroyed) {
            return;
        }
        int i = this.role == ROLE.CALLER ? z ? 5 : 3 : z ? 7 : 4;
        this.videoChatImpl.close(this.roomId, i, 0L);
        updateCallMsg(i, 0);
        notifyClose(i);
        destroy();
    }

    public void cancelByBusy() {
        if (ChatManager.debug) {
            Log.v(TAG, "cancelByBusy(), role:" + this.role);
        }
        if (this.destroyed) {
            return;
        }
        this.videoChatImpl.close(this.roomId, 6, 0L);
        updateCallMsg(6, 0);
        notifyClose(6);
        destroy();
    }

    public void destroy() {
        if (ChatManager.debug) {
            Log.v(TAG, "destroy()");
        }
        ChatManager.getInstance().unregisterVideoChatHelper(this);
        this.destroyed = true;
    }

    @Override // com.blued.android.chat.core.worker.chat.VideoChat.IVideoChatCallback
    public long getCallUid() {
        return this.role == ROLE.CALLER ? ChatManager.getInstance().getUid() : this.communicateUid;
    }

    public int getConsumeBeans() {
        return this.consumeBeans;
    }

    public void getLeftTimeAndCount() {
        if (this.destroyed) {
            return;
        }
        this.videoChatImpl.getLeftTimeAndCount();
    }

    @Override // com.blued.android.chat.core.worker.chat.VideoChat.IVideoChatCallback
    public String getRoomId() {
        return this.roomId;
    }

    @Override // com.blued.android.chat.core.worker.chat.VideoChat.IVideoChatCallback
    public int getRoomType() {
        return this.roomType;
    }

    public void hangup(int i) {
        if (ChatManager.debug) {
            Log.v(TAG, "hangup(), callTimeSec:" + i);
        }
        if (this.destroyed) {
            return;
        }
        int i2 = this.role == ROLE.CALLER ? 1 : 2;
        this.videoChatImpl.close(this.roomId, i2, i);
        updateCallMsg(i2, i);
        notifyClose(i2);
    }

    public boolean isDestroyed() {
        return this.destroyed;
    }

    @Override // com.blued.android.chat.core.worker.chat.VideoChat.IVideoChatCallback
    public void onCallFailed(CallFailed callFailed, String str, int i) {
        notifyCallFailed(callFailed, str, i);
    }

    @Override // com.blued.android.chat.core.worker.chat.VideoChat.IVideoChatCallback
    public void onCallSuccess(int i, int i2, boolean z, String str, int i3) {
        notifyCallSuccess(i, i2, z, str, i3);
    }

    @Override // com.blued.android.chat.core.worker.chat.VideoChat.IVideoChatCallback
    public void onClose(int i) {
        notifyClose(i);
    }

    @Override // com.blued.android.chat.core.worker.chat.VideoChat.IVideoChatCallback
    public void onGetLeftTime(int i, int i2) {
        notifyCallLeftTime(i, i2);
    }

    @Override // com.blued.android.chat.core.worker.chat.VideoChat.IVideoChatCallback
    public void onGetLeftTimeFail() {
        notifyCallLeftTimeFail();
    }

    @Override // com.blued.android.chat.core.worker.chat.VideoChat.IVideoChatCallback
    public void onReceiveCallingMsg(long j) {
        if (ChatManager.debug) {
            Log.v(TAG, "onReceiveCallingMsg(), msgId:" + j);
        }
        this.callingMsgId = j;
    }

    @Override // com.blued.android.chat.core.worker.chat.VideoChat.IVideoChatCallback
    public void onReceiveText(long j, ChattingModel chattingModel) {
        if (ChatManager.debug) {
            Log.v(TAG, "onReceiveText(), sessionId:" + j + ", msgContent = " + chattingModel.msgContent);
        }
        CallMsgListener callMsgListener = this.callMsgListener;
        if (callMsgListener != null) {
            callMsgListener.onReceiveText(chattingModel);
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.VideoChat.IVideoChatCallback
    public void onSwitchToAudio() {
        if (ChatManager.debug) {
            Log.v(TAG, "onSwitchToAudio()");
        }
        notifySwitchToAudio();
    }

    public void report(String str) {
        if (ChatManager.debug) {
            Log.v(TAG, "accept()  streamId=" + str + "   , destroyed=" + this.destroyed);
        }
        if (this.destroyed) {
            return;
        }
        this.videoChatImpl.report(str);
    }

    public void sendTextMsg(long j, ChattingModel chattingModel) {
        if (!this.destroyed) {
            this.videoChatImpl.sendMsg(j, chattingModel);
        } else if (ChatManager.debug) {
            Log.e(TAG, "当前状态已经是DESTROY了，不允许再执行send操作");
        }
    }

    public void setCallbackHandler(Handler handler) {
        this.callbackHandler = handler;
    }

    public void setConsumeBeans(int i) {
        this.consumeBeans = i;
    }

    public void switchToAudio() {
        if (ChatManager.debug) {
            Log.v(TAG, "switchToAudio()");
        }
        if (this.destroyed) {
            return;
        }
        this.videoChatImpl.switchToAudio(this.roomId);
    }

    public void updateCallTime(int i) {
        if (ChatManager.debug) {
            Log.v(TAG, "updateCallTime(), chatTimeSec:" + i);
        }
        if (this.destroyed) {
            return;
        }
        this.videoChatImpl.updateCallTimeToServer(this.roomId, i);
    }
}
