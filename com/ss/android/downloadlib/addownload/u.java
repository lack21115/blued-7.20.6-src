package com.ss.android.downloadlib.addownload;

import android.content.Context;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/u.class */
public interface u {
    long hj();

    u mb(long j);

    u mb(IDownloadButtonClickListener iDownloadButtonClickListener);

    u mb(OnItemClickListener onItemClickListener);

    void mb();

    void mb(boolean z);

    boolean mb(int i);

    u ox(int i, DownloadStatusChangeListener downloadStatusChangeListener);

    u ox(Context context);

    u ox(DownloadController downloadController);

    u ox(DownloadEventConfig downloadEventConfig);

    u ox(DownloadModel downloadModel);

    void ox(int i);

    boolean ox();

    void ww();
}
