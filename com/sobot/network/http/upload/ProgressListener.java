package com.sobot.network.http.upload;

import com.sobot.network.http.model.SobotProgress;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/upload/ProgressListener.class */
public interface ProgressListener<T> {
    void onError(SobotProgress sobotProgress);

    void onFinish(T t, SobotProgress sobotProgress);

    void onProgress(SobotProgress sobotProgress);

    void onRemove(SobotProgress sobotProgress);

    void onStart(SobotProgress sobotProgress);
}
