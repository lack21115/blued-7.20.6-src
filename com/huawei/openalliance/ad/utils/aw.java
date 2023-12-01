package com.huawei.openalliance.ad.utils;

import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.utils.f;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/aw.class */
public abstract class aw {
    private static final String Code = aw.class.getSimpleName();
    private static final int V = 1;

    public static <RESULT> RESULT Code(Callable<RESULT> callable, long j, RESULT result) {
        return (RESULT) Code(callable, result, j, TimeUnit.MILLISECONDS);
    }

    public static <RESULT> RESULT Code(Callable<RESULT> callable, RESULT result) {
        return (RESULT) Code(callable, result, 1L, TimeUnit.SECONDS);
    }

    private static <RESULT> RESULT Code(Callable<RESULT> callable, RESULT result, long j, TimeUnit timeUnit) {
        String str;
        StringBuilder sb;
        if (callable == null) {
            return result;
        }
        try {
            return (RESULT) f.Code(callable, f.a.SYNC_CALL).get(j, timeUnit);
        } catch (InterruptedException e) {
            e = e;
            str = Code;
            sb = new StringBuilder();
            sb.append("call ");
            sb.append(e.getClass().getSimpleName());
            ge.I(str, sb.toString());
            return result;
        } catch (Throwable th) {
            e = th;
            str = Code;
            sb = new StringBuilder();
            sb.append("call ");
            sb.append(e.getClass().getSimpleName());
            ge.I(str, sb.toString());
            return result;
        }
    }
}
