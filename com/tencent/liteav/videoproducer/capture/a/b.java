package com.tencent.liteav.videoproducer.capture.a;

import android.hardware.Camera;
import com.tencent.liteav.base.util.LiteavLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/a/b.class */
public final /* synthetic */ class b implements Camera.AutoFocusCallback {

    /* renamed from: a  reason: collision with root package name */
    private static final b f23163a = new b();

    private b() {
    }

    public static Camera.AutoFocusCallback a() {
        return f23163a;
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public final void onAutoFocus(boolean z, Camera camera) {
        LiteavLog.d("CameraController", "onAutoFocus success: %b", Boolean.valueOf(z));
    }
}
