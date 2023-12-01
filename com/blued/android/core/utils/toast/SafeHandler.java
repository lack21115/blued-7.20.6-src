package com.blued.android.core.utils.toast;

import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/SafeHandler.class */
final class SafeHandler extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f9754a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SafeHandler(Handler handler) {
        this.f9754a = handler;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            this.f9754a.handleMessage(message);
        } catch (WindowManager.BadTokenException | IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
