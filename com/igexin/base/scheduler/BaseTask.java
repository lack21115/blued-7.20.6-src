package com.igexin.base.scheduler;

import com.igexin.base.api.GTSchedulerManager;
import com.igexin.base.scheduler.b;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/base/scheduler/BaseTask.class */
public abstract class BaseTask implements Runnable {
    private static final String TAG = "BaseTask";
    private String groupName;
    private long initDelay;
    private volatile int isRunVal;
    private b.a mParent;
    private long period;
    private AtomicBoolean isCanceled = new AtomicBoolean();
    private GTSchedulerManager.TASKLEVEL taskLevel = GTSchedulerManager.TASKLEVEL.LEVEL_DEFAULT;

    public BaseTask(long j, long j2, TimeUnit timeUnit, boolean z) {
        setDelayImpl(j, j2, timeUnit, z);
    }

    public BaseTask(long j, TimeUnit timeUnit) {
        setDelayImpl(j, 0L, timeUnit, true);
    }

    private void setDelayImpl(long j, long j2, TimeUnit timeUnit, boolean z) {
        this.initDelay = TimeUnit.MILLISECONDS.convert(j, timeUnit);
        this.period = (z ? 1 : -1) * TimeUnit.MILLISECONDS.convert(j2, timeUnit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bind(b.a aVar) {
        if (aVar == null) {
            return;
        }
        this.mParent = aVar;
    }

    public boolean cancel() {
        b.a aVar = this.mParent;
        if (aVar != null) {
            return aVar.cancel(false);
        }
        this.isCanceled.set(true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void done() {
    }

    public String getGroupName() {
        return this.groupName;
    }

    public long getInitDelay() {
        return this.initDelay;
    }

    public long getPeriod() {
        return this.period;
    }

    public int getTaskLevel() {
        return this.taskLevel.val;
    }

    public boolean interrupt() {
        b.a aVar = this.mParent;
        if (aVar != null) {
            return aVar.cancel(true);
        }
        this.isCanceled.set(true);
        return true;
    }

    public boolean isPeriodic() {
        return this.period != 0;
    }

    public boolean isRunning() {
        return this.isRunVal != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCancel() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onException(Throwable th) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onRunTask();

    @Override // java.lang.Runnable
    public final void run() {
        if (this.isCanceled.get()) {
            return;
        }
        setIsRunning(true);
        onRunTask();
    }

    public void setDelay(long j, long j2, TimeUnit timeUnit, boolean z) {
        setDelayImpl(j, j2, timeUnit, z);
    }

    public void setDelay(long j, TimeUnit timeUnit) {
        setDelayImpl(j, 0L, timeUnit, true);
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void setIsRunning(boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public void setTaskLevel(GTSchedulerManager.TASKLEVEL tasklevel) {
        this.taskLevel = tasklevel;
    }
}
