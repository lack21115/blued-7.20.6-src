package com.bytedance.android.live.base.api.push;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.base.api.push.model.PushData;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/live/base/api/push/ILivePush.class */
public interface ILivePush {
    public static final String TAG = "livePush";

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/live/base/api/push/ILivePush$ClickType.class */
    public enum ClickType {
        LIVE("live"),
        CLOSE("close");
        
        private final String value;

        ClickType(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/live/base/api/push/ILivePush$PushType.class */
    public enum PushType {
        SELF_DRIVING(1),
        CLOD_LAUNCH(2),
        VIDEO(3);
        
        private final int value;

        PushType(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    void addPushInterceptor(PushInterceptor pushInterceptor);

    void clickPush(PushData pushData, Context context);

    void dismiss();

    void enterRoom(Context context, PushData pushData);

    boolean isShowing();

    void removePushInterceptor(PushInterceptor pushInterceptor);

    void reportPushClick(PushData pushData, ClickType clickType);

    void reportShow(PushData pushData);

    void requestPush(PushCallback pushCallback);

    void requestPushAndShow(boolean z, Activity activity, PushType pushType, PushCallback pushCallback, PushUIConfig pushUIConfig);
}
