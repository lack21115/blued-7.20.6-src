package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator;
import com.ss.android.socialbase.downloader.network.NetworkQuality;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/impls/DefaultChunkAdjustCalculator.class */
public class DefaultChunkAdjustCalculator implements IChunkAdjustCalculator {
    @Override // com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator
    public int calculateChunkCount(int i, NetworkQuality networkQuality) {
        if (networkQuality.ordinal() <= NetworkQuality.MODERATE.ordinal()) {
            return 1;
        }
        int i2 = i;
        if (networkQuality == NetworkQuality.GOOD) {
            i2 = i - 1;
        }
        return i2;
    }
}
