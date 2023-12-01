package com.anythink.china.api;

import com.anythink.core.api.ATEventInterface;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/api/CustomAdapterDownloadListener.class */
public interface CustomAdapterDownloadListener extends ATEventInterface {
    void onDownloadFail(long j, long j2, String str, String str2);

    void onDownloadFinish(long j, String str, String str2);

    void onDownloadPause(long j, long j2, String str, String str2);

    void onDownloadStart(long j, long j2, String str, String str2);

    void onDownloadUpdate(long j, long j2, String str, String str2);

    void onInstalled(String str, String str2);
}
