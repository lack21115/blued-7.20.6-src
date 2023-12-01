package com.tencent.thumbplayer.utils;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static CopyOnWriteArrayList<a> f25740a = new CopyOnWriteArrayList<>();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/f$a.class */
    public interface a {
        void a(int i, int i2, int i3, Object obj);
    }

    public static void a(int i, int i2, int i3, Object obj) {
        synchronized (f.class) {
            try {
                Iterator<a> it = f25740a.iterator();
                while (it.hasNext()) {
                    it.next().a(i, i2, i3, obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(a aVar) {
        synchronized (f.class) {
            try {
                if (f25740a != null && !f25740a.contains(aVar)) {
                    f25740a.add(aVar);
                    TPLogUtil.i("TPGlobalEventNofication", "add onNetStatus change listener: " + aVar + ", mListeners: " + f25740a.size());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void b(a aVar) {
        synchronized (f.class) {
            try {
                if (f25740a != null) {
                    f25740a.remove(aVar);
                    TPLogUtil.i("TPGlobalEventNofication", "remove netStatusChangeListener, listener: " + aVar + ", mListeners: " + f25740a.size());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
