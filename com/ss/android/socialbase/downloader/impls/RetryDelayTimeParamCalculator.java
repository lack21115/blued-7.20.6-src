package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/impls/RetryDelayTimeParamCalculator.class */
public class RetryDelayTimeParamCalculator implements IRetryDelayTimeCalculator {
    private final long[] mTimeArray;

    public RetryDelayTimeParamCalculator(String str) {
        this.mTimeArray = parseTimeArray(str);
    }

    private long[] parseTimeArray(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(",");
            if (split.length == 0) {
                return null;
            }
            long[] jArr = new long[split.length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= split.length) {
                    return jArr;
                }
                jArr[i2] = Long.parseLong(split[i2]);
                i = i2 + 1;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator
    public long calculateRetryDelayTime(int i, int i2) {
        long[] jArr = this.mTimeArray;
        if (jArr == null || jArr.length <= 0) {
            return 0L;
        }
        int i3 = i - 1;
        int i4 = i3;
        if (i3 < 0) {
            i4 = 0;
        }
        long[] jArr2 = this.mTimeArray;
        int i5 = i4;
        if (i4 > jArr2.length - 1) {
            i5 = jArr2.length - 1;
        }
        return this.mTimeArray[i5];
    }
}
