package com.bumptech.glide.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/util/Executors.class */
public final class Executors {

    /* renamed from: a  reason: collision with root package name */
    private static final Executor f21100a = new Executor() { // from class: com.bumptech.glide.util.Executors.1

        /* renamed from: a  reason: collision with root package name */
        private final Handler f21101a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f21101a.post(runnable);
        }
    };
    private static final Executor b = new Executor() { // from class: com.bumptech.glide.util.Executors.2
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }
    };

    private Executors() {
    }

    public static Executor a() {
        return f21100a;
    }

    public static Executor b() {
        return b;
    }
}
