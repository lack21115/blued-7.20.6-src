package com.ss.android.socialbase.downloader.impls;

import com.anythink.expressad.video.module.a.a.m;
import com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/impls/DefaultRetryDelayTimeCalculator.class */
public class DefaultRetryDelayTimeCalculator implements IRetryDelayTimeCalculator {
    @Override // com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator
    public long calculateRetryDelayTime(int i, int i2) {
        if (i == 1) {
            return m.ag;
        }
        if (i == 2) {
            return 15000L;
        }
        if (i == 3) {
            return 30000L;
        }
        return i > 3 ? 300000L : 0L;
    }
}
