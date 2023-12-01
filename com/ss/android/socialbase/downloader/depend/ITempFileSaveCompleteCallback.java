package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/depend/ITempFileSaveCompleteCallback.class */
public interface ITempFileSaveCompleteCallback {
    void onFailed(BaseException baseException);

    void onSuccess();
}
