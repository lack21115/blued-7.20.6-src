package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/impls/DefaultChunkCntCalculator.class */
public class DefaultChunkCntCalculator implements IChunkCntCalculator {
    @Override // com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator
    public int calculateChunkCount(long j) {
        return 1;
    }
}
