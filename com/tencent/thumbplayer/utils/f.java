package com.tencent.thumbplayer.utils;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static CopyOnWriteArrayList<a> f39431a = new CopyOnWriteArrayList<>();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/f$a.class */
    public interface a {
        void a(int i, int i2, int i3, Object obj);
    }

    public static void a(int i, int i2, int i3, Object obj) {
        synchronized (f.class) {
            try {
                Iterator<a> it = f39431a.iterator();
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
                if (f39431a != null && !f39431a.contains(aVar)) {
                    f39431a.add(aVar);
                    TPLogUtil.i("TPGlobalEventNofication", "add onNetStatus change listener: " + aVar + ", mListeners: " + f39431a.size());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void b(a aVar) {
        synchronized (f.class) {
            try {
                if (f39431a != null) {
                    f39431a.remove(aVar);
                    TPLogUtil.i("TPGlobalEventNofication", "remove netStatusChangeListener, listener: " + aVar + ", mListeners: " + f39431a.size());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
