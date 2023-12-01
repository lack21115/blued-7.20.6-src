package com.blued.android.chat;

import com.blued.android.chat.listener.IMStatusListener;
import com.blued.android.core.AppInfo;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/StableIMConnectListener.class */
public abstract class StableIMConnectListener implements IMStatusListener {
    private static final long MIN_CALLBACK_SPAN_MS = 500;
    private UICallbackTask uiCallback = new UICallbackTask(this, null);
    private long lastNotifyTime = -1;

    /* renamed from: com.blued.android.chat.StableIMConnectListener$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/StableIMConnectListener$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$blued$android$chat$StableIMConnectListener$IMStatus;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[IMStatus.values().length];
            $SwitchMap$com$blued$android$chat$StableIMConnectListener$IMStatus = iArr;
            try {
                iArr[IMStatus.DISCONNECT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$blued$android$chat$StableIMConnectListener$IMStatus[IMStatus.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$blued$android$chat$StableIMConnectListener$IMStatus[IMStatus.CONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$blued$android$chat$StableIMConnectListener$IMStatus[IMStatus.RECEIVING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/StableIMConnectListener$IMStatus.class */
    public enum IMStatus {
        DISCONNECT,
        CONNECTING,
        CONNECTED,
        RECEIVING
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/StableIMConnectListener$UICallbackTask.class */
    public class UICallbackTask implements Runnable {
        private IMStatus _state;

        private UICallbackTask() {
        }

        /* synthetic */ UICallbackTask(StableIMConnectListener stableIMConnectListener, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = AnonymousClass1.$SwitchMap$com$blued$android$chat$StableIMConnectListener$IMStatus[this._state.ordinal()];
            if (i == 1) {
                StableIMConnectListener.this.onUIDisconnected();
            } else if (i == 2) {
                StableIMConnectListener.this.onUIConnecting();
            } else if (i == 3) {
                StableIMConnectListener.this.onUIConnected();
            } else if (i != 4) {
            } else {
                StableIMConnectListener.this.onUIReceiving();
            }
        }

        public void setData(IMStatus iMStatus) {
            this._state = iMStatus;
        }
    }

    private void callBackNewState(IMStatus iMStatus) {
        this.uiCallback.setData(iMStatus);
        AppInfo.n().removeCallbacks(this.uiCallback);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastNotifyTime < 500) {
            AppInfo.n().postDelayed(this.uiCallback, 500L);
            return;
        }
        this.lastNotifyTime = currentTimeMillis;
        AppInfo.n().post(this.uiCallback);
    }

    @Override // com.blued.android.chat.listener.IMStatusListener
    public final void onConnected() {
        callBackNewState(IMStatus.CONNECTED);
    }

    @Override // com.blued.android.chat.listener.IMStatusListener
    public final void onConnecting() {
        callBackNewState(IMStatus.CONNECTING);
    }

    @Override // com.blued.android.chat.listener.IMStatusListener
    public final void onDisconnected() {
        callBackNewState(IMStatus.DISCONNECT);
    }

    @Override // com.blued.android.chat.listener.IMStatusListener
    public final void onReceiving() {
        callBackNewState(IMStatus.RECEIVING);
    }

    public abstract void onUIConnected();

    public abstract void onUIConnecting();

    public abstract void onUIDisconnected();

    public abstract void onUIReceiving();

    public void reset() {
        this.lastNotifyTime = -1L;
    }
}
