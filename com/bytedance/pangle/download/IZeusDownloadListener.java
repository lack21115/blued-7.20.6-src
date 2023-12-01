package com.bytedance.pangle.download;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/download/IZeusDownloadListener.class */
public interface IZeusDownloadListener {
    void onFailed(Throwable th, int i, String str);

    void onProgress(long j, long j2);

    void onStart();

    void onSuccess(String str, String str2, long j);
}
