package com.blued.android.module.live_china.utils;

import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/LiveNumFormatUtil.class */
public final class LiveNumFormatUtil {
    public static final LiveNumFormatUtil a = new LiveNumFormatUtil();

    private LiveNumFormatUtil() {
    }

    public final String a(int i) {
        return a(i);
    }

    public final String a(long j) {
        int i;
        if (j < 1000) {
            return String.valueOf(j);
        }
        if (j < 10000) {
            String format = new DecimalFormat("#,###").format(j);
            Intrinsics.c(format, "df.format(value)");
            return format;
        }
        String s = new DecimalFormat("#0.00").format(Float.valueOf(((float) j) / 10000.0f));
        int length = s.length();
        while (true) {
            int i2 = length - 1;
            i = i2;
            if (i2 < 0) {
                break;
            } else if (s.charAt(i2) == '.') {
                i = i2;
                break;
            } else if (s.charAt(i2) != '0') {
                i = i2 + 1;
                break;
            } else {
                length = i2;
            }
        }
        Intrinsics.c(s, "s");
        String substring = s.substring(0, i);
        Intrinsics.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return Intrinsics.a(substring, (Object) "w");
    }
}
