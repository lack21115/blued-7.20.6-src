package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.network.NetworkQuality;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/downloader/IChunkAdjustCalculator.class */
public interface IChunkAdjustCalculator {
    int calculateChunkCount(int i, NetworkQuality networkQuality);
}
