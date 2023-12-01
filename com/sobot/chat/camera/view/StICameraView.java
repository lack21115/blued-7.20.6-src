package com.sobot.chat.camera.view;

import android.graphics.Bitmap;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/view/StICameraView.class */
public interface StICameraView {
    void confirmState(int i);

    boolean handlerFoucs(float f, float f2);

    void playVideo(Bitmap bitmap, String str);

    void resetState(int i);

    void setTip(String str);

    void showPicture(Bitmap bitmap, boolean z);

    void startPreviewCallback();

    void stopVideo();
}
