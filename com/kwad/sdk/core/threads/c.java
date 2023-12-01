package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.g;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/threads/c.class */
public class c {
    private static int amD;
    private static int amE;
    private static long interval;
    private static long startTime;
    public static final String TAG = c.class.getSimpleName();
    private static int amC = 0;
    private static final ConcurrentHashMap<ThreadPoolExecutor, Long> amF = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<ThreadPoolExecutor, String> amG = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(d dVar) {
        com.kwad.sdk.core.threads.kwai.b.amK = true;
        com.kwad.sdk.core.threads.kwai.a.amK = true;
        interval = dVar.interval;
        amE = dVar.amJ;
        HandlerThread handlerThread = new HandlerThread("pollingHT");
        handlerThread.start();
        final Handler handler = new Handler(handlerThread.getLooper());
        startTime = SystemClock.elapsedRealtime();
        handler.post(new aw() { // from class: com.kwad.sdk.core.threads.c.2
            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                ExecutorService cK;
                for (String str : GlobalThreadPools.xW()) {
                    if (str != null && !c.amG.containsValue(str) && (cK = GlobalThreadPools.cK(str)) != null && (cK instanceof ThreadPoolExecutor) && !c.amF.containsKey(cK)) {
                        c.a((ThreadPoolExecutor) cK, str);
                    }
                }
                int i = 0;
                for (ThreadPoolExecutor threadPoolExecutor : c.amG.keySet()) {
                    String str2 = (String) c.amG.get(threadPoolExecutor);
                    int poolSize = i + threadPoolExecutor.getPoolSize();
                    b b = c.b(threadPoolExecutor, str2);
                    i = poolSize;
                    if (b != null) {
                        KSLoggerReporter.z(b.toJson());
                        i = poolSize;
                    }
                }
                b bVar = new b();
                bVar.ams = "total";
                bVar.amv = i;
                KSLoggerReporter.z(bVar.toJson());
                c.yc();
                if (c.amC < c.amE) {
                    Handler.this.postDelayed(this, c.interval);
                }
            }
        });
    }

    public static void a(ThreadPoolExecutor threadPoolExecutor, String str) {
        amF.put(threadPoolExecutor, Long.valueOf(threadPoolExecutor.getCompletedTaskCount()));
        amG.put(threadPoolExecutor, str);
    }

    public static b b(ThreadPoolExecutor threadPoolExecutor, String str) {
        if (threadPoolExecutor == null) {
            return null;
        }
        b bVar = new b();
        bVar.ams = str;
        bVar.amt = threadPoolExecutor.getCorePoolSize();
        bVar.amu = threadPoolExecutor.getMaximumPoolSize();
        bVar.amv = threadPoolExecutor.getPoolSize();
        bVar.amw = threadPoolExecutor.getActiveCount();
        bVar.amz = threadPoolExecutor.getQueue() == null ? 0 : threadPoolExecutor.getQueue().size();
        long longValue = (!amF.containsKey(threadPoolExecutor) || amF.get(threadPoolExecutor) == null) ? 0L : amF.get(threadPoolExecutor).longValue();
        long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
        bVar.amy = completedTaskCount - longValue;
        amF.put(threadPoolExecutor, Long.valueOf(completedTaskCount));
        if (threadPoolExecutor instanceof com.kwad.sdk.core.threads.kwai.c) {
            bVar.amx = ((com.kwad.sdk.core.threads.kwai.c) threadPoolExecutor).yg();
        } else {
            bVar.amx = 0L;
        }
        bVar.amA = SystemClock.elapsedRealtime() - startTime;
        bVar.interval = interval;
        bVar.amB = amD;
        return bVar;
    }

    public static void cL(final String str) {
        g.execute(new aw() { // from class: com.kwad.sdk.core.threads.c.1
            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                d cM;
                if (TextUtils.isEmpty(str) || (cM = c.cM(str)) == null || cM.amD == 0) {
                    return;
                }
                int unused = c.amD = cM.amD;
                if (Math.random() * c.amD >= 1.0d) {
                    return;
                }
                c.a(cM);
            }
        });
    }

    public static d cM(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Exception e) {
            com.kwai.sodler.lib.a.w(TAG, e.toString());
            return null;
        }
    }

    static /* synthetic */ int yc() {
        int i = amC;
        amC = i + 1;
        return i;
    }
}
