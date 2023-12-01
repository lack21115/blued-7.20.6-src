package com.ss.android.socialbase.downloader.segment;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/segment/Buffer.class */
public final class Buffer {
    public final byte[] data;
    public Buffer next;
    IOutput output;
    public int size;

    public Buffer(int i) {
        this.data = new byte[i];
    }
}
