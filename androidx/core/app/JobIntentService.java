package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import java.util.ArrayList;
import java.util.HashMap;

@Deprecated
/* loaded from: source-8756600-dex2jar.jar:androidx/core/app/JobIntentService.class */
public abstract class JobIntentService extends Service {
    static final Object h = new Object();
    static final HashMap<ComponentName, WorkEnqueuer> i = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    CompatJobEngine f2282a;
    WorkEnqueuer b;

    /* renamed from: c  reason: collision with root package name */
    CommandProcessor f2283c;
    boolean d = false;
    boolean e = false;
    boolean f = false;
    final ArrayList<CompatWorkItem> g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/JobIntentService$CommandProcessor.class */
    public final class CommandProcessor extends AsyncTask<Void, Void, Void> {
        CommandProcessor() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                GenericWorkItem c2 = JobIntentService.this.c();
                if (c2 == null) {
                    return null;
                }
                JobIntentService.this.a(c2.getIntent());
                c2.complete();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onCancelled(Void r3) {
            JobIntentService.this.b();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r3) {
            JobIntentService.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/JobIntentService$CompatJobEngine.class */
    public interface CompatJobEngine {
        IBinder compatGetBinder();

        GenericWorkItem dequeueWork();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/JobIntentService$CompatWorkEnqueuer.class */
    public static final class CompatWorkEnqueuer extends WorkEnqueuer {

        /* renamed from: a  reason: collision with root package name */
        boolean f2285a;
        boolean b;
        private final Context f;
        private final PowerManager.WakeLock g;
        private final PowerManager.WakeLock h;

        CompatWorkEnqueuer(Context context, ComponentName componentName) {
            super(componentName);
            this.f = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.g = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.h = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        void a(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.f2292c);
            if (this.f.startService(intent2) != null) {
                synchronized (this) {
                    if (!this.f2285a) {
                        this.f2285a = true;
                        if (!this.b) {
                            this.g.acquire(60000L);
                        }
                    }
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceProcessingFinished() {
            synchronized (this) {
                if (this.b) {
                    if (this.f2285a) {
                        this.g.acquire(60000L);
                    }
                    this.b = false;
                    this.h.release();
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceProcessingStarted() {
            synchronized (this) {
                if (!this.b) {
                    this.b = true;
                    this.h.acquire(600000L);
                    this.g.release();
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceStartReceived() {
            synchronized (this) {
                this.f2285a = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/JobIntentService$CompatWorkItem.class */
    public final class CompatWorkItem implements GenericWorkItem {

        /* renamed from: a  reason: collision with root package name */
        final Intent f2286a;
        final int b;

        CompatWorkItem(Intent intent, int i) {
            this.f2286a = intent;
            this.b = i;
        }

        @Override // androidx.core.app.JobIntentService.GenericWorkItem
        public void complete() {
            JobIntentService.this.stopSelf(this.b);
        }

        @Override // androidx.core.app.JobIntentService.GenericWorkItem
        public Intent getIntent() {
            return this.f2286a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/JobIntentService$GenericWorkItem.class */
    public interface GenericWorkItem {
        void complete();

        Intent getIntent();
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/JobIntentService$JobServiceEngineImpl.class */
    static final class JobServiceEngineImpl extends JobServiceEngine implements CompatJobEngine {

        /* renamed from: a  reason: collision with root package name */
        final JobIntentService f2288a;
        final Object b;

        /* renamed from: c  reason: collision with root package name */
        JobParameters f2289c;

        /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/JobIntentService$JobServiceEngineImpl$WrapperWorkItem.class */
        final class WrapperWorkItem implements GenericWorkItem {

            /* renamed from: a  reason: collision with root package name */
            final JobWorkItem f2290a;

            WrapperWorkItem(JobWorkItem jobWorkItem) {
                this.f2290a = jobWorkItem;
            }

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public void complete() {
                synchronized (JobServiceEngineImpl.this.b) {
                    if (JobServiceEngineImpl.this.f2289c != null) {
                        JobServiceEngineImpl.this.f2289c.completeWork(this.f2290a);
                    }
                }
            }

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public Intent getIntent() {
                return this.f2290a.getIntent();
            }
        }

        JobServiceEngineImpl(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.b = new Object();
            this.f2288a = jobIntentService;
        }

        @Override // androidx.core.app.JobIntentService.CompatJobEngine
        public IBinder compatGetBinder() {
            return getBinder();
        }

        @Override // androidx.core.app.JobIntentService.CompatJobEngine
        public GenericWorkItem dequeueWork() {
            synchronized (this.b) {
                if (this.f2289c == null) {
                    return null;
                }
                JobWorkItem dequeueWork = this.f2289c.dequeueWork();
                if (dequeueWork != null) {
                    dequeueWork.getIntent().setExtrasClassLoader(this.f2288a.getClassLoader());
                    return new WrapperWorkItem(dequeueWork);
                }
                return null;
            }
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters jobParameters) {
            this.f2289c = jobParameters;
            this.f2288a.a(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters jobParameters) {
            boolean a2 = this.f2288a.a();
            synchronized (this.b) {
                this.f2289c = null;
            }
            return a2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/JobIntentService$JobWorkEnqueuer.class */
    public static final class JobWorkEnqueuer extends WorkEnqueuer {

        /* renamed from: a  reason: collision with root package name */
        private final JobInfo f2291a;
        private final JobScheduler b;

        JobWorkEnqueuer(Context context, ComponentName componentName, int i) {
            super(componentName);
            a(i);
            this.f2291a = new JobInfo.Builder(i, this.f2292c).setOverrideDeadline(0L).build();
            this.b = (JobScheduler) context.getApplicationContext().getSystemService(Context.JOB_SCHEDULER_SERVICE);
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        void a(Intent intent) {
            this.b.enqueue(this.f2291a, new JobWorkItem(intent));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/JobIntentService$WorkEnqueuer.class */
    public static abstract class WorkEnqueuer {

        /* renamed from: c  reason: collision with root package name */
        final ComponentName f2292c;
        boolean d;
        int e;

        WorkEnqueuer(ComponentName componentName) {
            this.f2292c = componentName;
        }

        void a(int i) {
            if (!this.d) {
                this.d = true;
                this.e = i;
            } else if (this.e == i) {
            } else {
                throw new IllegalArgumentException("Given job ID " + i + " is different than previous " + this.e);
            }
        }

        abstract void a(Intent intent);

        public void serviceProcessingFinished() {
        }

        public void serviceProcessingStarted() {
        }

        public void serviceStartReceived() {
        }
    }

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.g = null;
        } else {
            this.g = new ArrayList<>();
        }
    }

    static WorkEnqueuer a(Context context, ComponentName componentName, boolean z, int i2) {
        JobWorkEnqueuer compatWorkEnqueuer;
        WorkEnqueuer workEnqueuer = i.get(componentName);
        WorkEnqueuer workEnqueuer2 = workEnqueuer;
        if (workEnqueuer == null) {
            if (Build.VERSION.SDK_INT < 26) {
                compatWorkEnqueuer = new CompatWorkEnqueuer(context, componentName);
            } else if (!z) {
                throw new IllegalArgumentException("Can't be here without a job id");
            } else {
                compatWorkEnqueuer = new JobWorkEnqueuer(context, componentName, i2);
            }
            i.put(componentName, compatWorkEnqueuer);
            workEnqueuer2 = compatWorkEnqueuer;
        }
        return workEnqueuer2;
    }

    public static void enqueueWork(Context context, ComponentName componentName, int i2, Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        synchronized (h) {
            WorkEnqueuer a2 = a(context, componentName, true, i2);
            a2.a(i2);
            a2.a(intent);
        }
    }

    public static void enqueueWork(Context context, Class<?> cls, int i2, Intent intent) {
        enqueueWork(context, new ComponentName(context, cls), i2, intent);
    }

    protected abstract void a(Intent intent);

    void a(boolean z) {
        if (this.f2283c == null) {
            this.f2283c = new CommandProcessor();
            WorkEnqueuer workEnqueuer = this.b;
            if (workEnqueuer != null && z) {
                workEnqueuer.serviceProcessingStarted();
            }
            this.f2283c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    boolean a() {
        CommandProcessor commandProcessor = this.f2283c;
        if (commandProcessor != null) {
            commandProcessor.cancel(this.d);
        }
        this.e = true;
        return onStopCurrentWork();
    }

    void b() {
        ArrayList<CompatWorkItem> arrayList = this.g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f2283c = null;
                if (this.g != null && this.g.size() > 0) {
                    a(false);
                } else if (!this.f) {
                    this.b.serviceProcessingFinished();
                }
            }
        }
    }

    GenericWorkItem c() {
        CompatJobEngine compatJobEngine = this.f2282a;
        if (compatJobEngine != null) {
            return compatJobEngine.dequeueWork();
        }
        synchronized (this.g) {
            if (this.g.size() > 0) {
                return this.g.remove(0);
            }
            return null;
        }
    }

    public boolean isStopped() {
        return this.e;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        CompatJobEngine compatJobEngine = this.f2282a;
        if (compatJobEngine != null) {
            return compatJobEngine.compatGetBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2282a = new JobServiceEngineImpl(this);
            this.b = null;
            return;
        }
        this.f2282a = null;
        this.b = a(this, new ComponentName(this, getClass()), false, 0);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList<CompatWorkItem> arrayList = this.g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f = true;
                this.b.serviceProcessingFinished();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (this.g != null) {
            this.b.serviceStartReceived();
            synchronized (this.g) {
                ArrayList<CompatWorkItem> arrayList = this.g;
                if (intent == null) {
                    intent = new Intent();
                }
                arrayList.add(new CompatWorkItem(intent, i3));
                a(true);
            }
            return 3;
        }
        return 2;
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    public void setInterruptIfStopped(boolean z) {
        this.d = z;
    }
}
