package com.blued.android.module.shortvideo.contract;

import android.graphics.Bitmap;
import com.qiniu.pili.droid.shortvideo.PLVideoFrame;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/contract/IStvVideoFrameCallback.class */
public interface IStvVideoFrameCallback<T> {
    void a(T t, PLVideoFrame pLVideoFrame, Bitmap bitmap, String str);
}
