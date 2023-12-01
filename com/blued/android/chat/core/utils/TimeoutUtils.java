package com.blued.android.chat.core.utils;

import androidx.collection.LongSparseArray;
import com.blued.android.chat.ChatManager;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/utils/TimeoutUtils.class */
public class TimeoutUtils {
    private static final String TAG = "Chat_TimeoutUtils";
    private final Object lock = new Object();
    private Timer timer;
    private LongSparseArray<TimeoutObject> timerObjectMap;
    private Stack<TimeoutObject> timerObjectStack;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/utils/TimeoutUtils$MyTimerTask.class */
    public class MyTimerTask extends TimerTask {
        private long keyId;

        public MyTimerTask(long j) {
            this.keyId = j;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            TimeoutObject timeoutObject;
            synchronized (TimeoutUtils.this.lock) {
                timeoutObject = (TimeoutObject) TimeoutUtils.this.timerObjectMap.get(this.keyId);
                if (timeoutObject != null) {
                    TimeoutUtils.this.timerObjectMap.delete(this.keyId);
                    TimeoutUtils.this.timerObjectStack.remove(timeoutObject);
                }
            }
            if (timeoutObject != null) {
                timeoutObject.listener.onPackageTimeout(timeoutObject.keyId, timeoutObject.data);
            }
            synchronized (TimeoutUtils.this.lock) {
                if (TimeoutUtils.this.timerObjectStack.size() > 0) {
                    TimeoutUtils.this.startTimerForObject((TimeoutObject) TimeoutUtils.this.timerObjectStack.get(0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/utils/TimeoutUtils$SingletonCreator.class */
    public static class SingletonCreator {
        private static final TimeoutUtils instance = new TimeoutUtils();

        private SingletonCreator() {
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/utils/TimeoutUtils$TimeoutListener.class */
    public interface TimeoutListener {
        void onPackageTimeout(long j, Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/utils/TimeoutUtils$TimeoutObject.class */
    public static class TimeoutObject {
        public Object data;
        public long keyId;
        public TimeoutListener listener;
        public long stopTimeMs;

        private TimeoutObject() {
        }

        public String toString() {
            return "[keyId:" + this.keyId + ", data:" + this.data + ", stopTimeMs:" + this.stopTimeMs + "]";
        }
    }

    private void addTimeoutObject(TimeoutObject timeoutObject) {
        synchronized (this.lock) {
            if (this.timerObjectMap == null) {
                this.timerObjectMap = new LongSparseArray<>();
            }
            if (this.timerObjectStack == null) {
                this.timerObjectStack = new Stack<>();
            }
            if (this.timerObjectMap.get(timeoutObject.keyId) != null && ChatManager.debug) {
                Log.e(TAG, "the time objet keyid is exist, timeObject:" + timeoutObject);
            }
            this.timerObjectMap.put(timeoutObject.keyId, timeoutObject);
            if (insertTimeoutObject(timeoutObject) == 0) {
                startTimerForObject(timeoutObject);
            }
        }
    }

    public static void addTimeoutPackage(long j, Object obj, long j2, TimeoutListener timeoutListener) {
        if (ChatManager.debug) {
            Log.v(TAG, "addTimeoutPackage(), keyId:" + j + ", data:" + obj + ", timeoutMs:" + j2);
        }
        TimeoutObject timeoutObject = new TimeoutObject();
        timeoutObject.keyId = j;
        timeoutObject.data = obj;
        timeoutObject.stopTimeMs = System.currentTimeMillis() + j2;
        timeoutObject.listener = timeoutListener;
        getInstance().addTimeoutObject(timeoutObject);
    }

    private Object cancelTimeoutObject(long j) {
        TimeoutObject timeoutObject;
        synchronized (this.lock) {
            if (this.timerObjectMap == null || (timeoutObject = this.timerObjectMap.get(j)) == null) {
                return null;
            }
            this.timerObjectMap.delete(j);
            this.timerObjectStack.remove(timeoutObject);
            return timeoutObject.data;
        }
    }

    public static Object cancelTimeoutPackage(long j) {
        return getInstance().cancelTimeoutObject(j);
    }

    private static TimeoutUtils getInstance() {
        return SingletonCreator.instance;
    }

    private int insertTimeoutObject(TimeoutObject timeoutObject) {
        synchronized (this.lock) {
            int size = this.timerObjectStack.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    this.timerObjectStack.add(timeoutObject);
                    return this.timerObjectStack.size() - 1;
                }
                if (timeoutObject.stopTimeMs < this.timerObjectStack.get(i2).stopTimeMs) {
                    this.timerObjectStack.add(i2, timeoutObject);
                    return i2;
                }
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTimerForObject(TimeoutObject timeoutObject) {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer.purge();
        }
        this.timer = new Timer();
        long currentTimeMillis = timeoutObject.stopTimeMs - System.currentTimeMillis();
        long j = currentTimeMillis;
        if (currentTimeMillis < 0) {
            j = 0;
        }
        this.timer.schedule(new MyTimerTask(timeoutObject.keyId), j);
    }
}
