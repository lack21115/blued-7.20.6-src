package com.efs.sdk.memoryinfo;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.base.observer.IConfigCallback;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/memoryinfo/d.class */
final class d implements UMMemoryMonitorApi {
    private boolean A;
    private boolean u;
    private boolean v = true;
    private b w;
    private WeakReference<Activity> x;
    private boolean y;
    private int z;

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final String getCurrentActivity() {
        Activity activity;
        WeakReference<Activity> weakReference = this.x;
        return (weakReference == null || (activity = weakReference.get()) == null) ? "" : activity.getClass().getName();
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final boolean isEnable() {
        b bVar;
        return this.v && (bVar = this.w) != null && bVar.b;
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final boolean isForeground() {
        return this.y;
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final void onActivityResumed(Activity activity) {
        if (this.v) {
            this.x = new WeakReference<>(activity);
        }
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final void onActivityStarted(Activity activity) {
        if (this.v && activity != null) {
            if (this.A) {
                this.A = false;
                return;
            }
            int i = this.z + 1;
            this.z = i;
            if (i == 1) {
                this.y = true;
            }
        }
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final void onActivityStopped(Activity activity) {
        if (this.v && activity != null) {
            if (activity.isChangingConfigurations()) {
                this.A = true;
                return;
            }
            int i = this.z - 1;
            this.z = i;
            if (i == 0) {
                this.y = false;
            }
        }
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final void setEnable(boolean z) {
        this.v = z;
    }

    @Override // com.efs.sdk.memoryinfo.UMMemoryMonitorApi
    public final void start(Context context, EfsReporter efsReporter) {
        if ((this.v || IntegrationTestingUtil.isIntegrationTestingInPeriod()) && !this.u) {
            this.u = true;
            final b bVar = new b(context, efsReporter);
            this.w = bVar;
            bVar.f21813a.getAllSdkConfig(new String[]{"apm_memperf_sampling_rate", "apm_memperf_collect_interval", "apm_memperf_collect_max_period_sec"}, new IConfigCallback() { // from class: com.efs.sdk.memoryinfo.b.1
                @Override // com.efs.sdk.base.observer.IConfigCallback
                public final void onChange(Map<String, Object> map) {
                    Object obj;
                    boolean z;
                    Object obj2;
                    Object obj3;
                    try {
                        if (b.this.b || (obj = map.get("apm_memperf_sampling_rate")) == null) {
                            return;
                        }
                        int parseInt = Integer.parseInt(obj.toString());
                        if (parseInt == 0 || (parseInt != 100 && new Random().nextInt(100) > parseInt)) {
                            z = false;
                            if ((z && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) || (obj2 = map.get("apm_memperf_collect_interval")) == null || (obj3 = map.get("apm_memperf_collect_max_period_sec")) == null) {
                                return;
                            }
                            final int parseInt2 = Integer.parseInt(obj2.toString());
                            final int parseInt3 = Integer.parseInt(obj3.toString());
                            final HandlerThread handlerThread = new HandlerThread("mem-info");
                            handlerThread.start();
                            final Handler handler = new Handler(handlerThread.getLooper()) { // from class: com.efs.sdk.memoryinfo.b.1.1
                                @Override // android.os.Handler
                                public final void handleMessage(Message message) {
                                    super.handleMessage(message);
                                    if (message.what == 1) {
                                        try {
                                            handlerThread.quit();
                                        } catch (Throwable th) {
                                        }
                                    }
                                }
                            };
                            handler.post(new Runnable() { // from class: com.efs.sdk.memoryinfo.b.1.2
                                @Override // java.lang.Runnable
                                public final void run() {
                                    try {
                                        String uuid = UUID.randomUUID().toString();
                                        int myPid = Process.myPid();
                                        final String lowerCase = UMUtils.MD5(myPid + uuid).toLowerCase();
                                        final b bVar2 = b.this;
                                        final Handler handler2 = handler;
                                        final int i = parseInt2;
                                        final int i2 = parseInt3;
                                        final e eVar = new e(bVar2.mContext, bVar2.f21813a);
                                        final long elapsedRealtime = SystemClock.elapsedRealtime();
                                        handler2.post(new Runnable() { // from class: com.efs.sdk.memoryinfo.b.2
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                if (SystemClock.elapsedRealtime() - elapsedRealtime > i2 * 1000) {
                                                    handler2.sendEmptyMessage(1);
                                                    return;
                                                }
                                                try {
                                                    b.a(b.this, eVar, lowerCase);
                                                } catch (Throwable th) {
                                                    f.a("collect ", th);
                                                }
                                                handler2.postDelayed(this, i * 1000);
                                            }
                                        });
                                    } catch (Throwable th) {
                                        handler.sendEmptyMessage(1);
                                    }
                                }
                            });
                            b.this.b = true;
                        }
                        z = true;
                        if (z) {
                        }
                        final int parseInt22 = Integer.parseInt(obj2.toString());
                        final int parseInt32 = Integer.parseInt(obj3.toString());
                        final HandlerThread handlerThread2 = new HandlerThread("mem-info");
                        handlerThread2.start();
                        final Handler handler2 = new Handler(handlerThread2.getLooper()) { // from class: com.efs.sdk.memoryinfo.b.1.1
                            @Override // android.os.Handler
                            public final void handleMessage(Message message) {
                                super.handleMessage(message);
                                if (message.what == 1) {
                                    try {
                                        handlerThread2.quit();
                                    } catch (Throwable th) {
                                    }
                                }
                            }
                        };
                        handler2.post(new Runnable() { // from class: com.efs.sdk.memoryinfo.b.1.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    String uuid = UUID.randomUUID().toString();
                                    int myPid = Process.myPid();
                                    final String lowerCase = UMUtils.MD5(myPid + uuid).toLowerCase();
                                    final b bVar2 = b.this;
                                    final Handler handler22 = handler2;
                                    final int i = parseInt22;
                                    final int i2 = parseInt32;
                                    final e eVar = new e(bVar2.mContext, bVar2.f21813a);
                                    final long elapsedRealtime = SystemClock.elapsedRealtime();
                                    handler22.post(new Runnable() { // from class: com.efs.sdk.memoryinfo.b.2
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            if (SystemClock.elapsedRealtime() - elapsedRealtime > i2 * 1000) {
                                                handler22.sendEmptyMessage(1);
                                                return;
                                            }
                                            try {
                                                b.a(b.this, eVar, lowerCase);
                                            } catch (Throwable th) {
                                                f.a("collect ", th);
                                            }
                                            handler22.postDelayed(this, i * 1000);
                                        }
                                    });
                                } catch (Throwable th) {
                                    handler2.sendEmptyMessage(1);
                                }
                            }
                        });
                        b.this.b = true;
                    } catch (Throwable th) {
                        f.a("collect ", th);
                    }
                }
            });
        }
    }
}
