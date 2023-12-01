package com.blued.android.chat;

import android.os.Handler;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.worker.chat.WawajiChat;
import com.blued.android.chat.data.ProfileData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/WawajiChatHelper.class */
public class WawajiChatHelper implements WawajiChat.IWawajiChatCallback {
    public static int MAX_VIEWER_COUNT_CALLBACK = 3;
    public static int MAX_VIEWER_COUNT_MEMORY = 30;
    private static final String TAG = "Chat_WawajiChat";
    private WawajiChatCallback callback;
    private Handler callbackHandler;
    private long sessionId;
    private ChatState chatState = ChatState.IDLE;
    private List<ProfileData> viewerList = new ArrayList();
    private List<ProfileData> viewerListCallback = new ArrayList();
    private WawajiChat wawajiChat = ChatManager.getInstance().registerWawajiHelper(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/WawajiChatHelper$ChatState.class */
    public enum ChatState {
        IDLE,
        ENTER,
        DEAD
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/WawajiChatHelper$WawajiChatCallback.class */
    public interface WawajiChatCallback {
        void onEnterFailed();

        void onEnterSuccess(int i, int i2, int i3, int i4, int i5, int i6, String str, String str2, String str3, Map<String, Object> map);

        void onGameResultUpdate(ProfileData profileData, int i, String str, String str2, String str3, int i2, Map<String, Object> map);

        void onPlayerUpdate(ProfileData profileData);

        void onQueueUpCountUpdate(int i);

        void onQueueUpFailed();

        void onQueueUpRankUpdate(int i);

        void onQueueUpSuccess(int i);

        void onViewerIn(ProfileData profileData);

        void onViewerUpdate(int i, List<ProfileData> list);
    }

    public WawajiChatHelper(long j, WawajiChatCallback wawajiChatCallback, Handler handler) {
        this.callback = wawajiChatCallback;
        this.callbackHandler = handler;
        this.sessionId = j;
        if (ChatManager.debug) {
            Log.v(TAG, "初始化娃娃机直播间, sessionId:" + j);
        }
    }

    private void addViewer(ProfileData profileData) {
        synchronized (this.viewerList) {
            this.viewerList.add(0, profileData);
        }
    }

    private boolean checkOperation(long j, ChatState chatState) {
        if (this.sessionId != j) {
            if (ChatManager.debug) {
                Log.e(TAG, "sessionId不匹配, 不进行该操作, 当前sessionId:" + this.sessionId + ", 通知sessionId:" + j);
                return false;
            }
            return false;
        } else if (this.chatState != chatState) {
            if (ChatManager.debug) {
                Log.e(TAG, "当前状态不对, 不进行该操作, 当前chatState:" + this.chatState + ", 期待:" + ChatState.ENTER);
                return false;
            }
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void collateViewerCallback() {
        this.viewerListCallback.clear();
        synchronized (this.viewerList) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= MAX_VIEWER_COUNT_CALLBACK || this.viewerList.size() <= i2) {
                    break;
                }
                this.viewerListCallback.add(this.viewerList.get(i2));
                i = i2 + 1;
            }
        }
    }

    private void initViewerList(List<ProfileData> list) {
        synchronized (this.viewerList) {
            if (list != null) {
                this.viewerList.clear();
                this.viewerList.addAll(list);
            }
        }
    }

    private void leaveRoom() {
        setState(ChatState.DEAD);
        this.wawajiChat.leaveRoom(this.sessionId);
    }

    private void notifyCallback(Runnable runnable) {
        Handler handler = this.callbackHandler;
        if (handler != null) {
            handler.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void removeViewer(ProfileData profileData) {
        synchronized (this.viewerList) {
            Iterator<ProfileData> it = this.viewerList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().uid == profileData.uid) {
                    it.remove();
                    break;
                }
            }
        }
    }

    private void setState(ChatState chatState) {
        if (ChatManager.debug) {
            Log.v(TAG, "current state:" + this.chatState + ", change to:" + chatState);
        }
        this.chatState = chatState;
    }

    private void trimViewerList() {
        synchronized (this.viewerList) {
            while (this.viewerList.size() > MAX_VIEWER_COUNT_MEMORY) {
                this.viewerList.remove(this.viewerList.size() - 1);
            }
        }
    }

    public void cancelQueueUp() {
        if (ChatManager.debug) {
            Log.v(TAG, "执行取消抢位操作");
        }
        if (checkOperation(this.sessionId, ChatState.ENTER)) {
            this.wawajiChat.cancelQueueUp(this.sessionId);
        }
    }

    public void destroy() {
        if (ChatManager.debug) {
            Log.v(TAG, "销毁娃娃机直播间");
        }
        setState(ChatState.DEAD);
        leaveRoom();
        this.wawajiChat = null;
        ChatManager.getInstance().unregisterWawajiHelper(this);
    }

    public void enter() {
        if (ChatManager.debug) {
            Log.v(TAG, "执行加入房间");
        }
        if (checkOperation(this.sessionId, ChatState.IDLE)) {
            this.wawajiChat.enterRoom(this.sessionId);
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiChat.IWawajiChatCallback
    public void onCancelQueueUpFailed(long j, String str) {
        if (ChatManager.debug) {
            Log.v(TAG, "取消排队抢位失败, errorMsg:" + str + ", sessionId:" + j);
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiChat.IWawajiChatCallback
    public void onCancelQueueUpSuccess(long j) {
        if (ChatManager.debug) {
            Log.v(TAG, "取消排队抢位成功, sessionId:" + j);
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiChat.IWawajiChatCallback
    public void onEnterRoomFailed(long j, String str) {
        if (ChatManager.debug) {
            Log.e(TAG, "进入房间失败, errorMsg:" + str + ", sessionId:" + j);
        }
        if (checkOperation(j, ChatState.IDLE)) {
            notifyCallback(new Runnable() { // from class: com.blued.android.chat.WawajiChatHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    WawajiChatHelper.this.callback.onEnterFailed();
                }
            });
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiChat.IWawajiChatCallback
    public void onEnterRoomSuccess(long j, final int i, final int i2, final int i3, final int i4, final int i5, final int i6, final String str, final String str2, final String str3, final Map<String, Object> map) {
        if (ChatManager.debug) {
            Log.v(TAG, "进入房间成功");
        }
        if (checkOperation(j, ChatState.IDLE)) {
            setState(ChatState.ENTER);
            notifyCallback(new Runnable() { // from class: com.blued.android.chat.WawajiChatHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    WawajiChatHelper.this.callback.onEnterSuccess(i, i2, i3, i4, i5, i6, str, str2, str3, map);
                }
            });
            this.wawajiChat.getRoomInfo(j);
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiChat.IWawajiChatCallback
    public void onGameResultUpdate(long j, final int i, final ProfileData profileData, String str, String str2, final String str3, final String str4, final int i2, final Map<String, Object> map) {
        if (ChatManager.debug) {
            Log.v(TAG, "娃娃机游戏结果通知, sessionId:" + j + ", result:" + i + ", tipsPlayer:" + str + ", tipsViewer:" + str2 + ", wawaImage:" + str3 + ", wawaName:" + str4 + ", giftBonus:" + i2 + ", player:" + profileData);
        }
        if (checkOperation(j, ChatState.ENTER)) {
            if (profileData == null || profileData.uid != ChatManager.getInstance().getUid()) {
                str = str2;
            }
            final String str5 = str;
            notifyCallback(new Runnable() { // from class: com.blued.android.chat.WawajiChatHelper.9
                @Override // java.lang.Runnable
                public void run() {
                    WawajiChatHelper.this.callback.onGameResultUpdate(profileData, i, str5, str3, str4, i2, map);
                }
            });
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiChat.IWawajiChatCallback
    public void onGetInfoFailed(long j, String str) {
        if (ChatManager.debug) {
            Log.e(TAG, "获取房间信息失败, errorMsg:" + str);
        }
        checkOperation(j, ChatState.ENTER);
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiChat.IWawajiChatCallback
    public void onGetInfoSuccess(long j) {
        if (ChatManager.debug) {
            Log.v(TAG, "获取房间信息成功");
        }
        checkOperation(j, ChatState.ENTER);
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiChat.IWawajiChatCallback
    public void onIMConnected() {
        if (ChatManager.debug) {
            Log.v(TAG, "IM重新连接上了，娃娃机尝试recover, sessionId:" + this.sessionId);
        }
        this.wawajiChat.recover(this.sessionId);
        this.wawajiChat.getRoomInfo(this.sessionId);
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiChat.IWawajiChatCallback
    public void onLeaveRoomFailed(long j, String str) {
        if (ChatManager.debug) {
            Log.e(TAG, "离开房间失败, errorMsg:" + str);
        }
        checkOperation(j, ChatState.DEAD);
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiChat.IWawajiChatCallback
    public void onLeaveRoomSuccess(long j) {
        if (ChatManager.debug) {
            Log.v(TAG, "离开房间成功");
        }
        checkOperation(j, ChatState.DEAD);
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiChat.IWawajiChatCallback
    public void onPlayerUpdate(long j, final ProfileData profileData) {
        if (ChatManager.debug) {
            Log.v(TAG, "玩家变化通知, sessionId:" + j + ", playerData:" + profileData);
        }
        if (checkOperation(j, ChatState.ENTER)) {
            notifyCallback(new Runnable() { // from class: com.blued.android.chat.WawajiChatHelper.7
                @Override // java.lang.Runnable
                public void run() {
                    WawajiChatHelper.this.callback.onPlayerUpdate(profileData);
                }
            });
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiChat.IWawajiChatCallback
    public void onQueueCountUpdate(long j, final int i) {
        if (ChatManager.debug) {
            Log.v(TAG, "排队总数变化通知, count:" + i);
        }
        if (checkOperation(j, ChatState.ENTER)) {
            notifyCallback(new Runnable() { // from class: com.blued.android.chat.WawajiChatHelper.5
                @Override // java.lang.Runnable
                public void run() {
                    WawajiChatHelper.this.callback.onQueueUpCountUpdate(i);
                }
            });
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiChat.IWawajiChatCallback
    public void onQueueRankUpdate(long j, final int i) {
        if (ChatManager.debug) {
            Log.v(TAG, "自己的排位变化通知, rank:" + i);
        }
        if (checkOperation(j, ChatState.ENTER)) {
            notifyCallback(new Runnable() { // from class: com.blued.android.chat.WawajiChatHelper.6
                @Override // java.lang.Runnable
                public void run() {
                    WawajiChatHelper.this.callback.onQueueUpRankUpdate(i);
                }
            });
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiChat.IWawajiChatCallback
    public void onQueueUpFailed(long j, String str) {
        if (ChatManager.debug) {
            Log.e(TAG, "排队抢位失败, errorMsg:" + str);
        }
        if (checkOperation(j, ChatState.ENTER)) {
            notifyCallback(new Runnable() { // from class: com.blued.android.chat.WawajiChatHelper.3
                @Override // java.lang.Runnable
                public void run() {
                    WawajiChatHelper.this.callback.onQueueUpFailed();
                }
            });
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiChat.IWawajiChatCallback
    public void onQueueUpSuccess(long j, final int i) {
        if (ChatManager.debug) {
            Log.v(TAG, "排队抢位成功, rank:" + i);
        }
        if (checkOperation(j, ChatState.ENTER)) {
            notifyCallback(new Runnable() { // from class: com.blued.android.chat.WawajiChatHelper.4
                @Override // java.lang.Runnable
                public void run() {
                    WawajiChatHelper.this.callback.onQueueUpSuccess(i);
                }
            });
        }
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiChat.IWawajiChatCallback
    public void onViewIn(long j, final ProfileData profileData, final int i) {
        if (ChatManager.debug) {
            Log.v(TAG, "加入娃娃机, count:" + i + ", viewerIn:" + profileData);
        }
        removeViewer(profileData);
        addViewer(profileData);
        trimViewerList();
        notifyCallback(new Runnable() { // from class: com.blued.android.chat.WawajiChatHelper.10
            @Override // java.lang.Runnable
            public void run() {
                WawajiChatHelper.this.collateViewerCallback();
                WawajiChatHelper.this.callback.onViewerUpdate(i, WawajiChatHelper.this.viewerListCallback);
                WawajiChatHelper.this.callback.onViewerIn(profileData);
            }
        });
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiChat.IWawajiChatCallback
    public void onViewOut(long j, ProfileData profileData, final int i) {
        if (ChatManager.debug) {
            Log.v(TAG, "退出娃娃机, count:" + i + ", viewerOut:" + profileData);
        }
        removeViewer(profileData);
        trimViewerList();
        notifyCallback(new Runnable() { // from class: com.blued.android.chat.WawajiChatHelper.11
            @Override // java.lang.Runnable
            public void run() {
                WawajiChatHelper.this.collateViewerCallback();
                WawajiChatHelper.this.callback.onViewerUpdate(i, WawajiChatHelper.this.viewerListCallback);
            }
        });
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiChat.IWawajiChatCallback
    public void onViewerUpdate(long j, final int i, List<ProfileData> list) {
        if (ChatManager.debug) {
            Log.v(TAG, "娃娃机房间观众更新, sessionId:" + j + ", count:" + i);
        }
        if (checkOperation(j, ChatState.ENTER)) {
            initViewerList(list);
            trimViewerList();
            notifyCallback(new Runnable() { // from class: com.blued.android.chat.WawajiChatHelper.8
                @Override // java.lang.Runnable
                public void run() {
                    WawajiChatHelper.this.collateViewerCallback();
                    WawajiChatHelper.this.callback.onViewerUpdate(i, WawajiChatHelper.this.viewerListCallback);
                }
            });
        }
    }

    public void queueUp() {
        if (ChatManager.debug) {
            Log.v(TAG, "执行抢位操作");
        }
        if (checkOperation(this.sessionId, ChatState.ENTER)) {
            this.wawajiChat.queueUp(this.sessionId);
        }
    }
}
