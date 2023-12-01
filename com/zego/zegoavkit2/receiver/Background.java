package com.zego.zegoavkit2.receiver;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/receiver/Background.class */
class Background implements Application.ActivityLifecycleCallbacks {
    private static final long CHECK_DELAY = 10;
    public static final String TAG = "BackgroundMonitor";
    private Application application;
    private boolean background;
    private static Callback becameForeground = new Callback() { // from class: com.zego.zegoavkit2.receiver.Background.1
        @Override // com.zego.zegoavkit2.receiver.Background.Callback
        public void invoke(Listener listener) {
            listener.onBecameForeground();
        }
    };
    private static Callback becameBackground = new Callback() { // from class: com.zego.zegoavkit2.receiver.Background.2
        @Override // com.zego.zegoavkit2.receiver.Background.Callback
        public void invoke(Listener listener) {
            listener.onBecameBackground();
        }
    };
    private static Background instance = new Background();
    private Listeners listeners = new Listeners();
    private boolean isInit = false;
    private Set<Integer> pageList = new HashSet();
    private Set<Integer> pagePauseList = new HashSet();
    private Lock lock = new ReentrantLock();

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/receiver/Background$Binding.class */
    public interface Binding {
        void unbind();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/receiver/Background$Callback.class */
    public interface Callback {
        void invoke(Listener listener);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/receiver/Background$Listener.class */
    public interface Listener {
        void onBecameBackground();

        void onBecameForeground();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/receiver/Background$Listeners.class */
    public static class Listeners {
        private List<WeakReference<Listener>> listeners;

        private Listeners() {
            this.listeners = new CopyOnWriteArrayList();
        }

        public Binding add(Listener listener) {
            final WeakReference<Listener> weakReference = new WeakReference<>(listener);
            this.listeners.add(weakReference);
            return new Binding() { // from class: com.zego.zegoavkit2.receiver.Background.Listeners.1
                @Override // com.zego.zegoavkit2.receiver.Background.Binding
                public void unbind() {
                    Listeners.this.listeners.remove(weakReference);
                }
            };
        }

        public void each(Callback callback) {
            ArrayList arrayList = new ArrayList();
            for (WeakReference<Listener> weakReference : this.listeners) {
                try {
                    Listener listener = weakReference.get();
                    if (listener != null) {
                        callback.invoke(listener);
                    } else {
                        arrayList.add(weakReference);
                    }
                } catch (Exception e) {
                    Log.e("BackgroundMonitor", "Listener threw exception!", e);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.listeners.removeAll(arrayList);
        }
    }

    Background() {
    }

    private boolean checkBackground() {
        this.application.getPackageName();
        ActivityManager activityManager = (ActivityManager) this.application.getSystemService("activity");
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        return (runningAppProcessInfo.importance == 100 || runningAppProcessInfo.importance == 200) ? false : true;
    }

    public static Background get() {
        return instance;
    }

    private void handleActivityOpen(int i) {
        if (this.pageList.contains(Integer.valueOf(i))) {
            return;
        }
        this.pageList.add(Integer.valueOf(i));
        if (this.background) {
            this.background = false;
            this.listeners.each(becameForeground);
        }
    }

    private void handleActivityPause(int i) {
        if (this.pagePauseList.contains(Integer.valueOf(i))) {
            return;
        }
        this.pagePauseList.add(Integer.valueOf(i));
    }

    private void handleActivityStop(int i) {
        if (this.pageList.contains(Integer.valueOf(i))) {
            this.pageList.remove(Integer.valueOf(i));
            if (this.pageList.size() == 0) {
                if (!this.background) {
                    this.background = true;
                    this.listeners.each(becameBackground);
                }
            } else if (this.background) {
                this.background = false;
                this.listeners.each(becameForeground);
            }
        } else if (this.pageList.size() == 0) {
            if (this.pagePauseList.contains(Integer.valueOf(i)) && !this.background) {
                this.background = true;
                this.listeners.each(becameBackground);
            }
        } else if (this.background) {
            this.background = false;
            this.listeners.each(becameForeground);
        }
        this.pagePauseList.remove(Integer.valueOf(i));
    }

    public Binding addListener(Listener listener) {
        return this.listeners.add(listener);
    }

    public Background init(Application application) {
        uninit();
        this.application = application;
        application.registerActivityLifecycleCallbacks(this);
        this.lock.lock();
        try {
            this.background = checkBackground();
            this.isInit = true;
            return this;
        } finally {
            this.lock.unlock();
        }
    }

    public boolean isBackground() {
        return this.background;
    }

    public boolean isForeground() {
        return !this.background;
    }

    public boolean isInited() {
        return this.isInit;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        int hashCode = activity.hashCode();
        this.lock.lock();
        try {
            if (this.isInit) {
                handleActivityOpen(hashCode);
            }
        } finally {
            this.lock.unlock();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        int hashCode = activity.hashCode();
        this.lock.lock();
        try {
            if (this.isInit) {
                handleActivityStop(hashCode);
            }
        } finally {
            this.lock.unlock();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        int hashCode = activity.hashCode();
        this.lock.lock();
        try {
            if (this.isInit) {
                handleActivityPause(hashCode);
            }
        } finally {
            this.lock.unlock();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        int hashCode = activity.hashCode();
        this.lock.lock();
        try {
            if (this.isInit) {
                handleActivityOpen(hashCode);
            }
        } finally {
            this.lock.unlock();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        int hashCode = activity.hashCode();
        this.lock.lock();
        try {
            if (this.isInit) {
                handleActivityOpen(hashCode);
            }
        } finally {
            this.lock.unlock();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int hashCode = activity.hashCode();
        this.lock.lock();
        try {
            if (this.isInit) {
                handleActivityStop(hashCode);
            }
        } finally {
            this.lock.unlock();
        }
    }

    public Background uninit() {
        Application application = this.application;
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(this);
            this.application = null;
        }
        this.lock.lock();
        try {
            this.pageList.clear();
            this.pagePauseList.clear();
            this.isInit = false;
            return this;
        } finally {
            this.lock.unlock();
        }
    }
}
