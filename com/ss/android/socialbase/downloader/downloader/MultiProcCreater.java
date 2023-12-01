package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.impls.IndependentDownloadServiceHandler;
import com.ss.android.socialbase.downloader.impls.IndependentProcessDownloadHandler;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/downloader/MultiProcCreater.class */
class MultiProcCreater implements DownloadComponentManager.IndependentHolderCreator {
    @Override // com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator
    public ISqlDownloadCache createCache(DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener onMainProcessRebindErrorListener) {
        SqlDownloadCacheAidlWrapper sqlDownloadCacheAidlWrapper = new SqlDownloadCacheAidlWrapper();
        sqlDownloadCacheAidlWrapper.setOnMainProcessRebindErrorCallback(onMainProcessRebindErrorListener);
        return sqlDownloadCacheAidlWrapper;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator
    public IDownloadProxy createProxy() {
        return new IndependentProcessDownloadHandler();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator
    public IDownloadServiceHandler createServiceHandler() {
        return new IndependentDownloadServiceHandler();
    }
}
