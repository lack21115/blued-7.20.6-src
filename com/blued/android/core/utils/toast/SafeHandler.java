package com.blued.android.core.utils.toast;

import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/SafeHandler.class */
final class SafeHandler extends Handler {
    private final Handler a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SafeHandler(Handler handler) {
        this.a = handler;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            this.a.handleMessage(message);
        } catch (WindowManager.BadTokenException | IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
