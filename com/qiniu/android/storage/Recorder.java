package com.qiniu.android.storage;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/storage/Recorder.class */
public interface Recorder {
    void del(String str);

    byte[] get(String str);

    String getFileName();

    void set(String str, byte[] bArr);
}
