package com.blued.android.chat;

import android.os.Handler;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.worker.chat.WawajiChat;
import com.blued.android.chat.data.ProfileData;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/WawajiResultReceiveHelper.class */
public class WawajiResultReceiveHelper implements WawajiChat.IWawajiResultCallback {
    private static final String TAG = "Chat_WawajiResultReceivet";
    private Handler callbackHandler;
    private IWawajiResultCallback resultCallback;
    private WawajiChat wawajiChat;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/WawajiResultReceiveHelper$IWawajiResultCallback.class */
    public interface IWawajiResultCallback {
        void onSuccess(ProfileData profileData, String str, String str2);
    }

    public WawajiResultReceiveHelper(IWawajiResultCallback iWawajiResultCallback, Handler handler) {
        this.resultCallback = iWawajiResultCallback;
        this.callbackHandler = handler;
        if (ChatManager.debug) {
            Log.v(TAG, "初始化娃娃机结果接收监听");
        }
    }

    private void notifyCallback(Runnable runnable) {
        Handler handler = this.callbackHandler;
        if (handler != null) {
            handler.post(runnable);
        } else {
            runnable.run();
        }
    }

    public void destroy() {
        if (ChatManager.debug) {
            Log.v(TAG, "销毁娃娃机结果接收监听");
        }
        ChatManager.getInstance().unregisterWawajiResultReceiveHelper(this);
        this.wawajiChat = null;
    }

    @Override // com.blued.android.chat.core.worker.chat.WawajiChat.IWawajiResultCallback
    public final void onGameResultReceive(long j, int i, final ProfileData profileData, final String str, String str2, final String str3) {
        if (ChatManager.debug) {
            Log.v(TAG, "接收到娃娃机结果, result:" + i + ", wawaName:" + str3 + ", player:" + profileData);
        }
        if (i == 1) {
            notifyCallback(new Runnable() { // from class: com.blued.android.chat.WawajiResultReceiveHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    WawajiResultReceiveHelper.this.resultCallback.onSuccess(profileData, str, str3);
                }
            });
        }
    }

    public void start() {
        if (ChatManager.debug) {
            Log.v(TAG, "开始娃娃机结果接收");
        }
        WawajiChat registerWawajiResultReceiveHelper = ChatManager.getInstance().registerWawajiResultReceiveHelper(this);
        this.wawajiChat = registerWawajiResultReceiveHelper;
        registerWawajiResultReceiveHelper.startReceiveAllGameResult();
    }

    public void stop() {
        if (ChatManager.debug) {
            Log.v(TAG, "停止娃娃机结果接收");
        }
        WawajiChat wawajiChat = this.wawajiChat;
        if (wawajiChat != null) {
            wawajiChat.stopReceiveAllGameResult();
        }
        ChatManager.getInstance().unregisterWawajiResultReceiveHelper(this);
        this.wawajiChat = null;
    }
}
