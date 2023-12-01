package com.qiniu.pili.droid.streaming;

import android.hardware.Camera;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/StreamingSessionListener.class */
public interface StreamingSessionListener {
    int onPreviewFpsSelected(List<int[]> list);

    Camera.Size onPreviewSizeSelected(List<Camera.Size> list);

    boolean onRecordAudioFailedHandled(int i);

    boolean onRestartStreamingHandled(int i);
}
