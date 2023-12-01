package com.jeremyliao.liveeventbus.core;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.ExternalLiveData;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.jeremyliao.liveeventbus.ipc.consts.IpcConst;
import com.jeremyliao.liveeventbus.ipc.core.ProcessorManager;
import com.jeremyliao.liveeventbus.ipc.receiver.LebIpcReceiver;
import com.jeremyliao.liveeventbus.logger.DefaultLogger;
import com.jeremyliao.liveeventbus.logger.Logger;
import com.jeremyliao.liveeventbus.logger.LoggerManager;
import com.jeremyliao.liveeventbus.utils.AppUtils;
import com.jeremyliao.liveeventbus.utils.ThreadUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

/* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/core/LiveEventBusCore.class */
public final class LiveEventBusCore {
    private boolean autoClear;
    private final Map<String, LiveEvent<Object>> bus;
    private final Config config;
    final InnerConsole console;
    private boolean isRegisterReceiver;
    private boolean lifecycleObserverAlwaysActive;
    private LoggerManager logger;
    private LebIpcReceiver receiver;

    /* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/core/LiveEventBusCore$InnerConsole.class */
    class InnerConsole {
        InnerConsole() {
        }

        private int getActiveCount(LiveData liveData) {
            try {
                Field declaredField = LiveData.class.getDeclaredField("mActiveCount");
                declaredField.setAccessible(true);
                return ((Integer) declaredField.get(liveData)).intValue();
            } catch (Exception e) {
                return -1;
            }
        }

        private int getObserverCount(LiveData liveData) {
            try {
                Field declaredField = LiveData.class.getDeclaredField("mObservers");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(liveData);
                Method declaredMethod = obj.getClass().getDeclaredMethod("size", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((Integer) declaredMethod.invoke(obj, new Object[0])).intValue();
            } catch (Exception e) {
                return -1;
            }
        }

        private String getObserverInfo(LiveData liveData) {
            try {
                Field declaredField = LiveData.class.getDeclaredField("mObservers");
                declaredField.setAccessible(true);
                return declaredField.get(liveData).toString();
            } catch (Exception e) {
                return "";
            }
        }

        String getBaseInfo() {
            return "lifecycleObserverAlwaysActive: " + LiveEventBusCore.this.lifecycleObserverAlwaysActive + "\nautoClear: " + LiveEventBusCore.this.autoClear + "\nlogger enable: " + LiveEventBusCore.this.logger.isEnable() + "\nlogger: " + LiveEventBusCore.this.logger.getLogger() + "\nReceiver register: " + LiveEventBusCore.this.isRegisterReceiver + "\nApplication: " + AppUtils.getApp() + "\n";
        }

        String getBusInfo() {
            StringBuilder sb = new StringBuilder();
            for (String str : LiveEventBusCore.this.bus.keySet()) {
                sb.append("Event name: " + str);
                sb.append("\n");
                LiveEvent.LifecycleLiveData lifecycleLiveData = ((LiveEvent) LiveEventBusCore.this.bus.get(str)).liveData;
                sb.append("\tversion: " + lifecycleLiveData.getVersion());
                sb.append("\n");
                sb.append("\thasActiveObservers: " + lifecycleLiveData.hasActiveObservers());
                sb.append("\n");
                sb.append("\thasObservers: " + lifecycleLiveData.hasObservers());
                sb.append("\n");
                sb.append("\tActiveCount: " + getActiveCount(lifecycleLiveData));
                sb.append("\n");
                sb.append("\tObserverCount: " + getObserverCount(lifecycleLiveData));
                sb.append("\n");
                sb.append("\tObservers: ");
                sb.append("\n");
                sb.append("\t\t" + getObserverInfo(lifecycleLiveData));
                sb.append("\n");
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getConsoleInfo() {
            return "*********Base info*********\n" + getBaseInfo() + "*********Event info*********\n" + getBusInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/core/LiveEventBusCore$LiveEvent.class */
    public class LiveEvent<T> implements Observable<T> {
        private final String key;
        private final Map<Observer, ObserverWrapper<T>> observerMap = new HashMap();
        private final Handler mainHandler = new Handler(Looper.getMainLooper());
        private final LiveEvent<T>.LifecycleLiveData<T> liveData = new LifecycleLiveData<>();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/core/LiveEventBusCore$LiveEvent$LifecycleLiveData.class */
        public class LifecycleLiveData<T> extends ExternalLiveData<T> {
            private LifecycleLiveData() {
            }

            @Override // androidx.lifecycle.ExternalLiveData
            public Lifecycle.State observerActiveLevel() {
                return LiveEventBusCore.this.lifecycleObserverAlwaysActive ? Lifecycle.State.CREATED : Lifecycle.State.STARTED;
            }

            @Override // androidx.lifecycle.LiveData
            public void removeObserver(Observer<? super T> observer) {
                super.removeObserver(observer);
                if (LiveEventBusCore.this.autoClear && !LiveEvent.this.liveData.hasObservers()) {
                    LiveEventBusCore.get().bus.remove(LiveEvent.this.key);
                }
                LoggerManager loggerManager = LiveEventBusCore.this.logger;
                Level level = Level.INFO;
                loggerManager.log(level, "observer removed: " + observer);
            }
        }

        /* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/core/LiveEventBusCore$LiveEvent$PostLifeValueTask.class */
        class PostLifeValueTask implements Runnable {
            private Object newValue;
            private LifecycleOwner owner;

            public PostLifeValueTask(Object obj, LifecycleOwner lifecycleOwner) {
                this.newValue = obj;
                this.owner = lifecycleOwner;
            }

            @Override // java.lang.Runnable
            public void run() {
                LifecycleOwner lifecycleOwner = this.owner;
                if (lifecycleOwner == null || !lifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                    return;
                }
                LiveEvent.this.postInternal(this.newValue);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/core/LiveEventBusCore$LiveEvent$PostValueTask.class */
        public class PostValueTask implements Runnable {
            private Object newValue;

            public PostValueTask(Object obj) {
                this.newValue = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                LiveEvent.this.postInternal(this.newValue);
            }
        }

        LiveEvent(String str) {
            this.key = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void broadcastInternal(T t, boolean z, boolean z2) {
            LoggerManager loggerManager = LiveEventBusCore.this.logger;
            Level level = Level.INFO;
            loggerManager.log(level, "broadcast: " + t + " foreground: " + z + " with key: " + this.key);
            Application app = AppUtils.getApp();
            if (app == null) {
                LiveEventBusCore.this.logger.log(Level.WARNING, "application is null, you can try setContext() when config");
                return;
            }
            Intent intent = new Intent(IpcConst.ACTION);
            if (z && Build.VERSION.SDK_INT >= 16) {
                intent.addFlags(268435456);
            }
            if (z2) {
                intent.setPackage(app.getPackageName());
            }
            intent.putExtra(IpcConst.KEY, this.key);
            if (ProcessorManager.getManager().writeTo(intent, t)) {
                try {
                    app.sendBroadcast(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void observeForeverInternal(Observer<T> observer) {
            ObserverWrapper<T> observerWrapper = new ObserverWrapper<>(observer);
            ((ObserverWrapper) observerWrapper).preventNextEvent = this.liveData.getVersion() > -1;
            this.observerMap.put(observer, observerWrapper);
            this.liveData.observeForever(observerWrapper);
            LoggerManager loggerManager = LiveEventBusCore.this.logger;
            Level level = Level.INFO;
            loggerManager.log(level, "observe forever observer: " + observerWrapper + "(" + observer + ") with key: " + this.key);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void observeInternal(LifecycleOwner lifecycleOwner, Observer<T> observer) {
            ObserverWrapper observerWrapper = new ObserverWrapper(observer);
            observerWrapper.preventNextEvent = this.liveData.getVersion() > -1;
            this.liveData.observe(lifecycleOwner, observerWrapper);
            LoggerManager loggerManager = LiveEventBusCore.this.logger;
            Level level = Level.INFO;
            loggerManager.log(level, "observe observer: " + observerWrapper + "(" + observer + ") on owner: " + lifecycleOwner + " with key: " + this.key);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void observeStickyForeverInternal(Observer<T> observer) {
            ObserverWrapper<T> observerWrapper = new ObserverWrapper<>(observer);
            this.observerMap.put(observer, observerWrapper);
            this.liveData.observeForever(observerWrapper);
            LoggerManager loggerManager = LiveEventBusCore.this.logger;
            Level level = Level.INFO;
            loggerManager.log(level, "observe sticky forever observer: " + observerWrapper + "(" + observer + ") with key: " + this.key);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void observeStickyInternal(LifecycleOwner lifecycleOwner, Observer<T> observer) {
            ObserverWrapper observerWrapper = new ObserverWrapper(observer);
            this.liveData.observe(lifecycleOwner, observerWrapper);
            LoggerManager loggerManager = LiveEventBusCore.this.logger;
            Level level = Level.INFO;
            loggerManager.log(level, "observe sticky observer: " + observerWrapper + "(" + observer + ") on owner: " + lifecycleOwner + " with key: " + this.key);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void postInternal(T t) {
            LoggerManager loggerManager = LiveEventBusCore.this.logger;
            Level level = Level.INFO;
            loggerManager.log(level, "post: " + t + " with key: " + this.key);
            this.liveData.setValue(t);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeObserverInternal(Observer<T> observer) {
            ObserverWrapper<T> observerWrapper = observer;
            if (this.observerMap.containsKey(observer)) {
                observerWrapper = this.observerMap.remove(observer);
            }
            this.liveData.removeObserver(observerWrapper);
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        @Deprecated
        public void broadcast(T t) {
            broadcast(t, false, false);
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void broadcast(final T t, final boolean z, final boolean z2) {
            if (AppUtils.getApp() == null) {
                post(t);
            } else if (ThreadUtils.isMainThread()) {
                broadcastInternal(t, z, z2);
            } else {
                this.mainHandler.post(new Runnable() { // from class: com.jeremyliao.liveeventbus.core.LiveEventBusCore.LiveEvent.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveEvent.this.broadcastInternal(t, z, z2);
                    }
                });
            }
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void observe(final LifecycleOwner lifecycleOwner, final Observer<T> observer) {
            if (ThreadUtils.isMainThread()) {
                observeInternal(lifecycleOwner, observer);
            } else {
                this.mainHandler.post(new Runnable() { // from class: com.jeremyliao.liveeventbus.core.LiveEventBusCore.LiveEvent.2
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveEvent.this.observeInternal(lifecycleOwner, observer);
                    }
                });
            }
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void observeForever(final Observer<T> observer) {
            if (ThreadUtils.isMainThread()) {
                observeForeverInternal(observer);
            } else {
                this.mainHandler.post(new Runnable() { // from class: com.jeremyliao.liveeventbus.core.LiveEventBusCore.LiveEvent.4
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveEvent.this.observeForeverInternal(observer);
                    }
                });
            }
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void observeSticky(final LifecycleOwner lifecycleOwner, final Observer<T> observer) {
            if (ThreadUtils.isMainThread()) {
                observeStickyInternal(lifecycleOwner, observer);
            } else {
                this.mainHandler.post(new Runnable() { // from class: com.jeremyliao.liveeventbus.core.LiveEventBusCore.LiveEvent.3
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveEvent.this.observeStickyInternal(lifecycleOwner, observer);
                    }
                });
            }
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void observeStickyForever(final Observer<T> observer) {
            if (ThreadUtils.isMainThread()) {
                observeStickyForeverInternal(observer);
            } else {
                this.mainHandler.post(new Runnable() { // from class: com.jeremyliao.liveeventbus.core.LiveEventBusCore.LiveEvent.5
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveEvent.this.observeStickyForeverInternal(observer);
                    }
                });
            }
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void post(T t) {
            if (ThreadUtils.isMainThread()) {
                postInternal(t);
            } else {
                this.mainHandler.post(new PostValueTask(t));
            }
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void postAcrossApp(T t) {
            broadcast(t, false, false);
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void postAcrossProcess(T t) {
            broadcast(t, false, true);
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void postDelay(LifecycleOwner lifecycleOwner, T t, long j) {
            this.mainHandler.postDelayed(new PostLifeValueTask(t, lifecycleOwner), j);
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void postDelay(T t, long j) {
            this.mainHandler.postDelayed(new PostValueTask(t), j);
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void postOrderly(T t) {
            this.mainHandler.post(new PostValueTask(t));
        }

        @Override // com.jeremyliao.liveeventbus.core.Observable
        public void removeObserver(final Observer<T> observer) {
            if (ThreadUtils.isMainThread()) {
                removeObserverInternal(observer);
            } else {
                this.mainHandler.post(new Runnable() { // from class: com.jeremyliao.liveeventbus.core.LiveEventBusCore.LiveEvent.6
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveEvent.this.removeObserverInternal(observer);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/core/LiveEventBusCore$ObserverWrapper.class */
    public class ObserverWrapper<T> implements Observer<T> {
        private final Observer<T> observer;
        private boolean preventNextEvent = false;

        ObserverWrapper(Observer<T> observer) {
            this.observer = observer;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(T t) {
            if (this.preventNextEvent) {
                this.preventNextEvent = false;
                return;
            }
            LoggerManager loggerManager = LiveEventBusCore.this.logger;
            Level level = Level.INFO;
            loggerManager.log(level, "message received: " + t);
            try {
                this.observer.onChanged(t);
            } catch (ClassCastException e) {
                LoggerManager loggerManager2 = LiveEventBusCore.this.logger;
                Level level2 = Level.WARNING;
                loggerManager2.log(level2, "class cast error on message received: " + t, e);
            } catch (Exception e2) {
                LoggerManager loggerManager3 = LiveEventBusCore.this.logger;
                Level level3 = Level.WARNING;
                loggerManager3.log(level3, "error on message received: " + t, e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/core/LiveEventBusCore$SingletonHolder.class */
    public static class SingletonHolder {
        private static final LiveEventBusCore DEFAULT_BUS = new LiveEventBusCore();

        private SingletonHolder() {
        }
    }

    private LiveEventBusCore() {
        this.config = new Config();
        this.isRegisterReceiver = false;
        this.console = new InnerConsole();
        this.bus = new HashMap();
        this.lifecycleObserverAlwaysActive = true;
        this.autoClear = false;
        this.logger = new LoggerManager(new DefaultLogger());
        this.receiver = new LebIpcReceiver();
        registerReceiver();
    }

    public static LiveEventBusCore get() {
        return SingletonHolder.DEFAULT_BUS;
    }

    public Config config() {
        return this.config;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void enableLogger(boolean z) {
        this.logger.setEnable(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerReceiver() {
        Application app;
        if (this.isRegisterReceiver || (app = AppUtils.getApp()) == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IpcConst.ACTION);
        app.registerReceiver(this.receiver, intentFilter);
        this.isRegisterReceiver = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAutoClear(boolean z) {
        this.autoClear = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLifecycleObserverAlwaysActive(boolean z) {
        this.lifecycleObserverAlwaysActive = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLogger(Logger logger) {
        this.logger.setLogger(logger);
    }

    public <T> Observable<T> with(String str, Class<T> cls) {
        LiveEvent<Object> liveEvent;
        synchronized (this) {
            if (!this.bus.containsKey(str)) {
                this.bus.put(str, new LiveEvent<>(str));
            }
            liveEvent = this.bus.get(str);
        }
        return liveEvent;
    }
}
