package com.anythink.expressad.exoplayer.scheduler;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import com.anythink.expressad.exoplayer.k.af;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/scheduler/PlatformScheduler.class */
public final class PlatformScheduler implements c {
    private static final String b = "PlatformScheduler";

    /* renamed from: c  reason: collision with root package name */
    private static final String f7730c = "service_action";
    private static final String d = "service_package";
    private static final String e = "requirements";
    private final int f;
    private final ComponentName g;
    private final JobScheduler h;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/scheduler/PlatformScheduler$PlatformSchedulerService.class */
    public static final class PlatformSchedulerService extends JobService {
        @Override // android.app.job.JobService
        public final boolean onStartJob(JobParameters jobParameters) {
            PersistableBundle extras = jobParameters.getExtras();
            if (!new a(extras.getInt(PlatformScheduler.e)).a(this)) {
                jobFinished(jobParameters, true);
                return false;
            }
            String string = extras.getString(PlatformScheduler.f7730c);
            String string2 = extras.getString(PlatformScheduler.d);
            Intent intent = new Intent(string).setPackage(string2);
            StringBuilder sb = new StringBuilder("Starting service action: ");
            sb.append(string);
            sb.append(" package: ");
            sb.append(string2);
            af.a((Context) this, intent);
            return false;
        }

        @Override // android.app.job.JobService
        public final boolean onStopJob(JobParameters jobParameters) {
            return false;
        }
    }

    private PlatformScheduler(Context context, int i) {
        this.f = i;
        this.g = new ComponentName(context, PlatformSchedulerService.class);
        this.h = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
    }

    private static JobInfo a(int i, ComponentName componentName, a aVar, String str, String str2) {
        JobInfo.Builder builder = new JobInfo.Builder(i, componentName);
        int a2 = aVar.a();
        int i2 = 4;
        if (a2 == 0) {
            i2 = 0;
        } else if (a2 == 1) {
            i2 = 1;
        } else if (a2 == 2) {
            i2 = 2;
        } else if (a2 != 3) {
            if (a2 != 4) {
                throw new UnsupportedOperationException();
            }
            if (af.f7632a < 26) {
                throw new UnsupportedOperationException();
            }
        } else if (af.f7632a < 24) {
            throw new UnsupportedOperationException();
        } else {
            i2 = 3;
        }
        builder.setRequiredNetworkType(i2);
        builder.setRequiresDeviceIdle(aVar.c());
        builder.setRequiresCharging(aVar.b());
        builder.setPersisted(true);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString(f7730c, str);
        persistableBundle.putString(d, str2);
        persistableBundle.putInt(e, aVar.d());
        builder.setExtras(persistableBundle);
        return builder.build();
    }

    private static void b() {
    }

    private static /* synthetic */ void c() {
    }

    @Override // com.anythink.expressad.exoplayer.scheduler.c
    public final boolean a() {
        new StringBuilder("Canceling job: ").append(this.f);
        this.h.cancel(this.f);
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.scheduler.c
    public final boolean a(a aVar, String str, String str2) {
        JobInfo.Builder builder = new JobInfo.Builder(this.f, this.g);
        int a2 = aVar.a();
        int i = 4;
        if (a2 == 0) {
            i = 0;
        } else if (a2 == 1) {
            i = 1;
        } else if (a2 == 2) {
            i = 2;
        } else if (a2 != 3) {
            if (a2 != 4) {
                throw new UnsupportedOperationException();
            }
            if (af.f7632a < 26) {
                throw new UnsupportedOperationException();
            }
        } else if (af.f7632a < 24) {
            throw new UnsupportedOperationException();
        } else {
            i = 3;
        }
        builder.setRequiredNetworkType(i);
        builder.setRequiresDeviceIdle(aVar.c());
        builder.setRequiresCharging(aVar.b());
        builder.setPersisted(true);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString(f7730c, str2);
        persistableBundle.putString(d, str);
        persistableBundle.putInt(e, aVar.d());
        builder.setExtras(persistableBundle);
        int schedule = this.h.schedule(builder.build());
        StringBuilder sb = new StringBuilder("Scheduling job: ");
        sb.append(this.f);
        sb.append(" result: ");
        sb.append(schedule);
        return schedule == 1;
    }
}
