package com.huawei.hms.ads;

import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/gh.class */
public class gh extends gc {
    private static final String I = "HiAdLog";
    private static final int V = 60;
    private final Executor B = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.huawei.openalliance.ad.utils.g("FileLog"));
    private final gj Z;

    public gh(gj gjVar) {
        this.Z = gjVar;
    }

    @Override // com.huawei.hms.ads.gj
    public gj Code(final String str, final String str2) {
        this.B.execute(new Runnable() { // from class: com.huawei.hms.ads.gh.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    gh.this.Z.Code(str, str2);
                } catch (Throwable th) {
                    Log.w(gh.I, "init err: " + th.getClass().getSimpleName());
                }
            }
        });
        if (this.Code != null) {
            this.Code.Code(str, str2);
        }
        return this;
    }

    @Override // com.huawei.hms.ads.gj
    public void Code(final gl glVar, final int i, final String str) {
        this.B.execute(new Runnable() { // from class: com.huawei.hms.ads.gh.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    gh.this.Z.Code(glVar, i, str);
                } catch (Throwable th) {
                    Log.w(gh.I, "log err: " + th.getClass().getSimpleName());
                }
            }
        });
        if (this.Code != null) {
            this.Code.Code(glVar, i, str);
        }
    }
}
