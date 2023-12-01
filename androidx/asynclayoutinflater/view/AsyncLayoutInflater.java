package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Pools;
import java.util.concurrent.ArrayBlockingQueue;

/* loaded from: source-8756600-dex2jar.jar:androidx/asynclayoutinflater/view/AsyncLayoutInflater.class */
public final class AsyncLayoutInflater {

    /* renamed from: a  reason: collision with root package name */
    LayoutInflater f1876a;
    private Handler.Callback d = new Handler.Callback() { // from class: androidx.asynclayoutinflater.view.AsyncLayoutInflater.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InflateRequest inflateRequest = (InflateRequest) message.obj;
            if (inflateRequest.d == null) {
                inflateRequest.d = AsyncLayoutInflater.this.f1876a.inflate(inflateRequest.f1881c, inflateRequest.b, false);
            }
            inflateRequest.e.onInflateFinished(inflateRequest.d, inflateRequest.f1881c, inflateRequest.b);
            AsyncLayoutInflater.this.f1877c.releaseRequest(inflateRequest);
            return true;
        }
    };
    Handler b = new Handler(this.d);

    /* renamed from: c  reason: collision with root package name */
    InflateThread f1877c = InflateThread.getInstance();

    /* loaded from: source-8756600-dex2jar.jar:androidx/asynclayoutinflater/view/AsyncLayoutInflater$BasicInflater.class */
    static class BasicInflater extends LayoutInflater {

        /* renamed from: a  reason: collision with root package name */
        private static final String[] f1879a = {"android.widget.", "android.webkit.", "android.app."};

        BasicInflater(Context context) {
            super(context);
        }

        @Override // android.view.LayoutInflater
        public LayoutInflater cloneInContext(Context context) {
            return new BasicInflater(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.view.LayoutInflater
        public View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
            View createView;
            String[] strArr = f1879a;
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return super.onCreateView(str, attributeSet);
                }
                try {
                    createView = createView(str, strArr[i2], attributeSet);
                } catch (ClassNotFoundException e) {
                }
                if (createView != null) {
                    return createView;
                }
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/asynclayoutinflater/view/AsyncLayoutInflater$InflateRequest.class */
    public static class InflateRequest {

        /* renamed from: a  reason: collision with root package name */
        AsyncLayoutInflater f1880a;
        ViewGroup b;

        /* renamed from: c  reason: collision with root package name */
        int f1881c;
        View d;
        OnInflateFinishedListener e;

        InflateRequest() {
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/asynclayoutinflater/view/AsyncLayoutInflater$InflateThread.class */
    static class InflateThread extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private static final InflateThread f1882a;
        private ArrayBlockingQueue<InflateRequest> b = new ArrayBlockingQueue<>(10);

        /* renamed from: c  reason: collision with root package name */
        private Pools.SynchronizedPool<InflateRequest> f1883c = new Pools.SynchronizedPool<>(10);

        static {
            InflateThread inflateThread = new InflateThread();
            f1882a = inflateThread;
            inflateThread.start();
        }

        private InflateThread() {
        }

        public static InflateThread getInstance() {
            return f1882a;
        }

        public void enqueue(InflateRequest inflateRequest) {
            try {
                this.b.put(inflateRequest);
            } catch (InterruptedException e) {
                throw new RuntimeException("Failed to enqueue async inflate request", e);
            }
        }

        public InflateRequest obtainRequest() {
            InflateRequest acquire = this.f1883c.acquire();
            InflateRequest inflateRequest = acquire;
            if (acquire == null) {
                inflateRequest = new InflateRequest();
            }
            return inflateRequest;
        }

        public void releaseRequest(InflateRequest inflateRequest) {
            inflateRequest.e = null;
            inflateRequest.f1880a = null;
            inflateRequest.b = null;
            inflateRequest.f1881c = 0;
            inflateRequest.d = null;
            this.f1883c.release(inflateRequest);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                runInner();
            }
        }

        public void runInner() {
            try {
                InflateRequest take = this.b.take();
                try {
                    take.d = take.f1880a.f1876a.inflate(take.f1881c, take.b, false);
                } catch (RuntimeException e) {
                    Log.w("AsyncLayoutInflater", "Failed to inflate resource in the background! Retrying on the UI thread", e);
                }
                Message.obtain(take.f1880a.b, 0, take).sendToTarget();
            } catch (InterruptedException e2) {
                Log.w("AsyncLayoutInflater", e2);
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/asynclayoutinflater/view/AsyncLayoutInflater$OnInflateFinishedListener.class */
    public interface OnInflateFinishedListener {
        void onInflateFinished(View view, int i, ViewGroup viewGroup);
    }

    public AsyncLayoutInflater(Context context) {
        this.f1876a = new BasicInflater(context);
    }

    public void inflate(int i, ViewGroup viewGroup, OnInflateFinishedListener onInflateFinishedListener) {
        if (onInflateFinishedListener == null) {
            throw new NullPointerException("callback argument may not be null!");
        }
        InflateRequest obtainRequest = this.f1877c.obtainRequest();
        obtainRequest.f1880a = this;
        obtainRequest.f1881c = i;
        obtainRequest.b = viewGroup;
        obtainRequest.e = onInflateFinishedListener;
        this.f1877c.enqueue(obtainRequest);
    }
}
