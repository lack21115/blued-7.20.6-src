package com.weimob.library.groups.imageloader.executor;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import java.util.concurrent.Executor;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/executor/CallerThreadExecutorSupplier.class */
public class CallerThreadExecutorSupplier implements ExecutorSupplier {
    private final Executor mBackgroundExecutor;
    private final Executor mDecodeExecutor;
    private final Executor mIoBoundExecutor;
    private final Executor mLightWeightBackgroundExecutor;

    public CallerThreadExecutorSupplier() {
        CallerThreadExecutor callerThreadExecutor = CallerThreadExecutor.getInstance();
        this.mIoBoundExecutor = callerThreadExecutor;
        this.mDecodeExecutor = callerThreadExecutor;
        this.mBackgroundExecutor = callerThreadExecutor;
        this.mLightWeightBackgroundExecutor = callerThreadExecutor;
    }

    public Executor forBackgroundTasks() {
        return this.mBackgroundExecutor;
    }

    public Executor forDecode() {
        return this.mDecodeExecutor;
    }

    public Executor forLightweightBackgroundTasks() {
        return this.mLightWeightBackgroundExecutor;
    }

    public Executor forLocalStorageRead() {
        return this.mIoBoundExecutor;
    }

    public Executor forLocalStorageWrite() {
        return this.mIoBoundExecutor;
    }
}
