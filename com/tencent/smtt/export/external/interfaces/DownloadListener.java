package com.tencent.smtt.export.external.interfaces;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/export/external/interfaces/DownloadListener.class */
public interface DownloadListener {
    void onDownloadStart(String str, String str2, String str3, String str4, long j);

    void onDownloadStart(String str, String str2, byte[] bArr, String str3, String str4, String str5, long j, String str6, String str7);

    void onDownloadVideo(String str, long j, int i);
}
