package com.ss.android.download.api.download;

import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/download/api/download/DownloadController.class */
public interface DownloadController {
    boolean enableAH();

    boolean enableAM();

    boolean enableNewActivity();

    boolean enableShowComplianceDialog();

    @Deprecated
    int getDowloadChunkCount();

    int getDownloadMode();

    Object getExtraClickOperation();

    JSONObject getExtraJson();

    Object getExtraObject();

    int getInterceptFlag();

    int getLinkMode();

    boolean isAddToDownloadManage();

    boolean isAutoDownloadOnCardShow();

    boolean isEnableBackDialog();

    @Deprecated
    boolean isEnableMultipleDownload();

    void setDownloadMode(int i);

    void setEnableNewActivity(boolean z);

    void setEnableShowComplianceDialog(boolean z);

    void setLinkMode(int i);

    boolean shouldUseNewWebView();
}
