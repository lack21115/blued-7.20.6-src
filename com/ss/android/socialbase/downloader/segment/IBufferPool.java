package com.ss.android.socialbase.downloader.segment;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/segment/IBufferPool.class */
public interface IBufferPool {
    Buffer obtain() throws StreamClosedException, InterruptedException;

    void recycle(Buffer buffer);
}
