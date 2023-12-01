package com.sobot.chat.camera.listener;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/listener/StCaptureListener.class */
public interface StCaptureListener {
    void recordEnd(long j);

    void recordError();

    void recordShort(long j);

    void recordStart();

    void recordZoom(float f);

    void takePictures();
}
