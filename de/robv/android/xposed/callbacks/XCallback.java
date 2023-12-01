package de.robv.android.xposed.callbacks;

import android.os.Bundle;
import de.robv.android.xposed.XposedBridge;
import java.io.Serializable;

/* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/callbacks/XCallback.class */
public abstract class XCallback implements Comparable<XCallback> {
    public static final int PRIORITY_DEFAULT = 50;
    public static final int PRIORITY_HIGHEST = 10000;
    public static final int PRIORITY_LOWEST = -10000;
    public final int priority;

    /* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/callbacks/XCallback$Param.class */
    public static abstract class Param {
        public final Object[] callbacks;
        private Bundle extra;

        /* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/callbacks/XCallback$Param$SerializeWrapper.class */
        private static class SerializeWrapper implements Serializable {
            private static final long serialVersionUID = 1;
            private final Object object;

            public SerializeWrapper(Object obj) {
                this.object = obj;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Deprecated
        public Param() {
            this.callbacks = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Param(XposedBridge.CopyOnWriteSortedSet<? extends XCallback> copyOnWriteSortedSet) {
            this.callbacks = copyOnWriteSortedSet.getSnapshot();
        }

        public Bundle getExtra() {
            Bundle bundle;
            synchronized (this) {
                if (this.extra == null) {
                    this.extra = new Bundle();
                }
                bundle = this.extra;
            }
            return bundle;
        }

        public Object getObjectExtra(String str) {
            Serializable serializable = getExtra().getSerializable(str);
            if (serializable instanceof SerializeWrapper) {
                return ((SerializeWrapper) serializable).object;
            }
            return null;
        }

        public void setObjectExtra(String str, Object obj) {
            getExtra().putSerializable(str, new SerializeWrapper(obj));
        }
    }

    @Deprecated
    public XCallback() {
        this.priority = 50;
    }

    public XCallback(int i) {
        this.priority = i;
    }

    public static void callAll(Param param) {
        if (param.callbacks == null) {
            throw new IllegalStateException("This object was not created for use with callAll");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= param.callbacks.length) {
                return;
            }
            try {
                ((XCallback) param.callbacks[i2]).call(param);
            } catch (Throwable th) {
                XposedBridge.log(th);
            }
            i = i2 + 1;
        }
    }

    protected void call(Param param) throws Throwable {
    }

    @Override // java.lang.Comparable
    public int compareTo(XCallback xCallback) {
        if (this == xCallback) {
            return 0;
        }
        return xCallback.priority != this.priority ? xCallback.priority - this.priority : System.identityHashCode(this) < System.identityHashCode(xCallback) ? -1 : 1;
    }
}
