package com.sobot.chat.camera.listener;

import android.graphics.Bitmap;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/listener/StCameraListener.class */
public interface StCameraListener {
    void captureSuccess(Bitmap bitmap);

    void recordSuccess(String str, Bitmap bitmap);
}
