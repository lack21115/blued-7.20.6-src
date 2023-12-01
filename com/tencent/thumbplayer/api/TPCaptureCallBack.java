package com.tencent.thumbplayer.api;

import android.graphics.Bitmap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCaptureCallBack.class */
public interface TPCaptureCallBack {
    void onCaptureVideoFailed(int i);

    void onCaptureVideoSuccess(Bitmap bitmap);
}
