package androidx.loader.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.os.OperationCanceledException;
import androidx.core.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* loaded from: source-8756600-dex2jar.jar:androidx/loader/content/AsyncTaskLoader.class */
public abstract class AsyncTaskLoader<D> extends Loader<D> {

    /* renamed from: a  reason: collision with root package name */
    volatile AsyncTaskLoader<D>.LoadTask f3034a;
    volatile AsyncTaskLoader<D>.LoadTask b;

    /* renamed from: c  reason: collision with root package name */
    long f3035c;
    long d;
    Handler e;
    private final Executor f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/loader/content/AsyncTaskLoader$LoadTask.class */
    public final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        boolean f3036a;
        private final CountDownLatch e = new CountDownLatch(1);

        LoadTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.loader.content.ModernAsyncTask
        public D a(Void... voidArr) {
            try {
                return (D) AsyncTaskLoader.this.d();
            } catch (OperationCanceledException e) {
                if (isCancelled()) {
                    return null;
                }
                throw e;
            }
        }

        @Override // androidx.loader.content.ModernAsyncTask
        protected void a(D d) {
            try {
                AsyncTaskLoader.this.b(this, d);
            } finally {
                this.e.countDown();
            }
        }

        @Override // androidx.loader.content.ModernAsyncTask
        protected void b(D d) {
            try {
                AsyncTaskLoader.this.a(this, d);
            } finally {
                this.e.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3036a = false;
            AsyncTaskLoader.this.c();
        }

        public void waitForLoader() {
            try {
                this.e.await();
            } catch (InterruptedException e) {
            }
        }
    }

    public AsyncTaskLoader(Context context) {
        this(context, ModernAsyncTask.THREAD_POOL_EXECUTOR);
    }

    private AsyncTaskLoader(Context context, Executor executor) {
        super(context);
        this.d = -10000L;
        this.f = executor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.loader.content.Loader
    public void a() {
        super.a();
        cancelLoad();
        this.f3034a = new LoadTask();
        c();
    }

    void a(AsyncTaskLoader<D>.LoadTask loadTask, D d) {
        onCanceled(d);
        if (this.b == loadTask) {
            rollbackContentChanged();
            this.d = SystemClock.uptimeMillis();
            this.b = null;
            deliverCancellation();
            c();
        }
    }

    void b(AsyncTaskLoader<D>.LoadTask loadTask, D d) {
        if (this.f3034a != loadTask) {
            a(loadTask, d);
        } else if (isAbandoned()) {
            onCanceled(d);
        } else {
            commitContentChanged();
            this.d = SystemClock.uptimeMillis();
            this.f3034a = null;
            deliverResult(d);
        }
    }

    @Override // androidx.loader.content.Loader
    protected boolean b() {
        if (this.f3034a != null) {
            if (!this.r) {
                this.u = true;
            }
            if (this.b != null) {
                if (this.f3034a.f3036a) {
                    this.f3034a.f3036a = false;
                    this.e.removeCallbacks(this.f3034a);
                }
                this.f3034a = null;
                return false;
            } else if (this.f3034a.f3036a) {
                this.f3034a.f3036a = false;
                this.e.removeCallbacks(this.f3034a);
                this.f3034a = null;
                return false;
            } else {
                boolean cancel = this.f3034a.cancel(false);
                if (cancel) {
                    this.b = this.f3034a;
                    cancelLoadInBackground();
                }
                this.f3034a = null;
                return cancel;
            }
        }
        return false;
    }

    void c() {
        if (this.b != null || this.f3034a == null) {
            return;
        }
        if (this.f3034a.f3036a) {
            this.f3034a.f3036a = false;
            this.e.removeCallbacks(this.f3034a);
        }
        if (this.f3035c <= 0 || SystemClock.uptimeMillis() >= this.d + this.f3035c) {
            this.f3034a.executeOnExecutor(this.f, null);
            return;
        }
        this.f3034a.f3036a = true;
        this.e.postAtTime(this.f3034a, this.d + this.f3035c);
    }

    public void cancelLoadInBackground() {
    }

    protected D d() {
        return loadInBackground();
    }

    @Override // androidx.loader.content.Loader
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.f3034a != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f3034a);
            printWriter.print(" waiting=");
            printWriter.println(this.f3034a.f3036a);
        }
        if (this.b != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.b);
            printWriter.print(" waiting=");
            printWriter.println(this.b.f3036a);
        }
        if (this.f3035c != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            TimeUtils.formatDuration(this.f3035c, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            TimeUtils.formatDuration(this.d, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    public boolean isLoadInBackgroundCanceled() {
        return this.b != null;
    }

    public abstract D loadInBackground();

    public void onCanceled(D d) {
    }

    public void setUpdateThrottle(long j) {
        this.f3035c = j;
        if (j != 0) {
            this.e = new Handler();
        }
    }

    public void waitForLoader() {
        AsyncTaskLoader<D>.LoadTask loadTask = this.f3034a;
        if (loadTask != null) {
            loadTask.waitForLoader();
        }
    }
}
