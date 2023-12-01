package com.ss.android.socialbase.downloader.depend;

import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/depend/IDownloadForbiddenCallback.class */
public interface IDownloadForbiddenCallback {
    boolean hasCallback();

    void onCallback(List<String> list);
}
