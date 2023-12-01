package com.kwad.sdk.crash.report;

import android.util.Log;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/report/c.class */
public abstract class c implements e {
    private ArrayList<a> asu = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/report/c$a.class */
    public static final class a {
        private ExceptionMessage asv;
        private int asw;

        a(ExceptionMessage exceptionMessage, int i) {
            this.asv = exceptionMessage;
            this.asw = i;
        }
    }

    private void Ac() {
        if (this.asu.isEmpty()) {
            return;
        }
        try {
            Iterator<a> it = this.asu.iterator();
            while (it.hasNext()) {
                a next = it.next();
                b(next.asv, next.asw, null);
                it.remove();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
    }

    private static boolean a(String str, List<String> list) {
        for (String str2 : list) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private void b(ExceptionMessage exceptionMessage, int i, CountDownLatch countDownLatch) {
        if (exceptionMessage == null || !c(exceptionMessage)) {
            return;
        }
        if (i == 3) {
            com.kwad.sdk.crash.report.a.b(exceptionMessage);
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(com.kwad.sdk.crash.report.request.c.d(exceptionMessage));
        com.kwad.sdk.crash.report.request.b.a(arrayList, countDownLatch);
    }

    private boolean c(ExceptionMessage exceptionMessage) {
        try {
            com.kwad.sdk.crash.e zy = com.kwad.sdk.crash.e.zy();
            if (zy.zD() == null || zy.zC() == 2) {
                return true;
            }
            List<com.kwad.sdk.crash.a> list = zy.zD().aqU;
            double d = zy.zD().aqB;
            String appId = zy.getAppId();
            String sdkVersion = zy.getSdkVersion();
            for (com.kwad.sdk.crash.a aVar : list) {
                if (aVar != null && (com.kwad.sdk.crash.utils.c.b(aVar.aqy) || aVar.aqy.contains(appId))) {
                    if (com.kwad.sdk.crash.utils.c.b(aVar.aqz) || aVar.aqz.contains(sdkVersion)) {
                        if (com.kwad.sdk.crash.utils.c.b(aVar.aqA) || a(exceptionMessage.mCrashDetail, aVar.aqA)) {
                            d = aVar.aqB;
                        }
                    }
                }
            }
            return Math.random() < d;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.w("BaseExceptionUploader", Log.getStackTraceString(e));
            return true;
        }
    }

    public final void a(ExceptionMessage exceptionMessage, int i, CountDownLatch countDownLatch) {
        try {
            Ac();
            b(exceptionMessage, i, countDownLatch);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            this.asu.add(new a(exceptionMessage, i));
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }
}
