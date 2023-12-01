package com.igexin.base.scheduler;

import android.text.TextUtils;
import com.igexin.base.scheduler.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/base/scheduler/a.class */
public final class a implements b.InterfaceC0445b, c {

    /* renamed from: a  reason: collision with root package name */
    private b f23212a;
    private Map<BaseTask, ScheduledFuture> b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Set<String> f23213c = new HashSet();
    private final Map<String, LinkedBlockingQueue<BaseTask>> d = new HashMap();

    public a() {
        b bVar = new b();
        this.f23212a = bVar;
        bVar.f23214a = this;
    }

    private ScheduledFuture b(BaseTask baseTask) {
        ScheduledFuture<?> schedule;
        ScheduledFuture scheduledFuture = this.b.get(baseTask);
        if (scheduledFuture != null) {
            if (scheduledFuture.cancel(false)) {
                this.b.remove(baseTask);
            }
            BlockingQueue<Runnable> queue = this.f23212a.getQueue();
            if (queue != null) {
                queue.remove(scheduledFuture);
            }
        }
        long initDelay = baseTask.getInitDelay();
        if (baseTask.isPeriodic()) {
            long period = baseTask.getPeriod();
            schedule = period > 0 ? this.f23212a.scheduleAtFixedRate(baseTask, initDelay, period, TimeUnit.MILLISECONDS) : this.f23212a.scheduleWithFixedDelay(baseTask, initDelay, -period, TimeUnit.MILLISECONDS);
        } else {
            schedule = this.f23212a.schedule(baseTask, initDelay, TimeUnit.MILLISECONDS);
        }
        this.b.put(baseTask, schedule);
        return schedule;
    }

    @Override // com.igexin.base.scheduler.b.InterfaceC0445b
    public final void a(BaseTask baseTask) {
        synchronized (this) {
            try {
                this.b.remove(baseTask);
                String groupName = baseTask.getGroupName();
                if (!TextUtils.isEmpty(groupName)) {
                    LinkedBlockingQueue<BaseTask> linkedBlockingQueue = this.d.get(groupName);
                    if (linkedBlockingQueue != null && linkedBlockingQueue.size() > 0) {
                        b(linkedBlockingQueue.poll());
                        return;
                    }
                    this.f23213c.remove(groupName);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.igexin.base.scheduler.c
    public final void execute(BaseTask baseTask) {
        try {
            baseTask.onRunTask();
            baseTask.done();
        } catch (Throwable th) {
            baseTask.onException(th);
        }
    }

    @Override // com.igexin.base.scheduler.c
    public final void submit(BaseTask baseTask) {
        synchronized (this) {
            try {
                String groupName = baseTask.getGroupName();
                boolean z = false;
                if (!TextUtils.isEmpty(groupName)) {
                    if (this.f23213c.contains(groupName)) {
                        if (this.d.get(groupName) == null) {
                            this.d.put(groupName, new LinkedBlockingQueue<>());
                        }
                        z = this.d.get(groupName).offer(baseTask);
                    } else {
                        this.f23213c.add(groupName);
                    }
                }
                if (z) {
                    return;
                }
                b(baseTask);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
