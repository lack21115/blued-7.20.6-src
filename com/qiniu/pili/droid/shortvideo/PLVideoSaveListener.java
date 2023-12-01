package com.qiniu.pili.droid.shortvideo;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLVideoSaveListener.class */
public interface PLVideoSaveListener {
    void onProgressUpdate(float f);

    void onSaveVideoCanceled();

    void onSaveVideoFailed(int i);

    void onSaveVideoSuccess(String str);
}
