package com.igexin.base.scheduler.task;

import com.igexin.base.api.GTSchedulerManager;
import com.igexin.base.scheduler.BaseTask;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/base/scheduler/task/SimpleTask.class */
public abstract class SimpleTask extends BaseTask {
    public SimpleTask() {
        super(0L, TimeUnit.MILLISECONDS);
        setTaskLevel(GTSchedulerManager.TASKLEVEL.LEVEL_DEFAULT);
    }
}
