package com.blued.android.framework.qrcode.camera;

import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;
import com.igexin.push.config.c;

/* loaded from: source-8756600-dex2jar.jar:com/blued/android/framework/qrcode/camera/AutoFocusCallback.class */
final class AutoFocusCallback implements Camera.AutoFocusCallback {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6652a = AutoFocusCallback.class.getSimpleName();
    private Handler b;

    /* renamed from: c  reason: collision with root package name */
    private int f6653c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Handler handler, int i) {
        this.b = handler;
        this.f6653c = i;
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public void onAutoFocus(boolean z, Camera camera) {
        Handler handler = this.b;
        if (handler == null) {
            Log.d(f6652a, "Got auto-focus callback, but no handler for it");
            return;
        }
        this.b.sendMessageDelayed(handler.obtainMessage(this.f6653c, Boolean.valueOf(z)), c.j);
        this.b = null;
    }
}
