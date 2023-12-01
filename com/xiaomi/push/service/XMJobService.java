package com.xiaomi.push.service;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.xiaomi.push.es;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/XMJobService.class */
public class XMJobService extends Service {

    /* renamed from: a  reason: collision with root package name */
    static Service f41568a;

    /* renamed from: a  reason: collision with other field name */
    private IBinder f915a = null;

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/XMJobService$a.class */
    static class a extends JobService {

        /* renamed from: a  reason: collision with root package name */
        Binder f41569a;

        /* renamed from: a  reason: collision with other field name */
        private Handler f916a;

        /* renamed from: com.xiaomi.push.service.XMJobService$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/XMJobService$a$a.class */
        static class HandlerC1094a extends Handler {

            /* renamed from: a  reason: collision with root package name */
            JobService f41570a;

            HandlerC1094a(JobService jobService) {
                super(jobService.getMainLooper());
                this.f41570a = jobService;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    return;
                }
                JobParameters jobParameters = (JobParameters) message.obj;
                com.xiaomi.channel.commonutils.logger.b.m11394a("Job finished " + jobParameters.getJobId());
                this.f41570a.jobFinished(jobParameters, false);
                if (jobParameters.getJobId() == 1) {
                    es.a(false);
                }
            }
        }

        a(Service service) {
            this.f41569a = null;
            this.f41569a = (Binder) com.xiaomi.push.bi.a((Object) this, "onBind", new Intent());
            com.xiaomi.push.bi.a((Object) this, "attachBaseContext", service);
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("Job started " + jobParameters.getJobId());
            Intent intent = new Intent(this, XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.f916a == null) {
                this.f916a = new HandlerC1094a(this);
            }
            Handler handler = this.f916a;
            handler.sendMessage(Message.obtain(handler, 1, jobParameters));
            return true;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("Job stop " + jobParameters.getJobId());
            return false;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IBinder iBinder = this.f915a;
        return iBinder != null ? iBinder : new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 21) {
            this.f915a = new a(this).f41569a;
        }
        f41568a = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f41568a = null;
    }
}
