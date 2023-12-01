package androidx.core.os;

import android.os.Build;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/os/CancellationSignal.class */
public final class CancellationSignal {

    /* renamed from: a  reason: collision with root package name */
    private boolean f2457a;
    private OnCancelListener b;

    /* renamed from: c  reason: collision with root package name */
    private Object f2458c;
    private boolean d;

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/os/CancellationSignal$OnCancelListener.class */
    public interface OnCancelListener {
        void onCancel();
    }

    private void a() {
        while (this.d) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }

    public void cancel() {
        synchronized (this) {
            if (this.f2457a) {
                return;
            }
            this.f2457a = true;
            this.d = true;
            OnCancelListener onCancelListener = this.b;
            Object obj = this.f2458c;
            if (onCancelListener != null) {
                try {
                    onCancelListener.onCancel();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.d = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (obj != null && Build.VERSION.SDK_INT >= 16) {
                ((android.os.CancellationSignal) obj).cancel();
            }
            synchronized (this) {
                this.d = false;
                notifyAll();
            }
        }
    }

    public Object getCancellationSignalObject() {
        Object obj;
        if (Build.VERSION.SDK_INT < 16) {
            return null;
        }
        synchronized (this) {
            if (this.f2458c == null) {
                android.os.CancellationSignal cancellationSignal = new android.os.CancellationSignal();
                this.f2458c = cancellationSignal;
                if (this.f2457a) {
                    cancellationSignal.cancel();
                }
            }
            obj = this.f2458c;
        }
        return obj;
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this) {
            z = this.f2457a;
        }
        return z;
    }

    public void setOnCancelListener(OnCancelListener onCancelListener) {
        synchronized (this) {
            a();
            if (this.b == onCancelListener) {
                return;
            }
            this.b = onCancelListener;
            if (!this.f2457a || onCancelListener == null) {
                return;
            }
            onCancelListener.onCancel();
        }
    }

    public void throwIfCanceled() {
        if (isCanceled()) {
            throw new OperationCanceledException();
        }
    }
}
