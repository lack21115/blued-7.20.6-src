package com.igexin.base.scheduler;

import com.igexin.base.scheduler.BaseTask;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/base/scheduler/c.class */
public interface c<T extends BaseTask> {
    void execute(T t);

    void submit(T t);
}
