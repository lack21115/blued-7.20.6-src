package com.blued.android.core.ui;

import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import java.util.HashSet;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/ui/UIRunnableManager.class */
public class UIRunnableManager {
    private static final WeakHashMap<IRequestHost, HashSet<UITask>> a = new WeakHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/ui/UIRunnableManager$UITask.class */
    public static class UITask implements Runnable {
        private final IRequestHost a;
        private final Runnable b;

        public UITask(IRequestHost iRequestHost, Runnable runnable) {
            this.a = iRequestHost;
            this.b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            IRequestHost iRequestHost = this.a;
            if (iRequestHost != null) {
                UIRunnableManager.b(iRequestHost, this);
                if (this.a.isActive()) {
                    this.b.run();
                }
            }
        }
    }

    public static void a(IRequestHost iRequestHost) {
        if (iRequestHost == null) {
            return;
        }
        synchronized (a) {
            HashSet<UITask> hashSet = a.get(iRequestHost);
            if (hashSet != null) {
                Iterator<UITask> it = hashSet.iterator();
                while (it.hasNext()) {
                    UITask next = it.next();
                    if (next != null) {
                        AppInfo.n().removeCallbacks(next);
                    }
                }
                hashSet.clear();
            }
            a.remove(iRequestHost);
        }
    }

    public static boolean a(IRequestHost iRequestHost, Runnable runnable, long j) {
        if (iRequestHost == null || !iRequestHost.isActive() || runnable == null) {
            return false;
        }
        UITask uITask = new UITask(iRequestHost, runnable);
        if (0 == j) {
            AppInfo.n().post(uITask);
        } else {
            AppInfo.n().postDelayed(uITask, j);
        }
        synchronized (a) {
            HashSet<UITask> hashSet = a.get(iRequestHost);
            HashSet<UITask> hashSet2 = hashSet;
            if (hashSet == null) {
                hashSet2 = new HashSet<>();
                a.put(iRequestHost, hashSet2);
            }
            hashSet2.add(uITask);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(IRequestHost iRequestHost, UITask uITask) {
        if (iRequestHost == null || uITask == null) {
            return;
        }
        synchronized (a) {
            HashSet<UITask> hashSet = a.get(iRequestHost);
            if (hashSet != null) {
                hashSet.remove(uITask);
            }
        }
    }
}
