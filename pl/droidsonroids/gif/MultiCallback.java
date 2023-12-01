package pl.droidsonroids.gif;

import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/MultiCallback.class */
public class MultiCallback implements Drawable.Callback {
    private final CopyOnWriteArrayList<CallbackWeakReference> a;
    private final boolean b;

    /* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/MultiCallback$CallbackWeakReference.class */
    static final class CallbackWeakReference extends WeakReference<Drawable.Callback> {
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && get() == ((CallbackWeakReference) obj).get();
        }

        public int hashCode() {
            Drawable.Callback callback = get();
            if (callback != null) {
                return callback.hashCode();
            }
            return 0;
        }
    }

    public MultiCallback() {
        this(false);
    }

    public MultiCallback(boolean z) {
        this.a = new CopyOnWriteArrayList<>();
        this.b = z;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.a.size()) {
                return;
            }
            CallbackWeakReference callbackWeakReference = this.a.get(i2);
            Drawable.Callback callback = callbackWeakReference.get();
            if (callback == null) {
                this.a.remove(callbackWeakReference);
            } else if (this.b && (callback instanceof View)) {
                ((View) callback).invalidate();
            } else {
                callback.invalidateDrawable(drawable);
            }
            i = i2 + 1;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.a.size()) {
                return;
            }
            CallbackWeakReference callbackWeakReference = this.a.get(i2);
            Drawable.Callback callback = callbackWeakReference.get();
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            } else {
                this.a.remove(callbackWeakReference);
            }
            i = i2 + 1;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.a.size()) {
                return;
            }
            CallbackWeakReference callbackWeakReference = this.a.get(i2);
            Drawable.Callback callback = callbackWeakReference.get();
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            } else {
                this.a.remove(callbackWeakReference);
            }
            i = i2 + 1;
        }
    }
}
