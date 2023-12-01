package com.xiaomi.push;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.push.es;
import com.xiaomi.push.service.XMJobService;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/eu.class */
public class eu implements es.a {

    /* renamed from: a  reason: collision with root package name */
    JobScheduler f41385a;

    /* renamed from: a  reason: collision with other field name */
    Context f408a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f409a = false;

    eu(Context context) {
        this.f408a = context;
        this.f41385a = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
    }

    @Override // com.xiaomi.push.es.a
    public void a() {
        this.f409a = false;
        this.f41385a.cancel(1);
    }

    void a(long j) {
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.f408a.getPackageName(), XMJobService.class.getName()));
        builder.setMinimumLatency(j);
        builder.setOverrideDeadline(j);
        builder.setRequiredNetworkType(1);
        builder.setPersisted(false);
        JobInfo build = builder.build();
        com.xiaomi.channel.commonutils.logger.b.c("schedule Job = " + build.getId() + " in " + j);
        this.f41385a.schedule(builder.build());
    }

    @Override // com.xiaomi.push.es.a
    public void a(boolean z) {
        if (z || this.f409a) {
            long b = ga.b();
            long j = b;
            if (z) {
                a();
                j = b - (SystemClock.elapsedRealtime() % b);
            }
            this.f409a = true;
            a(j);
        }
    }

    @Override // com.xiaomi.push.es.a
    /* renamed from: a */
    public boolean mo11732a() {
        return this.f409a;
    }
}
