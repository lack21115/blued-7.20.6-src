package com.ksad.download;

/* loaded from: source-7994992-dex2jar.jar:com/ksad/download/a.class */
public abstract class a {
    protected int mTaskId;

    public abstract void a(DownloadTask downloadTask);

    public abstract void a(DownloadTask downloadTask, int i, int i2);

    public abstract void a(DownloadTask downloadTask, Throwable th);

    public abstract void b(DownloadTask downloadTask);

    public abstract void c(DownloadTask downloadTask);

    public abstract void d(DownloadTask downloadTask);

    public abstract void e(DownloadTask downloadTask);

    public abstract void f(DownloadTask downloadTask);

    public final void setId(int i) {
        this.mTaskId = i;
    }
}
