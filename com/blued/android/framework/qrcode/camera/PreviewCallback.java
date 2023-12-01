package com.blued.android.framework.qrcode.camera;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/blued/android/framework/qrcode/camera/PreviewCallback.class */
public final class PreviewCallback implements Camera.PreviewCallback {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6660a = PreviewCallback.class.getSimpleName();
    private final CameraConfigurationManager b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f6661c;
    private Handler d;
    private int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PreviewCallback(CameraConfigurationManager cameraConfigurationManager, boolean z) {
        this.b = cameraConfigurationManager;
        this.f6661c = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Handler handler, int i) {
        this.d = handler;
        this.e = i;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point a2 = this.b.a();
        if (!this.f6661c) {
            camera.setPreviewCallback(null);
        }
        Handler handler = this.d;
        if (handler == null) {
            Log.d(f6660a, "Got preview callback, but no handler for it");
            return;
        }
        handler.obtainMessage(this.e, a2.x, a2.y, bArr).sendToTarget();
        this.d = null;
    }
}
