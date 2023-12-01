package com.blued.android.chat.core.worker.link;

import com.amap.api.services.core.AMapException;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.utils.Log;
import java.util.Grego;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/link/ReLinkTimer.class */
public class ReLinkTimer {
    private static final int MINUTE = 60000;
    private static final int SECOND = 1000;
    private static final String TAG = "Chat_ReLinkTimer";
    private Timer _timer;
    private ReLinkListener listener;
    private static final int[] TimeFreqForeArrayMs = {AMapException.CODE_AMAP_ROUTE_OUT_OF_SERVICE, AMapException.CODE_AMAP_ROUTE_OUT_OF_SERVICE, 5000, 5000, 10000, 10000, 30000, 30000, 30000, 60000, 60000, 60000, 300000, 300000, 300000, 600000, 600000, 600000};
    private static final int[] TimeFreqBackArrayMs = {10000, 30000, 60000, 120000, 180000, 300000, 300000, 600000, 600000, 1800000, Grego.MILLIS_PER_HOUR};
    private Object lock = new Object();
    private int _retryCount = 0;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/link/ReLinkTimer$ReLinkListener.class */
    public interface ReLinkListener {
        boolean onReLink(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/link/ReLinkTimer$ReLinkTimerTask.class */
    public class ReLinkTimerTask extends TimerTask {
        private ReLinkTimerTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            synchronized (ReLinkTimer.this.lock) {
                if (ReLinkTimer.this._timer == null) {
                    return;
                }
                ReLinkTimer.access$308(ReLinkTimer.this);
                Log.v(ReLinkTimer.TAG, "ReLinkTimer notify relink");
                if (ReLinkTimer.this.listener.onReLink(ReLinkTimer.this._retryCount, ReLinkTimer.this.getTimerDelay())) {
                    ReLinkTimer.this.start();
                }
            }
        }
    }

    public ReLinkTimer(ReLinkListener reLinkListener) {
        this.listener = reLinkListener;
    }

    static /* synthetic */ int access$308(ReLinkTimer reLinkTimer) {
        int i = reLinkTimer._retryCount;
        reLinkTimer._retryCount = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTimerDelay() {
        int[] iArr = ChatManager.getInstance().isAppActived() ? TimeFreqForeArrayMs : TimeFreqBackArrayMs;
        int i = this._retryCount;
        return i < iArr.length ? iArr[i] : iArr[iArr.length - 1];
    }

    private void startTimer() {
        stopTimer();
        this._timer = new Timer();
        int timerDelay = getTimerDelay();
        Log.v(TAG, "start ReLinkTimer, delay:" + timerDelay);
        this._timer.schedule(new ReLinkTimerTask(), (long) timerDelay);
    }

    private void stopTimer() {
        Timer timer = this._timer;
        if (timer != null) {
            timer.cancel();
            this._timer = null;
        }
    }

    public void start() {
        Log.v(TAG, "start ReLinkTimer");
        synchronized (this.lock) {
            startTimer();
        }
    }

    public void stop() {
        Log.v(TAG, "stop ReLinkTimer");
        synchronized (this.lock) {
            stopTimer();
            this._retryCount = 0;
        }
    }
}
