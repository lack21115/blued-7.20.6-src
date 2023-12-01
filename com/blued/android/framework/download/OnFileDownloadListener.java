package com.blued.android.framework.download;

import com.blued.android.framework.download.model.DownloadBaseInfo;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/download/OnFileDownloadListener.class */
public interface OnFileDownloadListener {
    void a(DownloadBaseInfo downloadBaseInfo);

    void a(DownloadBaseInfo downloadBaseInfo, int i, int i2);

    void a(DownloadBaseInfo downloadBaseInfo, String str);

    void b(DownloadBaseInfo downloadBaseInfo);
}
