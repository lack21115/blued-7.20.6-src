package com.ss.android.socialbase.downloader.segment;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/segment/IInput.class */
public interface IInput {
    Buffer read() throws StreamClosedException, InterruptedException;
}
