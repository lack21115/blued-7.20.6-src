package com.sobot.chat.camera.state;

import android.view.Surface;
import android.view.SurfaceHolder;
import com.sobot.chat.camera.CameraInterface;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/state/State.class */
public interface State {
    void cancle(SurfaceHolder surfaceHolder, float f);

    void capture();

    void confirm();

    void flash(String str);

    void foucs(float f, float f2, CameraInterface.FocusCallback focusCallback);

    void record(Surface surface, float f);

    void restart();

    void start(SurfaceHolder surfaceHolder, float f);

    void stop();

    void stopRecord(boolean z, long j);

    void swtich(SurfaceHolder surfaceHolder, float f);

    void zoom(float f, int i);
}
