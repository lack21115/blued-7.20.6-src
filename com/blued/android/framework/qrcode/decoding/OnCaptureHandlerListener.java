package com.blued.android.framework.qrcode.decoding;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import com.google.zxing.Result;

/* loaded from: source-8756600-dex2jar.jar:com/blued/android/framework/qrcode/decoding/OnCaptureHandlerListener.class */
public interface OnCaptureHandlerListener {
    void a(int i, Intent intent);

    void a(Intent intent);

    void a(Result result, Bitmap bitmap);

    Rect ap_();

    Handler aq_();
}
