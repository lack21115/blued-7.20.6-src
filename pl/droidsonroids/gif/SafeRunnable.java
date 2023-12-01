package pl.droidsonroids.gif;

import java.lang.Thread;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/SafeRunnable.class */
public abstract class SafeRunnable implements Runnable {
    final GifDrawable c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SafeRunnable(GifDrawable gifDrawable) {
        this.c = gifDrawable;
    }

    abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.c.a()) {
                return;
            }
            a();
        } catch (Throwable th) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null) {
                defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
            throw th;
        }
    }
}
