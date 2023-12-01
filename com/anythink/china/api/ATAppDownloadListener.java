package com.anythink.china.api;

import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATEventInterface;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/api/ATAppDownloadListener.class */
public interface ATAppDownloadListener extends ATEventInterface {
    void onDownloadFail(ATAdInfo aTAdInfo, long j, long j2, String str, String str2);

    void onDownloadFinish(ATAdInfo aTAdInfo, long j, String str, String str2);

    void onDownloadPause(ATAdInfo aTAdInfo, long j, long j2, String str, String str2);

    void onDownloadStart(ATAdInfo aTAdInfo, long j, long j2, String str, String str2);

    void onDownloadUpdate(ATAdInfo aTAdInfo, long j, long j2, String str, String str2);

    void onInstalled(ATAdInfo aTAdInfo, String str, String str2);
}
