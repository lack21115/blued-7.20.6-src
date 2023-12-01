package androidx.loader.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import androidx.core.util.DebugUtils;
import com.alipay.sdk.util.i;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: source-8756600-dex2jar.jar:androidx/loader/content/Loader.class */
public class Loader<D> {
    int n;
    OnLoadCompleteListener<D> o;
    OnLoadCanceledListener<D> p;
    Context q;
    boolean r = false;
    boolean s = false;
    boolean t = true;
    boolean u = false;
    boolean v = false;

    /* loaded from: source-8756600-dex2jar.jar:androidx/loader/content/Loader$ForceLoadContentObserver.class */
    public final class ForceLoadContentObserver extends ContentObserver {
        public ForceLoadContentObserver() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Loader.this.onContentChanged();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/loader/content/Loader$OnLoadCanceledListener.class */
    public interface OnLoadCanceledListener<D> {
        void onLoadCanceled(Loader<D> loader);
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/loader/content/Loader$OnLoadCompleteListener.class */
    public interface OnLoadCompleteListener<D> {
        void onLoadComplete(Loader<D> loader, D d);
    }

    public Loader(Context context) {
        this.q = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
    }

    public void abandon() {
        this.s = true;
        h();
    }

    protected boolean b() {
        return false;
    }

    public boolean cancelLoad() {
        return b();
    }

    public void commitContentChanged() {
        this.v = false;
    }

    public String dataToString(D d) {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(d, sb);
        sb.append(i.d);
        return sb.toString();
    }

    public void deliverCancellation() {
        OnLoadCanceledListener<D> onLoadCanceledListener = this.p;
        if (onLoadCanceledListener != null) {
            onLoadCanceledListener.onLoadCanceled(this);
        }
    }

    public void deliverResult(D d) {
        OnLoadCompleteListener<D> onLoadCompleteListener = this.o;
        if (onLoadCompleteListener != null) {
            onLoadCompleteListener.onLoadComplete(this, d);
        }
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.n);
        printWriter.print(" mListener=");
        printWriter.println(this.o);
        if (this.r || this.u || this.v) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.r);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.u);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.v);
        }
        if (this.s || this.t) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.s);
            printWriter.print(" mReset=");
            printWriter.println(this.t);
        }
    }

    protected void e() {
    }

    protected void f() {
    }

    public void forceLoad() {
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
    }

    public Context getContext() {
        return this.q;
    }

    public int getId() {
        return this.n;
    }

    protected void h() {
    }

    public boolean isAbandoned() {
        return this.s;
    }

    public boolean isReset() {
        return this.t;
    }

    public boolean isStarted() {
        return this.r;
    }

    public void onContentChanged() {
        if (this.r) {
            forceLoad();
        } else {
            this.u = true;
        }
    }

    public void registerListener(int i, OnLoadCompleteListener<D> onLoadCompleteListener) {
        if (this.o != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.o = onLoadCompleteListener;
        this.n = i;
    }

    public void registerOnLoadCanceledListener(OnLoadCanceledListener<D> onLoadCanceledListener) {
        if (this.p != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.p = onLoadCanceledListener;
    }

    public void reset() {
        g();
        this.t = true;
        this.r = false;
        this.s = false;
        this.u = false;
        this.v = false;
    }

    public void rollbackContentChanged() {
        if (this.v) {
            onContentChanged();
        }
    }

    public final void startLoading() {
        this.r = true;
        this.t = false;
        this.s = false;
        e();
    }

    public void stopLoading() {
        this.r = false;
        f();
    }

    public boolean takeContentChanged() {
        boolean z = this.u;
        this.u = false;
        this.v |= z;
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(this, sb);
        sb.append(" id=");
        sb.append(this.n);
        sb.append(i.d);
        return sb.toString();
    }

    public void unregisterListener(OnLoadCompleteListener<D> onLoadCompleteListener) {
        OnLoadCompleteListener<D> onLoadCompleteListener2 = this.o;
        if (onLoadCompleteListener2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (onLoadCompleteListener2 != onLoadCompleteListener) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.o = null;
    }

    public void unregisterOnLoadCanceledListener(OnLoadCanceledListener<D> onLoadCanceledListener) {
        OnLoadCanceledListener<D> onLoadCanceledListener2 = this.p;
        if (onLoadCanceledListener2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (onLoadCanceledListener2 != onLoadCanceledListener) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.p = null;
    }
}
